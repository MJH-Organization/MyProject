package com.sist.main;

import lombok.*;
//@EqualsAndHashCode
// Equals / HashCode => 재정의
@Data       // => @EqualsAndHashCode, @Getter, @Setter 를 합친 것이 @Data 이다
//@Getter
//@Setter
class Sawon
{
    private int sabun;
    private String name;
    private String dept;
    
    public Sawon(int sabun, String name, String dept) {
        super();
        this.sabun = sabun;
        this.name = name;
        this.dept = dept;
    }
    
    
}
public class 컬렉션_2_ArrayList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Sawon s1=new Sawon(1, "홍길동", "개발부");
        Sawon s2=new Sawon(1, "홍길동", "개발부");
        
        if (s1.equals(s2)) // 객체 비교
        {
            System.out.println("같은 사원입니다");
        }
        else
        {
            System.out.println("다른 사원입니다");
        }
    }

}
