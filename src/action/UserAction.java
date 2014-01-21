package action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import po.WebUser;
import service.UserService;

import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Component("userAction")
public class UserAction extends ActionSupport {
	private String username;
	private String psw;
	private String psw2;
	
	private WebUser user;
	private int id;
	
	private UserService userService;
	
	public UserAction() {
		System.out.println("a new UserAction is created.");
	}
	
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
	
	public String queryWebUserGet() {
		user = userService.getById(id);
		return "getWebUser";
	}
	
	public String queryWebUserLoad() {
		user = userService.loadById(id);
		return "getWebUser";
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

	public WebUser getUser() {
		return user;
	}

	public void setUser(WebUser user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
