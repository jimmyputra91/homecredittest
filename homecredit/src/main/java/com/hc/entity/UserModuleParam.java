/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.entity;

/**
 *
 * @author beps
 */
public class UserModuleParam {
    
    private String userID;
    private String moduleName;
    private int moduleOrder;
    private boolean activeStatus;

    public UserModuleParam(String userID, String moduleName, int moduleOrder, boolean activeStatus) {
        this.userID = userID;
        this.moduleName = moduleName;
        this.moduleOrder = moduleOrder;
        this.activeStatus = activeStatus;
    }

    public UserModuleParam() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public int getModuleOrder() {
        return moduleOrder;
    }

    public void setModuleOrder(int moduleOrder) {
        this.moduleOrder = moduleOrder;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }


    
    
}
