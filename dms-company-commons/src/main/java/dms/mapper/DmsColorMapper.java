package dms.mapper;

import dms.dto.DmsColor;
import dms.dto.DmsExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DmsColorMapper {
    int countByExample(DmsExample example);

    int deleteByExample(DmsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DmsColor record);

    int insertSelective(DmsColor record);

    List<DmsColor> selectByExample(DmsExample example);

    List<Map> selectDmsColorList(Map<String,Object> map);

    DmsColor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DmsColor record, @Param("example") DmsExample example);

    int updateByExample(@Param("record") DmsColor record, @Param("example") DmsExample example);

    int updateByPrimaryKeySelective(DmsColor record);

    int updateByPrimaryKey(DmsColor record);
}