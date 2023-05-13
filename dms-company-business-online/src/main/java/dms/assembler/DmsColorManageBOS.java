package dms.assembler;

import dms.domain.valueobject.DmsColorVO;
import dms.domain.valueobject.DmsCustomerVO;
import dms.infrastructure.exception.BusinessFailException;
import dms.infrastructure.repository.DmsColorRepository;
import dms.infrastructure.repository.DmsCustomerRepository;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DmsColorManageBOS {

    @Autowired
    DmsColorRepository dmsColorRepository;

    public void queryColor(DmsColorVO dmsColorVO, Logger log) {
        dmsColorRepository.selectCustomerList(dmsColorVO,log);
    }
}
