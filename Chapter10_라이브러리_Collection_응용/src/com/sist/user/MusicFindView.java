package com.sist.user;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import com.sist.vo.*;
import com.sist.dao.*;
public class MusicFindView extends JFrame {
    JTextField tf;
    JButton jb;
    JTable table;
    DefaultTableModel model;
    
    // 초기화
    public MusicFindView()
    {
        tf=new JTextField(10);
        jb=new JButton("검색");
        String[] col= {"순위","", "곡명","가수명","앨범"};
        Object[][] row=new Object[0][5];
        model=new DefaultTableModel(row,col)
        {
            //편집방지
            @Override
            public boolean isCellEditable(int row, int column) {
                // TODO Auto-generated method stub
                return false;
            }
            //이미지 출력
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                // TODO Auto-generated method stub
                return getValueAt(0, columnIndex).getClass();
            }
            
            // 익명의 클래스 => 재정의 (오버라이딩)
            // 내부 클래스의 대표적인 클래스
            // 상속없이 오버라이딩이 가능
            
        };
        
        table=new JTable(model);
        JScrollPane js=new JScrollPane(table);
        JPanel p=new JPanel();
        p.add(tf); p.add(jb);
        add("North", p);
        add("Center", js);
        table.setRowHeight(40);
        // 데이터 처리
        MusicDAO dao=MusicDAO.newInstance();
        List<MusicVO> list=dao.musicFindData("그");
        for (MusicVO vo: list)
        {
            try
            {
                String s="http:"+vo.getPoster();
                URL url=new URL(s);
                Image img=Commons.getImage(new ImageIcon(url), 30, 30);
                Object[] data= {
                        vo.getMno(),
                        new ImageIcon(img),
                        vo.getTitle(),
                        vo.getSinger(),
                        vo.getAlbum()
                };
                model.addRow(data);
                
            }catch(Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        setSize(800, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new MusicFindView();
        
    }

}
