package dms.controller.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.exceptions.StatefulException;
import cn.hutool.core.exceptions.ValidateException;
import cn.hutool.core.util.StrUtil;
import dms.assembler.DmsChannelLogBOS;
import dms.common.CodeEnum;
import dms.common.CommonConstants;
import dms.domain.model.common.DmsChannelLogBO;
import dms.domain.model.common.DmsCommonBO;
import dms.domain.model.trade.TradeResponse;
import dms.domain.valueobject.DmsChannelLogVO;
import dms.util.SpringUtil;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractTradeService implements IService{
    @Autowired
    DmsChannelLogBOS dmsChannelLogBOS;

    public static final String REALINWOKE ="realTimeInvoker";// 实时发起者
    public static final String ASYWINWOKE = "asynchronousInvoker"; // 异步发起者
    public static final String BEGINTIME = "BEGINTIME"; // 开始时间戳key值
    public static final String ENDTIME = "ENDTIME";//'结束时间戳key值
    public static final Integer RESULTF_SUCCESS = 1;
    public static final Integer RESULTF_FAIL = 2;
    public static final Integer RESULTF_DEALING = 3;

    protected abstract DmsChannelLogVO initSrv(Map<String, Object> inputMap);

    protected void beforeTrade(Map<String, Object> inputMap) {
    }
    protected void afterTrade(Map<String, Object> inputMap) {
    }

    @Override
    public final Map<String, Object> invoke(Map<String, Object> inputMap) {
        String className = this.getClass().getSimpleName();
        DmsChannelLogVO dmsChannelLogVO = initSrv(inputMap);
        DmsChannelLogBO dmsChannelLogBO = dmsChannelLogVO.getDmsChannelLogBO();
        DmsCommonBO dmsCommonBO = dmsChannelLogVO.getDmsCommonBO();
        Logger log = dmsChannelLogBO.getLogger();
        log.info(className + ":接收到外围请求" + inputMap);
        log.info(className + "-start.交易处理开始");
        Integer stepNo = 0;
        inputMap.put(BEGINTIME, DateUtil.formatTime(new Date()));
        try {
            stepNo++;
            log.info(className + "step" + stepNo + "：输入公共通讯区转换");
            //设置线程名
            Thread.currentThread().setName(dmsCommonBO.getSerialno());

            stepNo++;
            log.info(className + "step" + stepNo + "：输入通讯区校验");
            checkDate(dmsChannelLogBO, log);

            stepNo++;
            log.info(className + "step" + stepNo + "：交易前处理");
            beforeTrade(inputMap);
            if (dmsChannelLogBO.isRegChanLog()) {
                stepNo++;
                log.info(className + "step" + stepNo + "：登记渠道日志");
                registChanLog(dmsChannelLogVO, log);
            }
            stepNo++;
            log.info(className + "step" + stepNo + "发起者调用交易");
            TradeResponse<Object> response = executeTrade(inputMap,dmsChannelLogVO,log);
            stepNo++;
            log.info(className + "step" + stepNo + "：交易后处理");
            afterTrade(inputMap);
            if (dmsChannelLogBO.isRegChanLog()) {
                inputMap.put(ENDTIME, DateUtil.formatTime(new Date()));
                stepNo++;
                log.info(className + "step" + stepNo + "更新渠道日志");
                updateChanLog(dmsChannelLogVO,response,log);
                stepNo++;
            }

            log.info(className + "step" + stepNo + "服务返回处理");
            return getRetMap(inputMap, response);
        } catch (StatefulException e) {
            String errinfo = className + "服务处理异常：" +e.toString();
            log.error(errinfo);
            return getExceptionRetMap(inputMap, String.valueOf(e.getStatus()), e.getMessage(), errinfo);
        } catch (Exception e) {
            String errinfo = className + "服务处理异常：" +e.toString();
            log.error(errinfo);
            return getExceptionRetMap(inputMap, CodeEnum.ERR_9999.getCode(), CodeEnum.ERR_9999.getMsg(), errinfo);
        }
    }

    private void updateChanLog(DmsChannelLogVO dmsChannelLogVO,TradeResponse tradeResponse,Logger log){
        dmsChannelLogBOS.updateOperatelog(dmsChannelLogVO,log);
    }

    private void registChanLog(DmsChannelLogVO dmsChannelLogVO,Logger log){
        dmsChannelLogBOS.insertOperatelog(dmsChannelLogVO,log);
    }

    private <T> TradeResponse<T> executeTrade(Map<String, Object> inputMap,DmsChannelLogVO dmsChannelLogVO,Logger log){
        ITradeInvoker invoker = getTradeInvoker(false);
        return invoker.invoke(inputMap,dmsChannelLogVO,log);
    }

    public <T> Map<String, Object> getRetMap(Map<String, Object> inputMap,TradeResponse tradeResponse){
        Map<String, Object> outputMap = new HashMap<>();
        outputMap.put(CommonConstants.RETCODE,tradeResponse.getReturncode());
        outputMap.put(CommonConstants.RETMSG,tradeResponse.getReturnmsg());
        outputMap.put(CommonConstants.RETINFO,tradeResponse.getReturninfo());
        outputMap.put("private",tradeResponse.getData());
        return outputMap;
    }

    public <T> Map<String, Object> getExceptionRetMap(Map<String, Object> inputMap,String errorcode,String errormsg,String errorinfo){
        Map<String, Object> outputMap = new HashMap<>();
        outputMap.put(CommonConstants.RETCODE,errorcode);
        outputMap.put(CommonConstants.RETMSG,errormsg);
        outputMap.put(CommonConstants.RETINFO,errorinfo);
        outputMap.put("private",inputMap);
        return outputMap;
    }

    public void checkDate(DmsChannelLogBO dmsChannelLogBO,Logger log){
        String inputDate = dmsChannelLogBO.getIndate();
        String systemDate = DateUtil.date().toString("yyyy-MM-dd");
        if(StrUtil.isEmpty(inputDate)){
            log.info("日期检查：交易日期为空");
            throw new ValidateException("交易日期为空");
        }
        if(StrUtil.isEmpty(systemDate)){
            log.info("日期检查：系统日期为空");
            throw new ValidateException("交易日期为空");
        }
        Date tmpInputDate = DateUtil.parse(inputDate,"yyyy-mm-dd");
        Date tmpSystemDate = DateUtil.parse(systemDate,"yyyy-mm-dd");
        if(tmpInputDate.compareTo(tmpSystemDate) != 0){
            log.info("日期检查：系统日期与交易日期不同.交易日期"+inputDate+"，系统日期"+systemDate);
            throw new ValidateException("系统日期与交易日期不同.交易日期"+inputDate+"，系统日期"+systemDate);
        }

    }
    protected ITradeInvoker getTradeInvoker(boolean isAsyInvoke) {
        if (isAsyInvoke) {
            return (ITradeInvoker) SpringUtil.getBean(ASYWINWOKE);
        } else {
            return (ITradeInvoker) SpringUtil.getBean(REALINWOKE);
        }
    }
}
