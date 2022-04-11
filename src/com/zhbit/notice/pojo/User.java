package com.zhbit.notice.pojo;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class User {
	private int Uno;
	private String Uname;
	private String Upassword;
	private List<Notice> notices;

	public List<Notice> getNotices() {
		return notices;
	}

	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}

	public User() {
	}

	public int getUno() {
		return Uno;
	}

	public void setUno(int uno) {
		Uno = uno;
	}

	public String getUname() {
		return Uname;
	}

	public void setUname(String uname) {
		Uname = uname;
	}

	public String getUpassword() {
		return Upassword;
	}

	public void setUpassword(String upassword) {
		Upassword = upassword;
	}
}
