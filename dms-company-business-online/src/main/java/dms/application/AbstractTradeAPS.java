package dms.application;

import cn.hutool.json.JSONUtil;
import dms.common.CodeEnum;
import dms.common.LoggerConstants;
import dms.domain.model.trade.TradeResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import mybatis.executor.SqlExecutor;

import java.util.Map;

public abstract class AbstractTradeAPS implements ITrade{
    @Override
    public <T> TradeResponse<T> execute(Map<String,Object> map){
        Map<String,Object> resultMap;
        Logger logger = null;
        try{
            logger = LogManager.getLogger(LoggerConstants.CHANNEL);
            logger.info("开始交易，入参为："+ JSONUtil.toJsonStr(map));
            SqlExecutor.beginTransaction();
            resultMap = mainProcess(map,logger);
            SqlExecutor.endTransaction();
            logger.info("交易结束，出参为："+ JSONUtil.toJsonStr(resultMap));
        }catch (Exception e){
            logger.info("交易异常："+ e.toString());
            return TradeResponse.createFailResponse(CodeEnum.ERR_9999.getCode(),CodeEnum.ERR_9999.getMsg(),e.toString());
        }
        return TradeResponse.createResponse(resultMap);
    }

    public abstract Map<String,Object> mainProcess(Map<String,Object> map,Logger logger);
}
