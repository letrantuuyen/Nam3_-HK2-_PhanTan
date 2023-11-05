package dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import entity.Comment;
import entity.User;
import jakarta.persistence.EntityTransaction;

public class CommentDAO extends AbstractDao<Comment> {
	public CommentDAO () {
		super(Comment.class);
	}
	
	public Comment getCommentByID (Object id1,  Object id2) {
		return (Comment) em.createNativeQuery("select *  from Comment where UserId = "+id1 + " and NewsID = " + id2, Comment.class).getResultList().get(0);
	}
	
	public boolean deleteCommentByID (Object id1, Object id2) {
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
			em.remove(getCommentByID(id1, id2));
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}
	
	public Map<User, Integer> getCommentByUser () {
		Map<User, Integer> map = new LinkedHashMap<>();
		List<Object[]> objs = em.createNativeQuery("select count(*) as CommentOfUser, c.userID\r\n"
				+ "from Comment c\r\n"
				+ "group by c.userID\r\n"
				+ "order by count(*) desc").getResultList();
		objs.forEach(o -> {
			User user = new UserDAO().getByID(o[1]);
			Integer com = (Integer) o[0];
			map.put(user, com);
		});
		return map;
	}
	
	
}
