package com.zhbit.notice.pojo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class Notice {
	private int Nno;
	private String Ntitle;
	private String Ncontent;
	private String Neditor;
	private Date NcreateTime;
	private int Ntype;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Notice() {
	}

	public Notice(int nno, String ntitle, String ncontent, String neditor, Date ncreateTime, int ntype, User user) {
		Nno = nno;
		Ntitle = ntitle;
		Ncontent = ncontent;
		Neditor = neditor;
		NcreateTime = ncreateTime;
		Ntype = ntype;
		this.user = user;
	}

	public int getNno() {
		return Nno;
	}

	public void setNno(int nno) {
		Nno = nno;
	}

	public String getNtitle() {
		return Ntitle;
	}

	public void setNtitle(String ntitle) {
		Ntitle = ntitle;
	}

	public String getNcontent() {
		return Ncontent;
	}

	public void setNcontent(String ncontent) {
		Ncontent = ncontent;
	}

	public String getNeditor() {
		return Neditor;
	}

	public void setNeditor(String neditor) {
		Neditor = neditor;
	}

	public Date getNcreateTime() {
		return NcreateTime;
	}

	public void setNcreateTime(Date ncreateTime) {
		NcreateTime = ncreateTime;
	}

	public int getNtype() {
		return Ntype;
	}

	public void setNtype(int ntype) {
		Ntype = ntype;
	}
}
