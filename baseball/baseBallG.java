package baseball;

import java.applet.*;
import java.awt.*;
import java.util.*;
import java.text.*;  
import javax.swing.*;

import baseball.baseballapp.Counter;

public class baseBallG extends JFrame{
	   CirclePanel strike1;
	   CirclePanel strike2;
	   CirclePanel ball1;
	   CirclePanel ball2;
	   CirclePanel ball3;
	   CirclePanel out1;
	   CirclePanel out2;
	   JPanel sbo=new JPanel();    
	   Object[] sboList=new Object[11];
	   public baseBallG() {
		   this(Color.white);
	   }
	   
	   public baseBallG(Color c) {
		   
		   super("ContentPane Example");
		   
		   strike1=new CirclePanel(5,80,10,c);
		   strike2=new CirclePanel(5,80,10,c);
		   ball1=new CirclePanel(5,80,10,c);
		   ball2=new CirclePanel(5,80,10,c);
		   ball3=new CirclePanel(5,80,10,c);
		   out1=new CirclePanel(5,80,10,c);
		   out2=new CirclePanel(5,80,10,c);
		   
		   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   setTitle("SBOExample");
		   setSize(600,600);

		   sbo.setLayout(new GridLayout(3,4));
		   sboList[0]=new JLabel("S");
		   sboList[1]=strike1;
		   sboList[2]=strike2;
		   sboList[3]=new JLabel(" ");
		   sboList[4]=new JLabel("B");
		   sboList[5]=ball1;
		   sboList[6]=ball2;
		   sboList[7]=ball3;
		   sboList[8]=new JLabel("O");
		   sboList[9]=out1;
		   sboList[10]=out2;		   
		   
		   for(int i=0;i<11;i++) {
			   if(i==0||i==3||i==4||i==8)
				   sbo.add((JLabel)sboList[i]);
			   else
				   sbo.add((CirclePanel)sboList[i]);
		   }
		   add(sbo,BorderLayout.CENTER);
		  
		   //Todo initialize Jpanel as gridpanel(3,2) and fills it with CirclePanel 
	  
		  setVisible(true);		  
		  }
	   
	   public CirclePanel getStrike1() {
		return strike1;
	}

	public void setStrike1(CirclePanel strike1) {
		this.strike1 = strike1;
	}

	public CirclePanel getStrike2() {
		return strike2;
	}

	public void setStrike2(CirclePanel strike2) {
		this.strike2 = strike2;
	}

	public CirclePanel getBall1() {
		return ball1;
	}

	public void setBall1(CirclePanel ball1) {
		this.ball1 = ball1;
	}

	public CirclePanel getBall2() {
		return ball2;
	}

	public void setBall2(CirclePanel ball2) {
		this.ball2 = ball2;
	}

	public CirclePanel getBall3() {
		return ball3;
	}

	public void setBall3(CirclePanel ball3) {
		this.ball3 = ball3;
	}

	public CirclePanel getOut1() {
		return out1;
	}

	public void setOut1(CirclePanel out1) {
		this.out1 = out1;
	}

	public CirclePanel getOut2() {
		return out2;
	}

	public void setOut2(CirclePanel out2) {
		this.out2 = out2;
	}

	public void redraw () {

		CStrike(Color.red);
		repaint();
		revalidate();
	    
	   }
	   public void CStrike(Color c) {
		   setStrike1(new CirclePanel(5,80,10,c));
		   revalidate();
	       repaint();
	   }
	   
	   
	   
	   
	   
	   
	   public static void main(String[] args) {
			  baseBallG frame=new baseBallG();
			  //somcondition occured

			  frame.CStrike(Color.red);
			  frame.redraw();
				  //change one of S circle as red
				baseballGame game = new baseballGame();
				
				while(true) {
					
					game.printMenuScreen();
					
					Scanner scan = new Scanner(System.in);  // Create a Scanner object
					
					int cmd = scan.nextInt();
					
					switch(cmd){
					case 1: 
						game.gameStart();
						break;
					case 2:
						game.exitProgram();
						break;
						default:
							System.out.println("Wrong command!");
						break;
					}
					
					break;
				    
//					System.out.println("hi");
//					try {
//						Thread.sleep(1500);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				}
		   }
	   
	   
	   
	   
	   
	   
	   class CirclePanel extends JPanel {
		    int centerX, centerY, radius;
		    Color circle_color=Color.red;
		    public CirclePanel(int centerX, int centerY, int radius, Color c) {
		    	this.centerX = centerX;
		        this.centerY = centerY;
		        this.radius = radius;
		        this.circle_color = c;
		        revalidate();
		        repaint();
		    }
		    public void setCircle(int centerX, int centerY, int radius, Color c) {
		        this.centerX = centerX;
		        this.centerY = centerY;
		        this.radius = radius;
		        this.circle_color = c;
		        revalidate();
		        repaint();
		    }


		    protected void paintComponent(Graphics g) {
		        System.out.println("Trying to draw circle");
		        super.paintComponent(g);
		        g.setColor(this.circle_color);
		        g.fillOval(centerX, centerY, radius*2, radius*2);
		    }
		}
	  
	 
	 /* class SBOTable extends JPanel{
		  private JPanel SBOPanel;
		  private JLabel strike,ball,out;
		  private Graphics strike1;
		  private Graphics strike2;
		  private Graphics ball1;
		  private Graphics ball2;
		  private Graphics ball3;
		  private Graphics out1;
		  private Graphics out2;
		  public SBOTable() {
			  SBOPanel=new JPanel();
			  SBOPanel.setLayout(new GridLayout(1,3));
//			  SBOPanel.setLayout(new GridLayout(3,4));
			  this.strike=new JLabel("S");
			  this.ball=new JLabel("B");
			  this.out=new JLabel("O");
//			  strike1=(Graphics2D)g.create();
//			  strike2=(Graphics2D)g.create();
//			  ball1=(Graphics2D)g.create();
//			  ball2=(Graphics2D)g.create();
//			  ball3=(Graphics2D)g.create();
//			  out1=(Graphics2D)g.create();
//			  out2=(Graphics2D)g.create();
			  SBOPanel.add(strike);
			  
			  //SBOPanel.add(strike2);
			  SBOPanel.add(ball);
//			  SBOPanel.add(ball1);
//			  SBOPanel.add(ball2);
//			  SBOPanel.add(ball3);
			  SBOPanel.add(out);
//			  SBOPanel.add(out1);
//			  SBOPanel.add(out2);
//			  
		  }
//		  void strike() {
//			  if(strike1.getColor()==Color.green&&strike2.getColor()==Color.green) {
//				  strike1.setWhite();
//				  strike2.setWhite();
//			  }	  
//			  else if(strike1.getColor()==Color.green)
//				  strike2.setGreen();
//			  else
//				  strike1.setGreen();
//		  }
//		  void out() {
//			  if(out1.getColor()==Color.red&&out2.getColor()==Color.red){
//				  out1.setWhite();
//				  out2.setWhite();
//			  }
//			  else if(out1.getColor()==Color.red)
//				  out2.setRed();
//			  else
//				  out1.setRed();
//		  }
//		  void ball() {
//			  if(ball1.getColor()==Color.YELLOW&&ball2.getColor()==Color.YELLOW&&ball3.getColor()==Color.YELLOW) {
//				  ball1.setWhite();
//				  ball2.setWhite();
//				  ball3.setWhite();
//			  }
//			  else if(ball1.getColor()==Color.YELLOW&&ball2.getColor()==Color.YELLOW)
//				  ball3.setYellow();
//			  else if(ball1.getColor()==Color.YELLOW)
//				  ball2.setYellow();
//			  else
//				  ball1.setYellow();
//		  }
		  
		 
	  }
	  class Counter extends JPanel{
		  private Graphics count;
		  private int x;
		  private int y;
		  public Counter(Graphics g) {
			  count=(Graphics2D)g.create();
			  count.setColor(Color.white);
			  count.fillArc(x, y, 10, 10, 0, 360);
		  }
		  void setCounter(int x,int y){
			  count.fillArc(x, y, 10, 10, 0, 360);
		  }
		  void setGreen() {
			  count.setColor(Color.green);
			  count.fillArc(this.x, this.y, 10, 10, 0, 360);
		  }
		  void setYellow() {
			  count.setColor(Color.YELLOW);
			  count.fillArc(this.x, this.y, 10, 10, 0, 360);
		  }
		  void setRed() {
			  count.setColor(Color.red);
			  count.fillArc(this.x, this.y, 10, 10, 0, 360);
		  }
		  void setWhite() {
			  count.setColor(Color.white);
			  count.fillArc(this.x, this.y, 10, 10, 0, 360);
		  }
		  Color getColor() {
			  return count.getColor();
		  }
		 
		 
	  }
	  */
	
}


