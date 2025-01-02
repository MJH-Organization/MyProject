package com.sist.util;
import java.util.*;     // Date/Calendar/StringTokenizer
import java.text.SimpleDateFormat;
public class 라이브러리_6 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
        String today=sdf.format(date);
        // 2024-12-20
        StringTokenizer st= new StringTokenizer(today, "-");
        
        int year=Integer.parseInt(st.nextToken());
        int month=Integer.parseInt(st.nextToken());
        int day=Integer.parseInt(st.nextToken());

        Calendar cal1=Calendar.getInstance();
        // 추상클래스 => new를 이용할 수 없다
        /*
         *  날짜 설정
         *      => set()
         *  날짜 일기
         *      => get()
         *  달의 마지막 날짜
         *      => getActualMaximum
         *  요일 읽기
         *      => get(Calendar.DAY_OF_WEEK)
         */
        cal1.set(Calendar.YEAR, year);
        cal1.set(Calendar.MONTH, month-1);  // Calendar의 MONTH는 0~11 까지
        cal1.set(Calendar.DATE, day);
        
        int week=cal1.get(Calendar.DAY_OF_WEEK);
        week=week-1;
        String[] strWeek={"일", "월", "화", "수", "목", "금", "토"};
        
        System.out.println(year+"년도 "+month+"월 "+day+"일은 "+strWeek[week]+"요일");
        int lastday=cal1.getActualMaximum(Calendar.DATE);   // 설정한 달의 마지막 날짜를 가져온다
        
        Calendar cal2=Calendar.getInstance();
        cal2.set(Calendar.YEAR, year);
        cal2.set(Calendar.MONTH, month-1);
        cal2.set(Calendar.DATE, 1);
        
        int week2=cal2.get(Calendar.DAY_OF_WEEK);
        week2=week2-1;
        
        for (String s:strWeek)
        {
            System.out.printf("%2s\t",s);
        }
        System.out.println();
        for(int i=1; i<=lastday; i++)
        {
            if(i==1)
            {
                for (int j=0; j<week2; j++)
                {
                    System.out.print("\t");
                }
            }
            System.out.printf("%2d\t",i);
            week2++;
            if(week2>6) // 일요일이면
            {
                week2=0;
                System.out.println();
            }
        }
    }

}
