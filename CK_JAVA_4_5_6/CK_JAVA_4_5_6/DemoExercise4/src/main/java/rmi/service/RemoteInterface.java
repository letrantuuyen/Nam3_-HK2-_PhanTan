package rmi.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

import entity.Comment;
import entity.News;
import entity.User;

public interface RemoteInterface extends Remote {
	public boolean insertComment(Comment c) throws RemoteException;
	public boolean updateComment(Comment c) throws RemoteException;
	public boolean deleteComment(Object id1, Object id2) throws RemoteException;
	public Comment getByIDComment(Object id1, Object id2) throws RemoteException;
	public News getByIDNews(Object id1) throws RemoteException;
	public User getByIDUser(Object id1) throws RemoteException;
	public boolean insertUser_Area(Object id, String content) throws RemoteException;	
	public Map<User, Integer> getCommentbyUser () throws RemoteException;
}
