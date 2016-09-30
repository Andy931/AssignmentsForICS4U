import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	public static void main(String[] args){
		
		MrCoxallStack aStack = new MrCoxallStack();
		String aString;
		
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		
		System.out.println("Please enter a string to the stack");
		try{
			aString = br.readLine();
			aStack.push(aString);
			System.out.println(aStack);
		} catch (IOException e){
			e.printStackTrace();
		}
		
	}
	
}
