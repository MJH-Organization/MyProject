package com.sist.client;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

import com.sist.manager.NaverNewsSearch;
import com.sist.vo.*;
public class NewsPanel extends JPanel
implements ActionListener,MouseListener
{
    NewsCard[] cards=new NewsCard[10];
    JTextField tf;
    JButton b;
    JPanel pan;
    JScrollPane pane;
    ControlPanel cp;
    java.util.List<NewsVO> list=
            new ArrayList<>();
    
    public NewsPanel(ControlPanel cp)
    {
        this.cp=cp;
        tf=new JTextField();
        b=new JButton("검색");
        for(int i=0;i<cards.length;i++)
        {
            cards[i]=new NewsCard();
        }
        pan=new JPanel();
        pan.setLayout(new GridLayout(10,1,5,5));
        
        setLayout(null);
        
        tf.setBounds(20, 15, 600, 30);
        b.setBounds(625, 15, 100, 30);
        add(tf);
        add(b);
        pan.setPreferredSize(new Dimension(800,1200));
        pane=new JScrollPane(pan);
        pane.setPreferredSize(new Dimension(780,700));
        pane.setBounds(20, 55, 780, 550);
        add(pane);
        
        tf.addActionListener(this);
        b.addActionListener(this);
        
        clean();
    }
    
    public void clean()
    {
        for(int i=cards.length-1;i<=0;i--)
        {
            cards[i].titleLa.setText("");
            cards[i].contentTp.setText("");
            cards[i].dateLa.setText("");
        }
    }

    public void newsPrint(String fd)
    {
        list=NaverNewsSearch.newsSearchData(fd);
        int i=0;
        for(NewsVO vo:list)
        {
            cards[i].titleLa.setText("<html><body>"
                    +vo.getTitle()+"</html></body>");
            cards[i].contentTp.setText("<html><body>"
                    +vo.getDescription()+"</html></body>");
            cards[i].dateLa.setText(vo.getPubDate());
            pan.add(cards[i]);
            cards[i].titleLa.addMouseListener(this);
            i++;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==tf || e.getSource()==b)
        {
            String fd=tf.getText();
            if(fd.trim().length()<1)
            {
                JOptionPane.showMessageDialog(this, "검색어를 입력하세요");
                tf.requestFocus();
                return;
            }
            newsPrint(fd);
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        for(int i=0;i<cards.length;i++)
        {
            if(e.getSource()==cards[i].titleLa)
            {
                try
                {
                    Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe "
                            +list.get(i).getLink());
                }catch(Exception ex) {}
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
        for(int i=0;i<cards.length;i++)
        {
            if(e.getSource()==cards[i].titleLa)
            {
                cards[i].titleLa.setBorder(new LineBorder(Color.green,5));
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        for(int i=0;i<cards.length;i++)
        {
            if(e.getSource()==cards[i].titleLa)
            {
                cards[i].titleLa.setBorder(null);
            }
        }       
    }

}
