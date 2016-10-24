/****************************************************************************
 *
 * Created by: Andy Liu
 * Created on: Oct 1, 2016
 * Created for: ICS4U
 * Assignment #2b
 * This program simulates "Rock, Paper, Scissors" game
 *
 ****************************************************************************/

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
	
	public static void main(String[] args){
		Random rnd = new Random();
		Scanner sc = new Scanner(System.in);
		
		int userChoice, computerChoice, beginOrEnd = 0;
		
		//Rock: 0; Paper: 1; Scissors: 2 Loop the game until the user choose to end
		do{
			System.out.println("Make a move (0 = Rock; 1 = Paper; 2 = Scissors): ");
			userChoice = sc.nextInt(); //User chooses
			computerChoice = rnd.nextInt(3); //Computer chooses randomly
			if(userChoice < 0 || userChoice > 2){
				System.out.println("Out of range, try again");
			}
			else{
				RockPaperScissors(userChoice, computerChoice); //Call the function
			}
			System.out.println("Play again? Start = 0, End = others");
			beginOrEnd = sc.nextInt(); //Ask the user to play again or end the game
		}while(beginOrEnd == 0);
		
		System.out.println("The game is ended.");
		sc.close();
		System.exit(0); //End the game
	}
	
	//The function to determine who is winning or losing
	public static void RockPaperScissors(int userSelection, int computerSelection){
		if(userSelection == computerSelection)
		{
			if(userSelection == 0)
			{
				System.out.println("Both players chose rock!");
			}
			else if (userSelection == 1)
			{
				System.out.println("Both players chose paper!");
			}
			else
			{
				System.out.println("Both players chose scissors!");
			}
		} //When both user's and computer's choices are the same
				
		if(userSelection == 0)//When the user chooses rock
		{
			if(computerSelection == 1)
			{
				System.out.println("You chose rock; Computer chose paper");
				System.out.println("Computer wins!");
			}
			else if (userSelection != computerSelection)
			{
				System.out.println("You chose rock; Computer chose scissors");
				System.out.println("You win!");
			}
		}
		else if(userSelection == 1)//When the user chooses paper
		{
			if(computerSelection == 0)
			{
				System.out.println("You chose paper; Computer chose rock");
				System.out.println("You win!");
			}
			else if (userSelection != computerSelection)
			{
				System.out.println("You chose paper; Computer chose scissors");
				System.out.println("Computer wins!");
			}
		}
		else if (userSelection != computerSelection) //When the user chooses scissors
		{
			if(computerSelection == 0)
			{
				System.out.println("You chose scissors; Computer chose rock");
				System.out.println("Computer wins!");
			}
			else
			{
				System.out.println("You chose scissors; Computer chose paper");
				System.out.println("You win!");
			}
		}
	}
}
