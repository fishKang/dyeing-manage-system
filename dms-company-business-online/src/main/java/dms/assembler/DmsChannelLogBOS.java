package dms.assembler;

import cn.hutool.core.exceptions.StatefulException;
import dms.common.CodeEnum;
import dms.domain.valueobject.DmsChannelLogVO;
import dms.infrastructure.repository.DmsOperatelogRepository;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DmsChannelLogBOS {
    @Autowired
    DmsOperatelogRepository dmsOperatelogRepository;

    public void insertOperatelog(DmsChannelLogVO dmsChannelLogVO, Logger log){
        int i = dmsOperatelogRepository.insertOperatelog(dmsChannelLogVO,log);
        if(0 == i){
            throw new StatefulException(Integer.valueOf(CodeEnum.ERR_0100.getCode()), CodeEnum.ERR_0100.getMsg());
        }
    }

    public void updateOperatelog(DmsChannelLogVO dmsChannelLogVO, Logger log){
        int i = dmsOperatelogRepository.updateOperatelog(dmsChannelLogVO,log);
        if(0 == i){
            throw new StatefulException(Integer.valueOf(CodeEnum.ERR_0101.getCode()), CodeEnum.ERR_0101.getMsg());
        }
    }
}
