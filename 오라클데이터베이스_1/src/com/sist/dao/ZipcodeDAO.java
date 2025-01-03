package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;
public class ZipcodeDAO {

    private Connection conn;
    private PreparedStatement ps;
    // URL
    private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
    // 싱글턴
    private static ZipcodeDAO dao;
    
    // 드라이버 등록
    public ZipcodeDAO()
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(Exception ex) {}
    }
    // 오라클 연동
    public void getConnection() {
        try
        {
            conn=DriverManager.getConnection(URL,"hr","happy");
        }catch(Exception ex) {}
    }
    // 오라클 닫기
    public void disConnection()
    {
        try
        {
            if(ps!=null) ps.close();
            if(conn!=null) conn.close();
        }catch(Exception ex) {}
        
    }
    // 싱글턴
    
    public static ZipcodeDAO newInstance()
    {
        if(dao==null)
            dao=new ZipcodeDAO();
        return dao;
    }
    
    // 기능 우편번호 검색
    public List<ZipcodeVO> postFind(String dong)
    {
        List<ZipcodeVO> list = 
                new ArrayList<>();
        try
        {
            //1.연결
            getConnection();
            //2. SQL 
            String sql="SELECT zipcode,sido,gugun,dong,NVL(bunji,' ') "  // SQL에서 공백처리 함수 NVL(컬럼명, 대체값)
                    +"FROM zipcode "
                    +"WHERE dong LIKE '%'||?||'%'";     // 오라클 SQL/Java SQL 문장의 차이
            ps=conn.prepareStatement(sql);
            // ?에 값을 채워준다
            ps.setString(1, dong);
            // 실행을 요청
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                ZipcodeVO vo=new ZipcodeVO();
                
                vo.setZipcode(rs.getString(1));
                vo.setSido(rs.getString(2));
                vo.setGugun(rs.getString(3));
                vo.setDong(rs.getString(4));
                vo.setBunji(rs.getString(5));
                
                list.add(vo);
            }
            rs.close();
            
        }catch(Exception ex) 
        {
            ex.printStackTrace();
        }
        finally
        {
            disConnection();
        }
        return list;        
    }
    
    public int postFindCount(String dong)
    {
        int count=0;
        try
        {
            getConnection();
            String sql="SELECT COUNT(*) "
                    +"FROM zipcode "
                    +"WHERE dong LIKE '%'||?||'%'";
            ps=conn.prepareStatement(sql);
            ps.setString(1, dong);
            ResultSet rs=ps.executeQuery();
            rs.next();
            count=rs.getInt(1);
            rs.close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            disConnection();
        }
        return count;
    }
}
