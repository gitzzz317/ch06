package com.zhbit.notice.mapper;
import com.zhbit.notice.pojo.Type;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface TypeDao{
	@Select("select * from Type")
	List<Type> getAllTypeList();

	@Insert("insert into Type values(#{TtypeName})")
	void addType(@Param("TtypeName") String typeName);

}
