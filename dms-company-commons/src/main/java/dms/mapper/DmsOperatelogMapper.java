package dms.mapper;

import dms.dto.DmsOperatelog;

import java.util.List;

import dms.operations.DmsOperatelogExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DmsOperatelogMapper {
    int countByExample(DmsOperatelogExample example);

    int deleteByExample(DmsOperatelogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DmsOperatelog record);

    int insertSelective(DmsOperatelog record);

    List<DmsOperatelog> selectByExample(DmsOperatelogExample example);

    DmsOperatelog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DmsOperatelog record, @Param("example") DmsOperatelogExample example);

    int updateByExample(@Param("record") DmsOperatelog record, @Param("example") DmsOperatelogExample example);

    int updateByPrimaryKeySelective(DmsOperatelog record);

    int updateByPrimaryKey(DmsOperatelog record);

    int updateBySerialno(DmsOperatelog record);
}