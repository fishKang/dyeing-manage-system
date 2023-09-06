package dms.controller.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import common.SequenceConstants;
import dms.common.LoggerConstants;
import dms.controller.service.AbstractTradeService;
import dms.controller.service.IDmsServiceARS;
import dms.domain.model.common.DmsChannelLogBO;
import dms.domain.model.common.DmsCommonBO;
import dms.domain.valueobject.DmsChannelLogVO;
import dms.util.MapUtil;
import dms.util.SeqUtil;
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
        dmsChannelLogBO.setOriginal(dmsChannelLogBO.getSerialno());
        dmsChannelLogBO.setSerialno(dmsChannelLogBO.getSerialno());
//        dmsChannelLogBO.setSerialno(SeqUtil.getSerialNo(SequenceConstants.BUSINESS));
        dmsChannelLogBO.setRegChanLog(true);
        dmsChannelLogBO.setIndate(dmsCommonBO.getWorkdate());
        dmsChannelLogBO.setIntime(dmsCommonBO.getWorktime());
        dmsChannelLogBO.setLogger(LogManager.getLogger(LoggerConstants.CHANNEL));
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
