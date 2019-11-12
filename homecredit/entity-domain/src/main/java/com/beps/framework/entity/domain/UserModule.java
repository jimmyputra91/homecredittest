package com.beps.framework.entity.domain;

import lombok.Setter;
import lombok.ToString;



import lombok.Getter;

@Getter
@Setter
@ToString
public class UserModule
{
    private String userID;
    private String moduleName;
    private int moduleOrder;
    private boolean activeStatus;
}