package com.sist.main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
//////////////////////////////
import com.sist.vo.*;
import com.sist.manager.*;
////////////////////////////// Back
import java.awt.event.*;
// 행위   => 마우스 / 키보드    => 사건   => 사건에 처리
// 사건이 발생하면 => 사건 정보를 프로그래머로 넘겨준다
//                ----------------- 메서드가 구현이 안됨
// 추상 / 인터페이스
// 웹    => JavaScript

public class MusicFindPanel extends JPanel
implements  ActionListener
{
    /*
     *      Event
     *          버튼 / 텍스트 엔터 / 메뉴    actionPerformed
     *      마우스
     *          mouseClicked, mouseReleased mousePressed
     *          mouseEntered, mouseExited
     *      키보드
     *     
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource()==tf) // 엔터일때
        {
            // 입력된 데이터를 읽기
            String fd=tf.getText()  ;
            if(fd.trim().length()<1)
            {
                //입력이 안됨
                JOptionPane.showMessageDialog(this, "검색어를 입력하세요");
                tf.requestFocus();
                return;
            }
            musicFind(fd);
        }
        
    }

    JLabel la;
    JButton b1,b2;
    JTable table;
    DefaultTableModel model;
    JTextField tf;
    GenieMusicSystem gm=new GenieMusicSystem();

    public MusicFindPanel()
    {
//        setBackground(Color.pink);
        setLayout(null);
        tf=new JTextField();
        la=new JLabel("Music 검색", JLabel.CENTER);
        la.setFont(new Font("궁서체", Font.BOLD,35));
        la.setBounds(10,15,760,50);
        add(la);
        tf.setBounds(10, 70, 200, 30);
        add(tf);
        String[]    col= {"순위", "곡명", "가수명", "앨범"};
        String[][]  row=new String[0][4];
        model=new DefaultTableModel(row,col);
        table=new JTable(model);
        JScrollPane js=new JScrollPane(table);
        js.setBounds(10, 105, 760, 400);
        add(js);
        tf.addActionListener(this);
//        JPanel p=new JPanel()   ;
//        b1=new JButton("이전");
//        b2=new JButton("다음");
//        p.add(b1);
//        p.add(b2);
    }
    public void musicFind(String fd)
    {
        for (int i=model.getRowCount()-1; i>=0; i--)
        {
            model.removeRow(i);
        }
        MusicVO[]   music = gm.musicFindData(fd);
        for(MusicVO vo:music)
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
}
