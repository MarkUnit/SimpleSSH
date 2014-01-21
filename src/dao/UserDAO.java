package dao;

import po.WebUser;

public interface UserDAO {
	
	public WebUser queryByName(String name);
	public void save(WebUser user);
	public WebUser getById(int id);
	public WebUser loadById(int id);
	
}
