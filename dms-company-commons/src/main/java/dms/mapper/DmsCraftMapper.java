package dms.mapper;

import dms.dto.DmsCraft;
import dms.dto.DmsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DmsCraftMapper {
    int countByExample(DmsExample example);

    int deleteByExample(DmsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DmsCraft record);

    int insertSelective(DmsCraft record);

    List<DmsCraft> selectByExample(DmsExample example);

    DmsCraft selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DmsCraft record, @Param("example") DmsExample example);

    int updateByExample(@Param("record") DmsCraft record, @Param("example") DmsExample example);

    int updateByPrimaryKeySelective(DmsCraft record);

    int updateByPrimaryKey(DmsCraft record);
}