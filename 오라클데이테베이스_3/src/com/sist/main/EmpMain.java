package com.sist.main;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
public class EmpMain {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("★★★★★ 사원목록 ★★★★★");
        // 오라클 연결
        EmpDAO dao=EmpDAO.newInstance();
        List<EmpVO> list=dao.empJoinAllData();
        for (EmpVO vo:list)
        {
            System.out.println(vo.getEmpno()+" "
                    +vo.getEname()+" "
                    +vo.getJob()+" "
                    +vo.getHiredate()+" "
                    //+vo.getSal()+" "
                    +vo.getStrSal()+" "
                    +vo.getDvo().getDname()+" "
                    +vo.getDvo().getLoc()+" "
                    +vo.getSvo().getGrade()
                    );
            
        }
        System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★");
        EmpVO vo=dao.empFindData(7839);
        System.out.println(vo.getEmpno()+" "
                +vo.getEname()+" "
                +vo.getJob()+" "
                +vo.getHiredate()+" "
                //+vo.getSal()+" "
                +vo.getStrSal()+" "
                +vo.getDvo().getDname()+" "
                +vo.getDvo().getLoc()+" "
                +vo.getSvo().getGrade()
                );
    }

}
