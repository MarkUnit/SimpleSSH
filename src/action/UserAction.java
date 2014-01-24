package action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import po.WebUser;
import service.UserService;

@Controller
@RequestMapping("/user")
public class UserAction {
	private UserService userService;
	
	public UserAction() {
		System.out.println("a new UserAction is created.");
	}
	
	@RequestMapping("/register")
	public String register(@RequestParam String username, @RequestParam String psw, @RequestParam String psw2){
		if (!psw.equals(psw2)) {
			return "registerFail";
		}
		
		WebUser user = new WebUser();
		user.setUsername(username);
		user.setPsw(psw);
		
		userService.add(user);
		return "registerSuccess";
	}
	
	@RequestMapping("/get")
	public ModelAndView queryWebUserGet(@RequestParam int id) {
		ModelAndView mav = new ModelAndView("user");
		WebUser user = userService.getById(id);
		
		mav.addObject(user);
		
		return mav;
	}
	
	@RequestMapping("/load")
	public ModelAndView queryWebUserLoad(@RequestParam int id) {
		ModelAndView mav = new ModelAndView("user");
		WebUser user = userService.getById(id);
		
		return mav.addObject(user);
	}


	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
