package dms.mapper;

import dms.dto.DmsDye;
import dms.dto.DmsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DmsDyeMapper {
    int countByExample(DmsExample example);

    int deleteByExample(DmsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DmsDye record);

    int insertSelective(DmsDye record);

    List<DmsDye> selectByExample(DmsExample example);

    DmsDye selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DmsDye record, @Param("example") DmsExample example);

    int updateByExample(@Param("record") DmsDye record, @Param("example") DmsExample example);

    int updateByPrimaryKeySelective(DmsDye record);

    int updateByPrimaryKey(DmsDye record);
}