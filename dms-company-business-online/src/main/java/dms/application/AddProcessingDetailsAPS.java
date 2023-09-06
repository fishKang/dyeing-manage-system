package dms.application;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import dms.assembler.DmsProcessingdtlManageBOS;
import dms.common.CodeEnum;
import dms.convertor.ConvertorToMap;
import dms.domain.model.DmsProcessingdtlBO;
import dms.domain.model.common.DmsCommonBO;
import dms.domain.valueobject.DmsProcessingdtlVO;
import dms.infrastructure.exception.BusinessFailException;
import dms.util.MapUtil;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class AddProcessingDetailsAPS extends AbstractTradeAPS{
    @Autowired
    DmsProcessingdtlManageBOS dmsProcessingdtlManageBOS;
    @Override
    public Map<String, Object> mainProcess(Map<String, Object> map, Logger logger) {
        logger.info("AddProcessingDetailsAPS-添加明细开始，入参为："+ JSONUtil.toJsonStr(map));
        try{
            DmsProcessingdtlVO dmsProcessingdtlVO = initInputParam(map,logger);
            dmsProcessingdtlManageBOS.addProcessingdtl(dmsProcessingdtlVO,logger);
            logger.info("AddProcessingDetailsAPS-添加明细结束，出参为："+ dmsProcessingdtlVO.toString());
            return ConvertorToMap.convertorSuccessMap();
        }catch (BusinessFailException e){
            return ConvertorToMap.convertorFailMap(e.getCode(),e.getMsg(), e.getInfo());
        }catch (Exception e){
            return ConvertorToMap.convertorFailMap(CodeEnum.ERR_9999.getCode(),CodeEnum.ERR_9999.getMsg(),e.toString());
        }
    }

    public DmsProcessingdtlVO initInputParam(Map<String, Object> map, Logger logger){
        Map<String, Object> privateMap = MapUtil.nvl4Map(map,"private");
        DmsProcessingdtlBO dmsProcessingdtlBO = BeanUtil.mapToBean(privateMap, DmsProcessingdtlBO.class,true);
        if(null == dmsProcessingdtlBO.getAmount() || dmsProcessingdtlBO.getAmount().compareTo(new BigDecimal(0)) == 0){
            dmsProcessingdtlBO.setAmount(dmsProcessingdtlBO.getSettlementvolume().multiply(dmsProcessingdtlBO.getPrice()));
        }
        DmsProcessingdtlVO dmsProcessingdtlVO = new DmsProcessingdtlVO();
        dmsProcessingdtlVO.setDmsProcessingdtlBO(dmsProcessingdtlBO);
        return dmsProcessingdtlVO;
    }
}
