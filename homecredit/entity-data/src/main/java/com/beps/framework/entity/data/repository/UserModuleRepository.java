/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beps.framework.entity.data.repository;

import com.beps.framework.entity.domain.UserModule;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jimmy
 */
@Mapper
@Component
public interface UserModuleRepository 
{
    @Select("SELECT * FROM user_module u WHERE u.\"userID\" = #{uid} ORDER BY u.\"moduleOrder\" ASC")
    @Results(id = "findById", 
            value = {
                @Result(property = "userID", column = "userID"),
                @Result(property = "moduleName", column = "moduleName"),
                @Result(property = "moduleOrder", column = "moduleOrder"),
                @Result(property = "activeStatus", column = "activeStatus")
            })
    public List<UserModule> findById(@Param(value = "uid") String userID);


}
