package com.beps.framework.entity.data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author Nazar
 */
@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.beps.framework.entity.data","com.beps.framework.entity.data.repository","com.beps.framework.entity.data.service","com.beps.framework.entity.data.service.controller"})
public class Application 
{
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
}
