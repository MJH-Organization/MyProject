package com.sist.client;
//McWinLookAndFeel
//MintLookAndFeel
import javax.swing.*;
//							상속 => 재사용 => 변경
public class ClientMainFrame extends JFrame {
	MenuForm mf=new MenuForm();		// 포함 클래스 => 있는 그대로 사용
	ControlPanel cp=new ControlPanel();

	// 배치
	public ClientMainFrame()
	{
		setLayout(null);	// 사용자 정의	=> 직접 배치
		mf.setBounds(210, 15, 800, 50);
		add(mf);
		cp.setBounds(10, 70, 1220, 590);
		add(cp);
		setSize(1250,700);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
//			UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
		}catch(Exception ex) {}
		new ClientMainFrame();

	}

}
