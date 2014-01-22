package action;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.WebUser;

public class UserActionTest {
	ApplicationContext ac = null;

	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Ignore
	@Test
	public void testRegister() {
		UserAction userAction = (UserAction)ac.getBean("userAction");
		
		userAction.setUsername("testname2");
		userAction.setPsw("testPsw2");
		userAction.setPsw2("testPsw2");
		String result = userAction.register();
		
		assertEquals("success", result);
	}
	
	@Test
	public void testLoad() {
		UserAction userAction = (UserAction) ac.getBean("userAction");
		
		userAction.setId(2);
		String result = userAction.queryWebUserLoad();
		
		WebUser user = userAction.getUser();
		
		assertEquals("getWebUser", result);
		assertNotNull(user.getUsername());
	}
	
	@Test
	public void testGet(){
		UserAction userAction = (UserAction) ac.getBean("userAction");
		
		userAction.setId(2);
		String result = userAction.queryWebUserGet();
		
		WebUser user = userAction.getUser();
		
		assertEquals("getWebUser", result);
		assertNotNull(user.getUsername());
	}
}
