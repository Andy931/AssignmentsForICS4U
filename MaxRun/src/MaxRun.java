/****************************************************************************
 *
 * Created by: Andy Liu
 * Created on: Sept 19, 2016
 * Created for: ICS4U
 * Assignment #1b
 * This program calculates the max run of a string
 *
 ****************************************************************************/

import java.util.Scanner;

public class MaxRun {
	
	public static void main(String[] args){
		
		//variables
		String strUserInput = "";
		int maxRun;
		
		//input
		Scanner scan = new Scanner(System.in);  // Reading from System.in
		
		System.out.println("Please enter a random string: ");
		strUserInput = scan.nextLine();
		scan.close(); //Let the user to enter a string
		
		//process
		maxRun = MaxRunCounter(strUserInput); //call the function
		
		//output
		System.out.println("The max run is: "+ maxRun); //Show the result
	}

    public static int MaxRunCounter (String userInput){
    	//variables
    	int numberOfCharacter = 1;
    	int maxRun = 1, index = 0;
    	int lengthOfString;
    	char c1, c2; //for comparing characters
    	
    	//input
    	lengthOfString = userInput.length(); //get the length of the string
    	
    	while (lengthOfString -1 > index){		
    		c1 = userInput.charAt(index);
    		c2 = userInput.charAt(index + 1);
			
    		if(c1 == c2){
    			numberOfCharacter ++;
				
    			if(maxRun < numberOfCharacter)						
    				maxRun = numberOfCharacter;
    		}
    		else {
    			numberOfCharacter = 1;
    		}
    		index ++;
    	}; //comparing characters
	
    	return maxRun; //return value
    }
}