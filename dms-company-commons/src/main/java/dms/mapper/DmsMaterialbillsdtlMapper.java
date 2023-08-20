package dms.mapper;

import dms.dto.DmsMaterialbillsdtl;

import java.util.List;

import dms.operations.DmsMaterialbillsdtlExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DmsMaterialbillsdtlMapper {
    int countByExample(DmsMaterialbillsdtlExample example);

    int deleteByExample(DmsMaterialbillsdtlExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DmsMaterialbillsdtl record);

    int insertSelective(DmsMaterialbillsdtl record);

    List<DmsMaterialbillsdtl> selectByExample(DmsMaterialbillsdtlExample example);

    DmsMaterialbillsdtl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DmsMaterialbillsdtl record, @Param("example") DmsMaterialbillsdtlExample example);

    int updateByExample(@Param("record") DmsMaterialbillsdtl record, @Param("example") DmsMaterialbillsdtlExample example);

    int updateByPrimaryKeySelective(DmsMaterialbillsdtl record);

    int updateByPrimaryKey(DmsMaterialbillsdtl record);
}