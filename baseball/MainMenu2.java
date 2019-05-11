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

public class MainMenu2 extends Menu implements ActionListener{
	
	private JPanel contentPane;
	
	JButton	normalGBt = new JButton("친선 경기");
	JButton	leagueGBt = new JButton("리그 경기");
	JButton arcadeGBt = new JButton("아케이드 모드");
	JButton	backBt = new JButton("뒤로가기");
	baseballGame game;
	
	public MainMenu2(JPanel panel, baseballGame g) {
		
		this.game =g;
		
		setBackground();
		decoratePanel();
		contentPane=panel;
	}
	
	@Override
	public void decoratePanel() {
		
		//친선 경기 버튼 생성
		normalGBt.setSize(100, 40);
		normalGBt.setLocation(200, 200);
		normalGBt.addActionListener(this);
		bg.add(normalGBt); 
		
		
		//친선 경기 버튼 생성
		leagueGBt.setSize(100, 40);
		leagueGBt.setLocation(200, 250);
		leagueGBt.addActionListener(this);
		bg.add(leagueGBt); 
		
		//친선 경기 버튼 생성
		arcadeGBt.setSize(100, 40);
		arcadeGBt.setLocation(200, 300);
		arcadeGBt.addActionListener(this);
		bg.add(arcadeGBt); 
		
		//친선 경기 버튼 생성
		backBt.setSize(100, 40);
		backBt.setLocation(200, 350);
		backBt.addActionListener(this);
		bg.add(backBt); 
		// 게임시작  버튼 달기
		add(bg);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//액션 리스너 재정의
				if (e.getSource().equals(this.normalGBt))
				{	
					game.gameStart();
					field fieldPanel = new field(game);
					contentPane.add(fieldPanel, "Field");
					CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	                cardLayout.show(contentPane, "Field");
				}
				else if(e.getSource().equals(this.leagueGBt))
				{
					JOptionPane.showMessageDialog(this, "리그 경기");
				}
				else if(e.getSource().equals(this.arcadeGBt))
				{
					JOptionPane.showMessageDialog(this, "아케이드 모드");
				}
				else if(e.getSource().equals(this.backBt))
				{
					CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	                cardLayout.show(contentPane, "Main1");
				}
	}

	
	
	
	
}
