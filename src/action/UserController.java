package action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import exception.UserTestException;

import po.WebUser;
import service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private UserService userService;
	
	public UserController() {
		System.out.println("a new UserAction is created.");
	}
	
	@RequestMapping("/intoRegister")
	public String intoRegister() {
		return "user/register";
	}
	
	@RequestMapping("/register")
	public String register(@RequestParam String username, @RequestParam String psw, @RequestParam String psw2){
		if (!psw.equals(psw2)) {
			return "user/registerFail";
		}
		
		WebUser user = new WebUser();
		user.setUsername(username);
		user.setPsw(psw);
		
		userService.add(user);
		return "user/registerSuccess";
	}
	
	@RequestMapping("/get")
	public ModelAndView queryWebUserGet(@RequestParam int id) {
		ModelAndView mav = new ModelAndView("user/user");
		WebUser user = userService.getById(id);
		
		mav.addObject(user);
		
		return mav;
	}
	
	@RequestMapping("/load")
	public ModelAndView queryWebUserLoad(@RequestParam int id) {
		ModelAndView mav = new ModelAndView("user/user");
		WebUser user = userService.getById(id);
		
		return mav.addObject(user);
	}

	public ModelAndView throwExcption() {
		
		throw new UserTestException();
	}

	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
