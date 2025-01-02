package com.sist.exception;

/**
 *      예외처리    => try  catch
 *      => IO / SQL
 *      => try : 정상 수행하는 문장
 *               => 읿력값, 실수 => 오류발생
 *         => 오류발생  => 찾아서  => 오류 복구
 *            --------------------------
 *            catch
 *         try  => if
 *         catch    => else
 *         => if ~ else if ....
 *         catch    => 한개만 수행
 *         catch    => 클래스 크기에 따라 작은 순서 제작
 *                     -------------------------
 *                     1. 계층 구조
 *                        Object : 최상위 클래스
 *                           |
 *                      throwable
 *                           |
 *           ------------------------------------------
 *           |                                         |
 *         Error                                    Exception
 *         => 처리가 불가능                             => 처리가 가능한 에러
 *         
 *         Exception
 *            |
 *   Check              UnCheck
 *   => 컴파일시에         => 필요시에만 예외처리한다
 *      예외처리가 
 *      되었는지 확인         
 *  ------------------------------------
 *  |                                   |
 *                                  실행시 => 입력값 확인
 *  IOException                     RuntimeException
 *  SQLException                            |
 *  ClassNotFoundException          NumberFormatException
 *                                  ArrayIndexOfBoundsException
 *                                  ClassCastException
 *                                   ...
 *                                  NullPointerException
 *   예외를 잡을 수 있는 능력은 상위클래스일수록 크다
 *   => catch(Exception e)
 *   => 예외처리 전체 / 부분
 *   => 예제                                   
 */         
public class 예외처리_5 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
