package com.zhbit.notice.biz;

import com.zhbit.notice.mapper.UserDao;
import com.zhbit.notice.pojo.User;
import com.zhbit.notice.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class UserBiz {
	public User login(String userName, String password){
		SqlSession sqlSession = MybatisUtils.getSession();
		UserDao mapper = sqlSession.getMapper(UserDao.class);
		User user = mapper.getUserByPassword(userName, password);
		return user;
	}

	public void register(String userName, String password){
		SqlSession sqlSession = MybatisUtils.getSession();
		UserDao mapper = sqlSession.getMapper(UserDao.class);
		mapper.addUser(userName, password);
	}

	public void updateUser(int Uno ,String userName, String password){
		SqlSession sqlSession = MybatisUtils.getSession();
		UserDao mapper = sqlSession.getMapper(UserDao.class);
		mapper.updateUser(Uno ,userName,password);
	}

	public User getUserById(int Uno){
		SqlSession sqlSession = MybatisUtils.getSession();
		UserDao mapper = sqlSession.getMapper(UserDao.class);
		return mapper.getUserById(Uno);
	}
}
