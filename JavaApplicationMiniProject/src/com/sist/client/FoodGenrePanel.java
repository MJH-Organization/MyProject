package com.sist.client;
import java.util.*;
import java.util.List;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.event.*;
import java.net.URL;

import com.sist.commons.ImageChange;
import com.sist.dao.*;
import com.sist.vo.*;
/*
 *  1.  JFrame / JDialog => 
 *  2. JPanel => FlowLayout
 */
public class FoodGenrePanel extends JPanel
implements ActionListener,MouseListener
{
    ControlPanel cp;
    JButton[] genre=new JButton[5]; // 한식, 중식, 양식, 일식, 기타

    JButton prev,next; // 이전, 다음
    JLabel la=new JLabel("0 page / 0 pages");
    JLabel[] imgs=new JLabel[12];
    
    int curpage=1;
    int totalpage=0;
    JPanel pan=new JPanel(); // 이미지용 패널
    FoodDAO dao=FoodDAO.newInstance();
    String strGenre="한식";
    /*
     *  Border Layout: North,South,Center,West,East 다섯 군데 배치
     *  Flow Layout: 촤-> 우로 일자 배치
     *  Grid Layout: 바둑판식 배치
     */
    public FoodGenrePanel(ControlPanel cp)
    {
        this.cp=cp;
        
//        b1=new JButton("한식");
//        b2=new JButton("중식");
//        b3=new JButton("양식");
//        b4=new JButton("일식");
//        b5=new JButton("기타");

        prev=new JButton("이전");
        next=new JButton("다음");
        
        JPanel p1=new JPanel();
        p1.setLayout(new GridLayout(1,5,5,5));
        String[] temp= {"한식","중식","양식","일식","기타"};
        for (int i=0;i<genre.length;i++)
        {
            genre[i]=new JButton(temp[i]);
            p1.add(genre[i]);
            genre[i].addActionListener(this);
        }
        
//        p1.add(b1); p1.add(b2); p1.add(b3); p1.add(b4); b1.add(b5);
        
        JPanel p2=new JPanel();
        p2.add(prev); p2.add(la); p2.add(next);
        // add => 코딩 순서대로 출력
        
        pan.setLayout(new GridLayout(3,4,5,5)); // 3줄 * 4개 간격 5 배치
        ////// 전체 화면 배치
        setLayout(new BorderLayout());
        add("North", p1);
        add("Center", pan);
        add("South", p2);
        print();
        
        prev.addActionListener(this);
        next.addActionListener(this);
    }
    // 초기화
    public void init()
    {
        for(int i=0; i<imgs.length;i++)
        {
            imgs[i]=new JLabel("");
        }
        pan.removeAll(); // 전체 삭제
        pan.validate(); //재배치
    }
    // 이미지 출력
    public void print()
    {
        // 홈페이지 읽기
        totalpage=dao.foodGenreTotalPage(strGenre);
        List<FoodVO> list=dao.foodGenreData(curpage,strGenre);
        
        for(int i=0; i<list.size();i++)
        {
            FoodVO vo=list.get(i);
            try
            {
                URL url=new URL(vo.getPoster());
                Image image=ImageChange.getImage(new ImageIcon(url), 200, 180);
                imgs[i]=new JLabel(new ImageIcon(image));
                imgs[i].setToolTipText(vo.getName()+"^"+vo.getFno());
                pan.add(imgs[i]);
                // 이벤트 등록
                imgs[i].addMouseListener(this);
            }catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        la.setText(curpage+" page / "+totalpage+" pages");

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        for(int i=0;i<imgs.length;i++)
        {
            if(e.getSource()==imgs[i])
            {
                if(e.getClickCount()==2)
                {
                    String fno=imgs[i].getToolTipText();
                    fno=fno.substring(fno.lastIndexOf("^")+1);
                    FoodVO vo=dao.foodDetailData(Integer.parseInt(fno));
                    cp.fdp.detailPrint(2, vo);
                    cp.card.show(cp, "DETAIL");
                }
            }
        }
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        //onMouseOver
        for(int i=0;i<imgs.length;i++)
        {
            if(e.getSource()==imgs[i])
            {
                imgs[i].setBorder(new LineBorder(Color.GREEN,3));
            }
        }
        
    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        // onMouseOut
        for(int i=0;i<imgs.length;i++)
        {
            if(e.getSource()==imgs[i])
            {
                imgs[i].setBorder(null);
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        for(int i=0; i<genre.length;i++)
        {
            if(e.getSource()==genre[i])
            {
                strGenre=genre[i].getText();
                //버튼 문자열 읽기
                curpage=1;
                init();
                print();
            }
        }
        if(e.getSource()==prev)
        {
            if(curpage>1)
            {
                curpage--;
                init();
                print();
            }
        }
        else if(e.getSource()==next)
        {
            if(curpage<totalpage)
            {
                curpage++;
                init();
                print();
            }
        }
        
    }
}    
