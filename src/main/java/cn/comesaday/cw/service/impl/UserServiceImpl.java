package cn.comesaday.cw.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.comesaday.cw.dao.UserDao;
import cn.comesaday.cw.entity.User;
import cn.comesaday.cw.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao;
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.findThisUser(user);
	}
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}
	@Override
	public List<User> findThisPage(int pageSize, int currentPage) {
		// TODO Auto-generated method stub
		return userDao.findThisPage(pageSize, currentPage);
	}

}
