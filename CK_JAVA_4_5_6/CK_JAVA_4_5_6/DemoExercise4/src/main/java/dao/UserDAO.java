package dao;

import entity.User;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class UserDAO extends AbstractDao<User> {
	public UserDAO () {
		super(User.class);
	}
	
	public boolean insertUser_researchArea  (Object id, String content) {
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
			Query q = em.createNativeQuery("INSERT INTO Users_ResearchAreas (userID, researchAreas) values ("+id+", '"+content+"')");
			int r = q.executeUpdate();
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}
}
