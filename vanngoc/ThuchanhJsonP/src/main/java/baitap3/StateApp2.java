package baitap3;

import java.io.FileNotFoundException;

public class StateApp2 {
	private static final String FILE_NAME = "data/states.json";

	public static void main(String[] args) throws FileNotFoundException {
		StateManagerStreaming manager = new StateManagerStreaming(FILE_NAME);
		State state = manager.findByAb("ak");
		System.out.println(state);
	}
}
