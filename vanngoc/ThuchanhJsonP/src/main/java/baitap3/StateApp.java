package baitap3;

import java.io.FileNotFoundException;

public class StateApp {
	private static final String FILE_NAME = "data/states.json";

	public static void main(String[] args) throws FileNotFoundException {
		StateManagerObjectModel manager = new StateManagerObjectModel(FILE_NAME);
		State state = manager.findByAb("as");
		System.out.println(state);
	}
}
