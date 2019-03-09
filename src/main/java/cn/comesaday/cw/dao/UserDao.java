package cn.comesaday.cw.dao;

import java.util.List;

import cn.comesaday.cw.entity.User;

public interface UserDao {

	User findThisUser(User user);

	List<User> findAll();

	List<User> findThisPage(int pageSize, int currentPage);

}
