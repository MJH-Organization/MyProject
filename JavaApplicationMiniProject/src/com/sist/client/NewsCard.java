package com.sist.client;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class NewsCard extends JPanel{
    JLabel titleLa;
    JTextPane contentTp;    // 자동 줄바꿈, HTML 출력이 가능
    JLabel dateLa;
    public NewsCard()
    {
        setLayout(null);
        titleLa=new JLabel("");
        contentTp=new JTextPane();
        JScrollPane js=new JScrollPane(contentTp);
        contentTp.setEditable(false);
        contentTp.setContentType("text/html");
        //html출력이 가능
        dateLa=new JLabel("");
        
        titleLa.setBounds(20, 10, 450, 35);
        js.setBounds(20, 50, 750, 100);
        dateLa.setBounds(480, 10, 200, 35);
        
        add(titleLa);
        add(js);
        add(dateLa);
    }
}
