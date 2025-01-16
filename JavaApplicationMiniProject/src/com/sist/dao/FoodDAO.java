package com.sist.dao;
import com.sist.vo.*;
import java.sql.*;
import java.util.*;

public class FoodDAO {
    private Connection conn;
    private PreparedStatement ps;
    private static FoodDAO dao;
    private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
    
    //1. 드라이버 등록
    public FoodDAO()
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(Exception ex) {}
    }
    
    // WEB => jdbc => DBCP
    // JDBC +> 연결 / 닫기 => 연결에 시간 소모가 많다
    // => 미리 연결한 후에 사용 => 재사용(반환) => WEB에서 일반화
      // 2. 싱글톤
      public static FoodDAO newInstance() 
      {
          if (dao==null)
              dao=new FoodDAO();
          return dao;
      }
      // 3.연결
      public void getConnection() 
      {
          try
          {
              conn=DriverManager.getConnection(URL,"hr","happy");
          }catch(Exception ex) {}
          
      }
      // 4.닫기
      public void disConnection()
      {
          try
          {
              if(ps!=null) ps.close();
              if(conn!=null) conn.close();
              
          }catch(Exception ex) {}
      }
      // 기능
      // 1. 전체목록 출력 => 인라인뷰 이동
      public List<FoodVO> foodListData(int page)
      {
          List<FoodVO> list=new ArrayList<>();
          try
          {
              getConnection();
              String sql= "SELECT fno,name,poster,num "
                        + "FROM (SELECT fno,name,poster,rownum as num "
                        + "FROM (SELECT /*+ INDEX_ASC(food_menupan fm_fno_pk) */ fno,name,poster "
                        + "FROM food_menupan))"
                        + "WHERE num BETWEEN ? AND ?";
              // 3. SQL문장을 오라클로 전송
              ps=conn.prepareStatement(sql);
              // 4. ?에 데이터값을 채운다
              /*
               *    1page=> 1~12
               *    2page=> 13~24
               */
              int rowSize=12;
              int start=(rowSize*page)-(rowSize-1);
              int end=rowSize*page;
              ps.setInt(1, start);
              ps.setInt(2, end);
              ResultSet rs=ps.executeQuery();
              while(rs.next())
              {
                  FoodVO vo=new FoodVO();
                  vo.setFno(rs.getInt(1));
                  vo.setName(rs.getString(2));
                  vo.setPoster("http://menupan.com"+rs.getString(3));
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
      public int foodTotalPage()
      {
          int total=0;
          try
          {
              getConnection();
              String sql="SELECT CEIL(count(*)/12.0) FROM food_menupan";
              ps=conn.prepareStatement(sql);
              ResultSet rs=ps.executeQuery();
              rs.next();
              total=rs.getInt(1);
              rs.close();
              
          }catch(Exception ex )
          {
              ex.printStackTrace();
          }
          finally
          {
              disConnection();
          }
          return total;
      }
      // 2. 상세보기 => 조회수 증가 / WHERE 

}
