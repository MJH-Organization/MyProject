package com.sist.dao;
import java.sql.*;
public abstract class DataBase {
    // 기능 설정
    // => 같은 기능 => 구현
    public void driverConfig()
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
        }catch(Exception ex) {}
    }
    
    public Connection getConnection()
    {
        Connection conn=null;
        try {
            String url="jdbc:oracle:thin:@localhost:1521:XE";
            conn=DriverManager.getConnection(url, "hr", "happy");
        }catch(Exception ex) {}
        
        return conn;
    }
    // => 기능은 같다    => 구현내용이 틀린 경우  => 미구현
    public abstract void listPrint();
    public abstract void findPrint();

}
