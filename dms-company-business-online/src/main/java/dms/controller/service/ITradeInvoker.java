package dms.controller.service;

import dms.domain.model.trade.TradeResponse;
import dms.domain.valueobject.DmsChannelLogVO;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public interface ITradeInvoker {
    public <T> TradeResponse<T> invoke(Map<String, Object> inputMap, DmsChannelLogVO dmsChannelLogVO, Logger log);
}
