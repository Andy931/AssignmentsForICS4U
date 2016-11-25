import java.util.*;

public class TicTacToe {
	
	public static int userMove;
	public static int spaces = 9;
	
	public static void main(String[] args){
		char[] initialArray = new char[9];
		System.out.println("Enter a number to decide your move.");
		System.out.println("  _   _   _\n| 1 | 2 | 3 |\n  -   -   -\n| 4 | 5 | 6 |\n  -   -   -\n| 7 | 8 | 9 |");
		TicTacToeRec(initialArray);
	}
	
	public static void TicTacToeRec(char[] initialArray){
		
		char[] arrayOfXO = new char[9];
		
		if (spaces > 0){
			Scanner sc = new Scanner(System.in);
			userMove = sc.nextInt();
			sc.close();
		}
		
		spaces = spaces - 1;
		
		if (spaces > 0){
			TicTacToeRec(arrayOfXO);
		}
	}
	
	public static int UserInput(){
		if (spaces > 0){
			Scanner sc = new Scanner(System.in);
			userMove = sc.nextInt();
			sc.close();
			spaces = spaces - 1;
		}
		
		return userMove;
	}
}