package dms.controller.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import dms.common.LoggerConstants;
import dms.controller.service.AbstractTradeService;
import dms.controller.service.IDmsServiceARS;
import dms.domain.model.common.DmsChannelLogBO;
import dms.domain.model.common.DmsCommonBO;
import dms.domain.valueobject.DmsChannelLogVO;
import dms.util.MapUtil;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class IDmsServiceARSImpl extends AbstractTradeService implements IDmsServiceARS {
    public static final String METHOD = "method";
    public static final String APSSERVICE = "apsservice";
    public static final String MAINPROCESS = "mainProcess";

    @Override
    protected DmsChannelLogVO initSrv(Map<String, Object> inputMap) {
        DmsChannelLogVO dmsChannelLogVO = new DmsChannelLogVO();
        Map<String, Object> dmscommon = MapUtil.nvl4Map(inputMap,"dmscommon");
        DmsCommonBO dmsCommonBO = BeanUtil.mapToBean(dmscommon, DmsCommonBO.class,true);
        DmsChannelLogBO dmsChannelLogBO = BeanUtil.mapToBean(dmscommon, DmsChannelLogBO.class,true);
        dmsChannelLogBO.setApsservice(MapUtil.nvl(inputMap,"apsservice"));
        dmsChannelLogBO.setRegChanLog(true);
        dmsChannelLogBO.setIndate(dmsCommonBO.getWorkdate());
        dmsChannelLogBO.setIntime(dmsCommonBO.getWorktime());
        dmsChannelLogBO.setLogger(LogManager.getLogger(LoggerConstants.BUSINESS));
        dmsChannelLogBO.setInput(JSONUtil.toJsonStr(inputMap));

        dmsChannelLogVO.setDmsChannelLogBO(dmsChannelLogBO);
        dmsChannelLogVO.setDmsCommonBO(dmsCommonBO);
        return dmsChannelLogVO;
    }

    @Override
    public Map<String, Object> userRegister(Map<String, Object> inputMap) {
        inputMap.put(APSSERVICE,"userRegisterAPS");
        inputMap.put(METHOD,MAINPROCESS);
        return execute(inputMap);
    }

    @Override
    public Map<String, Object> userLogin(Map<String, Object> inputMap) {
        inputMap.put(APSSERVICE,"userLoginAPS");
        inputMap.put(METHOD,MAINPROCESS);
        return execute(inputMap);
    }

    @Override
    public Map<String, Object> queryCustomer(Map<String, Object> inputMap) {
        inputMap.put(APSSERVICE,"queryCustomerAPS");
        inputMap.put(METHOD,MAINPROCESS);
        return execute(inputMap);
    }

    @Override
    public Map<String, Object> addProcessingDetails(Map<String, Object> inputMap) {
        inputMap.put(APSSERVICE,"addProcessingDetailsAPS");
        inputMap.put(METHOD,MAINPROCESS);
        return execute(inputMap);
    }

    @Override
    public Map<String, Object> queryProcessingDetails(Map<String, Object> inputMap) {
        inputMap.put(APSSERVICE,"queryProcessingDetailsAPS");
        inputMap.put(METHOD,MAINPROCESS);
        return execute(inputMap);
    }

    @Override
    public Map<String, Object> updateProcessingDetails(Map<String, Object> inputMap) {
        inputMap.put(APSSERVICE,"updateProcessingDetailsAPS");
        inputMap.put(METHOD,MAINPROCESS);
        return execute(inputMap);
    }

    @Override
    public Map<String, Object> queryColor(Map<String, Object> inputMap) {
        inputMap.put(APSSERVICE,"queryColorAPS");
        inputMap.put(METHOD,MAINPROCESS);
        return execute(inputMap);
    }

    @Override
    public Map<String, Object> queryCraft(Map<String, Object> inputMap) {
        inputMap.put(APSSERVICE,"queryCraftAPS");
        inputMap.put(METHOD,MAINPROCESS);
        return execute(inputMap);
    }

    public Map<String, Object> execute(Map<String, Object> inputMap){
        Map<String, Object> result = super.invoke(inputMap);
        return result;
    }
}
