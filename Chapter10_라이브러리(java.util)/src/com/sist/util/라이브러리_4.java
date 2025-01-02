package com.sist.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *      날짜 관련
 *      -------
 *       Date => 기능이 없다
 *               현재 시스템의 날짜와 시간을 읽어 온다
 *               -------- 
 *               오라클과 호환
 *               java.util.Date (*********)
 *               java.sql.Date
 *       Calendar => Date에 해당 기능을 추가 
 *                   Date를 확장 => 제어가 간단하다
 *                   ------------------------
 *                    메서드 기능이 좋다
 *                    추상 클래스
 *      => 반드시 동행
 *         SimpleDateFormat => java.text
 *         ----------------
 *          날짜 출력시에 원하는 형태로 출력
 *          24/12/20 20204-12-20 ....
 *          
 *        년도 
 *          yyyy / yy
 *        월
 *          MM / M      => 10/10
 *                      => 09/9    
 *        일
 *          dd / d
 *        시간
 *          hh / h
 *        분
 *          mm / m
 *        초
 *          ss / s                         
 */
public class 라이브러리_4 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        while (true)
        {
            Date date=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            System.out.println(sdf.format(date));
            
        }

    }

}
