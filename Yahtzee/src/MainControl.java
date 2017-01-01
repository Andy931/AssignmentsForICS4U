/****************************************************************************
 *
 * Created by: Andy Liu
 * Created on: Nov 24, 2016
 * Created for: ICS4U
 * Assignment #6b
 * This main program to run Yahtzee Game
 *
 ****************************************************************************/

import java.util.*;

public class MainControl {
	//Arrays for keeping dice and scores
	public static boolean[] keepDice = new boolean[6];
	public static boolean[] keepScore = new boolean[14];
	
	public static void main (String[] arg){
		
		System.out.println("YAHTZEE\n");
		Scanner sc = new Scanner(System.in);
		
		//Variables and Constants
		int chosenScore;
		String yesOrNo;
		String rollDice;
		int rollTime = 1;
		
		//Keeping dice and score loop
		for (int i=1; i<=5; i++){
			keepDice[i] = false;
		}
		for (int i=1; i<=13; i++){
			keepScore[i] = false;
		}
		
		//New and run a game
		YahtzeeGame game = new YahtzeeGame();
		do{
			rollDice = "";
			do {
				System.out.println("This is roll " + rollTime + ". Roll dice?(Y/N)");
				rollDice = sc.nextLine();
				if (rollDice.equals("Y") || rollDice.equals("y")){
					break;
				}
				if (rollDice.equals("N") || rollDice.equals("n")){
					break;
				}
			} while ( true );
			
			if (rollDice.equals("Y") || rollDice.equals("y")){
				game.DiceRefresh(rollTime);
			}
			else{
				break;
			}
			game.UpperSection();
			game.Sum();
			game.FullHouse();
			game.Straights();
			game.Yahtzee();
			game.LowerSectionSum();
			game.GrandTotal();
			
			//Force the player to choose a score to keep
			if (rollTime >= 3){
				System.out.println("You have to choose a score to keep.");
			}
			System.out.println("Which score do you want to keep? (1-13), 0 for next roll.");
			chosenScore = sc.nextInt();
			
			//When the score has been filled
			if (keepScore[chosenScore] == true){
				System.out.println("This one has been filled. \nWhice score do you want to keep? (1-13), 0 for next roll.");
				chosenScore = sc.nextInt();
			}
			if (chosenScore != 0){
				keepScore[chosenScore] = true;
				rollTime = 1;
			}
			else{
				rollTime++;
				yesOrNo = sc.nextLine();
				System.out.println("Which dices do you want to keep?");
				for (int i = 1; i < 6; i++){
					System.out.println("Keep dice " + i + "? (Y/N)");
					yesOrNo = sc.nextLine();
					if (yesOrNo.equals("Y")||yesOrNo.equals("y")){
						keepDice[i] = true;
					}
					else{
						keepDice[i] = false;
					}
				} //Let player keep dice
			}
			
			
			int scoreCounter = 0;
			for (int i = 1; i <= 13; i++){
				if (keepScore[i] == false){
					scoreCounter++;
				}
			}
			if (scoreCounter == 0){
				game.UpperSection();
				game.Sum();
				game.FullHouse();
				game.Straights();
				game.Yahtzee();
				game.LowerSectionSum();
				game.GrandTotal();
				break;
			}
		} while (rollTime < 4); //Count how many times the dice are rolled
		
		System.out.println("   *****   Game Over   *****");		
	}
}