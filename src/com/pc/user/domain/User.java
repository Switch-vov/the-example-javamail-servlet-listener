package com.pc.user.domain;

import java.util.Date;

/**
 * 用户Bean
 * 
 * @author Switch
 * @data 2016年10月23日
 * @version V1.0
 */
public class User {
	private Integer id;
	private String username;
	private Date birthday;
	private String email;

	public User() {

	}

	public User(Integer id, String username, Date birthday, String email) {
		super();
		this.id = id;
		this.username = username;
		this.birthday = birthday;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", birthday=" + birthday + ", email=" + email + "]";
	}

}
