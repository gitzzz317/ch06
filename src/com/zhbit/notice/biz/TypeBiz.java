package com.zhbit.notice.biz;

import java.util.List;

import com.zhbit.notice.pojo.Type;
import com.zhbit.notice.mapper.TypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class TypeBiz {
	@Autowired
	private TypeDao typeDao;

	public List<Type> getAllType(){
//		SqlSession sqlSession = MybatisUtils.getSession();
//		TypeDao mapper = sqlSession.getMapper(TypeDao.class);
		return typeDao.getAllTypeList();
	}

	public void addType(String typeName){
//		SqlSession sqlSession = MybatisUtils.getSession();
//		TypeDao mapper = sqlSession.getMapper(TypeDao.class);
		typeDao.addType(typeName);
	}

	public void deleteType(int Tno){
//		SqlSession sqlSession = MybatisUtils.getSession();
//		TypeDao mapper = sqlSession.getMapper(TypeDao.class);
		typeDao.deleteType(Tno);
	}

	public void updateType(Type type){
//		SqlSession sqlSession = MybatisUtils.getSession();
//		TypeDao mapper = sqlSession.getMapper(TypeDao.class);
		typeDao.updataType(type);
	}
}
