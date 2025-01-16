package com.sist.dao;

import java.sql.*;
import java.util.*;

public class DataBase {
    private Connection conn;
    private PreparedStatement ps;
    
    private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
//    private static DataBase db=null;
    
    public DataBase()
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(Exception ex) {}
    }
    
//    public static DataBase newInstance() 
//    {
//        if (db==null)
//            db=new DataBase();
//        return db;
//    }
    
    public void getConnection() 
    {
        try
        {
            conn=DriverManager.getConnection(URL,"hr","happy");
        }catch(Exception ex) {}
        
    }
    
    public void disConnection()
    {
        try
        {
            if(ps!=null) ps.close();
            if(conn!=null) conn.close();
            
        }catch(Exception ex) {}
    }

}
