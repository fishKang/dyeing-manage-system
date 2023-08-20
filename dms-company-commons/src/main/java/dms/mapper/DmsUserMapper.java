package dms.mapper;

import dms.dto.DmsUser;

import java.util.List;
import java.util.Map;

import dms.operations.DmsUserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DmsUserMapper {
    int countByExample(DmsUserExample example);

    int deleteByExample(DmsUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DmsUser record);

    int insertSelective(DmsUser record);

    List<DmsUser> selectByExample(DmsUserExample example);

    DmsUser selectByPrimaryKey(Integer id);

    DmsUser selectForUserRegister(Map<String,Object> map);

    int updateByExampleSelective(@Param("record") DmsUser record, @Param("example") DmsUserExample example);

    int updateByExample(@Param("record") DmsUser record, @Param("example") DmsUserExample example);

    int updateByPrimaryKeySelective(DmsUser record);

    int updateByPrimaryKey(DmsUser record);
}