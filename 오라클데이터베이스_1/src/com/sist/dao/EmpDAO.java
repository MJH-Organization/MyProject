package com.sist.dao;
/*
 *      자바 12장
 *      오라클 연동
 *      --------
 *      1. 드라이버 설정
 *          => 한번만 설정
 *          => 생성자 이용
 *          => Class.forname("드라이버명")
 *                          ---------- oracle.jdbc.driver.OracleDriver
 *                          ---------- com.mysql.cj.jdbc.Driver
 *      2. 오라클 연결
 *          Connection conn=
 *                  DriverManager.getConnection(URL, "hr", "happy)
 *      3. 오라클로 SQL문장 전송
 *               ----------
 *         PreparedStatement ps=conn.preparedStatement(sql)                                      
 *      4. 오라클에서 SQL 실행하고 결과값 요청
 *         ResultSet rs = ps.executeQuery()     
 *         -----------------------------------
 *            id        pwd     name                        
 *         -----------------------------------
 *            aaa       1234    홍길동          | => next() ==> 가장 많이 사용
 *         -----------------------------------
 *            bbb       1234    심청이             
 *         -----------------------------------
 *            ccc       1234    박문수          | => previous()
 *         -----------------------------------
 *         | cursor 위치
 *         => rs.close()
 *         => ps.close()
 *         => conn.close()
 *         
 *         *** rs.next() => record 단위 => 한줄에 있는 모든 데이터를 읽는다
 */
import java.util.*;

import com.sist.vo.*;

import java.sql.*;
/*
 *      => SQL => ;을 사용하지 않는다
 *      => 변경 => LIKE 
 *      => LIKE '%'||문자열||'%' => 문자열 결합
 *         LIKE CONCAT('%',문자열,'%') => MYSQL
 *      => JOIN => Oracle JOIN / ANSI JOIN
 *                               ---------   
 */
public class EmpDAO {
    // 1. 오라클 연결
    private Connection conn;
    // 2. 오라클 SQL 송수신
    private PreparedStatement ps;
    /*
     *      SQL 문장을 전송
     *      오라클 실행 결과 읽기
     *      ---------------
     *      Statement : 데이터와 동시에 SQL문장을 전송
     *      PreparedStatement : SQL 먼저 전송
     *                          나중에 데이터를 채운다(***)
     *      CallableStatement : Procedure호출 => 함수
     *                          | SQL문장이 노출되지 않는다
     *                          | 보안
     *                          | ERP => 관리 프로그램
     *                            E4NET
     *      EmpVO
     *      String sql="INSERT INTO emp VALUES ("
     *              +vo.getEmpno()+",'"+vo.getEname()
     *              +"','"+vo.getJob()+"','"
     *              +vo.getHiredate()+"',"
     *              +vo.getSal()...
     *              
     *      String sql="INSERT INTO emp VALUES (?,?,?,?,?....)"
     *           => MyBatis / JPA                         
     */
    // => 클래스 전체에서 사용
    // 3. DAO => 오라클 연동 => 사용자 한명당 1개만 사용 (싱글턴)
    private static EmpDAO dao;
    private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
    // 4. 기능
    public EmpDAO()
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(Exception ex) {}
    }
    // 모든 메서드에서 공통으로 사용되는 기능
    // 4-0 : 오라클 연결 / 오라클 연결 해제
    public void getConnection()
    {
        try
        {
            conn=DriverManager.getConnection(URL,"hr","happy");
            // conn hr/happy
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    public void disConnection()
    {
        try
        {
            if(ps!=null) ps.close();
            if(conn!=null) conn.close();
        }catch(Exception ex) {}
    }
    
    // 4-0-1 : 싱글턴 => 메모리 공간을 한개만 생성
    public static EmpDAO newInstance()
    {
        if (dao==null)
            dao=new EmpDAO();
        return dao;
    }
    // -------------------------------------------- 항상 => jar
    // 2차 => JSP : MyBatis (XML) => Jquery, Ajax
    // 3차 => Spring : MyBatis (Annotation) => VueJS
    // 4-1 : 목록 => SELECT column_list
    public List<EmpVO> empListData(int type)
    {
        List<EmpVO> list=
                new ArrayList<>();
        String order="";
        if (type==1)
            order="ORDER BY empno ASC";
        else if(type==2)
            order="ORDER BY hiredate ASC";
        else if(type==3)
            order="ORDER BY ename ASC";
        try
        {
            // 1. 오라클 연결
            getConnection();
            // 2. SQL 문장 제작
            String sql="SELECT empno,ename,job,hiredate "   // SELECT 문과 FROM 문을 구분하기 위해 " "(공백)을 끝에 추가
                    +"FROM emp "
                    +order;
            // 3. 오라클로 전송
            ps=conn.prepareStatement(sql);
            // 4. SQL 을 실행한 후에 결과값을 가지고 온다 
            ResultSet rs=ps.executeQuery();
            // 정수 => getInt(), 실수 => getDouble()
            // 문자열 => getString(), 날짜 => getDate()
            // => 커서의 위치 변경
            // 7839 KING                 PRESIDENT          81/11/17
            while(rs.next())    // 처음부터 마지막까지 데이터를 읽어본다
            {
                //empno,ename,job,hiredate
                EmpVO vo=new EmpVO();
                vo.setEmpno(rs.getInt(1));
                vo.setEname(rs.getString(2));
                vo.setJob(rs.getString(3));
                vo.setHiredate(rs.getDate(4));
                list.add(vo);
            }
            rs.close();
        }catch(Exception ex)    
        {
            // 오류확인
            ex.printStackTrace();
        }
        finally
        {
            disConnection();
        }
        return list;
    }
    // 4-3 : 상세보기 => WHERE
    public EmpVO empDetail(int empno)
    {
        EmpVO vo=new EmpVO();
        try
        {
            getConnection();
            String sql="SELECT * "   
                    +"FROM emp "
                    +"WHERE empno="+empno;
            ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            rs.next();
            // 읽어오는 순서
            //  EMPNO(1) ENAME(2) JOB(3) MGR(4) HIREDATE(5) SAL(6) COMM(7) DEPTNO(8)
            vo.setEmpno(rs.getInt(1));
            vo.setEname(rs.getString(2));
            vo.setJob(rs.getString(3));
            vo.setMgr(rs.getInt(4));
            vo.setHiredate(rs.getDate(5));
            vo.setSal(rs.getInt(6));
            vo.setComm(rs.getInt(7));
            vo.setDeptno(rs.getInt(8));
            
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

}
