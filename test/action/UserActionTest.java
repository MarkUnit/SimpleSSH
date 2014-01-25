package action;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.web.servlet.ModelAndView;

import po.WebUser;

@ContextConfiguration("/applicationContext.xml")
public class UserActionTest extends AbstractTransactionalJUnit4SpringContextTests{
	private SessionFactory sessionFactory;
	private UserController userAction;
	
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
	public void testRegister() {
		String result = userAction.register("测试注册", "psw", "psw");
		
		assertEquals("registerSuccess", result);
	}
	
	@Test
	public void testLoad() {
		ModelAndView mac = userAction.queryWebUserLoad(MAGIC_ID);
		WebUser user = (WebUser) mac.getModel().get("webUser");
		
		assertEquals(MAGIC_NAME, user.getUsername());
	}
	
	@Test
	public void testGet(){
		ModelAndView mac = userAction.queryWebUserGet(MAGIC_ID);
		WebUser user = (WebUser) mac.getModel().get("webUser");
		
		assertEquals(MAGIC_NAME, user.getUsername());
	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public UserController getUserAction() {
		return userAction;
	}

	@Resource
	public void setUserAction(UserController userAction) {
		this.userAction = userAction;
	}
}
