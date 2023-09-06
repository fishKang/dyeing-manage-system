package dms.application;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import dms.assembler.DmsUserManageBOS;
import dms.common.CodeEnum;
import dms.convertor.ConvertorToMap;
import dms.domain.model.common.DmsCommonBO;
import dms.domain.model.DmsUserBO;
import dms.domain.valueobject.DmsUserVO;
import dms.infrastructure.exception.BusinessFailException;
import dms.util.MapUtil;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserRegisterAPS extends AbstractTradeAPS{
    @Autowired
    DmsUserManageBOS dmsUserManageBOS;
    @Override
    public Map<String, Object> mainProcess(Map<String, Object> map, Logger logger) {
        logger.info("UserRegisterAPS-用户注册开始，入参为："+ JSONUtil.toJsonStr(map));
        try{
            DmsUserVO dmsUserVO = initInputParam(map,logger);
            dmsUserManageBOS.userRegister(dmsUserVO,logger);
            logger.info("UserRegisterAPS-用户注册结束，出参为："+ JSONUtil.toJsonStr(map));
            return ConvertorToMap.convertorSuccessMap();
        }catch (BusinessFailException e){
            return ConvertorToMap.convertorFailMap(e.getCode(),e.getMsg(), e.getInfo());
        }catch (Exception e){
            return ConvertorToMap.convertorFailMap(CodeEnum.ERR_9999.getCode(),CodeEnum.ERR_9999.getMsg(),e.toString());
        }

    }

    public DmsUserVO initInputParam(Map<String, Object> map, Logger logger){
        Map<String, Object> privateMap = MapUtil.nvl4Map(map,"private");
        DmsUserBO dmsUserBO = BeanUtil.mapToBean(privateMap, DmsUserBO.class,true);

        DmsUserVO dmsUserVO = new DmsUserVO();
        dmsUserVO.setDmsUserBO(dmsUserBO);
        return dmsUserVO;
    }
}
