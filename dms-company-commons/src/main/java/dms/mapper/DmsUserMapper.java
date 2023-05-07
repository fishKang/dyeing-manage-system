package dms.mapper;

import dms.dto.DmsUser;
import dms.dto.DmsExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DmsUserMapper {
    int countByExample(DmsExample example);

    int deleteByExample(DmsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DmsUser record);

    int insertSelective(DmsUser record);

    List<DmsUser> selectByExample(DmsExample example);

    DmsUser selectByPrimaryKey(Integer id);

    DmsUser selectForUserRegister(Map<String,Object> map);

    int updateByExampleSelective(@Param("record") DmsUser record, @Param("example") DmsExample example);

    int updateByExample(@Param("record") DmsUser record, @Param("example") DmsExample example);

    int updateByPrimaryKeySelective(DmsUser record);

    int updateByPrimaryKey(DmsUser record);
}