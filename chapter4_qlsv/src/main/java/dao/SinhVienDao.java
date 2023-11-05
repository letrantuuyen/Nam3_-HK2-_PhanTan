package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.SinhVien;
import factory.MySessionFactory;


public class SinhVienDao {
	private SessionFactory sessionFactory;
	
	public SinhVienDao() {
		sessionFactory = MySessionFactory.getInstance().getSessionFactory();
		// TODO Auto-generated constructor stub
	}
	
	public SinhVien getSinhVien(int id) {
		Transaction tr = null;
		try(
				Session session = sessionFactory.openSession();
				){
			tr = session.beginTransaction();
			SinhVien sinhvien = session.find(SinhVien.class, id);
			tr.commit();
			
			return sinhvien;
		}catch(Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
		
	}
	
	public List<SinhVien> getAll(){
		Transaction tr = null;
		try(
				Session session = sessionFactory.openSession();
				){
			tr = session.beginTransaction();
			String sql = "select *from Sinhvien";
			List<SinhVien> list =  session.createNativeQuery(sql,SinhVien.class).getResultList();
			tr.commit();
			return list;
			
		}catch(Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
}
