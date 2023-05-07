package dms.controller;

import dms.application.UserRegisterAPS;
import dms.controller.service.IDmsServiceARS;
import dms.domain.model.trade.TradeResponse;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(tags = "DyeingManageSystem", description = "染色管理系统")
@Controller
@RequestMapping("/deingManageSystem")
public class DyeingManageSystemController {

    @Autowired
    UserRegisterAPS userRegisterAPS;
    @Autowired
    IDmsServiceARS iDmsServiceARS;

    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> userRegister(@RequestBody Map<String,Object> map){
        TradeResponse tradeResponse= userRegisterAPS.execute(map);
        return (Map<String, Object>) tradeResponse.getData();
    }

    @RequestMapping(value = "/userRegister2", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> userRegister2(@RequestBody Map<String,Object> map){
        Map<String,Object> resultMap= iDmsServiceARS.userRegister(map);
        return resultMap;
    }

}
