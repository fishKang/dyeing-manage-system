package dms.mapper;

import dms.dto.DmsColor;
import dms.operations.DmsColorExample;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
@Mapper
public interface DmsColorMapper {
    int countByExample(DmsColorExample example);

    int deleteByExample(DmsColorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DmsColor record);

    int insertSelective(DmsColor record);
    @MapKey("id")
    List<Map<String,Object>> selectDmsColorList(Map<String,Object> map);

    List<DmsColor> selectByExample(DmsColorExample example);

    DmsColor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DmsColor record, @Param("example") DmsColorExample example);

    int updateByExample(@Param("record") DmsColor record, @Param("example") DmsColorExample example);

    int updateByPrimaryKeySelective(DmsColor record);

    int updateByPrimaryKey(DmsColor record);
}