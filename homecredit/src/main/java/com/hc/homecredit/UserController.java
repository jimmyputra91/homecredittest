/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.homecredit;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hc.entity.UserModuleParam;
import com.hc.util.DBController;
import com.hc.util.DBUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jimmy
 */
@Controller
public class UserController {
        private final DBUtil dbUtil;

    public UserController() throws Exception {
        this.dbUtil = new DBUtil();
    }
    
    @RequestMapping(value="/hc", method = RequestMethod.GET)
    @ResponseBody
    public String userParam(@RequestParam(value="userID") String user) 
    throws Exception 
    {
        DBController dbc = new DBController();
        dbc.createSession();
        ObjectMapper mapper = new ObjectMapper();
        ObjectMapper moduleMap = new ObjectMapper();
        JSONArray modules = new JSONArray();
        List<UserModuleParam> lumparam = new ArrayList<UserModuleParam>();
        lumparam = dbUtil.getListUserModule(user);
        for (int i = 0; i < lumparam.size(); i++) 
        {
            UserModuleParam umparam = lumparam.get(i);
            JSONObject module =new JSONObject();

            module.put("moduleName", umparam.getModuleName());
            module.put("moduleOrder", umparam.getModuleOrder());
            modules.put(module);
            
        }
        JSONObject responses = new JSONObject();
        responses.put("modules", modules);
        dbc.closeSession();
        return responses.toString();   
        
    }
}
