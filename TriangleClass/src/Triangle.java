
public class Triangle{
	//Private Fields
	private static double _sideA;
	private static double _sideB;
	private static double _sideC;
	private static double _semiperimeter;
	private static double _perimeter;
	private static double _area;
	private static String _memberName;
	
	//Constructor
	public Triangle(double a, double b, double c){
		_sideA = a;
		_sideB = b;
		_sideC = c;
	}
	
	//Methods
	protected void IsTriangleValid(){
		boolean isTriangleValid;
		
		if (_sideA + _sideB > _sideC && _sideA + _sideC > _sideB && _sideB + _sideC > _sideA){
			isTriangleValid = true;
		}
		else{
			isTriangleValid = false;
		}
	}
	
	//Setter & Getter
	public static double get_area() {
		return _area;
	}

	public static void set_area(double _area) {
		Triangle._area = _area;
	}

	public static double get_perimeter() {
		return _perimeter;
	}

	public static void set_perimeter(double _perimeter) {
		Triangle._perimeter = _perimeter;
	}

	public static String get_memberName() {
		return _memberName;
	}

	public static void set_memberName(String _memberName) {
		Triangle._memberName = _memberName;
	}
	
	protected String TypeOfTriangle(){
		if (_sideA == _sideB && _sideA == _sideC){
			Triangle.set_memberName("Equilateral");
			return "Equilateral";
		}
		else if (_sideA == _sideB || _sideB == _sideC || _sideA == _sideC){
			Triangle.set_memberName("Isosceles");
		}
		else if (_sideA*_sideA==_sideB*_sideB+_sideC*_sideC || _sideB*_sideB==_sideA*_sideA+_sideC*_sideC || _sideC*_sideC==_sideA*_sideA+_sideB*_sideB){
			Triangle.set_memberName("Right-angle");
		}
		else{
			Triangle.set_memberName("Scalene");
		}
		return Triangle.get_memberName();
	}
	
	protected void GetPerimeter(){
		Triangle.set_perimeter(_sideA + _sideB +_sideC);
	}
	
	protected void GetArea(){
		Triangle._semiperimeter = get_perimeter() / 2;
		Triangle.set_area(Math.sqrt(_semiperimeter*(_semiperimeter - _sideA)*(_semiperimeter - _sideB)*(_semiperimeter - _sideC)));
	}

	
}
