package com.sist.main;

import javax.swing.*;
import java.awt.*;

public class 퍼즐게임_2 extends JFrame {
    private final int ROW = 4;
    private final int COLUMN = 4;
    private final int NUMBERS = ROW*COLUMN;
    
    JLabel title = new JLabel("숫자 퍼즐", JLabel.CENTER);
    JPanel board = new JPanel();
    JPanel ctlBoard = new JPanel();
    int[] buttonArr = new int[NUMBERS];
    JButton b1, b2;
    
    public 퍼즐게임_2()
    {
        
        b1 = new JButton("시작");
        b2 = new JButton("종료");
        ctlBoard.setBounds(10,15,620,120);
        ctlBoard.add(b1);
        ctlBoard.add(b2);
        add(ctlBoard);

        board.setLayout(new GridLayout(ROW,COLUMN,5,5));
        board.setBounds(10, 140, 620, 760);
        board.add(title);
        add(board);
        board.add(ctlBoard);
        setSize(640, 800);
        setVisible(true);
    }
            

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        new 퍼즐게임_2();
    }

}
