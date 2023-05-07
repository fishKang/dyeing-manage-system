package spring.util;

import common.CodeEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class TradeResponse<T> implements Serializable {
    String returncode;
    String returnmsg;
    String returninfo;
    T data;

    public static TradeResponse createSuccessResponse(Map<String,Object> data){
        TradeResponse tradeResponse = new TradeResponse();
        tradeResponse.setReturncode(CodeEnum.ERR_0000.getCode());
        tradeResponse.setReturnmsg(CodeEnum.ERR_0000.getMsg());
        tradeResponse.setData(data);
        return tradeResponse;
    }
    public static TradeResponse createSuccessResponse(String code,String msg){
        TradeResponse tradeResponse = new TradeResponse();
        tradeResponse.setReturncode(code);
        tradeResponse.setReturnmsg(msg);
        return tradeResponse;
    }

    public static TradeResponse createSuccessResponse(String code,String msg,String info){
        TradeResponse tradeResponse = new TradeResponse();
        tradeResponse.setReturncode(code);
        tradeResponse.setReturnmsg(msg);
        tradeResponse.setReturninfo(info);
        return tradeResponse;
    }
    public static TradeResponse createFailResponse(String code){
        TradeResponse tradeResponse = new TradeResponse();
        tradeResponse.setReturncode(code);
        return tradeResponse;
    }
    public static TradeResponse createFailResponse(String code,String msg){
        TradeResponse tradeResponse = new TradeResponse();
        tradeResponse.setReturncode(code);
        tradeResponse.setReturnmsg(msg);
        return tradeResponse;
    }

    public static TradeResponse createFailResponse(String code,String msg,String info){
        TradeResponse tradeResponse = new TradeResponse();
        tradeResponse.setReturncode(code);
        tradeResponse.setReturnmsg(msg);
        tradeResponse.setReturninfo(info);
        return tradeResponse;
    }
}
