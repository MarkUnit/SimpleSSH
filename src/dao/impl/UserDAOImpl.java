package dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import po.WebUser;
import dao.UserDAO;

@Component("userDAO")
public class UserDAOImpl extends SuperDAO implements UserDAO {
	
	@Override
	public WebUser queryByName(String name) {
		WebUser user = null;
			String hql = " from WebUser user where user.username = :username";
			List<WebUser> users = getHibernateTemplate().findByNamedParam(hql, "username", name);
			if (null != users) {
				user = users.get(0);
			}
		
		return user;
	}
	
	@Override
	public void save(WebUser user) {
		getHibernateTemplate().save(user);
	}
}
