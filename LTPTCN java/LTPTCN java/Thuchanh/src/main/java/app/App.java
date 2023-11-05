package app;

import java.util.Date;

import dao.ProjectDao;
import entity.Project;

public class App {
	public static void main(String[] args) {
		
		ProjectDao projectDao = new ProjectDao();
//		Project p;
//		boolean result = projectDao.addProject(p = new Project("PJ01", "Project 1", "Q1", "KT", 1000, new Date()));
//		System.out.println(result);
		
		projectDao.getProjects().forEach(p->System.out.println(p));
		
	}
}
