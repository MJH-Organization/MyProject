package com.sist.client;
// 상세보기
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;

import com.sist.commons.ImageChange;
import com.sist.dao.*;
import com.sist.vo.*;
public class FoodDetailPanel extends JPanel
implements ActionListener
{
    JLabel posterLa,poster;
    JLabel nameLa,typeLa,phoneLa,addressLa,scoreLa,timeLa,parkingLa,priceLa;
    JLabel name,type,phone,address,score,time,parking,price;
    JLabel themeLa;
    JLabel[] images=new JLabel[6];
    JTextPane themeTa,contentTa;
    JButton b1,b2,b3;
    int mode=0;
    ControlPanel cp;
    String[] link= {"","HOME","FOOD","FIND"};
    public FoodDetailPanel(ControlPanel cp)
    {
        this.cp=cp;
        setLayout(null);
        
        poster=new JLabel("");
        poster.setBounds(20, 20, 350, 300);
        add(poster);
        
        nameLa=new JLabel("업체명");
        name=new JLabel();
        nameLa.setBounds(380, 20, 80, 30);
        name.setBounds(465, 20, 250, 30);
        add(nameLa); add(name);

        typeLa=new JLabel("음식종류");
        type=new JLabel();
        typeLa.setBounds(380, 55, 80, 30);
        type.setBounds(465, 55, 250, 30);
        add(typeLa); add(type);

        addressLa=new JLabel("주소");
        address=new JLabel();
        addressLa.setBounds(380, 90, 80, 30);
        address.setBounds(465, 90, 350, 30);
        add(addressLa); add(address);
        
        phoneLa=new JLabel("전화");
        phone=new JLabel();
        phoneLa.setBounds(380, 125, 80, 30);
        phone.setBounds(465, 125, 250, 30);
        add(phoneLa); add(phone);
        
        timeLa=new JLabel("영업시간");
        time=new JLabel();
        timeLa.setBounds(380, 160, 80, 30);
        time.setBounds(465, 160, 250, 30);
        add(timeLa); add(time);
        
        parkingLa=new JLabel("주차");
        parking=new JLabel();
        parkingLa.setBounds(380, 195, 80, 30);
        parking.setBounds(465, 195, 250, 30);
        add(parkingLa); add(parking);
        
        priceLa=new JLabel("가격대");
        price=new JLabel();
        priceLa.setBounds(380, 230, 80, 30);
        price.setBounds(465, 230, 250, 30);
        add(priceLa); add(price);
        
        scoreLa=new JLabel("평점");
        score=new JLabel();
        scoreLa.setBounds(380, 265, 80, 30);
        score.setBounds(465, 265, 250, 30);
        add(scoreLa); add(score);
        
        themeLa=new JLabel("테마");
        themeTa=new JTextPane();
        themeLa.setBounds(380, 300, 80, 30);
        themeTa.setBounds(465, 300, 350, 90);
        add(themeLa); add(themeTa);
        themeTa.setEnabled(false);
        
        contentTa=new JTextPane();
        JScrollPane js2=new JScrollPane(contentTa);
        js2.setBounds(380, 400, 435, 120);
        add(js2);
        js2.setEnabled(false);
        
        b1=new JButton("찜하기");
        b2=new JButton("예약하기");
        b3=new JButton("목록");
        
        JPanel p=new JPanel();
        p.add(b1); p.add(b2); p.add(b3);
        p.setBounds(380, 525, 435, 35);
        add(p);
        
        b3.addActionListener(this);
    }
    
    public void detailPrint(int mode, FoodVO vo)
    {
        this.mode=mode;
        try
        {
            URL url=new URL(vo.getPoster());
            Image img=ImageChange.getImage(new ImageIcon(url), 350, 350);
            poster.setIcon(new ImageIcon(img));
            
            name.setText(vo.getName());
            type.setText(vo.getType());
            address.setText(vo.getAddress());
            phone.setText(vo.getPhone());
            price.setText(vo.getPrice());
            parking.setText(vo.getParking());
            score.setText(String.valueOf(vo.getScore()));
            time.setText(vo.getTime());
            themeTa.setText(vo.getTheme());
            contentTa.setText(vo.getContent());
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==b3)
        {
            cp.card.show(cp, link[mode]);
            // 자바스크립트에서는
            // history.back()
        }
    }
}
