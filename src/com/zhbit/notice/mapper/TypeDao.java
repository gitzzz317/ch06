package com.zhbit.notice.mapper;
import com.zhbit.notice.pojo.Type;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeDao{
	@Select("select * from Type")
	List<Type> getAllTypeList();

	@Insert("insert into Type values(#{TtypeName})")
	void addType(@Param("TtypeName") String typeName);

	@Delete("delete from Type where Tno = #{Tno}")
	void deleteType(@Param("Tno") int Tno);

	@Update("update Type set TtypeName = #{TtypeName} where Tno = #{Tno}")
	void updataType(Type type);
}
