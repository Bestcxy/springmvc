package com.bestcxx.stu.springmvc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 
 * @theme 实体类
 * @author wujie
 * @Datetime 2017年5月2日
 * DDL 建表语句
 * 
 * 
	CREATE TABLE `usermodel` (
	  `userName` int(8) NOT NULL auto_increment,
	  `passWord` varchar(10000) default NULL,
	  `createDate` datetime default NULL,
	  `intNum` int(10) default NULL,
	  `decimalNum` decimal(10,2) default NULL,
	  PRIMARY KEY  (`userName`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表'

 */
public class UserModelTwo implements Serializable{

	private static final long serialVersionUID = -2443619924488167195L;
	private String userName;
	private String passWord;
	private Date createDate;
	private Integer intNum;
	private BigDecimal decimalNum;
	
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
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getIntNum() {
		return intNum;
	}
	public void setIntNum(Integer intNum) {
		this.intNum = intNum;
	}
	public BigDecimal getDecimalNum() {
		return decimalNum;
	}
	public void setDecimalNum(BigDecimal decimalNum) {
		this.decimalNum = decimalNum;
	}
	@Override
	public String toString() {
		return "UserModelTwo[userName="+userName+",passWord="+passWord+",createDate="+createDate+",intNum="+intNum+",decimalNum="+decimalNum+"]";
	}
}
