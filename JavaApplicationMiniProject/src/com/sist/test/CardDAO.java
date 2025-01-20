package com.sist.test;
import java.sql.*;

import com.sist.dao.ReplyBoardDAO;
public class CardDAO {
    private Connection conn;
    private PreparedStatement ps;
    private static CardDAO dao;
    
    private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
    
    public CardDAO()
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(Exception ex) {}
    }
    
    public static CardDAO newInstance()
    {
        if(dao==null)
            dao=new CardDAO();
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
    
    public void cardInsert(String id,int price)
    {
        try
        {
            getConnection();
            conn.setAutoCommit(false); // commit 해제
            String sql="INSERT INTO myCard "
                    + "VALUES(?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setInt(2, price);
            ps.executeUpdate();
            
            sql="INSERT INTO myPoint "
               +"VALUES(1,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setInt(2, price);
            ps.executeUpdate();

            conn.commit();
        }catch(Exception ex)
        {
            ex.printStackTrace();
            try
            {
                conn.rollback();
            }catch(Exception e) {}
        }
        finally
        {
            try
            {
                conn.setAutoCommit(true);
            }catch(Exception e) {}
            disConnection();
        }
    }
    
    public static void main(String[] args) {
        CardDAO dao=CardDAO.newInstance();
        dao.cardInsert("park", 4000);
    }

}
