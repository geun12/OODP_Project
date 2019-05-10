package baseball;

import java.applet.*;
import java.awt.*;
import java.util.*;
import java.text.*;  
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class MainMenu  {
	
	public JPanel mainPanel;
	
	public MainMenu() {
		 mainPanel = new JPanel();
		//배경사진 설정
		JLabel bg = new JLabel(new ImageIcon("/Users/seosang-won/eclipse-workspace/oodp_baseball/src/baseball/img/baseball_background.jpg"));
		bg.setBounds(0, 0, 500, 578);

		bg.setLayout(null);
		
		//게임 시작 버튼 생성
		JButton startBt = new JButton("게임 시작");
		startBt.setSize(100, 40);
		startBt.setLocation(200, 300);
		//게임 종료 버튼 생성
		JButton	exitBt = new JButton("종료");
		exitBt.setSize(100, 40);
		exitBt.setLocation(200, 400);
		
		// 게임 이름 Label 
				JLabel lblBaseballManager_1 = new JLabel("Baseball Manager 2019");
				lblBaseballManager_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblBaseballManager_1.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
				bg.add(lblBaseballManager_1);
				lblBaseballManager_1.setBounds(129, 115, 248, 85);
		
		bg.add(startBt); // 게임시작  버튼 달기
		bg.add(exitBt);
		
		mainPanel.add(bg);
}
	
	
	
	public JComponent getGUI() {
		return mainPanel;
	}
	
	
	
	
	
}
