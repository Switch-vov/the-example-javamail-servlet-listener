package com.pc.user.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.pc.user.domain.User;
import com.pc.user.utils.C3P0Utils;

/**
 * 用户Dao
 * 
 * @author Switch
 * @data 2016年10月23日
 * @version V1.0
 */
public class UserDao {
	/**
	 * 获得今天为生日的用户
	 * 
	 * @param month
	 *            当前月
	 * @param day
	 *            当前天
	 * @return 用户列表
	 * @throws SQLException
	 */
	public List<User> getBirthDayUser(String month, String day) throws SQLException {
		QueryRunner queryRunner = new QueryRunner();
		String sql = "select * from user where birthday like ?";
		Object[] params = { "%-" + month + "-" + day };
		return queryRunner.query(C3P0Utils.getConnection(), sql, new BeanListHandler<>(User.class), params);
	}

}
