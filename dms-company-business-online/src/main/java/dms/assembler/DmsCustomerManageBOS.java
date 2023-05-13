package dms.assembler;

import dms.domain.valueobject.DmsCustomerVO;
import dms.infrastructure.exception.BusinessFailException;
import dms.infrastructure.repository.DmsCustomerRepository;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DmsCustomerManageBOS {

    @Autowired
    DmsCustomerRepository dmsCustomerRepository;

    public void queryCustomer(DmsCustomerVO dmsCustomerVO, Logger log) throws BusinessFailException {
        dmsCustomerRepository.selectCustomerList(dmsCustomerVO,log);
    }
}
