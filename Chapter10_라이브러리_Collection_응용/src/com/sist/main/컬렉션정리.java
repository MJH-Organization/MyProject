package com.sist.main;
/*
 *      DAO => 오라클, Manager => 파일
 *      ---------------------------
 *      
 *      컬렉션
 *      ----- IO => 2차 (문법=>형식) => DAO (웹)
 *                                  --------
 *                                  
 *      //트랜잭션 코딩
 *      @Transactional
 *      public void insert()
 *      {
 *          sql1;
 *          sql2;
 *      }  
 *      public void insert()
 *      {
 *          try
 *          {
 *              conn.setAutoCommit(false);
 *              ps.preparedStatement(sql1);
 *              ps.executeQuery();
 *              ps.preparedStatement(sql2);
 *              ps.executeQuery();
 *              conn.commit();
 *              
 *          }
 *          catch(Exception ex)
 *          {
 *              conn.rollback();
 *          }
 *          finally
 *          {
 *              try
 *              {
 *                  conn.setAutoCommit(true);
 *                  disConnection();
 *              } catch (Exception ex)
 *              {
 *              }
 *          }
 *      }
 *      
 *      컬렉션 (Collection)
 *          => 배열(고정적) => 데이터 추가 => 새로운 배열
 *              => 동적 배열 => 저장 갯수 확인
 *              ------------------------ 가변
 *          => 많은 데이터를 저장 할 수 있다
 *          => 표준화 => 개발자 모두가 같은 코딩    
 *          => 단점 : 모든 데이터를 저장할 수 있다
 *                  --------- 데이터형이 틀린 경우도 있다
 *                  => 형변환 / 제어문이 어렵다
 *                     
 *      java.lang
 *          Object
 *          Wrapper
 *      java.util
 *          Date / Calendar / StringTokenizer
 *          ArrayList / HashSet / HashMap
 *      java.text
 *          SimpleDateFormat
 *          
 *          
 *      ------------------
 *      java.io     : 파일입출력     => 다운로드 / 업로드
 *      java.sql    : 데이터베이스 입출력
 *      java.net    : 네트워크 입출력 
 *                    => 웹(네트워크) => 한글 변환
 *                       ?      
 */
import java.util.*;
public class 컬렉션정리 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList list = new ArrayList<>();
        list.add("aaa");    //0
        list.add(10);       //1
        list.add('A');      //2
        list.add(120.5);    //3
        list.add(10);       //4
    }

}
