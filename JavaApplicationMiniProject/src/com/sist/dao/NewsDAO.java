package com.sist.dao;

import java.util.*;
import java.sql.*;
import com.sist.vo.*;

public class NewsDAO {
    private Connection conn;
    private PreparedStatement ps;
    private static NewsDAO dao;
    
    private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
    
    public NewsDAO()
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(Exception ex) {}
    }
    
    public static NewsDAO newInstance()
    {
        if(dao==null)
            dao=new NewsDAO();
        return dao;
    }
    
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