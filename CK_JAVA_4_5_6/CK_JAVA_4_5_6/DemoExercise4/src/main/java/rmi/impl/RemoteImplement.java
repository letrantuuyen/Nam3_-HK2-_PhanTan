package rmi.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

import dao.CommentDAO;
import dao.NewsDao;
import dao.UserDAO;
import entity.Comment;
import entity.News;
import entity.User;
import rmi.service.RemoteInterface;

public class RemoteImplement extends UnicastRemoteObject implements RemoteInterface {

	private CommentDAO commentDao;
	private UserDAO userDAO;
	private NewsDao newsDAO;

	public RemoteImplement() throws RemoteException {
		super();
		commentDao = new CommentDAO();
		userDAO = new UserDAO();
		newsDAO = new NewsDao();
	}

	@Override
	public boolean insertComment(Comment c) throws RemoteException {
		return commentDao.insert(c);
	}

	@Override
	public boolean updateComment(Comment c) throws RemoteException {
		return commentDao.update(c);
	}

	@Override
	public boolean deleteComment(Object id1, Object id2) throws RemoteException {
		return commentDao.deleteCommentByID(id1, id2);
	}

	@Override
	public Comment getByIDComment(Object id1, Object id2) throws RemoteException {
		return commentDao.getCommentByID(id1, id2);
	}

	@Override
	public News getByIDNews(Object id1) throws RemoteException {
		return newsDAO.getByID(id1);
	}

	@Override
	public User getByIDUser(Object id1) throws RemoteException {
		return userDAO.getByID(id1);
	}

	@Override
	public boolean insertUser_Area(Object id, String content) throws RemoteException {
		return userDAO.insertUser_researchArea(id, content);
	}

	@Override
	public Map<User, Integer> getCommentbyUser() throws RemoteException {
		return commentDao.getCommentByUser();
	}

}
