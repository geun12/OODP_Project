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

public class GameWindow extends JFrame {
	
	
	JPanel contentPane = new JPanel();
	
	MainMenu mainPanel;
	MainMenu2 mainPanel2 ;
	
	
	
	public GameWindow(baseballGame game) {
		
		mainPanel= new MainMenu(contentPane);
		mainPanel2 = new MainMenu2(contentPane, game);
		
		contentPane.setLayout(new CardLayout());
		contentPane.add(mainPanel, "Main1");
		contentPane.add(mainPanel2, "Main2");
		
	
		setTitle("Baseball game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(500, 600); // 프레임 크기 500X600 설정
		setPreferredSize(new Dimension(500,600));
		getContentPane().add(contentPane);
		
		pack();
		
		setVisible(true); // 화면에 프레임 출력
	}
	


}
