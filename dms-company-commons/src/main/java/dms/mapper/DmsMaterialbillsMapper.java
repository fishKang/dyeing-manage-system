package dms.mapper;

import dms.dto.DmsMaterialbills;

import java.util.List;

import dms.operations.DmsMaterialbillsExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DmsMaterialbillsMapper {
    int countByExample(DmsMaterialbillsExample example);

    int deleteByExample(DmsMaterialbillsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DmsMaterialbills record);

    int insertSelective(DmsMaterialbills record);

    List<DmsMaterialbills> selectByExample(DmsMaterialbillsExample example);

    DmsMaterialbills selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DmsMaterialbills record, @Param("example") DmsMaterialbillsExample example);

    int updateByExample(@Param("record") DmsMaterialbills record, @Param("example") DmsMaterialbillsExample example);

    int updateByPrimaryKeySelective(DmsMaterialbills record);

    int updateByPrimaryKey(DmsMaterialbills record);
}