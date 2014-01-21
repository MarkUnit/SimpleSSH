package service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import po.WebUser;
import service.UserService;
import dao.UserDAO;

@Component("userService")
public class UserServiceImpl implements UserService {
	private UserDAO userDAO; 
	
	public boolean exists(WebUser user) {
		WebUser resultUser = userDAO.queryByName(user.getUsername());
		return null != resultUser;
	}
	
	public void add(WebUser user) {
		userDAO.save(user);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	@Resource
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public WebUser getById(int id) {
		return userDAO.getById(id);
	}
}
