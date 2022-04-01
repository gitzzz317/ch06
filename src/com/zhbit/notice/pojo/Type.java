package com.zhbit.notice.pojo;

public class Type {
	private int Tno;
	private String TtypeName;
	
	public Type(){
		
	}

	public Type(int tno, String ttypeName) {
		Tno = tno;
		TtypeName = ttypeName;
	}

	public int getTno() {
		return Tno;
	}

	public void setTno(int tno) {
		Tno = tno;
	}

	public String getTtypeName() {
		return TtypeName;
	}

	public void setTtypeName(String ttypeName) {
		TtypeName = ttypeName;
	}
}
