package dms.mapper;

import dms.dto.DmsDye;

import java.util.List;

import dms.operations.DmsDyeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DmsDyeMapper {
    int countByExample(DmsDyeExample example);

    int deleteByExample(DmsDyeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DmsDye record);

    int insertSelective(DmsDye record);

    List<DmsDye> selectByExample(DmsDyeExample example);

    DmsDye selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DmsDye record, @Param("example") DmsDyeExample example);

    int updateByExample(@Param("record") DmsDye record, @Param("example") DmsDyeExample example);

    int updateByPrimaryKeySelective(DmsDye record);

    int updateByPrimaryKey(DmsDye record);
}