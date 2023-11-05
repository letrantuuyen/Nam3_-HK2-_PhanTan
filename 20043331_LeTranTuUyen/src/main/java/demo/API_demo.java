package demo;

import java.io.FileNotFoundException;

import Util.PersonUtilObjectAPI;
import entity.Person;

public class API_demo {
	public static void main(String[] args) throws FileNotFoundException {

		System.out.println(PersonUtilObjectAPI.readFile("data/person.json"));
	}

}
