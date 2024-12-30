package com.sist.main;
import javax.swing.*;
import java.util.*; 

import java.util.List; // List 클래스가 두개의 package에 있는 경우 충돌 오류가 나온다. 
import com.sist.board.*;


import java.awt.*;
import java.text.SimpleDateFormat;
import java.awt.event.*;
public class BoardMainForm extends JFrame
implements ActionListener,MouseListener
{
    CardLayout card=new CardLayout();
    BoardList bList= new BoardList();
    BoardDetail bDetail=new BoardDetail();
    BoardInsert bInsert=new BoardInsert();
    BoardUpdate bUpdate = new BoardUpdate();
    BoardDelete bDelete = new BoardDelete();
    // 게시판 관리자
    BoardManager bm = new BoardManager();
    
    // 변수 설정
    int curpage=1;
    int totalpage=0;
    
    public BoardMainForm()
    {
        setLayout(card);
        add("LIST", bList);
        add("INSERT", bInsert);
        add("DETAIL", bDetail);
        add("UPDATE", bUpdate);
        add("DELETE", bDelete);
        
        setTitle("윈도우 게시판 ver 1.0");
        listPrint();
        setSize(640, 550);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // 이벤트 등록
        bList.inBtn.addActionListener(this);    // 글쓰기 이동
        bInsert.b1.addActionListener(this);     // 글쓰기
        bInsert.b2.addActionListener(this);     // 취소
        
        // 이전
        bList.prevBtn.addActionListener(this);
        // 다음
        bList.nextBtn.addActionListener(this);
        // table
        bList.table.addMouseListener(this);
        
        // 목록
        bDetail.b3.addActionListener(this);
        // 수정
        bDetail.b1.addActionListener(this);
        // 삭제
        bDetail.b2.addActionListener(this);
        
        // 실제 삭제
        bDelete.b1.addActionListener(this); // 삭제
        bDelete.b2.addActionListener(this); // 취소

        // 수정
        bUpdate.b1.addActionListener(this); // 수정
        bUpdate.b2.addActionListener(this); // 취소
    }
    
    public void listPrint()
    {
        //  => table의 내용을 지운다
        for (int i=bList.model.getRowCount()-1; i>=0; i--)
        {
            bList.model.removeRow(i);
        }
        
        // 데이터 받기
        // 다른 패키지에 같은 이름의 클래스가 있는 경우
        /*
         *  java.util.List
         *  java.awt.*
         *  
         *  java.util.List<BoardVO> list = ...
         */
        List<BoardVO> list=bm.boardListData(curpage);
        totalpage=bm.boardTotalPage();
        bList.pageLa.setText(curpage+"page / "+totalpage+"pages");
        // 게시물 출력
        for(int i=0; i<list.size(); i++)
        {
            BoardVO vo=list.get(i);
            String[] data= {
                    String.valueOf(vo.getNo()),
                    vo.getSubject(),
                    vo.getName(),
                    new SimpleDateFormat("yyyy-MM-dd").format(vo.getRegdate()),
                    String.valueOf(vo.getHit())
            };
            bList.model.addRow(data);
        }
    }
    
    public void detailPrint(BoardVO vo)
    {
        // frame의 내용을 update 한다
        // 수정 요청
        bDetail.no.setText(String.valueOf(vo.getNo()));
        bDetail.sub.setText(vo.getSubject());
        bDetail.ta.setText(vo.getContent());
        bDetail.hit.setText(String.valueOf(vo.getHit()));
        bDetail.day.setText(new SimpleDateFormat("yyyy-MM-dd").format(vo.getRegdate()));

    }

            
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new BoardMainForm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(bList.inBtn==e.getSource())  // 목록에서 새글 버튼 클릭
        {
            bInsert.nameTf.setText("");
            bInsert.subTf.setText("");
            bInsert.ta.setText("");
            bInsert.pwdPf.setText("");
            // 카드 변경 => 윈도우 창 변경
            card.show(getContentPane(), "INSERT");
            bInsert.nameTf.requestFocus();
        }
        else if(bInsert.b2==e.getSource()) // 글쓰기 취소
        {
            card.show(getContentPane(), "LIST");
            // javascript:history.back()
        }
        else if(bInsert.b1==e.getSource())  // 글쓰기
        {
            String name=bInsert.nameTf.getText();
            // 입력된 값 읽기
            if(name.length() < 1)
            {
                bInsert.nameTf.requestFocus();
                return;
            }
            /*
             *      let name=$('#name').val()
             *      if(name.length<1)
             *      {
             *         $('#name').focus()
             *         return
             *      }
             */
            String subject=bInsert.subTf.getText();
            // 입력된 값 읽기
            if(subject.length() < 1)
            {
                bInsert.subTf.requestFocus();
                return;
            }
            
            String content=bInsert.ta.getText();
            // 입력된 값 읽기
            if(content.length() < 1)
            {
                bInsert.ta.requestFocus();
                return;
            }
            
            String pwd=String.valueOf(bInsert.pwdPf.getPassword());
            // 입력된 값 읽기
            if(pwd.length() < 1)
            {
                bInsert.pwdPf.requestFocus();
                return;
            }
            
            BoardVO vo= new BoardVO();
            vo.setName(name);
            vo.setSubject(subject);
            vo.setContent(content);
            vo.setPwd(pwd);
            int no=bm.boardSequence();
            vo.setNo(no);
            vo.setRegdate(new Date());
            bm.boardInsert(vo);     // 추가
            
            // 목록으로 이동
            card.show(getContentPane(), "LIST");
            listPrint();
                    
        }
        else if(bList.prevBtn==e.getSource())   // 이전
        {
            if(curpage>1)
            {
                curpage--;
                listPrint();
            }
        }
        else if(bList.nextBtn==e.getSource())   // 다음
        {
            if(curpage<totalpage)
            {
                curpage++;
                listPrint();
            }
        }
        // => 웹 => 반드시 현재페이지 전송
        else if(bDetail.b3==e.getSource())  // 상세보기 => 목록
        {
            card.show(getContentPane(), "LIST");
            listPrint();
        }
        else if(bDetail.b2==e.getSource())  // 
        {
            card.show(getContentPane(), "DELETE");
            // 화면 변경
        }
        else if(bDetail.b1==e.getSource())  // 
        {
            // 수정 요청
            String no=bDetail.no.getText();
            BoardVO vo=bm.boardUpdateData(Integer.parseInt(no));
            card.show(getContentPane(), "UPDATE");
            bUpdate.nameTf.setText(vo.getName());
            bUpdate.subTf.setText(vo.getSubject());
            bUpdate.ta.setText(vo.getContent());
            
        }
        else if(bUpdate.b2==e.getSource())  // 
       {
           card.show(getContentPane(), "DETAIL");
       }
        else if(bUpdate.b1==e.getSource())  // 
       {
            String pwd=String.valueOf(bUpdate.pwdPf.getPassword());
            if(pwd.length()<1)
            {
                bUpdate.pwdPf.requestFocus();
                return;
            }
            BoardVO vo=new BoardVO();
            vo.setNo(Integer.parseInt(bDetail.no.getText()));
            vo.setName(bUpdate.nameTf.getText());
            vo.setSubject(bUpdate.subTf.getText());
            vo.setContent(bUpdate.ta.getText());
            vo.setPwd(pwd);
            vo.setHit(Integer.parseInt(bDetail.hit.getText()));
            
            boolean bCheck=bm.boardUpdate(vo);
            
            if(bCheck==false)
            {
                JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다!!");
                bUpdate.pwdPf.setText("");
                bUpdate.pwdPf.requestFocus();
            }
            else
            {
                
                card.show(getContentPane(), "DETAIL");
                detailPrint(vo);
            }
          
       }
         else if(bDelete.b2==e.getSource())  // 
        {
            card.show(getContentPane(), "DETAIL");
        }
        else if(bDelete.b1==e.getSource())  // 
        {
            String pwd=String.valueOf(bDelete.pf.getPassword());
            if(pwd.length()<1)
            {
                bDelete.pf.requestFocus();
                return;
            }
            String no=bDetail.no.getText();
            boolean bCheck=bm.boardDelete(Integer.parseInt(no), pwd);
            if(bCheck==false)
            {
                JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다!!");
                bDelete.pf.setText("");
                bDelete.pf.requestFocus();
            }
            else
            {
                card.show(getContentPane(), "LIST");
                listPrint();
            }
            
        }
        // 수정/삭제 => 본인여부 확인 => 비밀번호
        // boolean => 비밀번호 체크
        /*
         *  1. 목록 => 추가 => 목록
         *           삭제 => 목록
         *  2. 상세보기
         *       수정 => 상세보기
         *  3. 취소 => 이전화면 이동
         *      history.back()     
         */
    }
    // onMouseDown
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==bList.table)
        {
            if(e.getClickCount()==2)
            {
                int row=bList.table.getSelectedRow();
                String no=bList.model.getValueAt(row, 0).toString();
                //System.out.println(no);   
                BoardVO vo=bm.boardDetail(Integer.parseInt(no));
                card.show(getContentPane(), "DETAIL");
                
                // 출력 => bDetail
                bDetail.no.setText(String.valueOf(vo.getNo()));
                bDetail.name.setText(vo.getName());
                bDetail.sub.setText(vo.getSubject());
                bDetail.ta.setText(vo.getContent());
                bDetail.hit.setText(String.valueOf(vo.getHit()));
                bDetail.day.setText(new SimpleDateFormat("yyyy-MM-dd").format(vo.getRegdate()));
                // 1. 웹/윈도우 => 거의 대부분이 String 이기 때문에 
                // 정수 / 실수 변환 => String.valueOf()
                // --------- Integer.parseInt() Double.parseDouble()
                // 날짜 => SimpleDateFormat => 2024-12-27
                // 정수 => DecimalFormat => 1,000
                
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    // onMouserUp
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    // onMouseOver
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

}
