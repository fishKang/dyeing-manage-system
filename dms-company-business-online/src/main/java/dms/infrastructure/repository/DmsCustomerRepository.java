package dms.infrastructure.repository;

import dms.domain.valueobject.DmsCustomerVO;
import dms.dto.DmsCustomer;
import dms.dto.DmsExample;
import dms.mapper.DmsCustomerMapper;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DmsCustomerRepository {
    @Autowired
    DmsCustomerMapper dmsCustomerMapper;

    public void selectCustomerList(DmsCustomerVO dmsCustomerVO , Logger log) {
        DmsExample dmsExample = new DmsExample();
        DmsExample.Criteria criteria= dmsExample.createCriteria();
        dmsExample.setOrderByClause("id");
        criteria.andNameLike("%"+dmsCustomerVO.getDmsCustomerBO().getName()+"%");
        List list =  dmsCustomerMapper.selectCustomerList(dmsExample);
        dmsCustomerVO.setDmsCustomerList(list);
    }
}
