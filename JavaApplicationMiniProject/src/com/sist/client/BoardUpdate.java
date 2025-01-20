package com.sist.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.sist.dao.*;
import com.sist.vo.*;

public class BoardUpdate extends JPanel
implements ActionListener
{
    JLabel titleLa,nameLa,subLa,contLa,pwdLa,noLa;
    JTextField nameTf,subTf;
    JPasswordField pwdPf;
    JTextArea ta;
    JButton b1,b2;
    ControlPanel cp;    // 화면 변경 => 취소 / 수정
    
    public BoardUpdate(ControlPanel cp)
    {
        this.cp=cp;
    	titleLa=new JLabel("수정하기",JLabel.CENTER);// <table>
    	titleLa.setFont(new Font("맑은 고딕",Font.BOLD,30)); //<h3></h3>
    	setLayout(null);
    	titleLa.setBounds(10, 15, 620, 50);
    	add(titleLa);
    	
    	noLa=new JLabel();
    	noLa.setBounds(150, 70, 20, 30);
    	add(noLa);
    	noLa.setVisible(false);
    	// <input type=hidden>
    	
    	nameLa=new JLabel("이름",JLabel.CENTER);
    	nameTf=new JTextField();
    	nameLa.setBounds(100, 70, 80, 30);
    	nameTf.setBounds(185, 70, 150, 30);
    	add(nameLa);add(nameTf);
    	
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
    	
    	b1=new JButton("수정");
    	b2=new JButton("취소");
    	
    	JPanel p=new JPanel();
    	p.add(b1);p.add(b2);
    	p.setBounds(100, 435, 535, 35);
    	add(p);
    	
    	b1.addActionListener(this);
    	b2.addActionListener(this);
    	
    }
    
    // 값을 채운다 => 수정 (이전에 입력한 값을 가지고 온다)
    public void print(ReplyBoardVO vo)
    {
        nameTf.setText(vo.getName());
        subTf.setText(vo.getSubject());
        ta.setText(vo.getContent());
        noLa.setText(String.valueOf(vo.getNo()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==b2)
        {
            cp.card.show(cp, "BDETAIL");
        }
        else if(e.getSource()==b1)
        {
            String name=nameTf.getText();
            // NOT NULL을 설정한 경우 => 반드시 입력 유도
            if(name.trim().length()<1)
            {
                nameTf.requestFocus();
                return;
            }
            String subject=subTf.getText();
            if(subject.trim().length()<1)
            {
                subTf.requestFocus();
                return;
            }
            String content=ta.getText();
            if(content.trim().length()<1)
            {
                ta.requestFocus();
                return;
            }
            String pwd=String.valueOf(pwdPf.getPassword());
            if(pwd.trim().length()<1)
            {
                pwdPf.requestFocus();
                return;
            }
            String no=noLa.getText();
 
            //실제 수정
            ReplyBoardVO vo=new ReplyBoardVO();
            vo.setNo(Integer.parseInt(no));
            vo.setName(name);
            vo.setSubject(subject);
            vo.setContent(content);
            vo.setPwd(pwd);
            
            ReplyBoardDAO dao=ReplyBoardDAO.newInstance();
            boolean bCheck=dao.boardUpdate(vo);
            
            // List => Detail => 조회수 증가(O) => type=1
            // Update => Detail => 조회수 증가(X) => type=2
            if(bCheck==true)    // 수정한 상태
            {
                cp.card.show(cp, "BDETAIL");
                cp.bDetail.print(2,vo.getNo());
            }
            else    // 비밀번호가 틀리다
            {
                JOptionPane.showMessageDialog(this, "패스워드가 틀립니다 \n 다시 입력하세요");
                pwdPf.setText("");
                pwdPf.requestFocus();
                return;
            }
        }
        
    }
    /*
     *  게시판 => 최종으로 보여주는 화면
     *          ---------------
     *          BoardList       BoardDetail
     *              |                |
     *          BoardInsert     BoardUpdate
     *          BoardReply
     *          BoardDelete
     *          --------------- 웹/윈도우 동일
     *          
     *          card.show(카드명)
     *          response.sendRedirect(파일명)
     */
}
