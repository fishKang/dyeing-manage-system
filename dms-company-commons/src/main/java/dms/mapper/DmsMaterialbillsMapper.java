package dms.mapper;

import dms.dto.DmsMaterialbills;
import dms.dto.DmsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DmsMaterialbillsMapper {
    int countByExample(DmsExample example);

    int deleteByExample(DmsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DmsMaterialbills record);

    int insertSelective(DmsMaterialbills record);

    List<DmsMaterialbills> selectByExample(DmsExample example);

    DmsMaterialbills selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DmsMaterialbills record, @Param("example") DmsExample example);

    int updateByExample(@Param("record") DmsMaterialbills record, @Param("example") DmsExample example);

    int updateByPrimaryKeySelective(DmsMaterialbills record);

    int updateByPrimaryKey(DmsMaterialbills record);
}