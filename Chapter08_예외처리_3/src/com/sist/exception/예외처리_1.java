package com.sist.exception;

/**
 *      예외처리 방법
 *      ---------
 *      1. 직접처리 (예외복수)
 *         try
 *         {
 *              정상적으로 수행하는 문장
 *              => 오류발생 가능성이 있다
 *         }catch(예상되는 예외클래스) 
 *         {
 *              오류발생    => 처리 복구
 *              오류내용만 확인
 *         }
 *         finally
 *         {
 *              닫기 (서버, 오라클, 파일)    => 자원(resource) 반환
 *              => 무조건 수행하는 문장
 *         }
 *      2. 간접처리 : throws
 *         => 예외회피
 *         => 예상되는 예외를 선언   => 이런 예외 발생할 것 같다
 *                                 ------------------
 *                                 컴파일러에 알려준다
 *         => 이 메서드를 사용시에는 반드시 예외처리 후 사용이 가능
 *            => throws / try~catch 를 이용할 수 있다
 *         => 사용자 정의는 사용빈도가 적다 / 라이브러리가 많이 존재
 *            ---------------------
 *            코딩 소스가 많은데 중간에 예외처리할 문장이 있는 경우             
 *         => 형식)
 *            public void display() throws 예외처리클래스...
 *              => 여러개일 경우  : ,
 *              => 순서가 없다
 *              => 예상되는 예외를 지정
 *              
 *              CheckException          UnCheckException
 *              --------------          ----------------
 *              반드시 예외처리             필요시에만 예외처리
 *              
 *              Throwable
 *              Exception
 *              IOException
 *              InterruptedException
 *              SQLException
 *              ClassNotFoundException
 *              ...
 *              UnCheckException
 *              ----------------- 필요시에만 예외처림
 *              RuntimeException
 *              ArithmeticException
 *              ArrayIndexOutOfBoundsException
 *              NumberFormatException
 *              NullPointerException
 *              ClassCastException
 *              =====> throws 뒤에서 사용하지 않는다
 *              =====> 특별한 경우가 아니면  => throws => 예외를 피하는 상태 / 시스템에 의해 처리
 *                     => try~catch => 예외를 직접 잡아서 필요시에  => 복구해서 사용이 가능
 *              
 */
public class 예외처리_1 {
//    public int div(int a, int b) throws ArithmeticException
//    {
//        return a/b;
//    }
//    public void print()
//    {
//        int c=div(10,0);
//    }
    public void display() throws Exception,ClassNotFoundException
    {
        System.out.println("display call...");
    }
    // check => 호출시에는 반드시 예외처리를 하고 사용한다
    // uncheck => throws 문장을 사용하지 않는다
    // 1. try ~ catch
    public void print()
    {
        try {
            display();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 2. try ~ catch
    public void print2()
    {
        try {
            display();
//        } catch (Exception e) {
        } catch (Throwable e) {
        }
    }
    // 3. throws
    public void print3() throws Exception, ClassNotFoundException
    {
        display();
    }
    // 4. throws
    public void print4() throws Exception
    {
        display();
    }
    /*
     *  소스가 없는 경우   => 새로운 메서드를 만드는 경우
     *      try ~ catch => 개발
     *  이미 소스 코딩이 있는 경우 => 새로운 기능 추가
     *      throws    => 유지보수
     *      ------
     *      1. 예상되는 예외를 메서드 뒤에 선언
     *      2. 메서드 호출에 반드시 예외처리 후 호출
     *      -------------------------------
     *          => 직접처리 (*******)
     *          => 선언하고 사용할 수 있다
     */
   public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
