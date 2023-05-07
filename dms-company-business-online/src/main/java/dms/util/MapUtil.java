package dms.util;

import java.util.HashMap;
import java.util.Map;

public class MapUtil {
    public static Map<String,Object> nvl4Map(Map<String,Object> map,String key){
        try {
            Object value = (Object)map.get(key);
            if(null == value){
                return new HashMap<String,Object>();
            }
            return (Map<String,Object>)value;
        }catch (Exception exception){
            return new HashMap<String,Object>();
        }
    }

    public static Integer nvl4Int(Map<String,Object> map,String key){
        try {
            Object value = (Object)map.get(key);
            if(null == value){
                return new Integer(0);
            }
            return Integer.valueOf(value.toString());
        }catch (Exception exception){
            return new Integer(0);
        }
    }

    public static String nvl(Map<String,Object> map,String key){
        try {
            Object value = (Object)map.get(key);
            if(null == value){
                return "";
            }
            return (String)value;
        }catch (Exception exception){
            return "";
        }
    }
}
