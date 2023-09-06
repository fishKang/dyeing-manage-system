package dms.application;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import dms.assembler.DmsCraftManageBOS;
import dms.common.CodeEnum;
import dms.convertor.ConvertorToMap;
import dms.domain.model.DmsCraftBO;
import dms.domain.model.common.DmsCommonBO;
import dms.domain.valueobject.DmsCraftVO;
import dms.util.MapUtil;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class QueryCraftAPS extends AbstractTradeAPS{
    @Autowired
    DmsCraftManageBOS dmsCraftManageBOS;
    @Override
    public Map<String, Object> mainProcess(Map<String, Object> map, Logger logger) {
        logger.info("QueryColorAPS-查询色号信息开始，入参为："+ JSONUtil.toJsonStr(map));
        try{
            DmsCraftVO dmsCraftVO= initInputParam(map,logger);
            dmsCraftManageBOS.queryCraft(dmsCraftVO,logger);
            logger.info("QueryColorAPS-查询色号信息结束，出参为："+ dmsCraftVO.toString());
            return ConvertorToMap.convertorSuccessMap(dmsCraftVO.getDmsCraftList());
        }catch (Exception e){
            return ConvertorToMap.convertorFailMap(CodeEnum.ERR_9999.getCode(),CodeEnum.ERR_9999.getMsg(),e.toString());
        }
    }

    public DmsCraftVO initInputParam(Map<String, Object> map, Logger logger){
        Map<String, Object> privateMap = MapUtil.nvl4Map(map,"private");
        DmsCraftBO dmsCraftBO = BeanUtil.mapToBean(privateMap, DmsCraftBO.class,true);

        DmsCraftVO dmsCraftVO = new DmsCraftVO();
        dmsCraftVO.setDmsCraftBO(dmsCraftBO);
        return dmsCraftVO;
    }
}
