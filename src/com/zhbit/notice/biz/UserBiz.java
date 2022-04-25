package com.zhbit.notice.biz;

import com.zhbit.notice.mapper.UserDao;
import com.zhbit.notice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserBiz {
	@Autowired
	private UserDao userDao;

	public User login(String userName, String password){
		//SqlSession sqlSession = MybatisUtils.getSession();
		//UserDao mapper = sqlSession.getMapper(UserDao.class);
		User user = userDao.getUserByPassword(userName, password);
		return user;
	}

	public void register(String userName, String password){
//		SqlSession sqlSession = MybatisUtils.getSession();
//		UserDao mapper = sqlSession.getMapper(UserDao.class);
		userDao.addUser(userName, password);
	}

	public void updateUser(int Uno ,String userName, String password){
//		SqlSession sqlSession = MybatisUtils.getSession();
//		UserDao mapper = sqlSession.getMapper(UserDao.class);
		userDao.updateUser(Uno ,userName,password);
	}

	public User getUserById(int Uno){
//		SqlSession sqlSession = MybatisUtils.getSession();
//		UserDao mapper = sqlSession.getMapper(UserDao.class);
		return userDao.getUserById(Uno);
	}
}
