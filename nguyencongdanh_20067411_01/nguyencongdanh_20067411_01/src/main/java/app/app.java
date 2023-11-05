package app;

import java.io.FileNotFoundException;
import java.util.List;

import entity.Benhnhan;
import util.StreamAPI;


public class app {
	public static void main(String[] args) throws FileNotFoundException {
		Benhnhan ben = StreamAPI.toObject("data/benhnhan.json");
		System.out.println(ben);
	}
}
