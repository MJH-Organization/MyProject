package com.sist.main;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
public class MainClass {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("페이지 입력:");
        int page=scan.nextInt();
        FoodDAO dao=FoodDAO.newInstance();
        List<FoodVO> list=dao.foodListData(page);
        for(FoodVO vo:list)
        {
            System.out.println(vo.getFno()+"."
                    +vo.getName());
        }
    }

}
