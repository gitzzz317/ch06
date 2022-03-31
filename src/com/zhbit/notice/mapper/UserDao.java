package com.zhbit.notice.mapper;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.zhbit.notice.pojo.User;
import org.apache.ibatis.annotations.*;


public interface UserDao{

	@Select("Select * from Nuser where Uname = #{Uname} and Upassword = #{Upassword}")
	User getUserByPassword(@Param("Uname") String Uname, @Param("Upassword") String Upassword);

	@Insert("insert into Nuser (Uname,Upassword) values (#{Uname},#{Upassword})")
	void addUser(@Param("Uname") String Uname, @Param("Upassword") String Upassword);

	@Update("update Nuser set Uname = #{Uname} , Upassword = #{Upassword} where Uno = #{Uno}")
	void updateUser(@Param("Uno") int Uno , @Param("Uname") String Uname, @Param("Upassword") String Upassword);

	@Select("Select * from Nuser where Uno = #{Uno}")
	User getUserById(@Param("Uno") int Uno);
}
