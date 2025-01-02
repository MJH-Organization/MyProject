package com.sist.main;
import java.util.*;
public class 컬렉션_5_List {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        List<String> names=new ArrayList<String>();
//        
//        names=new LinkedList<String>();
//        names=new Vector<String>();
        
        List<String> list=new ArrayList<String>();
        list.add("Java");
        list.add("Oracle");
        list.add("HTML/CSS");
        list.add("JavaScript");
        list.add("JSP");        // Jquery / Ajax
        list.add("Spring");     // VueJS
        list.add("Python");     // Numpy / Pandas / MatplotLib
        list.add("ElasticSearch");
        list.add("AWS");        // Linux
        
        for (String subject:list)
        {
            System.out.println(subject);
            
        }
//        System.out.println("======================");
        
        // 데이터를 모아서 순차적으로 출력
//        Iterator<String> iter=list.iterator();
//        while(iter.hasNext())
//        {
//            System.out.println(iter.next());
//        }
//        // next()가 끝나면 2번 읽지는 못한다. 
//        while(iter.hasNext())
//        {
//            System.out.println(iter.next());
//        }

        System.out.println("======================");
        ListIterator<String> iter=list.listIterator();
        while(iter.hasNext())       // 위 => 아래
        {
            System.out.println(iter.next());
        }
        System.out.println("======================");
        while(iter.hasPrevious())   // 아래 => 위
        {
            System.out.println(iter.previous());
        }
        
    }

}
