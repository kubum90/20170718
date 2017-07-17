package com.hanbit.gms.domain;

import java.io.Serializable;

public class MemberBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id, password,name,ssn,regdate;
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String toString() {
		return String.format("이름:%s 아이디:%s 비밀번호:%s 주민번호:%s 날짜:%s \n",name,id,password,ssn,regdate);
	}
}