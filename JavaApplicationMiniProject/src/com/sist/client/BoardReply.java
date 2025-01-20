package com.sist.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.sist.dao.*;
import com.sist.vo.*;

// <html> => VO, DAO
// JSP => DataBase : React/Vue/Ajax => DataBase 연동
// 사용자 입력 => 오라클 저장 => 화면 이동(목록)
public class BoardReply extends JPanel{
    JLabel titleLa,nameLa,subLa,contLa,pwdLa,noLa;
    JTextField nameTf,subTf;
    JPasswordField pwdPf;
    JTextArea ta;
    JButton b1,b2;
    ControlPanel cp;
    
    public BoardReply(ControlPanel cp)
    {
        this.cp=cp;
        titleLa=new JLabel("답변하기",JLabel.CENTER);// <table>
        titleLa.setFont(new Font("맑은 고딕",Font.BOLD,30)); //<h3></h3>
        setLayout(null);
        titleLa.setBounds(10, 15, 830, 50);
        add(titleLa);
        
        nameLa=new JLabel("이름",JLabel.CENTER);
        nameTf=new JTextField();
        nameLa.setBounds(100, 70, 80, 30);
        nameTf.setBounds(185, 70, 150, 30);
        add(nameLa);add(nameTf);
        
        // 답변을 위한 댓글 정보를 입력 후 숨김처리
        // <input type=hidden>
        noLa=new JLabel();
        noLa.setBounds(340, 70, 50, 30);
        add(noLa);
        noLa.setVisible(false);
        
        subLa=new JLabel("제목",JLabel.CENTER);
        subTf=new JTextField();
        subLa.setBounds(100, 105, 80, 30);
        subTf.setBounds(185, 105, 450, 30);
        add(subLa);add(subTf);
        
        
        contLa=new JLabel("내용",JLabel.CENTER);
        ta=new JTextArea();
        JScrollPane js=new JScrollPane(ta);
        contLa.setBounds(100, 140, 80, 30);
        js.setBounds(185, 140, 450, 250);
        add(contLa);add(js);
 
        pwdLa=new JLabel("비밀번호",JLabel.CENTER);
        pwdPf=new JPasswordField();
        //             Top  Right Bottom Left ==> CSS
        pwdLa.setBounds(100, 395, 80, 30);
        //             x  y width heigth
        pwdPf.setBounds(185, 395, 150, 30);
        add(pwdLa);add(pwdPf);
        
        b1=new JButton("답변");
        b2=new JButton("취소");
        
        JPanel p=new JPanel();
        p.add(b1);p.add(b2);
        p.setBounds(100, 435, 535, 35);
        add(p);
        
//        b1.addActionListener(this);    //글쓰기
//        b2.addActionListener(this);    // 취소
        
    }
}
