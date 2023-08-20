package dms.mapper;

import dms.dto.DmsProcessingdtl;

import java.util.List;
import java.util.Map;

import dms.operations.DmsProcessingdtlExample;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DmsProcessingdtlMapper {
    int countByExample(DmsProcessingdtlExample example);

    int deleteByExample(DmsProcessingdtlExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DmsProcessingdtl record);
    int insertSelective(DmsProcessingdtl record);

    List<DmsProcessingdtl> selectByExample(DmsProcessingdtlExample example);
    @MapKey("id")
    List<Map> selectProcessingdtlList(Map<String,Object> map);

    DmsProcessingdtl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DmsProcessingdtl record, @Param("example") DmsProcessingdtlExample example);

    int updateByExample(@Param("record") DmsProcessingdtl record, @Param("example") DmsProcessingdtlExample example);

    int updateByPrimaryKeySelective(DmsProcessingdtl record);

    int updateByPrimaryKey(DmsProcessingdtl record);

    int updateDmsProcessingdtl(DmsProcessingdtl record);
}