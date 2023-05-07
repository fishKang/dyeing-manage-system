package dms.mapper;

import dms.dto.DmsCustomer;
import dms.dto.DmsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DmsCustomerMapper {
    int countByExample(DmsExample example);

    int deleteByExample(DmsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DmsCustomer record);

    int insertSelective(DmsCustomer record);

    List<DmsCustomer> selectByExample(DmsExample example);

    DmsCustomer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DmsCustomer record, @Param("example") DmsExample example);

    int updateByExample(@Param("record") DmsCustomer record, @Param("example") DmsExample example);

    int updateByPrimaryKeySelective(DmsCustomer record);

    int updateByPrimaryKey(DmsCustomer record);
}