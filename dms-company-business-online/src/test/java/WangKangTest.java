import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import dms.domain.model.common.DmsCommonBO;
import dms.domain.model.DmsUserBO;

import java.util.HashMap;
import java.util.Map;

public class WangKangTest {
    public static void main(String[] args) {
        WangKangTest wangKangTest = new WangKangTest();
        wangKangTest.initParam();
    }

    public void initParam(){
        DmsCommonBO dmsCommonBO = new DmsCommonBO();
        dmsCommonBO.setZoneno(200);
        dmsCommonBO.setDepartment("开发");
        dmsCommonBO.setLogtype("USERREGISTER");
        dmsCommonBO.setSerialno(IdUtil.fastUUID());
        dmsCommonBO.setMethod("userRegister");
        dmsCommonBO.setService("UserManage");
        dmsCommonBO.setWorkdate("2003-04-03");
        dmsCommonBO.setWorktime("20:21:11");
        DmsUserBO dmsUserBO = new DmsUserBO();
        dmsUserBO.setId(1);
        dmsUserBO.setName("wk");
        dmsUserBO.setPassword("admin");
        dmsUserBO.setPermission("admin");
        Map<String,Object> map = new HashMap<>();
        map.put("dmscommon", BeanUtil.beanToMap(dmsCommonBO));
        map.put("private", BeanUtil.beanToMap(dmsUserBO));

        System.out.println(JSONUtil.toJsonStr(map));
    }
}
