package exer;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.InputEvent;
import java.lang.reflect.InvocationTargetException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class Exercise5 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuItem newMenu;
	private JMenuItem openMenu;
	private JTextArea ta;
	private JScrollPane sc;

	public Exercise5() {

		setTitle("Notepad");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(500, 300);
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(600, 400));

		JMenuBar menuBar;
		setJMenuBar(menuBar = new JMenuBar());
		JMenu fileMenu;
		menuBar.add(fileMenu = new JMenu("File"));
		fileMenu.setMnemonic('F');

		fileMenu.add(newMenu = new JMenuItem("New", 'N'));
		fileMenu.add(new JSeparator());
		newMenu.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
		fileMenu.add(openMenu = new JMenuItem("Open", 'O'));
		openMenu.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK));

		Container container = getContentPane();

		container.add(sc = new JScrollPane(ta = new JTextArea()));
		ta.setLineWrap(true);
		sc.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		JPanel pnl;
		container.add(pnl = new JPanel(), BorderLayout.SOUTH);
		pnl.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		pnl.setLayout(new BorderLayout());
		pnl.add(new JLabel("Ready..."));
		

	}

	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		SwingUtilities.invokeAndWait(() -> {
			new Exercise5().setVisible(true);
		});
	}

}