package com.sist.dao;
import java.util.*;

import com.sist.vo.*;

import java.sql.*;
public class FoodDAO {
    private Connection conn;
    private PreparedStatement ps;
    
    private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
    private static FoodDAO dao;
    
    public FoodDAO()
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(Exception ex) {}
    }
    public static FoodDAO newInstance()
    {
        if(dao==null)
            dao=new FoodDAO();
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
    
    public void foodInsert(FoodVO vo)
    {
        try
        {
            getConnection();
            String sql="INSERT INTO food_menupan "
                    +"VALUES(fm_fno_seq.nextval,"
                    +"?,?,?,?,?,?,?,?,?,?,?,0,?)";
            // name type phone address score
            // theme poster images time parking content
            // hit price
            ps=conn.prepareStatement(sql);
            ps.setString(1, vo.getName());
            ps.setString(2, vo.getType());
            ps.setString(3, vo.getPhone());
            ps.setString(4, vo.getAddress());
            ps.setDouble(5, vo.getScore());
            ps.setString(6, vo.getTheme());
            ps.setString(7, vo.getPoster());
            ps.setString(8, vo.getImages());
            ps.setString(9, vo.getTime());
            ps.setString(10, vo.getParking());
            ps.setString(11, vo.getContent());
            ps.setString(12, vo.getPrice());
            ps.executeUpdate();
            
        }catch(Exception ex) 
        {
            ex.printStackTrace();
        }
        finally
        {
            disConnection();
        }
    }
    
//    public void genieMusicInsert(MusicVO vo)
//    {
//        try
//        {
//            getConnection();
//            String sql="INSERT INTO genie_music "
//                    +"VALUES((SELECT NVL(MAX(mno)+1,1) FROM genie_music),"
//                    +"?,?,?,?,?,?,?,?,0)";
//            ps=conn.prepareStatement(sql);
//            ps.setInt(1, vo.getCno());
//            ps.setString(2, vo.getTitle());
//            ps.setString(3, vo.getSinger());
//            ps.setString(4, vo.getAlbum());
//            ps.setString(5, vo.getPoster());
//            ps.setInt(6, vo.getIdcrement());
//            ps.setString(7, vo.getState());
//            System.out.println("vo.getState()=["+vo.getState()+"]");
//            ps.setString(8, vo.getKey());
//            // youtube => 2번 
//            ps.executeUpdate();
//        }catch(Exception ex)
//        {
//            ex.printStackTrace();
//        }
//        finally
//        {
//            disConnection();
//        }
//    }

    
}
