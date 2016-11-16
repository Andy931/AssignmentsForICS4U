/****************************************************************************
 *
 * Created by: Andy Liu
 * Created on: Nov 12, 2016
 * Created for: ICS4U
 * Assignment #5b
 * This program generates a symmetric series of number recursively
 *
 ****************************************************************************/

import java.util.*;

public class RecursiveNumberLines {
	public static void main(String[] args){
		String inputNumber;
		int lineNumber;
		
		System.out.println("Please enter an integer larger than 1 to see the recursive number line: ");
		
		//Input
		Scanner sc = new Scanner(System.in);
		inputNumber = sc.next();
		sc.close();   // Let the user input a number
		
		//Process & Output
		float inputNumberFloat = Float.parseFloat(inputNumber); // For determining if it is not an integer
		
		if (inputNumberFloat * 10 % 10 == 0 && inputNumberFloat >= 1){
			lineNumber = (int)(inputNumberFloat);
			RecNumberLines("", lineNumber, 1);
		}
		else{
			System.out.println("Invalid input, try again!");
			System.exit(0);
		}  // Determine if the number is an integer that less than 1
	}
	
	public static void RecNumberLines(String stringOfNumbers, int numberOfInput, int counter){
		if (counter <= numberOfInput){
			if (counter > 5){
				stringOfNumbers = stringOfNumbers + Integer.toString(counter) + "\n" + stringOfNumbers;
			}
			else{
				stringOfNumbers = stringOfNumbers + Integer.toString(counter) + " " + stringOfNumbers;
			}  // Determine if the number is greater than 5, if is, then start a new line to print the number line
			RecNumberLines(stringOfNumbers, numberOfInput, counter+1);
		}
		else{
			System.out.println(stringOfNumbers);
		}  // Determine if counter reaches the limit, if does, print the numbers out
	}
}