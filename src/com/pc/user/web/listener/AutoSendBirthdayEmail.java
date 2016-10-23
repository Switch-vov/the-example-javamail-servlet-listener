package com.pc.user.web.listener;

import java.sql.SQLException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.pc.user.domain.User;
import com.pc.user.service.UserService;
import com.pc.user.utils.DateUtils;
import com.pc.user.utils.MailUtils;

/**
 * 自动发送邮件给今天是生日的用户
 * 
 * @author Switch
 * @data 2016年10月23日
 * @version V1.0
 */
public class AutoSendBirthdayEmail implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 设置每天发送祝福邮件的定时器
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// 获得今天为生日的用户
				List<User> users;
				try {
					users = new UserService().getBirthDayUser();
					// 向他们发送祝福邮件
					if (users != null && users.size() > 0) {
						for (User user : users) {
							MailUtils.sendMail(user);
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}, 0, DateUtils.getOneDay());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
