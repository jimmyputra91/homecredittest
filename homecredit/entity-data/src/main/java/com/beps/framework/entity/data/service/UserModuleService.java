/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beps.framework.entity.data.service;

import com.beps.framework.entity.domain.UserModule;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.beps.framework.entity.data.repository.UserModuleRepository;

/**
 *
 * @author Jimmy
 */
@Service(value = "UserModuleService")
@Component
public class UserModuleService 
{
    @Autowired
    private UserModuleRepository repo;
    
//    public TerminalService(TerminalRepository repo)
//    {
//        this.repo = repo;
//    }
    
    public List<UserModule> findByUserID(String userID)
    {
        return (userID != null ? repo.findById(userID) : null);
    }

}
