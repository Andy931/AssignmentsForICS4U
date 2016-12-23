/**
 * 
 * 
 */

import java.util.*;

public class CubeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("   *****   Cube   *****");	
		
		Scanner sc = new Scanner(System.in);
		
		CubeClass cube1 = new CubeClass();

		cube1.CubeInit(cube1);
		cube1.CubePrint(cube1);
		CubeRecoverer.CubeInput(cube1);
		CubeRecoverer.CubeCheck(cube1);
		//cube1.RandomizeCube(cube1);
		
		CubeRecoverer.Recovery(cube1);
		
		sc.close();
		System.out.println("\n   *****   Thanks   *****");
	}

}
