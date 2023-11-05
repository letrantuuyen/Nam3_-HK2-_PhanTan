package rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.Map;

import entity.Comment;
import entity.News;
import entity.User;
import rmi.service.RemoteInterface;

public class Client {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		RemoteInterface ri = (RemoteInterface) Naming.lookup("rmi://LAPTOP-5ABCG2KH:9777/ri");
		
//		//GetByID
//		Comment c = ri.getByIDComment(1, 1);
//		System.out.println(c);
//		
//		//Insert
//		User user = ri.getByIDUser(1);
//		News news = ri.getByIDNews(4);
//		System.out.println(user);
//		System.out.println(news);
//		Comment comment = new Comment("content", new Date(), user, news);
//		System.out.println(ri.insertComment(comment));
//		
//		// Update 
//		c.setCommentContent("Update content");
//		System.out.println(ri.updateComment(c));
		
//		// delete
//		System.out.println(ri.deleteComment(1, 4));
		
		// getCommentBYUser
		Map<User, Integer> map = ri.getCommentbyUser();
		map.entrySet().iterator().forEachRemaining(en -> {
			System.out.println(en.getKey().getUserName() + " : " + en.getValue());
		});
		
		// InsertArea
		System.out.println(ri.insertUser_Area(2, "Content VIP"));
	}
}
