/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beps.framework.entity.data.controller;

import com.beps.framework.entity.data.service.UserModuleService;
import com.beps.framework.entity.domain.UserModule;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jimmy
 */
@RestController
public class UserModuleController 
{
    @Autowired
    UserModuleService service;
    

    @RequestMapping(
            "/hc")
    public String find(@RequestParam(value = "userID", defaultValue = "C")String userID)
    {
        JSONArray modules = new JSONArray();
        List <UserModule> lumparam = service.findByUserID(userID);
        for (int i = 0; i < lumparam.size(); i++) 
        {
            UserModule umparam = lumparam.get(i);
            JSONObject module =new JSONObject();

            module.put("moduleName", umparam.getModuleName());
            module.put("moduleOrder", umparam.getModuleOrder());
            modules.put(module);
            
        }
        JSONObject responses = new JSONObject();
        responses.put("modules", modules);
        return responses.toString();  
    }

}
