package dms.convertor;

import dms.common.CodeEnum;
import dms.common.CommonConstants;

import java.util.HashMap;
import java.util.Map;

public class ConvertorToMap {
    public static Map<String,Object> convertorSuccessMap(){
        Map<String,Object> map = new HashMap<>();
        map.put(CommonConstants.RETCODE, CodeEnum.ERR_0000.getCode());
        map.put(CommonConstants.RETMSG,CodeEnum.ERR_0000.getMsg());
        return map;
    }
    public static Map<String,Object> convertorSuccessMap(String code,String msg){
        Map<String,Object> map = new HashMap<>();
        map.put(CommonConstants.RETCODE,code);
        map.put(CommonConstants.RETMSG,msg);
        return map;
    }
    public static Map<String,Object> convertorSuccessMap(String code,String msg,String info){
        Map<String,Object> map = new HashMap<>();
        map.put(CommonConstants.RETCODE,code);
        map.put(CommonConstants.RETMSG,msg);
        map.put(CommonConstants.RETINFO,info);
        return map;
    }
    public static Map<String,Object> convertorFailMap(String code,String msg){
        Map<String,Object> map = new HashMap<>();
        map.put(CommonConstants.RETCODE,code);
        map.put(CommonConstants.RETMSG,msg);
        return map;
    }
    public static Map<String,Object> convertorFailMap(String code,String msg,String info){
        Map<String,Object> map = new HashMap<>();
        map.put(CommonConstants.RETCODE,code);
        map.put(CommonConstants.RETMSG,msg);
        map.put(CommonConstants.RETINFO,info);
        return map;
    }
}
