/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.util;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author Jimmy
 */
public class DBController 
{
    InputStream inputStream;
    Statement st;
    private static Connection conn;
    private static SqlMapClient sqlMapper;                     

    public boolean createSession() throws Exception
    {
        Properties config = new Properties();
        String propFileName = "web.properties";
        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        if (inputStream != null) 
        {
               config.load(inputStream);
        } 
        else 
        {
          throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }    
        Class.forName(config.getProperty("driver"));

        // Establish the connection to the database.
        String url = config.getProperty("jdbcURL");

        conn = DriverManager.getConnection(url, config.getProperty("username"), config.getProperty("password"));

        if(conn.isClosed())
            return false;

        st = conn.createStatement(); 
        
        Reader reader = Resources.getResourceAsReader("sql-map-config.xml");
//        if(reader) 
        {
            sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); 
            sqlMapper.startTransaction();
        }


        return true;
    }

    public SqlMapClient getSqlMapClient() throws Exception
    {
          return sqlMapper;
    }
    
    public void closeSession() throws Exception
    {
        sqlMapper.commitTransaction();
        sqlMapper.endTransaction();
        sqlMapper = null;

        if(!conn.isClosed())
            conn.close();
        
    }
    
}
