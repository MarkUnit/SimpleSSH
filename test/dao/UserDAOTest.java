package dao;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import dao.impl.UserDAOImpl;

import po.WebUser;

public class UserDAOTest {
	UserDAO userDAO = null;
	
	@Before
	public void before(){
		userDAO  = new UserDAOImpl();
	}
	
	@Test
	public void existsTest(){
		
		WebUser user = userDAO.queryByName("user1");
		assertNotEquals(null, user);
	}
}
