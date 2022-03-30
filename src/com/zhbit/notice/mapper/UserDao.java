package com.zhbit.notice.mapper;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.zhbit.notice.pojo.User;
import org.apache.ibatis.annotations.*;


public interface UserDao{

	@Select("Select * from Nuser where Uname = #{Uname} and Upassword = #{Upassword}")

	User getUserByPassword(@Param("Uname") String Uname, @Param("Upassword") String Upassword);
}