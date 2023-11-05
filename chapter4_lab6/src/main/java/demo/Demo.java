package demo;

import org.hibernate.dialect.SQLServerDialect;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import db.MyEntityFactory;

public class Demo {
	public static void main(String[] args) {
		MyEntityFactory.getInstance().getEmf();
	}

}
