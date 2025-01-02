package com.sist.main;

/**
 *      제네릭
 *      ----
 *      1) 데이터형을 변경해서 사용이 쉽게 만든다
 *          => 리턴형 / 매개변수 => Object => 원하는 데이터형으로 변경
 *      2) 한번에 데이터형 통일이 가능하다
 *      3) 형변환 없이 사용이 가능 => 소스 간결 / 가독성
 *      4) Object 단점
 *          => 데이터 읽기가 어렵다
 *          ArrayList list=new ArrayList();
 *          list.add(1);
 *          list.add(10.5);
 *          list.add('A');
 *          list.add("AAA");
 *          list.add(new A());
 *          => 데이터의 통일성이 없다 => 반복문 사용 불가
 *             ---------- 반복문 사용이 가능 => 데이터형을 한개로 통일
 *          => 배열과 동일시 => 같은 데이터형만 
 *                          ---------   제어가 쉽다
 *          => 사용자 정의(X) => 표준화
 *          => 사용법 <클래스형> -> int, long 등 일반 데이터형은 들어갈 수 없다. (Wrapper class)를 사용해야 함
 *                             <int> (X) <Integer> (O) 
 *          => 임시 데이터형
 *              T / E / K / V
 *              => T/E => 클래스
 *                 type/element
 *              => K/V => Map
 *                 key/value
 */
/*
 *      Box<String> b=new Box<String>();
 *      T=>String
 *      Box b=new Box();
 *      T=>Object
 *      
 *      JDK 1.5 => JDK 1.8
 *                 -------  호환성이 좋다
 *                 -------  SUN 의 마지막 version
 *      => 객체의 데이터형 안정성 => 제어문 사용이 편리하다
 *      => 형변환을 하지 않기 때문에 소스가 간결하다           
 *      => 명시적으로 코딩 => 유지보수시 어떤 데이터가 들어가는지 확인이 좋다
 *      => 사용법
 *          ArrayList<String>
 *          ArrayList<Integer>
 *          ArrayList<Double>
 *          ArrayList<Sawon> <Movie> ...           
 */
class Box<T>
{
    T t;    // String t
    public void setT(T t)   // String t
    {
        this.t= t;
    }
    public T get()   // String t
    {
        return t;
    }
}
public class 제네릭_Collection_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Box<String> b=new Box<String>();
        b.setT("Hello");
        System.out.println(b.get());
    }

}
