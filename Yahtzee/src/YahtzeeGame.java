/****************************************************************************
 *
 * Created by: Andy Liu
 * Created on: Nov 24, 2016
 * Created for: ICS4U
 * Assignment #6b
 * This program is a class for Yahtzee Game
 *
 ****************************************************************************/
import java.util.*;
import java.util.stream.IntStream;

public class YahtzeeGame {
	private int[] _arrayOfDice = new int[5];
	private int[] _diceBackup = new int[5];
	private int[] _scorePad = new int[18];
	
	private int Ones = 0;
	private int Twos = 0;
	private int Threes = 0;
	private int Fours = 0;
	private int Fives = 0;
	private int Sixes = 0;
	
	//Methods
	//Roll dice
	protected void RollDice(){
		Random random = new Random();
		for (int counter = 0; counter <= _arrayOfDice.length - 1; counter++){
			int number = random.nextInt((6 - 1) + 1) + 1;
			_arrayOfDice[counter]=number;
		}
		
	} 
	
	protected void DiceRefresh(int rollTimes){
		_diceBackup = _arrayOfDice.clone();
		if (rollTimes == 1){
			RollDice();
		}
		else{
			RollDice();
			for (int i=0; i<5; i++){
				if (MainControl.keepDice[i+1] == true){
					_arrayOfDice[i] = _diceBackup[i];
				}
			}
		}
		System.out.println(Arrays.toString(_arrayOfDice));
		
		Ones = 0;
		Twos = 0;
		Threes = 0;
		Fours = 0;
		Fives = 0;
		Sixes = 0;
		
		for (int i = 0; i<_arrayOfDice.length; i++){
			switch (_arrayOfDice[i]){
			case 1: Ones++;
					break;
			case 2: Twos++;
					break;
			case 3: Threes++;
					break;
			case 4: Fours++;
					break;
			case 5: Fives++;
					break;
			case 6: Sixes++;
			}
		}
	}
	
	//Sum
	protected void Sum(){
		int sum = 0;
		
		sum = Ones*1 + Twos *2 + Threes*3 + Fours*4 + Fives*5 + Sixes*6;
		
		//3 of a Kind
		if (!MainControl.keepScore[7]){
			if (Ones >= 3){
				_scorePad[7] = sum;
			}
			else if (Twos >= 3){
				_scorePad[7] = sum;
			}
			else if(Threes >= 3){
				_scorePad[7] = sum;
			}
			else if (Fours >= 3){
				_scorePad[7] = sum;
			}
			else if (Fives >= 3){
				_scorePad[7] = sum;
			}
			else if (Sixes >= 3){
				_scorePad[7] = sum;
			}
		}
		
		//4 of a Kind
		if (!MainControl.keepScore[8]){
			if (Ones >= 4){
				_scorePad[8] = sum;
			}
			else if (Twos >= 4){
				_scorePad[8] = sum;
			}
			else if(Threes >= 4){
				_scorePad[8] = sum;
			}
			else if (Fours >= 4){
				_scorePad[8] = sum;
			}
			else if (Fives >= 4){
				_scorePad[8] = sum;
			}
			else if (Sixes >= 4){
				_scorePad[8] = sum;
			}
		}
		
		//Chance
		if (! MainControl.keepScore[9]){
			_scorePad[9] = sum;
		}
		
		//Print
		if (MainControl.keepScore[7]){
			System.out.println("     7 == 3 of a Kind: " + _scorePad[7]);
		}
		else{
			System.out.println(" 7 -> 3 of a Kind: " + _scorePad[7]);
		}
		if (MainControl.keepScore[8]){
			System.out.println("     8 == 4 of a Kind: " + _scorePad[8]);
		}
		else{
			System.out.println(" 8 -> 4 of a Kind: " + _scorePad[8]);
		}	
		if (MainControl.keepScore[9]){
			System.out.println("     9 == Chance: " + _scorePad[9]);
		}
		else{
			System.out.println(" 9 -> Chance: " + _scorePad[9]);
		}
	}
	
	//Full House
	protected void FullHouse(){
		if (! MainControl.keepScore[10]){
			if ((Ones == 3 || Twos == 3 || Threes == 3 || Fours == 3 || Fives == 3 || Sixes == 3)&&(Ones == 2 || Twos == 2 || Threes == 2 || Fours == 2 || Fives == 2 || Sixes == 2)){
				_scorePad[10] = 25;
			}
		}
		if (MainControl.keepScore[10])
			System.out.println("    10 == Full House: " + _scorePad[10]);
		else
			System.out.println("10 -> Full House: " + _scorePad[10]);
	}
	
	//Straights
	protected void Straights(){
		
		if (! MainControl.keepScore[11]){
			if ((Ones >= 1 && Twos >= 1 && Threes >= 1 && Fours >= 1)||(Twos >= 1 && Threes >= 1 && Fours >= 1 && Fives >= 1)||(Threes >= 1 && Fours >= 1 && Fives >= 1 && Sixes >= 1)){
				_scorePad[11] = 30;
			}
		}
		
		if (!MainControl.keepScore[12]){
			if ((Ones == 1 && Twos == 1 && Threes == 1 && Fours == 1 && Fives == 1)||(Twos == 1 && Threes == 1 && Fours == 1 && Fives == 1 && Sixes == 1)){
				_scorePad[12] = 40;
			}
		}
		
		if (MainControl.keepScore[11])
			System.out.println("    11 == Small Straight: " + _scorePad[11]);
		else
			System.out.println("11 -> Small Straight: " + _scorePad[11]);
		
		if (MainControl.keepScore[12])
			System.out.println("    12 == Large Straight: " + _scorePad[12]);
		else
			System.out.println("12 -> Large Straight: " + _scorePad[12]);
	}
	
	//YAHTZEE & YAHTZEE Bonus
	protected void Yahtzee(){
		
		if (Ones == 5 || Twos == 5 || Threes == 5 || Fours == 5 || Fives == 5 || Sixes == 5){
			if (MainControl.keepScore[13])
				_scorePad[14] = _scorePad[14]+ 100;
			else{
				MainControl.keepScore[13] = true;
				_scorePad[13] = 50;
				
			}
		}
		
		if (MainControl.keepScore[13])
			System.out.println("    13 == YAHTZEE: " + _scorePad[13]);
		else 
			System.out.println("13 -> YAHTZEE: " + _scorePad[13]);
		
		System.out.println("\nYAHTZEE Bonus: " + _scorePad[14]);
	}
	
	//Lower Section Sum
	protected void LowerSectionSum(){
		int lowerSectionSum = 0;
		for (int position = 0; position <= 7; position++){
			lowerSectionSum = lowerSectionSum + _scorePad[position];
		}
		System.out.println("--- Lower Section Sum: " + lowerSectionSum);
	}
	
	//UpperSection & Bonus
	protected void UpperSection(){
		int upperSectionSum = 0;
		
		if (!MainControl.keepScore[1]) _scorePad[1] = Ones * 1;
		if (!MainControl.keepScore[2]) _scorePad[2] = Twos * 2;
		if (!MainControl.keepScore[3]) _scorePad[3] = Threes * 3;
		if (!MainControl.keepScore[4]) _scorePad[4] = Fours * 4;
		if (!MainControl.keepScore[5]) _scorePad[5] = Fives * 5;
		if (!MainControl.keepScore[6]) _scorePad[6] = Sixes * 6;
		
		if (MainControl.keepScore[1])
			System.out.println("     1 == Aces: " + _scorePad[1]);
		else 
			System.out.println(" 1 -> Aces: " + _scorePad[1]);
		
		if (MainControl.keepScore[2])
			System.out.println("     2 == Twos: " + _scorePad[2]);
		else 
			System.out.println(" 2 -> Twos: " + _scorePad[2]);
		
		if (MainControl.keepScore[3])
			System.out.println("     3 == Threes: " + _scorePad[3]);
		else 
			System.out.println(" 3 -> Threes: " + _scorePad[3]);
		
		if (MainControl.keepScore[4])
			System.out.println("     4 == Fours: " + _scorePad[4]);
		else 
			System.out.println(" 4 -> Fours: " + _scorePad[4]);
		
		if (MainControl.keepScore[5])
			System.out.println("     5 == Fives: " + _scorePad[5]);
		else 
			System.out.println(" 5 -> Fives: " + _scorePad[5]);
		
		if (MainControl.keepScore[6])
			System.out.println("     6 == Sixes: " + _scorePad[6]);
		else 
			System.out.println(" 6 -> Sixes: " + _scorePad[6]);
		
		for (int position = 1; position <= 6; position++){
			upperSectionSum = upperSectionSum + _scorePad[position];
		}
		
		System.out.println("--- Upper Section Sum: " + upperSectionSum);
		
		if (_scorePad[1] + _scorePad[2] + _scorePad[3] + _scorePad[4] + _scorePad[5] + _scorePad[6] > 63){
			_scorePad[15] = 35;
			System.out.println("You get a bonus: " + _scorePad[15]);
		}
	}
	
	//Total Score
	protected void GrandTotal(){
		int grandTotal = IntStream.of(_scorePad).sum();
		System.out.println("Your total score: " + grandTotal);
	}
}
