package dms.application;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import dms.assembler.DmsCustomerManageBOS;
import dms.common.CodeEnum;
import dms.convertor.ConvertorToMap;
import dms.domain.model.DmsCustomerBO;
import dms.domain.model.common.DmsCommonBO;
import dms.domain.valueobject.DmsCustomerVO;
import dms.infrastructure.exception.BusinessFailException;
import dms.util.MapUtil;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class QueryCustomerAPS extends AbstractTradeAPS{
    @Autowired
    DmsCustomerManageBOS dmsCustomerManageBOS;
    @Override
    public Map<String, Object> mainProcess(Map<String, Object> map, Logger logger) {
        logger.info("QueryCustomerAPS-查询客户信息开始，入参为："+ JSONUtil.toJsonStr(map));
        try{
            DmsCustomerVO dmsCustomerVO = initInputParam(map,logger);
            dmsCustomerManageBOS.queryCustomer(dmsCustomerVO,logger);
            logger.info("QueryCustomerAPS-查询客户信息结束，出参为："+ dmsCustomerVO.toString());
            return ConvertorToMap.convertorSuccessMap(dmsCustomerVO.getDmsCustomerList());
        }catch (BusinessFailException e){
            return ConvertorToMap.convertorFailMap(e.getCode(),e.getMsg(), e.getInfo());
        }catch (Exception e){
            return ConvertorToMap.convertorFailMap(CodeEnum.ERR_9999.getCode(),CodeEnum.ERR_9999.getMsg(),e.toString());
        }
    }

    public DmsCustomerVO initInputParam(Map<String, Object> map, Logger logger){
        Map<String, Object> dmscommon = MapUtil.nvl4Map(map,"dmscommon");
        DmsCommonBO dmsCommonBO = BeanUtil.mapToBean(dmscommon, DmsCommonBO.class,true);
        String serialno = IdUtil.fastUUID();
        dmsCommonBO.setSerialno(serialno);

        Map<String, Object> privateMap = MapUtil.nvl4Map(map,"private");
        DmsCustomerBO dmsCustomerBO = BeanUtil.mapToBean(privateMap, DmsCustomerBO.class,true);

        DmsCustomerVO dmsCustomerVO = new DmsCustomerVO();
        dmsCustomerVO.setDmsCommonBO(dmsCommonBO);
        dmsCustomerVO.setDmsCustomerBO(dmsCustomerBO);
        return dmsCustomerVO;
    }
}
