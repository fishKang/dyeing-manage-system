package dms.application;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import dms.assembler.DmsColorManageBOS;
import dms.common.CodeEnum;
import dms.convertor.ConvertorToMap;
import dms.domain.model.DmsColorBO;
import dms.domain.model.common.DmsCommonBO;
import dms.domain.valueobject.DmsColorVO;
import dms.infrastructure.exception.BusinessFailException;
import dms.util.MapUtil;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class QueryColorAPS extends AbstractTradeAPS{
    @Autowired
    DmsColorManageBOS dmsColorManageBOS;
    @Override
    public Map<String, Object> mainProcess(Map<String, Object> map, Logger logger) {
        logger.info("QueryColorAPS-查询色号信息开始，入参为："+ JSONUtil.toJsonStr(map));
        try{
            DmsColorVO dmsColorVO = initInputParam(map,logger);
            dmsColorManageBOS.queryColor(dmsColorVO,logger);
            logger.info("QueryColorAPS-查询色号信息结束，出参为："+ dmsColorVO.toString());
            return ConvertorToMap.convertorSuccessMap(dmsColorVO.getDmsColorList());
        }catch (Exception e){
            return ConvertorToMap.convertorFailMap(CodeEnum.ERR_9999.getCode(),CodeEnum.ERR_9999.getMsg(),e.toString());
        }
    }

    public DmsColorVO initInputParam(Map<String, Object> map, Logger logger){
        Map<String, Object> dmscommon = MapUtil.nvl4Map(map,"dmscommon");
        DmsCommonBO dmsCommonBO = BeanUtil.mapToBean(dmscommon, DmsCommonBO.class,true);
        String serialno = IdUtil.fastUUID();
        dmsCommonBO.setSerialno(serialno);

        Map<String, Object> privateMap = MapUtil.nvl4Map(map,"private");
        DmsColorBO dmsColorBO = BeanUtil.mapToBean(privateMap, DmsColorBO.class,true);

        DmsColorVO dmsColorVO = new DmsColorVO();
        dmsColorVO.setDmsCommonBO(dmsCommonBO);
        dmsColorVO.setDmsColorBO(dmsColorBO);
        return dmsColorVO;
    }
}
