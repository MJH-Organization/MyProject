package com.sist.main;
import com.sist.dao.*;

public class EmpMain {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        EmpDeptDAO dao=EmpDeptDAO.newInstance();
        dao.sqlExecute();
        System.out.println("============================================================");
        dao.viewExecute();
    }

}
