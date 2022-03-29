package com.zhbit.notice.mapper;

import com.zhbit.notice.pojo.Notice;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface NoticeDao{
	@Insert("insert into Notice (Ntitle, Ncontent,Neditor,NcreateTime,Ntype) values(#{Ntitle},#{Ncontent},#{Neditor},#{NcreateTime},#{Ntype})")
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
	Notice getNoticeById(@Param("Nno") int Nno);
}