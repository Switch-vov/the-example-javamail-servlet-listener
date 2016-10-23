package com.pc.user.service;

import java.sql.SQLException;
import java.util.List;

import com.pc.user.dao.UserDao;
import com.pc.user.domain.User;
import com.pc.user.utils.DateUtils;

/**
 * 用户Service
 * 
 * @author Switch
 * @data 2016年10月23日
 * @version V1.0
 */
public class UserService {
	/**
	 * 获得今天为生日的用户
	 * 
	 * @return 用户列表
	 * @throws SQLException 
	 */
	public List<User> getBirthDayUser() throws SQLException {
		String month = DateUtils.getCurrentMonth();
		String day = DateUtils.getCurrentDay();
		UserDao userDao = new UserDao();
		return userDao.getBirthDayUser(month, day);
	}

}
