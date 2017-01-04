/****************************************************************************
 *
 * Created by: Andy Liu
 * Created on: Dec 14, 2016
 * Created for: ICS4U
 * Unit #5
 * This program call methods and functions in CubeClass and CubeRecoverer
 * to run them orderly
 * 
 ****************************************************************************/

import java.util.*;

public class CubeMain {

	public static void main(String[] args) {
		System.out.println("  *****   Cube   *****");	
		
		Scanner sc = new Scanner(System.in);
		
		CubeClass cube1 = new CubeClass();

		cube1.CubeInit(cube1);
		cube1.CubePrint(cube1);
		//CubeRecoverer.CubeInput(cube1);
		cube1.RandomizeCube(cube1);
		
		CubeRecoverer.CubeSolver(cube1);
		
		sc.close();
	}

}
