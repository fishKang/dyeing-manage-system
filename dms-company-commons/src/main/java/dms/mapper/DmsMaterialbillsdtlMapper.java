package dms.mapper;

import dms.dto.DmsMaterialbillsdtl;
import dms.dto.DmsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DmsMaterialbillsdtlMapper {
    int countByExample(DmsExample example);

    int deleteByExample(DmsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DmsMaterialbillsdtl record);

    int insertSelective(DmsMaterialbillsdtl record);

    List<DmsMaterialbillsdtl> selectByExample(DmsExample example);

    DmsMaterialbillsdtl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DmsMaterialbillsdtl record, @Param("example") DmsExample example);

    int updateByExample(@Param("record") DmsMaterialbillsdtl record, @Param("example") DmsExample example);

    int updateByPrimaryKeySelective(DmsMaterialbillsdtl record);

    int updateByPrimaryKey(DmsMaterialbillsdtl record);
}