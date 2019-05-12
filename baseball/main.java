package baseball;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		baseballGame game = new baseballGame();
		GameWindow gw = new GameWindow(game);
		
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
		    
//			System.out.println("hi");
//			try {
//				Thread.sleep(1500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}

}
