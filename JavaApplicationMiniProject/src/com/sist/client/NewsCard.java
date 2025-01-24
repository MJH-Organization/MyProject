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
        
        titleLa.setBounds(10, 5, 450, 25);
        js.setBounds(10, 35, 740, 60);
        dateLa.setBounds(480, 5, 200, 25);
        
        add(titleLa);
        add(js);
        add(dateLa);
    }
}
