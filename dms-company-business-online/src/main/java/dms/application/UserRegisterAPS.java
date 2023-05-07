package dms.application;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import dms.assembler.DmsUserManageBOS;
import dms.common.CodeEnum;
import dms.convertor.ConvertorToMap;
import dms.domain.model.common.DmsCommonBO;
import dms.domain.model.user.DmsUserBO;
import dms.domain.valueobject.DmsUserVO;
import dms.infrastructure.exception.BusinessFailException;
import dms.util.MapUtil;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class UserRegisterAPS extends AbstractTradeAPS{
    @Autowired
    DmsUserManageBOS dmsUserManageBOS;
    @Override
    public Map<String, Object> mainProcess(Map<String, Object> map, Logger logger) {
        logger.info("UserRegisterAPS-用户注册开始，入参为："+ JSONUtil.toJsonStr(map));
        try{
            DmsUserVO dmsUserVO = initInputParam(map,logger);
            dmsUserManageBOS.userRegister(dmsUserVO,logger);
        }catch (BusinessFailException e){
            return ConvertorToMap.convertorFailMap(e.getCode(),e.getMsg(), e.getInfo());
        }catch (Exception e){
            return ConvertorToMap.convertorFailMap(CodeEnum.ERR_9999.getCode(),CodeEnum.ERR_9999.getMsg(),e.toString());
        }
        logger.info("UserRegisterAPS-用户注册结束，出参为："+ JSONUtil.toJsonStr(map));
        return ConvertorToMap.convertorSuccessMap();
    }

    public DmsUserVO initInputParam(Map<String, Object> map, Logger logger){
        Map<String, Object> dmscommon = MapUtil.nvl4Map(map,"dmscommon");
        DmsCommonBO dmsCommonBO = BeanUtil.mapToBean(dmscommon, DmsCommonBO.class,true);
        String serialno = IdUtil.fastUUID();
        dmsCommonBO.setSerialno(serialno);

        Map<String, Object> privateMap = MapUtil.nvl4Map(map,"private");
        DmsUserBO dmsUserBO = BeanUtil.mapToBean(privateMap, DmsUserBO.class,true);

        DmsUserVO dmsUserVO = new DmsUserVO();
        dmsUserVO.setDmsCommonBO(dmsCommonBO);
        dmsUserVO.setDmsUserBO(dmsUserBO);
        return dmsUserVO;
    }
}
