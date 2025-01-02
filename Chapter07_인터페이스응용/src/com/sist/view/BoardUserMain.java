package com.sist.view;
import com.sist.contraller.*;
import java.util.*;
public class BoardUserMain {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        Controller c=new Controller();
        System.out.print("list,write,update,detail,detail,find?: ");
        String msg=scan.next();
        
        Controller con=new Controller();
        con.service(msg);
        

    }

}
