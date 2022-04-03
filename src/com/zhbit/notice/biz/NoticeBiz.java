package com.zhbit.notice.biz;


import com.zhbit.notice.mapper.NoticeDao;
import com.zhbit.notice.pojo.Notice;
import com.zhbit.notice.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class NoticeBiz {

	public List<Notice> getAllNotice(){
		SqlSession sqlSession = MybatisUtils.getSession();
		NoticeDao mapper = sqlSession.getMapper(NoticeDao.class);
		return mapper.getAllNoticeList();
	}
	
	public Notice getNoticeById(int noticeId){
		SqlSession sqlSession = MybatisUtils.getSession();
		NoticeDao mapper = sqlSession.getMapper(NoticeDao.class);
		return mapper.getNoticeById(noticeId);
	}
	
	public List<Notice> getNoticeByTypeId(int typeId){
		SqlSession sqlSession = MybatisUtils.getSession();
		NoticeDao mapper = sqlSession.getMapper(NoticeDao.class);
		return mapper.getNoticeByType(typeId);
	}
	
	public boolean addNotice(Notice notice){
		SqlSession sqlSession = MybatisUtils.getSession();
		NoticeDao mapper = sqlSession.getMapper(NoticeDao.class);
		return mapper.addNotice(notice);
	}

	public boolean updateNotice(Notice notice){
		SqlSession sqlSession = MybatisUtils.getSession();
		NoticeDao mapper = sqlSession.getMapper(NoticeDao.class);
		return mapper.updateNotice(notice);
	}
	
	public boolean deleteNotice(int noticeId){
		SqlSession sqlSession = MybatisUtils.getSession();
		NoticeDao mapper = sqlSession.getMapper(NoticeDao.class);
		return mapper.deleteNotice(noticeId);
	}

	public List<Notice> getNoticeByTitle(String Ntitle){
		SqlSession sqlSession = MybatisUtils.getSession();
		NoticeDao mapper = sqlSession.getMapper(NoticeDao.class);
		return mapper.getNoticeByTitle(Ntitle);
	}
}
