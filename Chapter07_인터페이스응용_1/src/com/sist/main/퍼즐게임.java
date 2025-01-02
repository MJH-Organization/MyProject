package com.sist.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class 퍼즐게임 extends JFrame implements ActionListener {
    
    private final int ROW = 4;
    private final int COLUMN = 4;
    private final int BUTTON_GAP = 5;
    private final int BUTTON_NUM = ROW * COLUMN;
    JButton[] btns=new JButton[BUTTON_NUM];
    JLabel la=new JLabel("퍼즐게임",JLabel.CENTER);
    JButton b1,b2;
    int[] panCount=new int[BUTTON_NUM];
    int last=0; // 빈칸

    // 초기화
    public 퍼즐게임()
    {
        la.setFont(new Font("궁서체", Font.BOLD,30));
        la.setBounds(10, 2, 550, 35);
        add(la);

        b1=new JButton("시작");
        b2=new JButton("종료");
                        
        JPanel p=new JPanel();  // 컴퍼넌트 여러개 묶어서 배치
        JPanel pan=new JPanel();
        
        pan.setLayout(new GridLayout(ROW,COLUMN,BUTTON_GAP,BUTTON_GAP));
        for (int i=0; i<BUTTON_NUM; i++)
        {
            btns[i]=new JButton(String.valueOf(i+1));
            btns[i].setFont(new Font("궁서체",Font.BOLD,45));
            pan.add(btns[i]);
            btns[i].addActionListener(this);
        }
        
        setLayout(null);
        pan.setBounds(10,40,550,350);
        add(pan);
        
        p.add(b1); p.add(b2);
        p.setBounds(10,500,450,35);
        add(p);
        
        
        setSize(590,580);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // 등록
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new 퍼즐게임();

    }
    //버튼 처리하는 메서드 => 개발자가 구현 => 자동 호출
    @Override
    public void actionPerformed(ActionEvent e)
    {
        for (int i=0; i< BUTTON_NUM; i++)
        {
            if(e.getSource()==btns[last])
            {
                return;
            }
            if(e.getSource()==btns[i])
            {
                if(Math.abs(i-last)!=1 && Math.abs(i-last)!=COLUMN)
                {
                    return;
                }
                panCount[i]=BUTTON_NUM-1;
                panCount[last]=Integer.parseInt(btns[i].getText())-1;
                last=i;
                
                puzzleLayout();
                if(isEnd())
                {
                    JOptionPane.showMessageDialog(this, "Game Over~~~");;
                }

            }
        }
        if(e.getSource()==b2)
        {
            System.exit(0); // 프로그램 종료
        }
        else if (e.getSource()==b1)
        {
            while(true)
            {
                if (getRand())
                    break;
            }
            puzzleLayout();
        }
    }
    
    // 사용자 정의 메서드
    public boolean getRand()
    {
        boolean isRunnable=false;
        for(int i=0; i<BUTTON_NUM; i++)
        {
            panCount[i]=(int)(Math.random()*BUTTON_NUM);
            for (int j=0; j<i;j++)
            {
                if (panCount[i]==panCount[j])
                {
                    i--;
                    break;
               }
            }
        }
        for (int i=0; i<BUTTON_NUM; i++)
        {
            if(panCount[i]==BUTTON_NUM-1)
            {
                last=i;
                break;
            }
        }

        int countR=0;
        for (int i=0; i<BUTTON_NUM; i++)
        {
            for (int j=i+1; j<BUTTON_NUM; j++)
            {
                if(panCount[i]!=BUTTON_NUM-1 && panCount[i] > panCount[j])
                    countR++;
            }
        }
        
        if (ROW%2!=0)
        {
           if(countR%2==0) isRunnable=true;
        }
        else if ((ROW-last/COLUMN)%2==0) 
        {
            if(countR%2!=0) isRunnable=true;
        }
        else
        {
            if(countR%2==0) isRunnable=true;
        }
        
        return isRunnable;
    }
    // 배치
    public void puzzleLayout()
    {
        for (int i=0; i<BUTTON_NUM; i++)
        {
            if(last==i)
            {
                btns[i].setText("");
            }
            else
            {
                btns[i].setText(String.valueOf(panCount[i]+1));
            }
        }
    }
    public boolean isEnd() 
    {
        for (int i=0; i<BUTTON_NUM; i++)
        {
            if(panCount[i]!=i) {
                return false;
            }
        }
        return true;
    }
}
