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

}
