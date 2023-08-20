package dms.infrastructure.repository;

import dms.domain.valueobject.DmsCustomerVO;
import dms.mapper.DmsCustomerMapper;
import dms.operations.DmsCustomerExample;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DmsCustomerRepository {
    @Autowired
    DmsCustomerMapper dmsCustomerMapper;

    public void selectCustomerList(DmsCustomerVO dmsCustomerVO , Logger log) {
        DmsCustomerExample DmsCustomerExample = new DmsCustomerExample();
        DmsCustomerExample.Criteria criteria= DmsCustomerExample.createCriteria();
        DmsCustomerExample.setOrderByClause("id");
        criteria.andNameLike("%"+dmsCustomerVO.getDmsCustomerBO().getName()+"%");
        List list =  dmsCustomerMapper.selectCustomerList(DmsCustomerExample);
        dmsCustomerVO.setDmsCustomerList(list);
    }
}
