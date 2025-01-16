package com.sist.dao;
import java.util.*;

import com.sist.vo.MusicVO;

import java.sql.*;


public class MusicDAO {
    private Connection conn;
    private PreparedStatement ps;
    
    private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
    private static MusicDAO dao;
    
    public MusicDAO()
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(Exception ex) {}
    }
    public static MusicDAO newInstance()
    {
        if(dao==null)
            dao=new MusicDAO();
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
    
    public void genieMusicInsert(MusicVO vo)
    {
        try
        {
            getConnection();
            String sql="INSERT INTO genie_music "
                    +"VALUES((SELECT NVL(MAX(mno)+1,1) FROM genie_music),"
                    +"?,?,?,?,?,?,?,?,0)";
            ps=conn.prepareStatement(sql);
            ps.setInt(1, vo.getCno());
            ps.setString(2, vo.getTitle());
            ps.setString(3, vo.getSinger());
            ps.setString(4, vo.getAlbum());
            ps.setString(5, vo.getPoster());
            ps.setInt(6, vo.getIdcrement());
            ps.setString(7, vo.getState());
            System.out.println("vo.getState()=["+vo.getState()+"]");
            ps.setString(8, vo.getKey());
            // youtube => 2번 
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

}
