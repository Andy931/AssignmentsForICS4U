/****************************************************************************
 *
 * Created by: Andy Liu
 * Created on: Oct 30, 2016
 * Created for: ICS4U
 * Assignment #4b
 * This program is a class for the MainClass
 *
 ****************************************************************************/

public class Triangle{
	//Private Fields
	private static double _sideA;
	private static double _sideB;
	private static double _sideC;
	private static double _semiperimeter;
	private static double _perimeter;
	private static double _area;
	private static String _typeName;
	
	//Constructor
	public Triangle(double a, double b, double c){
		_sideA = a;
		_sideB = b;
		_sideC = c;
	}  //Pass the parameters
	
	//Methods
	//Determine if the triangle is valid
	protected boolean IsTriangleValid(){
		boolean isTriangleValid;
		
		if (_sideA + _sideB > _sideC && _sideA + _sideC > _sideB && _sideB + _sideC > _sideA){
			isTriangleValid = true;
			return isTriangleValid;
		}
		else{
			isTriangleValid = false;
			return isTriangleValid;
		}
	}
	
	//Determine the type of a triangle
	protected String TypeOfTriangle(){
		if (_sideA == _sideB && _sideA == _sideC){
			_typeName = "Equilateral";
		}
		else if (_sideA == _sideB || _sideB == _sideC || _sideA == _sideC){
			_typeName = "Isosceles";
		}
		else if (_sideA*_sideA==_sideB*_sideB+_sideC*_sideC || _sideB*_sideB==_sideA*_sideA+_sideC*_sideC || _sideC*_sideC==_sideA*_sideA+_sideB*_sideB){
			_typeName = "Right-angle";
		}
		else{
			_typeName = "Scalene";
		}
		return _typeName;
	}
	
	//Calculate the perimeter
	protected double GetPerimeter(){
		_perimeter = _sideA + _sideB +_sideC;
		return _perimeter;
	}
	
	//Calculate the area
	protected double GetArea(){
		_semiperimeter = _perimeter / 2;
		_area = Math.round(Math.sqrt(_semiperimeter*(_semiperimeter - _sideA)*(_semiperimeter - _sideB)*(_semiperimeter - _sideC)) * 100.0) / 100.0;
		return _area;
	}
	
	//Height of the triangle
	public void TriangleHeight(){
		double heightA = Math.round(_area*2/_sideA * 100.0) / 100.0;
		double heightB = Math.round(_area*2/_sideB * 100.0) / 100.0;
		double heightC = Math.round(_area*2/_sideC * 100.0) / 100.0;
		
		System.out.println("This triangle have 3 heights: "+heightA+", "+heightB+", "+heightC);
	}
	
	//The largest inscribed circle
	public void LargestInscribedCircle(){
		double radius = Math.round(_area / _semiperimeter * 100.0) / 100.0;
		double inscribedCircleArea = Math.round(radius * radius * 3.14 * 100.0) / 100.0;
		
		System.out.println("The radius of the largest inscribed circle that can fit inside the triangle: " + radius);
		System.out.println("The area of the largest inscribed circle that can fit inside the triangle: " + inscribedCircleArea);
	}
	
	//Circumcircle of the triangle
	public void AreaOfTheCircumcircleOfTheTriangle(){
		double radiusOfCircumcircleOfTheTriangle = Math.round(_sideA*_sideB*_sideC / 4 / _area * 100.0) / 100.0;
		double areaOfCircumcircleOfTheTriangle = Math.round(3.14 * radiusOfCircumcircleOfTheTriangle * radiusOfCircumcircleOfTheTriangle * 100.0) / 100.0;
		System.out.println("The area of the circumcircle of the triangle: " + areaOfCircumcircleOfTheTriangle);
	}
}

