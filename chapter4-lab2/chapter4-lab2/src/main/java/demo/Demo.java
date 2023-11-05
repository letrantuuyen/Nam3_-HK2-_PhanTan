package demo;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import factory.MySessionFactory;

public class Demo {
	public static void main(String[] args) {
		MySessionFactory.getInstance().getSessionFactory();
		
	}
}
