package dms.controller;

import dms.application.UserRegisterAPS;
import dms.controller.service.IDmsProcessingDetailsARS;
import dms.controller.service.IDmsServiceARS;
import dms.domain.dto.DmsProcessingdtlDTO;
import dms.domain.model.trade.TradeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Api(tags = "DyeingManageSystem", description = "染色管理系统")
@Controller
@RequestMapping("/deingManageSystem")
public class DyeingManageSystemController {

    @Autowired
    UserRegisterAPS userRegisterAPS;
    @Autowired
    IDmsServiceARS iDmsServiceARS;
    @Autowired
    IDmsProcessingDetailsARS iDmsProcessingDetailsARS;

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

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> userLogin(@RequestBody Map<String,Object> map){
        Map<String,Object> resultMap= iDmsServiceARS.userLogin(map);
        return resultMap;
    }

    @RequestMapping(value = "/queryCustomer", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> queryCustomer(@RequestBody Map<String,Object> map){
        Map<String,Object> resultMap= iDmsServiceARS.queryCustomer(map);
        return resultMap;
    }

    @RequestMapping(value = "/addProcessingDetails", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addProcessingDetails(@RequestBody Map<String,Object> map){
        Map<String,Object> resultMap= iDmsProcessingDetailsARS.addProcessingDetails(map);
        return resultMap;
    }

    @RequestMapping(value = "/queryProcessingDetails", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> queryProcessingDetails(@RequestBody Map<String,Object> map){
        Map<String,Object> resultMap= iDmsProcessingDetailsARS.queryProcessingDetails(map);
        return resultMap;
    }



    @RequestMapping(value = "/updateProcessingDetails", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateProcessingDetails(@RequestBody Map<String,Object> map){
        Map<String,Object> resultMap= iDmsProcessingDetailsARS.updateProcessingDetails(map);
        return resultMap;
    }

    @RequestMapping(value = "/deleteProcessingDetails", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> deleteProcessingDetails(@RequestBody Map<String,Object> map){
        Map<String,Object> resultMap= iDmsProcessingDetailsARS.deleteProcessingDetails(map);
        return resultMap;
    }

    @RequestMapping(value = "/queryColor", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> queryColor(@RequestBody Map<String,Object> map){
        Map<String,Object> resultMap= iDmsServiceARS.queryColor(map);
        return resultMap;
    }

    @RequestMapping(value = "/queryCraft", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> queryCraft(@RequestBody Map<String,Object> map){
        Map<String,Object> resultMap= iDmsServiceARS.queryCraft(map);
        return resultMap;
    }

    @RequestMapping(value = "/queryCraft2", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> queryCraft2(@RequestBody Map<String,Object> map){
        List<Map> list = new ArrayList<Map>();
        for(int i = 0 ;i < 10 ;i++){
            Map<String,Object> detailMap= new HashMap<>();
            detailMap.put("createtime",i);
            detailMap.put("amount",i);
            detailMap.put("settlementvolume",i);
            detailMap.put("colorcode",i);
            detailMap.put("createdate",i);
            detailMap.put("remark ",i);
            detailMap.put("type",i);
            detailMap.put("plannedvolume",i);
            detailMap.put("material",i);
            detailMap.put("price",i);
            detailMap.put("netweight",i);
            detailMap.put("outbounddate",i);
            detailMap.put("pricetype",i);
            detailMap.put("id",i);
            detailMap.put("plan",i);
            detailMap.put("customer",i);
            detailMap.put("status",i);
            list.add(detailMap);
        }
        Map<String,Object> resultMap= new HashMap<>();
        resultMap.put("data",list);
        resultMap.put("total",10);
        resultMap.put("success",true);
        resultMap.put("errorCode",0);
        resultMap.put("errorMessage",0);
        return resultMap;
    }

    @RequestMapping(value = "/queryCraft3", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> queryCraft3(@RequestBody Map<String,Object> map){
        List<Map> list = new ArrayList<Map>();
        for(int i = 0 ;i < 10 ;i++){
            Map<String,Object> detailMap= new HashMap<>();
            detailMap.put("createtime",i);
            detailMap.put("amount",i);
            detailMap.put("settlementvolume",i);
            detailMap.put("colorcode",i);
            detailMap.put("createdate",i);
            detailMap.put("remark ",i);
            detailMap.put("type",i);
            detailMap.put("plannedvolume",i);
            detailMap.put("material",i);
            detailMap.put("price",i);
            detailMap.put("netweight",i);
            detailMap.put("outbounddate",i);
            detailMap.put("pricetype",i);
            detailMap.put("id",i);
            detailMap.put("plan",i);
            detailMap.put("customer",i);
            detailMap.put("status",i);
            list.add(detailMap);
        }


        Map<String,Object> retinfoMap= new HashMap<>();
        retinfoMap.put("RETINFO",list);

        Map<String,Object> resultMap= new HashMap<>();
        resultMap.put("data",retinfoMap);
        resultMap.put("total",10);
        resultMap.put("success",true);
        resultMap.put("errorCode",0);
        resultMap.put("errorMessage",0);
        return resultMap;
    }
}
