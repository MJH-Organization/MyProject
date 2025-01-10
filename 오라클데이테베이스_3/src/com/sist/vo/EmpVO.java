package com.sist.vo;
//사원 정보를 모아서 관리 => 사원 한명에 대한 정보를 저장
//=> 모아서 한번에 윈도우나 브라우저 전송하는 목적
/*
 EMPNO  NOT NULL NUMBER(4) = int
 ENAME  VARCHAR2(10) = String
 JOB     VARCHAR2(9) = String
 MGR      NUMBER(4) = int
 HIREDATE   DATE = java.util.Date
 SAL         NUMBER(7,2) = int
 COMM        NUMBER(7,2) = int
 DEPTNO      NUMBER(2) = int
 -------------------------------------- 오류 : 내부 변환이 안된다
 
     => 오라클
        문자
            = CHAR/VARCHAR2/CLOB ===> String
        숫자
            = NUMBER ====> double/int
        날짜 
            = DATE ======> java.util.Date
            
      --------------------------------------------
      Front-END ***
      Back-END
      --------------------------------------------
      DataBase : DBA / 경력 5년 이상   
      
      => 테이블 여러개 컬럼을 섞어서 사용
         -----------------------
         | 한개의 테이블로 변경 => View (가상테이블)
 */
import java.util.*;
// => 테이블 연동 : 다른 테이블의 컬럼을 추가하면 안된다
public class EmpVO {
    private int empno,mgr,sal,comm,deptno;
    private String ename,job;
    private Date hiredate;
    private String strSal;
    // TO_CHAR => 문자열 => String
    // => 문자열을 받을 수 있게 String 변수 추가
    // 1. 정수(천단위 ,)
    // 2. 날짜 변환
    
    public String getStrSal() {
        return strSal;
    }
    public void setStrSal(String strSal) {
        this.strSal = strSal;
    }
    // 조인
    private DeptVO dvo=new DeptVO();
    private SalGradeVO svo=new SalGradeVO();
    
    public DeptVO getDvo() {
        return dvo;
    }
    public void setDvo(DeptVO dvo) {
        this.dvo = dvo;
    }
    public SalGradeVO getSvo() {
        return svo;
    }
    public void setSvo(SalGradeVO svo) {
        this.svo = svo;
    }
    
    public int getEmpno() {
        return empno;
    }
    public void setEmpno(int empno) {
        this.empno = empno;
    }
    public int getMgr() {
        return mgr;
    }
    public void setMgr(int mgr) {
        this.mgr = mgr;
    }
    public int getSal() {
        return sal;
    }
    public void setSal(int sal) {
        this.sal = sal;
    }
    public int getComm() {
        return comm;
    }
    public void setComm(int comm) {
        this.comm = comm;
    }
    public int getDeptno() {
        return deptno;
    }
    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }
    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public Date getHiredate() {
        return hiredate;
    }
    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }
}
