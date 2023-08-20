package dms.mapper;

import dms.dto.DmsCustomer;

import java.util.List;
import java.util.Map;

import dms.operations.DmsCustomerExample;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DmsCustomerMapper {
    int countByExample(DmsCustomerExample example);

    int deleteByExample(DmsCustomerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DmsCustomer record);

    int insertSelective(DmsCustomer record);

    List<DmsCustomer> selectByExample(DmsCustomerExample example);

    @MapKey("id")
    List<Map> selectCustomerList(DmsCustomerExample example);

    DmsCustomer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DmsCustomer record, @Param("example") DmsCustomerExample example);

    int updateByExample(@Param("record") DmsCustomer record, @Param("example") DmsCustomerExample example);

    int updateByPrimaryKeySelective(DmsCustomer record);

    int updateByPrimaryKey(DmsCustomer record);
}