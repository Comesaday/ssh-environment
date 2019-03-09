package cn.comesaday.cw.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import cn.comesaday.cw.dao.UserDao;
import cn.comesaday.cw.entity.User;

@Repository("userDao")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	@Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public User findThisUser(User user) {
		// TODO Auto-generated method stub
		String hql = "from User where account = ?0 and password = ?1";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, user.getAccount(),user.getPassword());
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		String hql = "from User";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findThisPage(int pageSize, int currentPage) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
		List<User> list = (List<User>) this.getHibernateTemplate().findByCriteria(detachedCriteria, (currentPage - 1)*pageSize, pageSize);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

}
