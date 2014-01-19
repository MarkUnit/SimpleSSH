package service.impl;

import po.WebUser;
import service.UserService;
import dao.UserDAO;
import dao.impl.UserDAOImpl;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO = new UserDAOImpl(); 
	
	public boolean exists(WebUser user) {
		WebUser resultUser = userDAO.queryByName(user.getUsername());
		return null != resultUser;
	}
	
	public void add(WebUser user) {
		userDAO.save(user);
	}
}
