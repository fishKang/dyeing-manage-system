package dms.mapper;

import dms.dto.DmsCraft;

import java.util.List;
import java.util.Map;

import dms.operations.DmsCraftExample;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DmsCraftMapper {
    int countByExample(DmsCraftExample example);

    int deleteByExample(DmsCraftExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DmsCraft record);

    int insertSelective(DmsCraft record);

    List<DmsCraft> selectByExample(DmsCraftExample example);
    @MapKey("id")
    List<Map> selectDmsCraftList(Map<String,Object> map);

    DmsCraft selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DmsCraft record, @Param("example") DmsCraftExample example);

    int updateByExample(@Param("record") DmsCraft record, @Param("example") DmsCraftExample example);

    int updateByPrimaryKeySelective(DmsCraft record);

    int updateByPrimaryKey(DmsCraft record);
}