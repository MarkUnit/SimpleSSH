package action;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserActionTest {
	ApplicationContext ac = null;
	
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Test
	public void testRegister() {
		UserAction userAction = (UserAction)ac.getBean("userAction");
		
		userAction.setUsername("testname2");
		userAction.setPsw("testPsw2");
		userAction.setPsw2("testPsw2");
		String result = userAction.register();
		
		assertEquals("success", result);
	}

}
