package exer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class Exercice4 {
	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		SwingUtilities.invokeAndWait(() -> {
			new CopierGUI().setVisible(true);
		});
	}
}

class CopierGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3022044392351108380L;
	private JTextField tfFrom;
	private JTextField tfTo;
	private JButton btnCopy;
	private JProgressBar progressBar;

	public CopierGUI() {

		setSize(600, 250);
		setTitle("Copy utility");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);


		Box b = Box.createVerticalBox();

		getContentPane().add(b);
		b.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		Box b1, b2, b3, b4;
		b.add(b1 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(5));
		b.add(b2 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(5));
		b.add(b3 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(5));
		b.add(b4 = Box.createHorizontalBox()); b.add(Box.createVerticalStrut(5));

		b1.setBorder(BorderFactory.createTitledBorder("From"));
		b1.add(tfFrom = new JTextField("data/big.txt"));
		b2.setBorder(BorderFactory.createTitledBorder("To"));
		b2.add(tfTo = new JTextField("data/big_v2.txt"));

		b3.add(btnCopy = new JButton("Copy..."));
		b4.add(progressBar = new JProgressBar());
		progressBar.setStringPainted(true);

		btnCopy.addActionListener((e) -> {
			String fileFrom = tfFrom.getText().trim();
			String fileTo = tfTo.getText().trim();
			CopyTask task = new CopyTask(fileFrom, fileTo);
			Thread thread = new Thread(task);
			thread.start();
		});

		progressBar.addPropertyChangeListener((e) -> {

			if("progress".equals(e.getPropertyName())) {
				progressBar.setValue((int) e.getNewValue());
			}
		});

	}


	class CopyTask extends SwingWorker<Long, Long> {

		private String fileFrom;
		private String fileTo;

		private long total = 0l;
		private long copied = 0l;



		public CopyTask(String fileFrom, String fileTo) {
			super();
			this.fileFrom = fileFrom;
			this.fileTo = fileTo;

			total = new File(fileFrom).length();

		}



		@Override
		protected Long doInBackground() throws Exception {

			BufferedInputStream in = null;
			BufferedOutputStream out = null;

			try {

				in = new BufferedInputStream(new FileInputStream(fileFrom));
				out = new BufferedOutputStream(new FileOutputStream(fileTo));

				int len = 1024;
				byte[] buff = new byte[len];

				while(in.available() > 0) {
					int n = in.read(buff, 0, len);
					out.write(buff, 0, n);

					copied += n;

					publish(copied);

					progressBar.setValue((int) (copied / total * 100));

					Thread.sleep(1);

				}

			}finally {
				in.close();
				out.close();
			}

			return null;
		}

		@Override
		protected void process(List<Long> chunks) {
			System.out.println(chunks);
		}

		@Override
		protected void done() {
			JOptionPane.showMessageDialog(null, "Finished!");
		}

	}

}

