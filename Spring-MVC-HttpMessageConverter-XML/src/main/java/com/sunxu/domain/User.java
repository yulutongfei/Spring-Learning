package com.sunxu.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import java.util.Date;
/**
 * @author 25720
 */
@XStreamAlias("message")
public class User {
    @XStreamAlias("id")
	@XStreamAsAttribute
	private String userId;

	@XStreamAsAttribute
	private String userName;

    @XStreamAsAttribute
	private String password;

    @XStreamAsAttribute
	private String realName;
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

}
