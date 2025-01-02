package com.sist.oracle;
import java.sql.*;

public class 오라클연동 {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        // 드라이버 설정
        Class.forName("oracle.jdbc.driver.OracleDriver");
        // ojdbc8.jar
        // 오라클 연결
        String url="jdbc:oracle:thin:@localhost:1521:XE";       // ORACLE 은 재설치되는 경우 port가 변경됨: 1521 -> 1522 -> 1523
        Connection conn=DriverManager.getConnection(url,"hr","happy");
        // conn hr/happy
        String sql="SELECT * FROM emp";
        // 오라클  => SQL 문장 전송
        // SQL
        PreparedStatement ps=conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        // rs에 실행된 데이터가 들어가 있다
        
        while(rs.next())    // 데이터가 시작~끝까지 읽어 온다
        {
            System.out.println(
                    rs.getInt(1)+" "
                    +rs.getString(2)+" "
                    +rs.getString(3)
                    );
        }
    }

}
