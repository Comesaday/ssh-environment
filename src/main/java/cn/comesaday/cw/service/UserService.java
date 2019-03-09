package cn.comesaday.cw.service;

import java.util.List;

import cn.comesaday.cw.entity.User;

public interface UserService {

	User login(User user);

	List<User> findAll();

	List<User> findThisPage(int pageSize, int currentPage);

}
