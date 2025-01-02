package com.sist.exception;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Class.forName()  => ClassNotFoundException
// CheckException   => 반드시 예외처리 후 사용
class Movie
{
    public void display()
    {
        System.out.println("Movie");
    }
}
public class 예외처리_메모리할당_리플렉션 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try
        {
            Class clsName=Class.forName("com.sist.exception.Movie");
            //클래스 정보읽기
            Object obj=clsName.getDeclaredConstructor().newInstance();
            Method[] methods=clsName.getDeclaredMethods();
            methods[0].invoke(obj, null);
        }catch(Exception ex) {}
        
//        }catch(ClassNotFoundException ex) {}
//        catch(NoSuchMethodException e) {}
//        catch(InvocationTargetException e) {}
    }

}
