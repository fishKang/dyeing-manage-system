package dms.assembler;

import dms.domain.valueobject.DmsCraftVO;
import dms.infrastructure.repository.DmsCraftRepository;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DmsCraftManageBOS {

    @Autowired
    DmsCraftRepository dmsCraftRepository;

    public void queryCraft(DmsCraftVO dmsCraftVO, Logger log) {
        dmsCraftRepository.selectCraftList(dmsCraftVO,log);
    }
}
