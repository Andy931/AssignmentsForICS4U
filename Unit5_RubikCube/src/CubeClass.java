/****************************************************************************
 *
 * Created by: Andy Liu
 * Created on: Dec 14, 2016
 * Created for: ICS4U
 * Unit #5
 * This is a class that define a Rubik's Cube 
 * 
 ****************************************************************************/

import java.util.*;

public class CubeClass {

		public char[][] Cube_F = new char[3][3];
		public char[][] Cube_B = new char[3][3];
		public char[][] Cube_U = new char[3][3];
		public char[][] Cube_D = new char[3][3];
		public char[][] Cube_L = new char[3][3];
		public char[][] Cube_R = new char[3][3];
	
		protected void CubePrint2D(){
	    			
		    
		    System.out.println("         _______");
		    System.out.println("        | 11 12 |");
		    System.out.println("        |   U   |");
		    System.out.println("        | 21 22 |");
		    System.out.println(" _______|_______|_______________");
		    System.out.println("| 11 12 | 11 12 | 11 12 | 11 12 |");
		    System.out.println("|   L   |   F   |   R   |   B   |");
		    System.out.println("| 21 22 | 21 22 | 21 22 | 21 22 |");
		    System.out.println("|_______|_______|_______|_______|");
		    System.out.println("        | 11 12 |");
		    System.out.println("        |   D   |");
		    System.out.println("        | 21 22 |");
		    System.out.println("        |_______|");
		    System.out.println("");
		}
		
		protected void CubePrint(CubeClass cube){
			System.out.println("");
			System.out.println("         _______");
		    System.out.println("        | "+cube.Cube_U[1][1]+"   "+cube.Cube_U[1][2]+" |");
		    System.out.println("        |   U   |");
		    System.out.println("        | "+cube.Cube_U[2][1]+"   "+cube.Cube_U[2][2]+" |");
		    System.out.println(" _______|_______|_______________");
		    System.out.println("| "+cube.Cube_L[1][1]+"   "+cube.Cube_L[1][2]+" | "+cube.Cube_F[1][1]+"   "+cube.Cube_F[1][2]+" | "+cube.Cube_R[1][1]+"   "+cube.Cube_R[1][2]+" | "+cube.Cube_B[1][1]+"   "+cube.Cube_B[1][2]+" |");
		    System.out.println("|   L   |   F   |   R   |   B   |");
		    System.out.println("| "+cube.Cube_L[2][1]+"   "+cube.Cube_L[2][2]+" | "+cube.Cube_F[2][1]+"   "+cube.Cube_F[2][2]+" | "+cube.Cube_R[2][1]+"   "+cube.Cube_R[2][2]+" | "+cube.Cube_B[2][1]+"   "+cube.Cube_B[2][2]+" |");
		    System.out.println("|_______|_______|_______|_______|");
		    System.out.println("        | "+cube.Cube_D[1][1]+"   "+cube.Cube_D[1][2]+" |");
		    System.out.println("        |   D   |");
		    System.out.println("        | "+cube.Cube_D[2][1]+"   "+cube.Cube_D[2][2]+" |");
		    System.out.println("        |_______|");
		    System.out.println("");

		}

		
		//Methods
		//Cube Initialize
		protected void CubeInit(CubeClass cube){
			
			for (int i = 1; i<=2; i++){
				for (int j = 1; j<=2; j++){
					cube.Cube_F[i][j] = 'W';	// Front = White
					cube.Cube_B[i][j] = 'Y';	// Back  = Yellow
					cube.Cube_U[i][j] = 'O';	// Up    = Orange
					cube.Cube_D[i][j] = 'R';	// Down  = Red
					cube.Cube_L[i][j] = 'G';	// Left  = Green
					cube.Cube_R[i][j] = 'B';	// Right = Blue
				}
			}
			
		}
		
		//Randomize Cube
		protected void RandomizeCube (CubeClass cube){
			int move;
			int InitStep=21;

			System.out.println("Initialize Cube: ");
			
			for (int counter = 1; counter <= InitStep; counter++){
				Random rd = new Random();
				move = rd.nextInt((12 - 1) + 1) + 1;
				//System.out.print(" "+move+" ");
				switch (move){
					case 1:
						cube.RotateFront(cube);
						break;
					case 2:
						cube.RotateFrontC(cube);
						break;
					case 3:
						cube.RotateUp(cube);
						break;
					case 4:	
						cube.RotateUpC(cube);
						break;
					case 5:
						cube.RotateLeft(cube);
						break;
					case 6:
						cube.RotateLeftC(cube);
						break;
					case 7:
						cube.RotateBack(cube);
						break;
					case 8:
						cube.RotateBackC(cube);
						break;
					case 9:
						cube.RotateDown(cube);
						break;
					case 10:
						cube.RotateDownC(cube);
						break;
					case 11:
						cube.RotateRight(cube);
						break;
					case 12:
						cube.RotateRightC(cube);
						break;
				}

			}
			
			cube.CubePrint(cube);

		}
		
		
		// Front face rotate clockwise 90 degree
		protected void RotateFront(CubeClass cube){
			char cTemp1, cTemp2;
			
			System.out.print("F");
			//Front position change
			cTemp1 = cube.Cube_F[1][1];
			
			cube.Cube_F[1][1] = cube.Cube_F[2][1];
			cube.Cube_F[2][1] = cube.Cube_F[2][2];
			cube.Cube_F[2][2] = cube.Cube_F[1][2];
			cube.Cube_F[1][2] = cTemp1;
			
			// U, L, R, D rubies move with front face rotation CW 90
			cTemp1 = cube.Cube_U[2][1];
			cTemp2 = cube.Cube_U[2][2];
			
			cube.Cube_U[2][1] = cube.Cube_L[2][2];
			cube.Cube_U[2][2] = cube.Cube_L[1][2];
			
			cube.Cube_L[2][2] = cube.Cube_D[1][2];
			cube.Cube_L[1][2] = cube.Cube_D[1][1];
			
			cube.Cube_D[1][2] = cube.Cube_R[1][1];
			cube.Cube_D[1][1] = cube.Cube_R[2][1];
			
			cube.Cube_R[1][1] = cTemp1;
			cube.Cube_R[2][1] = cTemp2;
		
		}	
	
		// Front face rotate counterclockwise 90 degree
		protected void RotateFrontC(CubeClass cube){
			char cTemp1, cTemp2;
			
			System.out.print("F'");
			//Front position change
			cTemp1 = cube.Cube_F[1][1];
			
			cube.Cube_F[1][1] = cube.Cube_F[1][2];
			cube.Cube_F[1][2] = cube.Cube_F[2][2];
			cube.Cube_F[2][2] = cube.Cube_F[2][1];
			cube.Cube_F[2][1] = cTemp1;
			
			// U, L, R, D rubies move with front face rotation CCW 90
			cTemp1 = cube.Cube_U[2][1];
			cTemp2 = cube.Cube_U[2][2];
			
			cube.Cube_U[2][1] = cube.Cube_R[1][1];
			cube.Cube_U[2][2] = cube.Cube_R[2][1];
			
			cube.Cube_R[1][1] = cube.Cube_D[1][2];
			cube.Cube_R[2][1] = cube.Cube_D[1][1];
			
			cube.Cube_D[1][2] = cube.Cube_L[2][2];
			cube.Cube_D[1][1] = cube.Cube_L[1][2];
			
			cube.Cube_L[2][2] = cTemp1;
			cube.Cube_L[1][2] = cTemp2;
		
		}
		
		
		// Up face rotate clockwise 90 degree
		protected void RotateUp(CubeClass cube){
			char cTemp1, cTemp2;
			
			System.out.print("U");
			//Up face position change
			cTemp1 = cube.Cube_U[1][1];
			
			cube.Cube_U[1][1] = cube.Cube_U[2][1];
			cube.Cube_U[2][1] = cube.Cube_U[2][2];
			cube.Cube_U[2][2] = cube.Cube_U[1][2];
			cube.Cube_U[1][2] = cTemp1;
			
			// F, B, L, R rubies move with Up face rotation CW 90
			cTemp1 = cube.Cube_B[1][1];
			cTemp2 = cube.Cube_B[1][2];
			
			cube.Cube_B[1][1] = cube.Cube_L[1][1];
			cube.Cube_B[1][2] = cube.Cube_L[1][2];
			
			cube.Cube_L[1][1] = cube.Cube_F[1][1];
			cube.Cube_L[1][2] = cube.Cube_F[1][2];
			
			cube.Cube_F[1][1] = cube.Cube_R[1][1];
			cube.Cube_F[1][2] = cube.Cube_R[1][2];
			
			cube.Cube_R[1][1] = cTemp1;
			cube.Cube_R[1][2] = cTemp2;
		
		}	
	
		// Up face rotate counterclockwise 90 degree
		protected void RotateUpC(CubeClass cube){
			char cTemp1, cTemp2;
			
			System.out.print("U'");
			//Up face position change
			cTemp1 = cube.Cube_U[1][1];
			
			cube.Cube_U[1][1] = cube.Cube_U[1][2];
			cube.Cube_U[1][2] = cube.Cube_U[2][2];
			cube.Cube_U[2][2] = cube.Cube_U[2][1];
			cube.Cube_U[2][1] = cTemp1;
			
			// F, B, L, R rubies move with Up face rotation CCW 90
			cTemp1 = cube.Cube_B[1][1];
			cTemp2 = cube.Cube_B[1][2];
			
			cube.Cube_B[1][1] = cube.Cube_R[1][1];
			cube.Cube_B[1][2] = cube.Cube_R[1][2];
			
			cube.Cube_R[1][1] = cube.Cube_F[1][1];
			cube.Cube_R[1][2] = cube.Cube_F[1][2];
			
			cube.Cube_F[1][1] = cube.Cube_L[1][1];
			cube.Cube_F[1][2] = cube.Cube_L[1][2];
			
			cube.Cube_L[1][1] = cTemp1;
			cube.Cube_L[1][2] = cTemp2;
		
		}
		
		
		// Left face rotate clockwise 90 degree
		protected void RotateLeft(CubeClass cube){
			char cTemp1, cTemp2;
			
			System.out.print("L");
			//Left face position change
			cTemp1 = cube.Cube_L[1][1];
			
			cube.Cube_L[1][1] = cube.Cube_L[2][1];
			cube.Cube_L[2][1] = cube.Cube_L[2][2];
			cube.Cube_L[2][2] = cube.Cube_L[1][2];
			cube.Cube_L[1][2] = cTemp1;
			
			// F, B, U, D rubies move with Left face rotation CW 90
			cTemp1 = cube.Cube_F[1][1];
			cTemp2 = cube.Cube_F[2][1];
			
			cube.Cube_F[1][1] = cube.Cube_U[1][1];
			cube.Cube_F[2][1] = cube.Cube_U[2][1];
			
			cube.Cube_U[1][1] = cube.Cube_B[2][2];
			cube.Cube_U[2][1] = cube.Cube_B[1][2];
			
			cube.Cube_B[2][2] = cube.Cube_D[1][1];
			cube.Cube_B[1][2] = cube.Cube_D[2][1];
			
			cube.Cube_D[1][1] = cTemp1;
			cube.Cube_D[2][1] = cTemp2;
		
		}	
	
		// Left face rotate counterclockwise 90 degree
		protected void RotateLeftC(CubeClass cube){
			char cTemp1, cTemp2;
			
			System.out.print("L'");
			//Left face position change
			cTemp1 = cube.Cube_L[1][1];
			
			cube.Cube_L[1][1] = cube.Cube_L[1][2];
			cube.Cube_L[1][2] = cube.Cube_L[2][2];
			cube.Cube_L[2][2] = cube.Cube_L[2][1];
			cube.Cube_L[2][1] = cTemp1;
			
			// F, B, U, D rubies move with Left face rotation CCW 90
			cTemp1 = cube.Cube_F[1][1];
			cTemp2 = cube.Cube_F[2][1];
			
			cube.Cube_F[1][1] = cube.Cube_D[1][1];
			cube.Cube_F[2][1] = cube.Cube_D[2][1];
			
			cube.Cube_D[1][1] = cube.Cube_B[2][2];
			cube.Cube_D[2][1] = cube.Cube_B[1][2];
			
			cube.Cube_B[2][2] = cube.Cube_U[1][1];
			cube.Cube_B[1][2] = cube.Cube_U[2][1];
			
			cube.Cube_U[1][1] = cTemp1;
			cube.Cube_U[2][1] = cTemp2;
		
		}
		
		// Back face rotate clockwise 90 degree
		protected void RotateBack(CubeClass cube){
			char cTemp1, cTemp2;
			
			System.out.print("B");
			//Back position change
			cTemp1 = cube.Cube_B[1][1];
			
			cube.Cube_B[1][1] = cube.Cube_B[2][1];
			cube.Cube_B[2][1] = cube.Cube_B[2][2];
			cube.Cube_B[2][2] = cube.Cube_B[1][2];
			cube.Cube_B[1][2] = cTemp1;
			
			// U, D, L, R rubies move with front face rotation CW 90
			cTemp1 = cube.Cube_U[1][1];
			cTemp2 = cube.Cube_U[1][2];
			
			cube.Cube_U[1][1] = cube.Cube_R[1][2];
			cube.Cube_U[1][2] = cube.Cube_R[2][2];
			
			cube.Cube_R[1][2] = cube.Cube_D[2][2];
			cube.Cube_R[2][2] = cube.Cube_D[2][1];
			
			cube.Cube_D[2][2] = cube.Cube_L[2][1];
			cube.Cube_D[2][1] = cube.Cube_L[1][1];
			
			cube.Cube_L[2][1] = cTemp1;
			cube.Cube_L[1][1] = cTemp2;
		
		}	
	
		// Back face rotate counterclockwise 90 degree
		protected void RotateBackC(CubeClass cube){
			char cTemp1, cTemp2;
			
			System.out.print("B'");
			//Back face position change
			cTemp1 = cube.Cube_B[1][1];
			
			cube.Cube_B[1][1] = cube.Cube_B[1][2];
			cube.Cube_B[1][2] = cube.Cube_B[2][2];
			cube.Cube_B[2][2] = cube.Cube_B[2][1];
			cube.Cube_B[2][1] = cTemp1;
			
			// U, D, L, R rubies move with front face rotation CCW 90
			cTemp1 = cube.Cube_U[1][1];
			cTemp2 = cube.Cube_U[1][2];
			
			cube.Cube_U[1][1] = cube.Cube_L[2][1];
			cube.Cube_U[1][2] = cube.Cube_L[1][1];
			
			cube.Cube_L[2][1] = cube.Cube_D[2][2];
			cube.Cube_L[1][1] = cube.Cube_D[2][1];
			
			cube.Cube_D[2][2] = cube.Cube_R[1][2];
			cube.Cube_D[2][1] = cube.Cube_R[2][2];
			
			cube.Cube_R[1][2] = cTemp1;
			cube.Cube_R[2][2] = cTemp2;
		
		}
		
		// Down face rotate clockwise 90 degree
		protected void RotateDown(CubeClass cube){
			char cTemp1, cTemp2;
			
			System.out.print("D");
			//Down face position change
			cTemp1 = cube.Cube_D[1][1];
			
			cube.Cube_D[1][1] = cube.Cube_D[2][1];
			cube.Cube_D[2][1] = cube.Cube_D[2][2];
			cube.Cube_D[2][2] = cube.Cube_D[1][2];
			cube.Cube_D[1][2] = cTemp1;
			
			// F, B, L, R rubies move with Down face rotation CW 90
			cTemp1 = cube.Cube_F[2][1];
			cTemp2 = cube.Cube_F[2][2];
			
			cube.Cube_F[2][1] = cube.Cube_L[2][1];
			cube.Cube_F[2][2] = cube.Cube_L[2][2];
			
			cube.Cube_L[2][1] = cube.Cube_B[2][1];
			cube.Cube_L[2][2] = cube.Cube_B[2][2];
			
			cube.Cube_B[2][1] = cube.Cube_R[2][1];
			cube.Cube_B[2][2] = cube.Cube_R[2][2];
			
			cube.Cube_R[2][1] = cTemp1;
			cube.Cube_R[2][2] = cTemp2;
		
		}	
	
		// Down face rotate counterclockwise 90 degree
		protected void RotateDownC(CubeClass cube){
			char cTemp1, cTemp2;
			
			System.out.print("D'");
			//Down face position change
			cTemp1 = cube.Cube_D[1][1];
			
			cube.Cube_D[1][1] = cube.Cube_D[1][2];
			cube.Cube_D[1][2] = cube.Cube_D[2][2];
			cube.Cube_D[2][2] = cube.Cube_D[2][1];
			cube.Cube_D[2][1] = cTemp1;
			
			// F, B, L, R rubies move with Down face rotation CCW 90
			cTemp1 = cube.Cube_F[2][1];
			cTemp2 = cube.Cube_F[2][2];
			
			cube.Cube_F[2][1] = cube.Cube_R[2][1];
			cube.Cube_F[2][2] = cube.Cube_R[2][2];
			
			cube.Cube_R[2][1] = cube.Cube_B[2][1];
			cube.Cube_R[2][2] = cube.Cube_B[2][2];
			
			cube.Cube_B[2][1] = cube.Cube_L[2][1];
			cube.Cube_B[2][2] = cube.Cube_L[2][2];
			
			cube.Cube_L[2][1] = cTemp1;
			cube.Cube_L[2][2] = cTemp2;
		
		}
		
		
		// Right face rotate clockwise 90 degree
		protected void RotateRight(CubeClass cube){
			char cTemp1, cTemp2;
			
			System.out.print("R");
			//Right face position change
			cTemp1 = cube.Cube_R[1][1];
			
			cube.Cube_R[1][1] = cube.Cube_R[2][1];
			cube.Cube_R[2][1] = cube.Cube_R[2][2];
			cube.Cube_R[2][2] = cube.Cube_R[1][2];
			cube.Cube_R[1][2] = cTemp1;
			
			// F, B, U, D rubies move with Right face rotation CW 90
			cTemp1 = cube.Cube_F[1][2];
			cTemp2 = cube.Cube_F[2][2];
			
			cube.Cube_F[1][2] = cube.Cube_D[1][2];
			cube.Cube_F[2][2] = cube.Cube_D[2][2];
			
			cube.Cube_D[1][2] = cube.Cube_B[2][1];
			cube.Cube_D[2][2] = cube.Cube_B[1][1];
			
			cube.Cube_B[2][1] = cube.Cube_U[1][2];
			cube.Cube_B[1][1] = cube.Cube_U[2][2];
			
			cube.Cube_U[1][2] = cTemp1;
			cube.Cube_U[2][2] = cTemp2;
		
		}	
	
		// Right face rotate counterclockwise 90 degree
		protected void RotateRightC(CubeClass cube){
			char cTemp1, cTemp2;
			
			System.out.print("R'");
			//Right face position change
			cTemp1 = cube.Cube_R[1][1];
			
			cube.Cube_R[1][1] = cube.Cube_R[1][2];
			cube.Cube_R[1][2] = cube.Cube_R[2][2];
			cube.Cube_R[2][2] = cube.Cube_R[2][1];
			cube.Cube_R[2][1] = cTemp1;
			
			// F, B, U, D rubies move with Right face rotation CCW 90
			cTemp1 = cube.Cube_F[1][2];
			cTemp2 = cube.Cube_F[2][2];
			
			cube.Cube_F[1][2] = cube.Cube_U[1][2];
			cube.Cube_F[2][2] = cube.Cube_U[2][2];
			
			cube.Cube_U[1][2] = cube.Cube_B[2][1];
			cube.Cube_U[2][2] = cube.Cube_B[1][1];
			
			cube.Cube_B[2][1] = cube.Cube_D[1][2];
			cube.Cube_B[1][1] = cube.Cube_D[2][2];
			
			cube.Cube_D[1][2] = cTemp1;
			cube.Cube_D[2][2] = cTemp2;
		
		}	

		
		//Rotate_Cube_Clockwise 90 degree from front side
		protected void RotateCubeClockwise(CubeClass cube){
			char cTemp1, cTemp2,cTemp3,cTemp4;
			
			System.out.println("Rotate cube Clockwise by 90 Degree");

			cTemp1 = cube.Cube_U[1][1];
			cTemp2 = cube.Cube_U[1][2];
			cTemp3 = cube.Cube_U[2][1];
			cTemp4 = cube.Cube_U[2][2];

			cube.Cube_U[1][1] = cube.Cube_L[2][1];
			cube.Cube_U[1][2] = cube.Cube_L[1][1];
			cube.Cube_U[2][1] = cube.Cube_L[2][2];
			cube.Cube_U[2][2] = cube.Cube_L[1][2];
			
			cube.Cube_L[1][1] = cube.Cube_D[2][1];
			cube.Cube_L[1][2] = cube.Cube_D[1][1];
			cube.Cube_L[2][1] = cube.Cube_D[2][2];
			cube.Cube_L[2][2] = cube.Cube_D[1][2];

			cube.Cube_D[1][1] = cube.Cube_R[2][1];
			cube.Cube_D[1][2] = cube.Cube_R[1][1];
			cube.Cube_D[2][1] = cube.Cube_R[2][2];
			cube.Cube_D[2][2] = cube.Cube_R[1][2];
			
			cube.Cube_R[1][1] = cTemp3;
			cube.Cube_R[1][2] = cTemp1;
			cube.Cube_R[2][1] = cTemp4;
			cube.Cube_R[2][2] = cTemp2;
			
			
			cTemp1 = cube.Cube_F[1][1];
			cube.Cube_F[1][1] = cube.Cube_F[2][1];
			cube.Cube_F[2][1] = cube.Cube_F[2][2];
			cube.Cube_F[2][2] = cube.Cube_F[1][2];
			cube.Cube_F[1][2] = cTemp1;		
			
			cTemp1 = cube.Cube_B[1][1];
			cube.Cube_B[1][1] = cube.Cube_B[1][2];
			cube.Cube_B[1][2] = cube.Cube_B[2][2];
			cube.Cube_B[2][2] = cube.Cube_B[2][1];
			cube.Cube_B[2][1] = cTemp1;
		}	
		
		
		//Rotate_Cube_Horizontally clockwise 90 degree from D side
		protected void RotateCubeHorizontally(CubeClass cube){
			char cTemp1;
			
			System.out.println("Rotate Cube Horizontally clockwise by 90 Degree");
			
			for (int i = 1; i<=2; i++){
				for (int j = 1; j<=2; j++){
					cTemp1 = cube.Cube_F[i][j];
					
					cube.Cube_F[i][j] = cube.Cube_L[i][j];
					cube.Cube_L[i][j] = cube.Cube_B[i][j];
					cube.Cube_B[i][j] = cube.Cube_R[i][j];
					cube.Cube_R[i][j] = cTemp1;
				}
			}
			
			cTemp1 = cube.Cube_U[1][1];
			cube.Cube_U[1][1] = cube.Cube_U[1][2];
			cube.Cube_U[1][2] = cube.Cube_U[2][2];
			cube.Cube_U[2][2] = cube.Cube_U[2][1];
			cube.Cube_U[2][1] = cTemp1;		
			
			cTemp1 = cube.Cube_D[1][1];
			cube.Cube_D[1][1] = cube.Cube_D[2][1];
			cube.Cube_D[2][1] = cube.Cube_D[2][2];
			cube.Cube_D[2][2] = cube.Cube_D[1][2];
			cube.Cube_D[1][2] = cTemp1;

		}	
		
		//Rotate_Cube_Vertical clockwise 90 degree from R side
		protected void RotateCubeVertically(CubeClass cube){
			char cTemp1;
			
			System.out.println("Rotate cube Vertically clockwise by 90 Degree");
			
			for (int i = 1; i<=2; i++){
				for (int j = 1; j<=2; j++){
					cTemp1 = cube.Cube_F[i][j];
					
					cube.Cube_F[i][j] = cube.Cube_D[i][j];
					cube.Cube_D[i][j] = cube.Cube_B[3-i][3-j];
					cube.Cube_B[3-i][3-j] = cube.Cube_U[i][j];
					cube.Cube_U[i][j] = cTemp1;
				}
			}
			
			cTemp1 = cube.Cube_R[1][1];
			cube.Cube_R[1][1] = cube.Cube_R[2][1];
			cube.Cube_R[2][1] = cube.Cube_R[2][2];
			cube.Cube_R[2][2] = cube.Cube_R[1][2];
			cube.Cube_R[1][2] = cTemp1;		
			
			cTemp1 = cube.Cube_L[1][1];
			cube.Cube_L[1][1] = cube.Cube_L[1][2];
			cube.Cube_L[1][2] = cube.Cube_L[2][2];
			cube.Cube_L[2][2] = cube.Cube_L[2][1];
			cube.Cube_L[2][1] = cTemp1;

		}
		
		//Rotate cube sides using sequence
		protected void RotateCubeSequence(String RotateSeq, CubeClass cube){
			
			for (int i=0; i<RotateSeq.length(); i++){

				switch (RotateSeq.charAt(i)){
				
					case 'F': 
					{
						if (i==RotateSeq.length()-1)
							cube.RotateFront(cube);
						else 
							if (RotateSeq.charAt(i+1)=='\'')
								cube.RotateFrontC(cube);
							else
								cube.RotateFront(cube);
						break;
					}
				
					case 'B': 
					{
						if (i==RotateSeq.length()-1)
							cube.RotateBack(cube);
						else 
							if (RotateSeq.charAt(i+1)=='\'')
								cube.RotateBackC(cube);
							else
								cube.RotateBack(cube);
						break;
					}
					
					case 'U': 
					{
						if (i==RotateSeq.length()-1)
							cube.RotateUp(cube);
						else 
							if (RotateSeq.charAt(i+1)=='\'')
								cube.RotateUpC(cube);
							else
								cube.RotateUp(cube);
						break;
					}
					
					case 'D': 
					{
						if (i==RotateSeq.length()-1)
							cube.RotateDown(cube);
						else 
							if (RotateSeq.charAt(i+1)=='\'')
								cube.RotateDownC(cube);
							else
								cube.RotateDown(cube);
						break;
					}
					
					case 'L': 
					{
						if (i==RotateSeq.length()-1)
							cube.RotateLeft(cube);
						else 
							if (RotateSeq.charAt(i+1)=='\'')
								cube.RotateLeftC(cube);
							else
								cube.RotateLeft(cube);
						break;
					}
					
					case 'R': 
					{
						if (i==RotateSeq.length()-1)
							cube.RotateRight(cube);
						else 
							if (RotateSeq.charAt(i+1)=='\'')
								cube.RotateRightC(cube);
							else
								cube.RotateRight(cube);
						break;
					}
				}
			}
		}
		
		// ---------------------
		
}
