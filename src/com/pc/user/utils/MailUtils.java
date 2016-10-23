package com.pc.user.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import com.pc.user.domain.User;

/**
 * 邮件工具类
 * 
 * @author Switch
 * @data 2016年10月23日
 * @version V1.0
 */
public class MailUtils {
	/**
	 * 发送邮件
	 * 
	 * @param user
	 *            用户Bean
	 */
	public static void sendMail(User user) {
		// Session对象(会话)
		Properties props = new Properties();
		// 邮件服务器在本机
		props.setProperty("mail.host", "localhost");

		// 邮件服务器在外网需要用下面两个配置替代
		// props.setProperty("mail.host", "smtp-mail.outlook.com");
		// 外网会强制验证
		props.setProperty("mail.smtp.auth", "true");
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			public PasswordAuthentication getPasswordAuthentication() {
				// 邮件服务器在本机
				return new PasswordAuthentication("Admin@store.com", "123456");

				// 邮件服务器在外网
				// return new PasswordAuthentication("*****@163.com","123456");
			}
		});

		// Message对象
		Message message = new MimeMessage(session);
		try {
			// 设置发件人：（最好是与登录名相同）
			message.setFrom(new InternetAddress("Admin@store.com"));
			// 设置收件人:
			message.addRecipient(RecipientType.TO, new InternetAddress(user.getEmail()));
			// 设置主题:
			message.setSubject("生日快乐");
			// 设置内容：
			message.setContent("尊敬的用户，祝您生日快乐！", "text/html;charset=UTF-8");
			// 3.Transport对象:
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
