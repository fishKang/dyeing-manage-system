package dms.controller.service;

import java.util.Map;

public interface IDmsServiceARS {
    //用户注册
    public Map<String,Object> userRegister(Map<String,Object> inputMap);
    //用户登录
    public Map<String,Object> userLogin(Map<String,Object> inputMap);
    //查询客户名称
    public Map<String,Object> queryCustomer(Map<String,Object> inputMap);
    //查询色号名称
    public Map<String,Object> queryColor(Map<String,Object> inputMap);
    //查询工艺类型名称
    public Map<String,Object> queryCraft(Map<String,Object> inputMap);
}
