package dms.mapper;

import dms.dto.DmsOperatelog;
import dms.dto.DmsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DmsOperatelogMapper {
    int countByExample(DmsExample example);

    int deleteByExample(DmsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DmsOperatelog record);

    int insertSelective(DmsOperatelog record);

    List<DmsOperatelog> selectByExample(DmsExample example);

    DmsOperatelog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DmsOperatelog record, @Param("example") DmsExample example);

    int updateByExample(@Param("record") DmsOperatelog record, @Param("example") DmsExample example);

    int updateByPrimaryKeySelective(DmsOperatelog record);

    int updateByPrimaryKey(DmsOperatelog record);

    int updateBySerialno(DmsOperatelog record);
}