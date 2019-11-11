/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hc.util;

/**
 *
 * @author beps
 */
import com.hc.entity.UserModuleParam;
import java.io.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import java.sql.SQLException;


public class DBUtil {
    InputStream inputStream;
    Statement st;
    private static Connection conn;
   
    public DBUtil() throws Exception
    {
        Properties config = new Properties();
        String propFileName = "web.properties";
        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        if (inputStream != null) 
        {
          try {
               config.load(inputStream);
          } catch (IOException ex) {
          }
        } else 
        {
          throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }    
        Class.forName(config.getProperty("driver"));

        // Establish the connection to the database.
        String url = config.getProperty("jdbcURL");

        conn = DriverManager.getConnection(url, config.getProperty("username"), config.getProperty("password"));

        st = conn.createStatement();
 
    }
     
      public SqlMapClient getSqlMapClient() throws Exception
      {
            SqlMapClient sqlMapper;                     
                      
            try (Reader reader = Resources.getResourceAsReader("sql-map-config.xml")) {
                sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); 
            }
            return sqlMapper;
      }

    public List getListUserModule (String id) throws Exception
        {
        DBUtil util = new DBUtil();
        SqlMapClient sqlMapper = util.getSqlMapClient();
        List<UserModuleParam> umparam = new ArrayList<UserModuleParam>();
        umparam = sqlMapper.queryForList("user_module.selectListUserModule", id);

        util.closeConnection();
        Thread.sleep(1000);
        util = null;  

        return umparam;

        }
    
      
    public void closeConnection() throws SQLException
    {
        if(!conn.isClosed())
            conn.close();
    } 
}
