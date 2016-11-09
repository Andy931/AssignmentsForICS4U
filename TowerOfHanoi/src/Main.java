
public class Main {
	
	public static void main(String[] args){
		System.out.println("Moves");
		TowerOfHanoi(3, 'a', 'b', 'c');
	}
	
	public static void TowerOfHanoi(int n, char beg, char aux, char end){
		if (n==1){
			System.out.printf("%c --> %c\n", beg, end);
		}
		else{
			TowerOfHanoi(n-1, beg, end, aux);
			TowerOfHanoi(1, beg, aux, end);
			TowerOfHanoi(n-1, aux, beg, end);
		}
	}
}
