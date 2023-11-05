package main;

import db.connection;
import jakarta.persistence.EntityManager;

public class Demo {
	private static EntityManager em;

	public static void main(String[] args) {
		em = new connection().getInstance().getEM();
	}
}
