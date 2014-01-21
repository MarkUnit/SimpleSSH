package service;

import po.WebUser;
import dao.UserDAO;
import dao.impl.UserDAOImpl;

public interface UserService {
	public boolean exists(WebUser user);
	public void add(WebUser user);
	public WebUser getById(int id);
	public WebUser loadById(int id);
}
