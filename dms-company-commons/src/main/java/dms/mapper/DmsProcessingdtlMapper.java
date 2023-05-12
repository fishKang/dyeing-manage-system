package dms.mapper;

import dms.dto.DmsProcessingdtl;
import dms.dto.DmsExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DmsProcessingdtlMapper {
    int countByExample(DmsExample example);

    int deleteByExample(DmsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DmsProcessingdtl record);
    int insertSelective(DmsProcessingdtl record);

    List<DmsProcessingdtl> selectByExample(DmsExample example);

    List<Map> selectProcessingdtlList(Map<String,Object> map);

    DmsProcessingdtl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DmsProcessingdtl record, @Param("example") DmsExample example);

    int updateByExample(@Param("record") DmsProcessingdtl record, @Param("example") DmsExample example);

    int updateByPrimaryKeySelective(DmsProcessingdtl record);

    int updateByPrimaryKey(DmsProcessingdtl record);

    int updateDmsProcessingdtl(DmsProcessingdtl record);
}