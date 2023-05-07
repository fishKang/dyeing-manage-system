package dms.controller.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.exceptions.ExceptionUtil;
import dms.application.ITrade;
import dms.domain.model.trade.TradeResponse;
import dms.domain.valueobject.DmsChannelLogVO;
import dms.util.SpringUtil;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RealTimeInvoker implements ITradeInvoker{
    @Override
    public <T> TradeResponse<T> invoke(Map<String, Object> inputMap, DmsChannelLogVO dmsChannelLogVO, Logger log) {
        try{
            ITrade iTrade = (ITrade) SpringUtil.getBean(dmsChannelLogVO.getDmsChannelLogBO().getApsservice());
            return iTrade.execute(inputMap);
        }catch (Exception e){
            String errorMsg = ExceptionUtil.getMessage(e);
            return TradeResponse.createFailResponse("9999",errorMsg);
        }

    }
}
