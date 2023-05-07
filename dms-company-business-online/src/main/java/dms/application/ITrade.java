package dms.application;

import dms.domain.model.trade.TradeResponse;

import java.util.Map;

public interface ITrade {
    public <T> TradeResponse<T> execute(Map<String,Object> map);
}
