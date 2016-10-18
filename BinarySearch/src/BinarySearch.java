/****************************************************************************
 *
 * Created by: Andy Liu
 * Created on: Oct 15, 2016
 * Created for: ICS4U
 * Assignment #3b
 * This program searches a number exists in an random array using binary search
 *
 ****************************************************************************/
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {
	static int arraySize = 250; // define the size of the array
	
	public static void main (String[] args){
		// initialize the array
		int[] numberArray = new int[arraySize];
        Random random = new Random();
        
        for (int i = 0; i<numberArray.length; i++){
            int number = random.nextInt(2000)+1;
            
            for(int j = 0;j <= i;j++){
                if(number != numberArray[j]){
                	numberArray[i]=number;
                }                              
            }
        }
		
		BubbleSort(numberArray); // Call bubble sort function to sort the array
		
		for (int i=0; i<numberArray.length; i++){
			System.out.println("[" + i + "]" + "-->" + numberArray[i]);
		} // print out the array (i for counting)
		System.out.println("Length: " + numberArray.length);
		Scanner scan = new Scanner(System.in);  // Reading from System.in
		
		System.out.println("Please enter a integer to search: ");
		int inputNumber = Integer.parseInt(scan.nextLine()); // input the number to search
		scan.close(); //Let the user to enter a string
		
		int position = BinarySearch(inputNumber, numberArray);
		
		System.out.println("The position of the number is " + position);
		
	}
	
	public static int BinarySearch(int searchValue, int num[]){
		int startPosition = 0, endPosition = arraySize - 1;
		int midPosition; // these variables define a range for searching
		
		do{
			midPosition= (int) ((endPosition-startPosition)/2+startPosition);
			if (searchValue > num[midPosition]){
				startPosition = midPosition;
			}
			else{
				endPosition = midPosition;
			}
			if (endPosition-startPosition <= 1){
				if (searchValue == num[startPosition]){
					return startPosition;
				}
				else if (searchValue == num[endPosition]){
					return endPosition;
				}
				else{
					System.out.println("Not Found! ");
					return (-1);
				}
			}
		} while (searchValue != num[midPosition]);   // loop the process until the number is found
		
		return midPosition;
	}
	
	public static void BubbleSort(int num[]){
		
	    boolean flag = false;   // set flag to true to begin first pass
	    int temp;   //holding variable

	    while (flag==false)
	    {
	    	flag = true;    //set flag to false awaiting a possible swap
	        for (int j=0; j<num.length-1; j++)
	        {
	        	if (num[j] > num[j+1])   // change to > for ascending sort
	            {
	        		temp = num[j+1];                //swap elements
	                num[j+1] = num[j];
	                num[j] = temp;
	                flag = false;              //shows a swap occurred  
	            } 
	        } 
	    } 
	} 
}
