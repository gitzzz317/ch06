package com.zhbit.notice.biz;


import com.zhbit.notice.mapper.NoticeDao;
import com.zhbit.notice.pojo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class NoticeBiz {
	@Autowired
	private NoticeDao noticeDao;

	public List<Notice> getAllNotice(){
//		SqlSession sqlSession = MybatisUtils.getSession();
//		NoticeDao mapper = sqlSession.getMapper(NoticeDao.class);
		return noticeDao.getAllNoticeList();
	}
	
	public Notice getNoticeById(int noticeId){
//		SqlSession sqlSession = MybatisUtils.getSession();
//		NoticeDao mapper = sqlSession.getMapper(NoticeDao.class);
		return noticeDao.getNoticeById(noticeId);
	}
	
	public List<Notice> getNoticeByTypeId(int typeId){
//		SqlSession sqlSession = MybatisUtils.getSession();
//		NoticeDao mapper = sqlSession.getMapper(NoticeDao.class);
		return noticeDao.getNoticeByType(typeId);
	}
	
	public boolean addNotice(Notice notice){
//		SqlSession sqlSession = MybatisUtils.getSession();
//		NoticeDao mapper = sqlSession.getMapper(NoticeDao.class);
		return noticeDao.addNotice(notice);
	}

	public boolean updateNotice(Notice notice){
//		SqlSession sqlSession = MybatisUtils.getSession();
//		NoticeDao mapper = sqlSession.getMapper(NoticeDao.class);
		return noticeDao.updateNotice(notice);
	}
	
	public boolean deleteNotice(int noticeId){
//		SqlSession sqlSession = MybatisUtils.getSession();
//		NoticeDao mapper = sqlSession.getMapper(NoticeDao.class);
		return noticeDao.deleteNotice(noticeId);
	}

	public List<Notice> getNoticeByTitle(String Ntitle){
//		SqlSession sqlSession = MybatisUtils.getSession();
//		NoticeDao mapper = sqlSession.getMapper(NoticeDao.class);
		return noticeDao.getNoticeByTitle(Ntitle);
	}

	public List<Notice> getNoticeByTime(String startTime, String endTime ){
//		SqlSession sqlSession = MybatisUtils.getSession();
//		NoticeDao mapper = sqlSession.getMapper(NoticeDao.class);
		return noticeDao.getNoticeByTime(startTime,endTime);
	}
}
