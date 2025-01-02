package com.sist.execute;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CalcMain extends JFrame
implements ActionListener
{
    // 웹
    JTextField tf1, tf2, tf3;
    JLabel la;
    JComboBox box;
    JButton b1, b2;
    
    //초기화
    public CalcMain()
    {
        tf1=new JTextField(7);
        tf2=new JTextField(7);
        tf3=new JTextField(7);
        
        la= new JLabel("=");
        box=new JComboBox<>();
        box.addItem("+");
        box.addItem("-");
        box.addItem("*");
        box.addItem("/");
        b1=new JButton("계산");
        b2=new JButton("종료");
        setLayout(new FlowLayout());    // 한 중에 출력
        
        add(tf1);
        add(box);
        add(tf2);
        add(la);
        add(tf3);
        add(b1);
        add(b2);
        setSize(500, 100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new CalcMain();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==b2)
        {
            System.exit(0);
        }
        else if(e.getSource()==b1)
        {
            int  n1=0, n2=0;
            // if문 처리가 어려운 경우 (입력된 문자가 숫자형인지 아닌지 판단하기 어렵다) => Integer.parseInt()로 예외처리 유도 
            try
            {
                String no1=tf1.getText();
                n1=Integer.parseInt(no1);
                
            }catch(Exception ex) 
            {
                tf1.setText("");
                tf1.requestFocus();
                return;
            }
            try
            {
                String no2=tf2.getText();
                n2=Integer.parseInt(no2);
                
            }catch(Exception ex) 
            {
                tf2.setText("");
                tf2.requestFocus();
                return;
            }
            
            String op=box.getSelectedItem().toString();
            switch (op)
            {
            case "+":
                tf3.setText(String.valueOf(n1+n2));
                break;
            case "-":
                tf3.setText(String.valueOf(n1-n2));
                break;
            case "*":
                tf3.setText(String.valueOf(n1*n2));
                break;
            case "/":
                if(n2==0)
                {
                    JOptionPane.showMessageDialog(this, "0으로 나눌 수 없다");
                    tf2.setText("");
                    tf2.requestFocus();
                }
                else
                {
                    tf3.setText(String.valueOf(n1/(double)n2));
                }
                break;
            }
        }
        
        
        
    }

}
