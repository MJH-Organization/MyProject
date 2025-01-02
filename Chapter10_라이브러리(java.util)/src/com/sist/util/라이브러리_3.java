package com.sist.util;
import java.util.*;
public class 라이브러리_3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String color="red|yellow|green|pink|magenta|blue|black|cyan";
        StringTokenizer st= new StringTokenizer(color, "|");
        System.out.println("컬러 갯수: "+st.countTokens());
        // 초과시에는 오류
//        String color1=st.nextToken();
//        String color2=st.nextToken();
//        String color3=st.nextToken();
//        String color4=st.nextToken();
//        String color5=st.nextToken();
//        String color6=st.nextToken();
//        String color7=st.nextToken();
//        String color8=st.nextToken();
//        String color=st.nextToken();
    
          while(st.hasMoreTokens())
          {
              System.out.println(st.nextToken());
          }
          
          /*
            hasMoreTokens
            ---------------------------------------
                => before First
            ---------------------------------------
                red     => st.nextToken()   => true
            ---------------------------------------
                yellow  => st.nextToken()   => true
            ---------------------------------------
                green   => st.nextToken()   => true
            ---------------------------------------
                ...     => st.nextToken()   => false
            ---------------------------------------
                => after last
            ---------------------------------------
            
           */
    }
    

}
