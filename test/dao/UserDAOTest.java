package dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import dao.impl.UserDAOImpl;

import po.WebUser;

@ContextConfiguration("/applicationContext.xml")
public class UserDAOTest extends AbstractTransactionalJUnit4SpringContextTests{
	private SessionFactory sessionFactory;
	private UserDAO userDAO;
	
	private static int MAGIC_ID = 0;
	private static String MAGIC_NAME = "youNeverUseThisAsName";
	private static String MAGIC_PSW = "youNeverUseThisAsPsw";
	
	@Before
	public void insertData() {
		String sqlForInsert = "insert into webuser(username, psw) values('" + MAGIC_NAME + "', '" + MAGIC_PSW + "')";
		SQLQuery insertQuery = sessionFactory.getCurrentSession().createSQLQuery(sqlForInsert);
		insertQuery.executeUpdate();
		
		String sqlForQuery = " select id from webuser where username = '" + MAGIC_NAME + "'";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sqlForQuery);
		MAGIC_ID = (Integer) query.uniqueResult();
	}
	
	@Test
	public void getById() {
		WebUser user = userDAO.getById(MAGIC_ID);
		assertEquals(MAGIC_NAME, user.getUsername());
	}
	
	@Test
	public void loadById() {
		WebUser user = userDAO.getById(MAGIC_ID);
		assertEquals(MAGIC_NAME, user.getUsername());
	}
	
	@Test
	public void queryByName() {
		WebUser user = userDAO.queryByName(MAGIC_NAME);
		assertEquals(MAGIC_NAME, user.getUsername());
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}
	@Resource
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
