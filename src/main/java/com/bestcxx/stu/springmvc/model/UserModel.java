package com.bestcxx.stu.springmvc.model;

import java.io.Serializable;
import java.util.Date;

public class UserModel implements Serializable{
	
	private static final long serialVersionUID = -2443619924488167195L;
	private String userName;
	private String passWord;
	private Date createDate;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
