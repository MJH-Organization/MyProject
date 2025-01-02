package com.sist.main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.*;

import com.sist.manager.*;
import com.sist.vo.*;
import java.awt.event.*;

public class MusicListPanel extends JPanel
implements ActionListener
{
    JLabel la;
    JButton b1,b2;
    JTable table;
    DefaultTableModel model;
    GenieMusicSystem gm=new GenieMusicSystem();

    public MusicListPanel()
    {
        setLayout(null);

        la=new JLabel("Music Top 50", JLabel.CENTER);
        la.setFont(new Font("궁서체", Font.BOLD,35));
        la.setBounds(10,15,760,50);
        add(la);
        
        b1=new JButton("지니뮤직");
        b2=new JButton("멜론");
        b1.setBounds(10, 75, 120, 30);
        b2.setBounds(135, 75, 100, 30);
        add(b1); add(b2);
        
        String[]    col= {"순위", "곡명", "가수명", "앨범"};
        String[][]  row=new String[0][4];
        model=new DefaultTableModel(row,col);
        table=new JTable(model);
        JScrollPane js=new JScrollPane(table);
        js.setBounds(10, 110, 760, 400);
        add(js);
        musicPrint(1);
        b1.addActionListener(this);
        b2.addActionListener(this);
        table.setRowHeight(40);
//        JPanel p=new JPanel()   ;
//        b1=new JButton("이전");
//        b2=new JButton("다음");
//        p.add(b1);
//        p.add(b2);
    }
    
    public void musicPrint(int type)
    {
        for (int i=model.getRowCount()-1; i>=0; i--)
        {
            model.removeRow(i);
        }
        if (type == 1) 
        {
            gm=new GenieMusicSystem();
            la.setText("지니뮤직 Top50");
            b1.setEnabled(false);
            b2.setEnabled(true);
        }
        else
        {
            gm=new MelonMusicSystem();
            la.setText("멜론 Top50");
            b2.setEnabled(false);
            b1.setEnabled(true);
        }
        
        MusicVO[] musics=gm.musicAllData();
        for (MusicVO vo:musics)
        {
            String[] data= {
                    String.valueOf(vo.getNo()),
                    vo.getTitle(),
                    vo.getSinger(),
                    vo.getAlbum()
            };
            model.addRow(data);
        }
        
    }

    // 버튼 처리
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==b1) // b1버튼 클릭 
        {
            musicPrint(1);
        }
        else if (e.getSource()== b2)
        {
            musicPrint(2);
            
        }
    }

}
