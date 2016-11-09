/****************************************************************************
 *
 * Created by: Andy Liu
 * Created on: Oct 30, 2016
 * Created for: ICS4U
 * Assignment #4b
 * This program determines the type, area, perimeter, hights, largest 
 * inscribed circle area and circumcircle area of triangle
 *
 ****************************************************************************/

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args){
		double sideA, sideB, sideC;
		
		//Input
		Scanner sc = new Scanner(System.in);
		System.out.println("1st length: ");
		sideA = sc.nextDouble();
		System.out.println("2nd length: ");
		sideB = sc.nextDouble();
		System.out.println("3rd length: ");
		sideC = sc.nextDouble();
		
		sc.close(); //Get lengths of three sides of a triangle from the user
		
		//Process and Output
		Triangle triangle = new Triangle(sideA, sideB, sideC);
		triangle.IsTriangleValid();
		boolean validityOfTriangle = triangle.IsTriangleValid(); //Determine if the triangle is valid
		
		if (validityOfTriangle == true){
			System.out.println("Is triangle valid: " + validityOfTriangle);
		}
		else{
			System.out.println("Is triangle valid: " + validityOfTriangle + "\nTry again!");
			System.exit(0);
		}  //
		
		System.out.printf("Type: " + triangle.TypeOfTriangle() + "\n"); //Get the type of triangle
		System.out.printf("Perimeter: " + Double.toString(triangle.GetPerimeter()) + "\n"); //Get the perimeter
		System.out.printf("Area: " + Double.toString(triangle.GetArea()) + "\n");  //Get the area
		triangle.TriangleHeight();  //Get heights
		triangle.LargestInscribedCircle();  //Get the area of the largest inscribed circle
		triangle.AreaOfTheCircumcircleOfTheTriangle(); //Get the area of circumcircle
	}
}