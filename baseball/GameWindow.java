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
	
	
	public GameWindow() {
		
		MainMenu mainPanel = new MainMenu();
		
		setTitle("Baseball game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 600); // 프레임 크기 500X600 설정
		
		add(mainPanel.getGUI());
		
		pack();
		
		setVisible(true); // 화면에 프레임 출력
	}

}
