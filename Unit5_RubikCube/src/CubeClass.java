import java.util.*;
/*
3D presentation of a Cube:
                ______
               /     /|
              /  U  / |
             /_____/  | B
            |      |R |
          L |   F  |  /
            |      | /
            |______|/
                D

2D presentation and array position of a Cube:
            _______
           | 11 12 |
           |   U   |
           | 21 22 |
    _______|_______|_______________
   | 11 12 | 11 12 | 11 12 | 11 12 |
   |   L   |   F   |   R   |   B   |
   | 21 22 | 21 22 | 21 22 | 21 22 |
   |_______|_______|_______|_______|
           | 11 12 |
           |   D   |
           | 21 22 |
           |_______|

            _______
           | O   O |
           |   U   |
           | O   O |
    _______|_______|_______________
   | G   G | W   W | B   B | Y   Y |
   |   L   |   F   |   R   |   B   |
   | G   G | W   W | B   B | Y   Y |
   |_______|_______|_______|_______|
           | R   R |
           |   D   |
           | R   R |
           |_______|

Cube: W=white, O=orange, G=green, R=Red, B=Blue, Y=Yellow  
Center: F=front, B=back, U=up, D=down, L=left, R=right
*/

/* Cube 2D expand image
         _______
        | 11 12 |
        |   U   |
        | 21 22 |
 _______|_______|_______________
| 11 12 | 11 12 | 11 12 | 11 12 |
|   L   |   F   |   R   |   B   |
| 21 22 | 21 22 | 21 22 | 21 22 |
|_______|_______|_______|_______|
        | 11 12 |
        |   D   |
        | 21 22 |
        |_______|
        | 22 21 |
        |   B   |
        | 12 11 |
        |_______|
 */
/* Rotate Methods: 
F :Rotate_F()
F':Rotate_Fc()
B :Rotate_B()
B':Rotate_Bc()
U :Rotate_U()
U':Rotate_Uc()
D :Rotate_D()
D':Rotate_Dc()
L :Rotate_L()
L':Rotate_Lc()
R :Rotate_R()
R':Rotate_Rc()
*/


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
						cube.Rotate_F(cube);
						break;
					case 2:
						cube.Rotate_Fc(cube);
						break;
					case 3:
						cube.Rotate_U(cube);
						break;
					case 4:	
						cube.Rotate_Uc(cube);
						break;
					case 5:
						cube.Rotate_L(cube);
						break;
					case 6:
						cube.Rotate_Lc(cube);
						break;
					case 7:
						cube.Rotate_B(cube);
						break;
					case 8:
						cube.Rotate_Bc(cube);
						break;
					case 9:
						cube.Rotate_D(cube);
						break;
					case 10:
						cube.Rotate_Dc(cube);
						break;
					case 11:
						cube.Rotate_R(cube);
						break;
					case 12:
						cube.Rotate_Rc(cube);
						break;
				}

			}
			
			cube.CubePrint(cube);

		}
		
		
		// Front face rotate clockwise 90 degree
		protected void Rotate_F(CubeClass cube){
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
		protected void Rotate_Fc(CubeClass cube){
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
		protected void Rotate_U(CubeClass cube){
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
		protected void Rotate_Uc(CubeClass cube){
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
		protected void Rotate_L(CubeClass cube){
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
		protected void Rotate_Lc(CubeClass cube){
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
		protected void Rotate_B(CubeClass cube){
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
		protected void Rotate_Bc(CubeClass cube){
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
		protected void Rotate_D(CubeClass cube){
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
		protected void Rotate_Dc(CubeClass cube){
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
		protected void Rotate_R(CubeClass cube){
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
		protected void Rotate_Rc(CubeClass cube){
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

		
		//Rotate_Rubik_Clockwise Clockwise 90 degree from front side
		protected void RotateRubikClockwise(CubeClass cube){
			char cTemp1, cTemp2,cTemp3,cTemp4;
			
			System.out.println("Rotate_Rubik_Clockwise-90");

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
		
		
		//Rotate_Rubik_Horizon clockwise 90 degree from D side
		protected void RotateRubikHorizon(CubeClass cube){
			char cTemp1;
			
			System.out.println("Rotate_Rubik_Horizon-90");
			
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
		
		//Rotate_Rubik_Vertical clockwise 90 degree from R side
		protected void RotateRubikVertical(CubeClass cube){
			char cTemp1;
			
			System.out.println("Rotate_Rubik_Vertical-90");
			
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

		protected void CubeCheck(CubeClass cube){
			
		}
		
		//Rotate cube sides using sequence
		protected void RotateCubeSequence(String RotateSeq, CubeClass cubes){
			
			for (int i=0; i<RotateSeq.length(); i++){

				switch (RotateSeq.charAt(i)){
				
					case 'F': 
					{
						if (i==RotateSeq.length()-1)
							cubes.Rotate_F(cubes);
						else 
							if (RotateSeq.charAt(i+1)=='\'')
								cubes.Rotate_Fc(cubes);
							else
								cubes.Rotate_F(cubes);
						break;
					}
				
					case 'B': 
					{
						if (i==RotateSeq.length()-1)
							cubes.Rotate_B(cubes);
						else 
							if (RotateSeq.charAt(i+1)=='\'')
								cubes.Rotate_Bc(cubes);
							else
								cubes.Rotate_B(cubes);
						break;
					}
					
					case 'U': 
					{
						if (i==RotateSeq.length()-1)
							cubes.Rotate_U(cubes);
						else 
							if (RotateSeq.charAt(i+1)=='\'')
								cubes.Rotate_Uc(cubes);
							else
								cubes.Rotate_U(cubes);
						break;
					}
					
					case 'D': 
					{
						if (i==RotateSeq.length()-1)
							cubes.Rotate_D(cubes);
						else 
							if (RotateSeq.charAt(i+1)=='\'')
								cubes.Rotate_Dc(cubes);
							else
								cubes.Rotate_D(cubes);
						break;
					}
					
					case 'L': 
					{
						if (i==RotateSeq.length()-1)
							cubes.Rotate_L(cubes);
						else 
							if (RotateSeq.charAt(i+1)=='\'')
								cubes.Rotate_Lc(cubes);
							else
								cubes.Rotate_L(cubes);
						break;
					}
					
					case 'R': 
					{
						if (i==RotateSeq.length()-1)
							cubes.Rotate_R(cubes);
						else 
							if (RotateSeq.charAt(i+1)=='\'')
								cubes.Rotate_Rc(cubes);
							else
								cubes.Rotate_R(cubes);
						break;
					}
				}
			}
		}
		
		// ---------------------
		
}
