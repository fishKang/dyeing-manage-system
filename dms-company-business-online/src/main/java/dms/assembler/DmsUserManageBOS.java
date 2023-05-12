package dms.assembler;

import cn.hutool.core.bean.BeanUtil;
import dms.common.CodeEnum;
import dms.domain.valueobject.DmsUserVO;
import dms.dto.DmsUser;
import dms.infrastructure.exception.BusinessFailException;
import dms.infrastructure.repository.DmsUserRepository;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DmsUserManageBOS {

    @Autowired
    DmsUserRepository dmsUserRepository;

    public void userRegister(DmsUserVO dmsUserVO, Logger log) throws BusinessFailException {
        DmsUser dmsUser = dmsUserRepository.selectForUserRegister(dmsUserVO,log);
        if(null == dmsUser){
            int i = dmsUserRepository.insertForUserRegister(dmsUserVO,log);
            if(0 == i){
                log.info("DmsUserManageBOS-用户注册失败"+ dmsUserVO.toString());
                throw new BusinessFailException(CodeEnum.ERR_0004.getCode(),CodeEnum.ERR_0004.getMsg());
            }
        }else {
            log.info("DmsUserManageBOS-用户已注册"+ dmsUserVO.toString());
            throw new BusinessFailException(CodeEnum.ERR_0003.getCode(),CodeEnum.ERR_0003.getMsg());
        }
    }

    public void userLogin(DmsUserVO dmsUserVO, Logger log) throws BusinessFailException {
        DmsUser dmsUser = dmsUserRepository.selectForUserRegister(dmsUserVO,log);
        if(null == dmsUser){
            log.info("DmsUserManageBOS-用户登录失败"+ dmsUserVO.toString());
            throw new BusinessFailException(CodeEnum.ERR_0005.getCode(),CodeEnum.ERR_0005.getMsg());
        }
        BeanUtil.copyProperties(dmsUser,dmsUserVO.getDmsUserBO());
    }
}
