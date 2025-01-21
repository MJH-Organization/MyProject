package com.sist.client;
import java.awt.CardLayout;
import java.awt.Color;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;
// 화면 변경
public class ControlPanel extends JPanel {
    HomePanel hp;
    ChatPanel cp;
    FoodGenrePanel fgp;
    FoodFindPanel ffp;
    FoodDetailPanel fdp;
    BoardList bList;
    BoardInsert bInsert;
    BoardDetail bDetail;
    BoardUpdate bUpdate;
    BoardReply  bReply;
    BoardDelete bDelete;
    NewsPanel np;
    CardLayout card=new CardLayout();
	public ControlPanel()
	{
	    setLayout(card);
	    hp=new HomePanel(this);
	    add("HOME",hp);
	    cp=new ChatPanel(this);
	    add("CHAT",cp);
	    fgp=new FoodGenrePanel(this);
	    add("FOOD",fgp);
	    ffp=new FoodFindPanel(this);
	    add("FIND",ffp);
	    fdp=new FoodDetailPanel(this);
	    add("DETAIL",fdp);
	    
	    bList=new BoardList(this);
	    add("BLIST",bList);
	    bInsert=new BoardInsert(this);
	    add("BINSERT",bInsert);
	    bDetail=new BoardDetail(this);
	    add("BDETAIL",bDetail);
	    bUpdate=new BoardUpdate(this);
	    add("BUPDATE",bUpdate);
	    bReply=new BoardReply(this);
	    add("BREPLY",bReply);
	    bDelete=new BoardDelete(this); // => jsp => URL 주소
	    // delete.jsp?no=10&pwd=1234
	    add("BDELETE",bDelete);
	    np=new NewsPanel(this);
	    add("NP",np);
	    /*
	     *     사용자 요청 ===> ControlPanel => 화면 이동
	     *                              필요한 데이터 전송
         *     사용자 요청 ===> Controller => Model
         *                                  |=> 데이터 전송
         *                                 화면이동(View):JSP
         *     => MVC (Spring형식)                                 
	     *                              
	     */
	}

}
