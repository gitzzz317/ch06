package com.zhbit.notice.mapper;
import com.zhbit.notice.pojo.Type;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface TypeDao{
	@Select("select * from Type")
	List<Type> getAllTypeList();

}
