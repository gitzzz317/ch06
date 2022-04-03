package com.zhbit.notice.mapper;

import com.zhbit.notice.pojo.Notice;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface NoticeDao{

	@Insert("insert into Notice (Ntitle, Ncontent,Neditor,NcreateTime,Ntype,Uno) values(#{Ntitle},#{Ncontent},#{Neditor},#{NcreateTime},#{Ntype},#{user.Uno})")
	boolean addNotice(Notice notice);

	@Delete("delete Notice where Nno= #{Nno}")
	boolean deleteNotice(int Nno);

	@Update("update Notice set Ntitle=#{Ntitle}, Ncontent=#{Ncontent},Neditor=#{Neditor},NcreateTime=#{NcreateTime},Ntype=#{Ntype} where Nno=#{Nno}")
	boolean updateNotice(Notice notice);

	@Select("select * from notice")
	List<Notice> getAllNoticeList();

	@Select("select * from notice where Ntype=#{Ntype}")
	List<Notice> getNoticeByType(@Param("Ntype") int Ntype);

	@Select("select * from notice where Nno=#{Nno}")
	@Results({
			@Result(id=true,column = "Nno",property = "Nno"),
			@Result(column = "Ntitle" , property = "ntitle"),
			@Result(column = "Ncontent" , property = "Ncontent"),
			@Result(column = "Neditor" , property = "Neditor"),
			@Result(column = "NcreateTime" , property = "NcreateTime"),
			@Result(column = "Ntype" , property = "Ntype"),
			@Result(column = "Uno" , property = "user",
			many = @Many(select = "com.zhbit.notice.mapper.UserDao.getUserById")
			)
	})
	Notice getNoticeById(@Param("Nno") int Nno);

	@Select("select * from notice where Ntitle like '%${Ntitle}%'")
	List<Notice> getNoticeByTitle(@Param("Ntitle") String Ntitle);

}