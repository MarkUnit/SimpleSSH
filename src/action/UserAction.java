package action;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import po.WebUser;
import service.UserService;
import service.impl.UserServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

@Component
public class UserAction extends ActionSupport {
	private String username;
	private String psw;
	private String psw2;
	
	private UserService userService;
	
	public String register(){
		if (!psw.equals(psw2)) {
			return "fail";
		}
		
		WebUser user = new WebUser();
		user.setUsername(username);
		user.setPsw(psw);
		
		userService.add(user);
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getPsw2() {
		return psw2;
	}

	public void setPsw2(String psw2) {
		this.psw2 = psw2;
	}

	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
