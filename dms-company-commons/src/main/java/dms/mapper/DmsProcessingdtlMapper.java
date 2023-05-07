package dms.mapper;

import dms.dto.DmsProcessingdtl;
import dms.dto.DmsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DmsProcessingdtlMapper {
    int countByExample(DmsExample example);

    int deleteByExample(DmsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DmsProcessingdtl record);

    int insertSelective(DmsProcessingdtl record);

    List<DmsProcessingdtl> selectByExample(DmsExample example);

    DmsProcessingdtl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DmsProcessingdtl record, @Param("example") DmsExample example);

    int updateByExample(@Param("record") DmsProcessingdtl record, @Param("example") DmsExample example);

    int updateByPrimaryKeySelective(DmsProcessingdtl record);

    int updateByPrimaryKey(DmsProcessingdtl record);
}