package dms.application;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import common.SequenceConstants;
import dms.assembler.DmsProcessingdtlManageBOS;
import dms.assembler.DmsSequenceBOS;
import dms.common.CodeEnum;
import dms.common.LoggerConstants;
import dms.convertor.ConvertorToMap;
import dms.domain.model.DmsProcessingdtlBO;
import dms.domain.model.common.DmsCommonBO;
import dms.domain.valueobject.DmsProcessingdtlVO;
import dms.util.MapUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class QueryProcessingDetailsAPS extends AbstractTradeAPS{
    @Autowired
    DmsProcessingdtlManageBOS dmsProcessingdtlManageBOS;
    @Autowired
    DmsSequenceBOS dmsSequenceBOS;
    @Override
    public Map<String, Object> mainProcess(Map<String, Object> map, Logger logger) {
        logger.info("QueryProcessingDetailsAPS-查询明细开始，入参为："+ JSONUtil.toJsonStr(map));
        try{
            DmsProcessingdtlVO dmsProcessingdtlVO = initInputParam(map,logger);
            dmsProcessingdtlManageBOS.queryProcessingdtl(dmsProcessingdtlVO,logger);
            dmsSequenceBOS.updateCurrentValue(SequenceConstants.PROCESSINGDETAILS);
            logger.info("QueryProcessingDetailsAPS-查询明细结束，出参为："+ dmsProcessingdtlVO.toString());
            return ConvertorToMap.convertorSuccessMap(dmsProcessingdtlVO.getDmsProcessingdtlBOList());
        }catch (Exception e){
            return ConvertorToMap.convertorFailMap(CodeEnum.ERR_9999.getCode(),CodeEnum.ERR_9999.getMsg(),e.toString());
        }
    }

    public DmsProcessingdtlVO initInputParam(Map<String, Object> map, Logger logger){
        Map<String, Object> privateMap = MapUtil.nvl4Map(map,"private");
        DmsProcessingdtlBO dmsProcessingdtlBO = BeanUtil.mapToBean(privateMap, DmsProcessingdtlBO.class,true);

        DmsProcessingdtlVO dmsProcessingdtlVO = new DmsProcessingdtlVO();
        dmsProcessingdtlVO.setDmsProcessingdtlBO(dmsProcessingdtlBO);
        return dmsProcessingdtlVO;
    }
}
