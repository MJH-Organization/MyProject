package com.sist.client;
import java.util.*;
import java.net.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
// 마우스 / 버튼 / 엔터    => 서버로 전송
// 서버에서 전송하는 값 읽기   => 자동화 처리   => 쓰레드
import com.sist.commons.*;
public class ChatMain extends JFrame
implements ActionListener, Runnable
{

    Login login=new Login();
    WaitRoom wr=new WaitRoom();
    CardLayout card=new CardLayout();
    // <jsp:include>
    // 네트워크 관련 클래스
    Socket s;
    OutputStream out;
    BufferedReader in;
    // 본인 여부 확인
    String myId;
    public ChatMain()
    {
        setLayout(card);
        add("LOG", login);
        add("WR", wr);
        
        setSize(800,600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        login.b1.addActionListener(this);
        login.b2.addActionListener(this);
        
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new ChatMain();
    }
    
    // 서버 => 수신 => 화면 출력 => 쓰레드
    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }
    
    // 서버로 요청값 전송 => 사용자
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==login.b2)
        {
            dispose();  // 윈도우 메모리 해제
            System.exit(0);  // 프로그램 종료
        }
        else if(e.getSource()==login.b1)
        {
            
        }
                    
        
    }
    public void connection (String id, String name, String sex)
    {
        try
        {
            s=new Socket("localhost", 4321);
            // 서버 정보
            out=s.getOutputStream();
            in=new BufferedReader(new InputStreamReader(s.getInputStream()));
            // login 요청        
        }catch (Exception ex) {
            // TODO: handle exception
        }
        // 서버와 통신을 해라
        new Thread(this).start();
    }

}
