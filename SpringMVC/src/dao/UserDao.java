package dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import entity.User;

public class UserDao extends HibernateDaoSupport{

	public User login(User user) {
		// TODO Auto-generated method stub
		String hql = "from User where username = ?0 and password = ?1";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, user.getUsername(),user.getPassword());
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
		
	}

}
