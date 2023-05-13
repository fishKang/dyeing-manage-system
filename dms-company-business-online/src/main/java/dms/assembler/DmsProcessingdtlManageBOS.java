package dms.assembler;

import dms.common.CodeEnum;
import dms.domain.valueobject.DmsProcessingdtlVO;
import dms.infrastructure.exception.BusinessFailException;
import dms.infrastructure.repository.DmsProcessingdtlRepository;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DmsProcessingdtlManageBOS {

    @Autowired
    DmsProcessingdtlRepository dmsProcessingdtlRepository;

    public void addProcessingdtl(DmsProcessingdtlVO dmsProcessingdtlVO, Logger log) throws BusinessFailException {
        int i = dmsProcessingdtlRepository.addProcessingdtl(dmsProcessingdtlVO,log);
        if(0 == i){
            log.info("DmsProcessingdtlManageBOS-加工明细插入失败"+ dmsProcessingdtlVO.toString());
            throw new BusinessFailException(CodeEnum.ERR_0006.getCode(),CodeEnum.ERR_0006.getMsg());
        }
    }

    public void queryProcessingdtl(DmsProcessingdtlVO dmsProcessingdtlVO, Logger log)  {
        dmsProcessingdtlRepository.selectProcessingdtlList(dmsProcessingdtlVO,log);
    }

    public void updateProcessingdtl(DmsProcessingdtlVO dmsProcessingdtlVO, Logger log) throws BusinessFailException {
        int i = dmsProcessingdtlRepository.updateProcessingdtl(dmsProcessingdtlVO,log);
        if(0 == i){
            log.info("DmsProcessingdtlManageBOS-加工明细更新失败"+ dmsProcessingdtlVO.toString());
            throw new BusinessFailException(CodeEnum.ERR_0007.getCode(),CodeEnum.ERR_0007.getMsg());
        }
    }
}
