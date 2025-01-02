package com.sist.lang;

/**
 *       Wrapper 
 *             : 기본형(데이터형)을 클래스화 시켜서 사용이 편리하게 만든
 *               byte ===> Byte
 *               short ===> Short
 *               ***int ===> Integer
 *               ***long ===> Long
 *               float ===> Float
 *               ***double ===> Double
 *               char ===> Character
 *               ***boolean ===> Boolean
 *          => 변환 (문자열)
 *          => 데이터형의 통일화    : 제네릭스
 *             <클래스형>
 *             => <int> (X) => <Integer>       
 *          => 기능 많다
 *          => 일반 기본형과 호환
 *              Integer i=10 / int i=10
 *              Integer i=(int)10.5;
 */
import java.util.Scanner;
public class 라이브러리_3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // 1. 진법변환 8,2,16
        Scanner scan = new Scanner(System.in);
        System.out.print("정수 입력: ");
        Integer i = scan.nextInt();
        //8진법
        System.out.println(Integer.toOctalString(i));
        //16진법
        System.out.println(Integer.toHexString(i));
        //2진법
        System.out.println(Integer.toBinaryString(i));
        // 2. 범위 : 테이터형의 범위
       System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        
        // 3. 변환 : 문자열 => 정수형
        System.out.print("첫번째 문자열 입력: ");
        String s1=scan.next();
        System.out.print("두번째 문자열 입력: ");
        String s2=scan.next();
        System.out.println(s1+s2);
        System.out.println(Integer.parseInt(s1)+Integer.parseInt(s2));
    }

}
