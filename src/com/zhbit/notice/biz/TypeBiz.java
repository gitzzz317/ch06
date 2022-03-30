package com.zhbit.notice.biz;

import java.util.List;

import com.zhbit.notice.pojo.Type;
import com.zhbit.notice.mapper.TypeDao;
import com.zhbit.notice.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class TypeBiz {
	public List<Type> getAllType(){
		SqlSession sqlSession = MybatisUtils.getSession();
		TypeDao mapper = sqlSession.getMapper(TypeDao.class);
		return mapper.getAllTypeList();
	}

}