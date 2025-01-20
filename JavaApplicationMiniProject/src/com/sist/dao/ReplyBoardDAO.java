package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;
import com.sist.dao.*;
public class ReplyBoardDAO {
    private Connection conn;
    private PreparedStatement ps;
    private static ReplyBoardDAO dao;
    
    private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
    
    public ReplyBoardDAO()
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(Exception ex) {}
    }
    
    public static ReplyBoardDAO newInstance()
    {
        if(dao==null)
            dao=new ReplyBoardDAO();
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
    //////////////////// 자바에서 오라클 연동 기본(공통)
    //////////////////// -------------- JDBC
    //// JDBC (원시소스) => DBCP => ORM (MyBatis, Hibernate => JPA)
    /// 기능
    // 1.목록 출력 => 인라인뷰 => 1페이지에 10개
    // => 최신순
    // => INDEX사용 X => 추가, 수정, 삭제가 많은 경우 
    // INDEX가 속도가 저하 => ORDER BY를 이용한다
    /*
NO         NOT NULL NUMBER         
NAME       NOT NULL VARCHAR2(51)   
SUBJECT    NOT NULL VARCHAR2(2000) 
CONTENT    NOT NULL CLOB           
PWD        NOT NULL VARCHAR2(10)   
REGDATE             DATE           
HIT                 NUMBER         
GROUP_ID            NUMBER         
GROUP_STEP          NUMBER         
GROUP_TAB           NUMBER         
ROOT                NUMBER         
DEPTH               NUMBER        
     */
    public List<ReplyBoardVO> boardListData(int page)
    {
        List<ReplyBoardVO> list=new ArrayList<>();
        try
        {
            getConnection();
            String sql="SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD'),hit,group_tab "
                    + "FROM (SELECT no,subject,name,regdate,hit,group_tab,rownum as num "
                    + "FROM (SELECT no,subject,name,regdate,hit,group_tab "
                    + "FROM replyBoard ORDER BY group_id DESC, group_step ASC)) "
                    + "WHERE num BETWEEN ? AND ?";
            ps=conn.prepareStatement(sql);
            int rowSize=10;
            int start=(rowSize*page)-(rowSize-1);
            int end=(rowSize*page);
            ps.setInt(1, start);
            ps.setInt(2, end);
            
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                ReplyBoardVO vo=new ReplyBoardVO();
                vo.setNo(rs.getInt(1));
                vo.setSubject(rs.getString(2));
                vo.setName(rs.getString(3));
                vo.setDbday(rs.getString(4));
                vo.setHit(rs.getInt(5));
                vo.setGroup_tab(rs.getInt(6));
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
    //1.1. 총페이지
    public int boardTotalPage()
    {
        int total=0;
        try
        {
            getConnection();
            String sql="SELECT CEIL(COUNT(*)/10.0) FROM replyBoard";
            ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            rs.next();
            total=rs.getInt(1);
            rs.close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            disConnection();
        }
        return total;
    }
    // 2.글쓰기 => INSERT
    // 매개변수가 3개 이상 => 배열 / VO를 이용한다
    public void boardInsert(ReplyBoardVO vo)
    {
        try
        {
            getConnection();
            // 새로운 그룹 생성 => 그룹번호 : group_id 하나 증가
            String sql="INSERT INTO replyBoard(no,name,subject,content,pwd,group_id) "
                    + "VALUES(rb_no_seq.nextval,?,?,?,?,"
                    + "(SELECT NVL(MAX(group_id)+1,1) FROM replyBoard))";
            ps=conn.prepareStatement(sql);
            ps.setString(1, vo.getName());
            ps.setString(2, vo.getSubject());
            ps.setString(3, vo.getContent());
            ps.setString(4, vo.getPwd());
            ps.executeUpdate(); // commit()을 수행
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            disConnection();
        }
    }
    // 3.상세보기 => WHERE
    public ReplyBoardVO boardDetailData(int type, int no)
    {
        ReplyBoardVO vo=new ReplyBoardVO();
        // => 반드시 사용자로부터 Primary Key 를 받아서 출력
        try
        {
            getConnection();
            // SQL1 조회수 증가
            if(type==1)
            {
                String sql="UPDATE replyBoard SET "
                        +"hit=hit+1 "
                        +"WHERE no="+no;
                ps=conn.prepareStatement(sql);
                ps.executeUpdate();     // => COMMIT
                
            }

            // SQL2 상세보기에서 데이터 읽기
            String sql="SELECT no,name,subject,content,"
               +"TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS'),hit "
               +"FROM replyBoard "
               +"WHERE no="+no;
            ps=conn.prepareStatement(sql);
            // 한 기능을 수행
            ResultSet rs=ps.executeQuery();
            rs.next();
            vo.setNo(rs.getInt(1));
            vo.setName(rs.getString(2));
            vo.setSubject(rs.getString(3));
            vo.setContent(rs.getString(4));
            vo.setDbday(rs.getString(5));
            vo.setHit(rs.getInt(6));
            rs.close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            disConnection();
        }
        
        return vo;
    }
    // 4.수정 => UPDATE
    public ReplyBoardVO boardUpdateData(int no)
    {
        ReplyBoardVO vo=new ReplyBoardVO();
        try
        {
            getConnection();
            String sql="SELECT no,name,subject,content "
                    +"FROM replyBoard "
                    +"WHERE no="+no;
            ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            rs.next();
            vo.setNo(rs.getInt(1));
            vo.setName(rs.getString(2));
            vo.setSubject(rs.getString(3));
            vo.setContent(rs.getString(4));
            rs.close();
                    
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            disConnection();
        }
        return vo;
    }
    // 4.1 실제 수정하기
    public boolean boardUpdate(ReplyBoardVO vo)
    {
        boolean bCheck=false; // 비밀번호 처리
        /*
         *  메서드 : 사용자 요청처리
         *  1) 사용자 요청값을 받는다
         *      => 매개변수
         *  2) 요청처리후에 결과값
         *      => 경우의 수
         *      1. 목록 : lIST<~VO>
         *      2. 상세보기 : ~VO
         *      3. 비밀번호가 맞다 / 아니다
         *                 --------- boolean
         *      4. 경우의 수가 3개 이상
         *         String / int
         *         ------ 알아볼 수 있게 처리
         *         | 로그인 처리
         *           => NOID / NOPWD / ok     
         *      --------------------------------     
         *       자바 => 메서드 제작
         *             -------- 데이터 확인 (VO)  
         *     1. 형식 => String
         *        = INSERT
         *          => DEFAULT가 많은 경우
         *          INSERT INTO table_name(컬럼,컬럼....)
         *          VALUES(값,값....)
         *          => DEFAULT가 없는 경우
         *          INSERT INTO table_name VALUES(값....)
         *          => 날짜 / 문자 => ''
         *             --------------
         *             set STring(1,값) => '값'                
         */
        try
        {
            getConnection();
            // 1. SQL => 비밀번호
            String sql="SELECT pwd FROM replyBoard WHERE no="+vo.getNo();
            ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            rs.next();
            String db_pwd=rs.getString(1);
            rs.close();
            
            // 오라클에 존재      사용자가 보내준 비밀번호
            if(db_pwd.equals(vo.getPwd()))
            {
                bCheck=true;
                //실제 수정
                sql="UPDATE replyBoard SET "
                  + "name=?,subject=?,content=? "      
                  + "WHERE no=?";
                ps=conn.prepareStatement(sql);
                ps.setString(1, vo.getName());
                ps.setString(2, vo.getSubject());
                ps.setString(3, vo.getContent());
                ps.setInt(4, vo.getNo());
                //수행해라
                ps.executeUpdate();
                // INSERT / UPDATE 가 여러개인 경우 => 
                // SELECT : 검색 => COMMIT이 필요없다
            }
            else
            {
                bCheck=false;
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            disConnection();
        }
        return bCheck;
    }
    
    // 5.답변 => 트랜잭션
    /*
     *  // => 100% / INDEX / VIEW
     *  BLOB / BFILE
     *  GET/POST
     *  --------------- SESSION / COOKIE
     *  --------------- MVC
     *  --------------- DI / AOP / ORM
     *  --------------- Framework / Boot
     *  try
     *  {
     *      getConnection(); 연결
     *      conn.setAutoCommit(false);  commit 해제
     *      ---------------
     *      SQL => INSERT
     *      SQL => INSERT
     *      ---------------
     *      conn.commit();
     *  }catch(Exception ex)
     *  {
     *      ex.printStackTrace()
     *      try
     *      {
     *          conn.rollback();
     *      }catch(Exception e){}
     *  }
     *  finally
     *  {
     *      conn.setAutoCommit(true)
     *      try
     *      {
     *      }catch(Exception e) {}
     *  } 
     */
    // 6.삭제 => 트랜잭션
    
}
