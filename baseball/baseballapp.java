package baseball;

import java.applet.*;
import java.awt.*;
import java.util.*;
import java.text.*;  
import javax.swing.*;
import java.awt.event.*;

public class baseballapp extends JApplet implements Runnable{
	   SBOTable sbo;
	   ScoreTable sTable;
	   protected team t1;   //팀 1번 
	   protected team t2;   //팀 2번 
		
	   private team currentTeam = new team();    //현재 팀에 새로운 팀 할당.
	   private ArrayList<String> resultList;     //공을 던진 후의 결과를 모아놓은 리스트.
		
	   protected int inning;  //현재 이닝.

	   protected boolean isGameOver;  //게임 종료 여부.
	   protected int strike;  //스트라이크
	   protected int ball; // 볼.
	   protected int out; // 아웃
		
	   protected String msg1; //메시지를 담는 변수. 
	   protected int gameFlag; //0이 되면 체인지, 1이 되면 
	   private int[][] scoreBoard = new int[2][11];	//스코어보드
		
	   public void init() {  
		
	   }  
	  
	   public void start() {  
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
			    
//				System.out.println("hi");
//				try {
//					Thread.sleep(1500);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
	   }  
	  
	    
	   public void run() {
		   
	   }  
	  
	    
	  public void paint( Graphics g ) {  
		  
		  //Canvas Size
		  this.setSize(500, 500);
		  	 
		  	 
		  //�븘�뱶 �쟾泥� 洹몃━湲� 
		      Graphics2D outField = (Graphics2D)g.create();
		      Color groundColor = new Color(180, 104, 1);
				setForeground(groundColor);
				outField.fillArc(0,200,500,500,45,90);
				
			//�궡�빞 �븘�뱶
			
			  Graphics2D inField = (Graphics2D)g.create();
			  Rectangle base = new Rectangle();
			  base.setBounds(200,320,100,100);
			  inField.setColor(Color.green);
			  inField.rotate(Math.toRadians(45), base.x + base.width/2, base.y + base.height/2);
			  inField.draw(base);
			  inField.fill(base);
			  
			//Draw FirstBase
				
			  Graphics2D fB = (Graphics2D)g.create();
			  Rectangle rec = new Rectangle();
			  rec.setBounds(245,305,10,10);
			  fB.setColor(Color.white);
			  fB.rotate(Math.toRadians(45), rec.x + rec.width/2, rec.y + rec.height/2);
			  fB.draw(rec);
			  fB.fill(rec);
			  
			//Draw SecondBase
				
			  Graphics2D sB = (Graphics2D)g.create();
			  Rectangle rec2 = new Rectangle();
			  rec2.setBounds(305,365,10,10);
			  sB.setColor(Color.white);
			  sB.rotate(Math.toRadians(45), rec2.x + rec2.width/2, rec2.y + rec2.height/2);
			  sB.draw(rec2);
			  sB.fill(rec2);
			  
			  
			//Draw ThirdBase
				
			  Graphics2D tB = (Graphics2D)g.create();
			  Rectangle rec3 = new Rectangle();
			  rec3.setBounds(185,365,10,10);
			  tB.setColor(Color.white);
			  tB.rotate(Math.toRadians(45), rec3.x + rec3.width/2, rec3.y + rec3.height/2);
			  tB.draw(rec3);
			  tB.fill(rec3);
			  SBOTable sbo=new SBOTable(g,300,400,150,80);
			  sbo.strike();
			  sbo.strike();
			  sbo.strike();
	   }
	  
	  class ScoreTable extends JPanel {
		    public ScoreTable() {
		        Object[][] cellData = {
		            {"row1-col1", "row1-col2"},
		            {"row2-col1", "row2-col2"}};
		        String[] columnNames = {"col1", "col2"};
		        add(  new JTable(cellData, columnNames) ) ;
		    }
		}
	  class SBOTable extends JPanel{
		  private Graphics SBOTable;
		  private Counter strike1;
		  private Counter strike2;
		  private Counter ball1;
		  private Counter ball2;
		  private Counter ball3;
		  private Counter out1;
		  private Counter out2;
		  
		  public SBOTable(Graphics g,int x,int y,int width,int height) {
			  SBOTable=(Graphics2D)g.create();
			  SBOTable.setColor(Color.gray);
			  SBOTable.fillRect(x, y, width, height);
			  strike1=new Counter(g,310,410);
			  strike2=new Counter(g,330, 410);
			  ball1=new Counter(g,310, 430);
			  ball2=new Counter(g,330, 430);
			  ball3=new Counter(g,350, 430);
			  out1=new Counter(g,310, 450);
			  out2=new Counter(g,330, 450);
		  }
		  void strike() {
			  if(strike1.getColor()==Color.green&&strike2.getColor()==Color.green) {
				  strike1.setWhite();
				  strike2.setWhite();
			  }	  
			  else if(strike1.getColor()==Color.green)
				  strike2.setGreen();
			  else
				  strike1.setGreen();
		  }
		  void out() {
			  if(out1.getColor()==Color.red&&out2.getColor()==Color.red){
				  out1.setWhite();
				  out2.setWhite();
			  }
			  else if(out1.getColor()==Color.red)
				  out2.setRed();
			  else
				  out1.setRed();
		  }
		  void ball() {
			  if(ball1.getColor()==Color.YELLOW&&ball2.getColor()==Color.YELLOW&&ball3.getColor()==Color.YELLOW) {
				  ball1.setWhite();
				  ball2.setWhite();
				  ball3.setWhite();
			  }
			  else if(ball1.getColor()==Color.YELLOW&&ball2.getColor()==Color.YELLOW)
				  ball3.setYellow();
			  else if(ball1.getColor()==Color.YELLOW)
				  ball2.setYellow();
			  else
				  ball1.setYellow();
		  }
		  
		 
	  }
	  class Counter extends JPanel{
		  private Graphics2D count;
		  private int x;
		  private int y;
		  public Counter(Graphics g,int x,int y) {
			  this.x=x;
			  this.y=y;
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
	  
	  public baseballapp(){
			this.isGameOver = false;
			this.strike = 0;
			this.ball = 0;
			this.out = 0;
		}
		//게임이 시작됬을 때의 함수
		public void gameStart() {
			resultList = new ArrayList<String>(36);
			setList();
			this.t1 = new team("HGU");
			this.t2 = new team("COM");
			
			this.currentTeam = t1;

			while(true) {
				if(gameFlag == 0) {
					this.plusInning();	//Inning 증

					if(this.isGameOver())
						break;

					msg1 = currentTeam.playerList.get(0).getTeam()+"팀의 " + this.getInning() + "공격입니다.";
					//FileIO.getInputString();
					printGameScreen();
					}
			
			 
			if(gameFlag == 0 || gameFlag == 1) { //gameFlag가 1이라면, 공수교대.

				this.msg1 = currentTeam.getBatter() + "번 타자 "+currentTeam.playerList.get(currentTeam.getBatter()-1).getName()+" 타석에 들어섭니다.";
				currentTeam.playerList.get(currentTeam.getBatter()-1).setLocation(0);	
				currentTeam.inningRun=0;		
				printGameScreen();
				}
			
			
			msg1 = "�� "+currentTeam.playerList.get(currentTeam.getBatter()-1).getCount() + "�� �����ϴ�!";
			currentTeam.playerList.get(currentTeam.getBatter()-1).count++;//������++;

						
			//경우의 수 리스트를 불러온다.
			String result = this.getResultList();
			
			msg1 = result;
			printGameScreen();

				if(result.equals("스트라이크")){
					strike++;
					
					//2 스트라이크 였으면, 
					if(strike == 3)
					{						
						currentTeam.playerList.get(currentTeam.getBatter()-1).setLocation(-1); //타자를 베이스 밖으로.
						currentTeam.playerList.get(currentTeam.getBatter()-1).so++;//삼진아웃.;
						currentTeam.nextBatter();//타자는 다음 타자로 교체.
						out++; //아웃카운트 증가.
						gameFlag = 1;
						msg1 = "삼진 아웃!";
						if(out == 3)
						{
							gameFlag = 0;
							msg1 = "삼진 아웃! 공수가 교체됩니다.";
						}
						clearCount();//아웃카운트를 초기화.					
					}
					else	//계속 진행.
					{						
						gameFlag = 2;
					}
				}

				else if(result.equals("볼")) {//볼 
					ball++;
					if(ball == 4) {//볼이 3개 였다면.				
							currentTeam.playerList.get(currentTeam.getBatter()-1).bb++;//4볼
							clearCount();//카운트 초기화.
							int run = this.runBase(currentTeam.playerList, 1); //���� ����
							currentTeam.playerList.get(currentTeam.getBatter()-1).rbi += run;	//득점 증가.
							currentTeam.nextBatter();
							gameFlag = 1;
							msg1 = "볼넷!";
					}
					else {				
						gameFlag = 2;
					}
				}
				
				else if(result.equals("1루타"))	{//1루타
			
					currentTeam.playerList.get(currentTeam.getBatter()-1).singleH++;
					clearCount();
					int run = this.runBase(currentTeam.playerList, 1); //전체 베이스 개씩 진루.
					currentTeam.playerList.get(currentTeam.getBatter()-1).rbi += run;	//현재 타자의 타점 누적.
					currentTeam.nextBatter();//다음 타자
					gameFlag = 1;
				}
				else if(result.equals("2루타"))	{//2루타
		
					currentTeam.playerList.get(currentTeam.getBatter()-1).doubleH++;
					clearCount();
					int run = this.runBase(currentTeam.playerList, 2); //전체 베이스 한개씩 진루.
					currentTeam.playerList.get(currentTeam.getBatter()-1).rbi += run;	//현재 타자의 타점 누적.
					currentTeam.nextBatter();//다음 타자
					gameFlag = 1;
				}
				else if(result.equals("3루타"))	{//3루타
				
					currentTeam.playerList.get(currentTeam.getBatter()-1).tripleH++;
					clearCount();
					int run = this.runBase(currentTeam.playerList, 3); //전체 베이스 개씩 진루.
					currentTeam.playerList.get(currentTeam.getBatter()-1).rbi += run;	//현재 타자의 타점 누적.
					currentTeam.nextBatter();//다음 타자	
					gameFlag = 1;
				}						

				else if(result.equals("홈런"))	{//홈런
			
					currentTeam.playerList.get(currentTeam.getBatter()-1).homerun++;
					clearCount();
					int run = this.runBase(currentTeam.playerList, 4); //전체 베이스 개씩 진루.
					currentTeam.playerList.get(currentTeam.getBatter()-1).rbi += run;	//현재 타자의 타점 누적.
					currentTeam.nextBatter();//다음 타자	
					gameFlag = 1;
				}
				else if(result.equals("파울")){
					gameFlag = 2;
			
					//만약 2스트라이크 전이라면.
					if(strike != 2)
						strike++;	
				}
				else if(result.equals("아웃")) {
					out++;
					if(out == 3)
					{
						currentTeam.playerList.get(currentTeam.getBatter()-1).setLocation(-1); //아웃.
						currentTeam.nextBatter();
						clearCount();
						gameFlag = 0;
					}
					else
					{
						currentTeam.playerList.get(currentTeam.getBatter()-1).setLocation(-1); 
						currentTeam.nextBatter();
						clearCount();
						gameFlag = 1;
					}
				}
				
				int	i = currentTeam.team.equals("HGU") ? 0 : 1;
				int j = Integer.parseInt(this.getInning().substring(0,1))-1;
				scoreBoard[i][j] = currentTeam.getInningRun();
				
				if(gameFlag == 0) {
					currentTeam.resetInningData();
					currentTeam = (currentTeam.team.equals("HGU") ? t2 : t1);
				}
				
				
			}
		}
		
		public boolean isGameOver()
		{
			boolean result = false;
			if(this.getInning().equals("3회말"))
			{
				if(t1.getRun() < t2.getRun()) {
					result = true;
					printGameOverScreen();
				}
			}
			else if(this.getInning().equals("4회초")){
					result = true;
					printGameOverScreen();
			}
			return result;
		}	
		public void exitProgram() {

			printExitScreen();

		}//end exitProgram()
		//Game Print
		
		public void printMenuScreen() {
			System.out.println("==============================");
			System.out.println("|     1. 친선 경기              |");
			System.out.println("|     2. 종료                  |");
			System.out.println("==============================");
		}

		
		public void clearCount(){
			if(out == 3) //
				out = 0;

			ball = 0;
			strike = 0;
		}
		
		public void printGameScreen() { 
			System.out.printf("==============================================================\n");
			System.out.printf(" 이닝  |  1 |  2 |  3 |  4 |  5 |  6 |  7 |  8 |  9 |  R |  H |\n");
			System.out.printf("==============================================================\n");
			System.out.printf(" HGU  |%3d |%3d |%3d |  0 |  0 |  0 |  0 |  0 |  0 |%3d |%3d |\n",scoreBoard[0][0],scoreBoard[0][1],scoreBoard[0][2],scoreBoard[0][0]+scoreBoard[0][1]+scoreBoard[0][2],t1.getHits());
			System.out.printf("==============================================================\n");
			System.out.printf(" COM  |%3d |%3d |%3d |  0 |  0 |  0 |  0 |  0 |  0 |%3d |%3d |\n",scoreBoard[1][0],scoreBoard[1][1],scoreBoard[1][2],scoreBoard[1][0]+scoreBoard[1][1]+scoreBoard[1][2],t2.getHits());
			System.out.printf("   => %s         \r",msg1);
		}//end printGameScreen()
		
		
//		//Referee
//		public void hit1(){
//			
//		}
//		public void hit2(){
//			
//		}
//		public void hit3(){
//			
//		}
//		public void homerun(){
//			
//		}
//		public void fourBall() {}
//		public void foul(){
//			if(this.strike<2) this.strike++;
//			
//			System.out.println("파울!");
//		}
	//	
//		public void out(){
//			if(this.out==2) {
//				change();
//				this.out=0;
//			}
//			else {
//				this.out++;
//				System.out.println("아웃!");
//			}
//		}
	//	
//		public void strike() {
//			if(this.strike==2) {
//				out();
//				this.strike=0;
//			}else {
//				this.strike++;
//				System.out.println("스트라이크!");
//			}
//		}
	//	
//		public void ball() {
//			if(this.ball==3) {
//				fourBall();
//				this.ball=0;
//			}else {
//				this.ball++;
//				System.out.println("볼!");
//			}
//		}
	//	
//		public void change() {
//			if(this.isTop) {
//				isTop=!isTop;
//				System.out.println("공수 체인지! "+inning+"회 "+(isTop?"초":"말")+"입니다.");
//			}
//			else {
//				if(this.inning==9) {
//					isGameOver=true;
//				}else {
//					this.inning++;
//					isTop=!isTop;
//					System.out.println("이닝 체인지! "+inning+"회 초 입니다.");
//				}
//			}
//		}
		
		public void plusInning() {
			this.inning++;
		}
		public void setInning(int inning) {
			this.inning = inning;
		}
		
		
		public void printGameOverScreen() {
			System.out.println("게임이 종료되었습니다.");
			System.out.println("점수는 다음과 같습니다.");
			System.out.printf("HGU : %d\n" ,scoreBoard[0][0]+scoreBoard[0][1]+scoreBoard[0][2]);
			System.out.printf("COM : %d\n" ,scoreBoard[1][0]+scoreBoard[1][1]+scoreBoard[1][2]);
		}
		
		public void printExitScreen() {
			System.out.println("게임을 종료니다.");
		}
		
		/*
		 * 구성 : 총 36개의 경우의 수로 이루어져 있다.
		 * 
		 * 각 경우의 수의 확률은  다음과 같다.
		 * 
		 *  x/36으로 계산 하면된다. 
		 * 홈런 : 1 
		 * 3루타 : 1
		 * 2루타 : 3
		 * 안타 : 4
		 * 스트라이트 : 5
		 * 파울 : 5
		 * 볼 : 7
		 * 아웃 : 10
		 * */
		
		public void setList() {

			this.resultList.add("3루타");			
			this.resultList.add("홈런");				

			for(int i=0; i< 3; i++) { this.resultList.add("2루타"); } 

			for(int i=0; i< 5; i++) {			
				this.resultList.add("스트라이크");
				this.resultList.add("파울");		
			}

			for(int i=0; i< 4; i++) { this.resultList.add("1루타"); } 

			for(int i=0; i< 7; i++) { this.resultList.add("볼"); } 

			for(int i=0; i< 10; i++) { this.resultList.add("아웃"); } 
		}//end setList


		// ��� ���ڿ� ��ȯ
		public String getResultList() {
			Random rnd = new Random();
			return this.resultList.get(rnd.nextInt(34));
		}//end getResultList()
		
		
		public int runBase(ArrayList<player> currentList, int baseCount){
			int count=0;	
			for(int i = 0; i < baseCount; i++)
			{
				for(int j = 0; j < currentList.size(); j++)
				{
					if(currentList.get(j).getLocation() != -1)
					{
						currentList.get(j).plusLocation();
					}
					if(currentList.get(j).getLocation() == 4)  //타자가 한 바퀴를 돌았다면.
					{
						currentList.get(j).run++;		
						currentList.get(j).inningRun++;	
						count++;
						currentList.get(j).setLocation(-1);	
					}
				}
			}
			return count;
		}
		
		public String getInning() {
			String result="";
			switch(this.inning) {
				case 1:
					result = "1회초";
					break;
				case 2:
					result = "1회말";
					break;
				case 3:
					result = "2회초";
					break;
				case 4:
					result = "2회말";
					break;
				case 5:
					result = "3회초";
					break;			
				case 6:
					result = "3회말";
					break;
				case 7:
					result = "4회초";
					break;
					default:
			}//end switch

			return result;
			
		}//end getInning()

	  
	
}
