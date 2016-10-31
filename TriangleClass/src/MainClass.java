import java.util.Scanner;
public class MainClass {
	public static void main(String[] args){
		double sideA, sideB, sideC;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1st lenghth: ");
		sideA = sc.nextDouble();
		System.out.println("2nd lenghth: ");
		sideB = sc.nextDouble();
		System.out.println("3rd lenghth: ");
		sideC = sc.nextDouble();
		
		sc.close();
		
		Triangle triangle = new Triangle(sideA, sideB, sideC);
		
		
		//System.out.println(Triangle.get_area(), Triangle.get_perimeter());
		System.out.printf(Double.toString(Triangle.get_area()));
		//System.out.printf(Double.toString(Triangle.get_area()), Double.toString(Triangle.get_perimeter()), Triangle.get_memberName());
	}
}