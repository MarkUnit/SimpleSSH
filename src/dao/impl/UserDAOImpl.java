package dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import po.WebUser;
import util.HibernateSessionFactory;
import dao.UserDAO;

public class UserDAOImpl implements UserDAO {
	
	@Override
	public WebUser queryByName(String name) {
		Session session = HibernateSessionFactory.getSession();
		WebUser user = null;
		try {
			String hql = " from WebUser user where user.username = :username";
			Query query = session.createQuery(hql);
			query.setString("username", name);
			user = (WebUser) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return user;
	}
	
	@Override
	public void save(WebUser user) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			session.save(user);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (null != tx) {
				tx.rollback();
			}
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}
}
