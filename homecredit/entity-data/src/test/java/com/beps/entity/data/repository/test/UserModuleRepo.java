/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beps.entity.data.repository.test;

import com.beps.framework.entity.data.service.UserModuleService;
import com.beps.framework.entity.domain.UserModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import org.hamcrest.collection.IsEmptyCollection;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Jimmy
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(value = "classpath:spring-context.xml")
public class UserModuleRepo {
    @Autowired
    UserModuleService service;
    
    
    @Test
    public void whenRecordsInDatabase_shouldReturnUserModuleGivenId() throws Exception {
        
        List<UserModule> actual =  service.findByUserID("A");
        
        UserModule umparam1, umparam2, umparam3, umparam4, umparam5; 
        
        umparam1 = umparam2 = umparam3 = umparam4 = umparam5 = new UserModule();
        umparam1.setModuleName("Promo");
        umparam1.setModuleOrder(1);
        umparam1.setUserID("A");
        umparam1.setActiveStatus(true);
        umparam2.setModuleName("Category");
        umparam2.setModuleOrder(2);
        umparam2.setUserID("A");
        umparam2.setActiveStatus(true);
        umparam3.setModuleName("FlashSale");
        umparam3.setModuleOrder(3);
        umparam3.setUserID("A");
        umparam3.setActiveStatus(true);
        umparam4.setModuleName("History");
        umparam4.setModuleOrder(4);
        umparam4.setUserID("A");
        umparam4.setActiveStatus(true);
        umparam5.setModuleName("News");
        umparam5.setModuleOrder(5);
        umparam5.setUserID("A");
        umparam5.setActiveStatus(true);

        List<UserModule> expected = Arrays.asList(umparam1, umparam2, umparam3, umparam4, umparam5);     

        assertThat(actual, hasSize(5));
        assertTrue(actual.size()>0);
        assertTrue(actual.size() == expected.size());
        //5. check empty list
        assertThat(actual, not(IsEmptyCollection.empty()));
        assertThat(new ArrayList<>(), IsEmptyCollection.empty());


    }
}
