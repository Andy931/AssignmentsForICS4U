/****************************************************************************
 *
 * Created by: Andy Liu
 * Created on: Dec 14, 2016
 * Created for: ICS4U
 * Unit #5
 * This program solve a Rubik's Cube step by step 
 * 
 ****************************************************************************/

import java.util.*;

public class CubeRecoverer {
    
    //Define 8 cube color-combination code 
	public static int WRG = 16077;
	public static int WRB = 15862;
	public static int YRB = 19038;
	public static int YRG = 19253;
	public static int WOG = 13908;
	public static int WOB = 13693;
	public static int YOB = 16869;
	public static int YOG = 17084;

    public static int [] CubeCode = new int[9];

    protected static void CubeSolver(CubeClass cube){
        String strSquence = "";

        System.out.println("******Recovering******");

        CubeSort(cube);

        System.out.println("\n----Step 1:");

        //Step 0: Find WOB cube and move to F21 position
        switch (FindCubePos(WOB)){
            case 1:
            RotateWOBinF21(cube);
            break;

            case 2: {
                cube.RotateCubeHorizontally(cube);
                cube.RotateCubeHorizontally(cube);
                cube.RotateCubeHorizontally(cube);
                RotateWOBinF21(cube);
                break;
            }

            case 3: {
                cube.RotateCubeHorizontally(cube);
                cube.RotateCubeHorizontally(cube);
                RotateWOBinF21(cube);
                break;
            }

            case 4: {
                cube.RotateCubeHorizontally(cube);
                RotateWOBinF21(cube);
                break;
            }

            case 5: {
                cube.RotateCubeVertically(cube);
                cube.RotateCubeVertically(cube);
                cube.RotateCubeVertically(cube);
                RotateWOBinF21(cube);
                break;
            }

            case 6: {
                cube.RotateCubeClockwise(cube);
                cube.RotateCubeClockwise(cube);
                RotateWOBinF21(cube);
                break;
            }

            case 7: {
                cube.RotateCubeClockwise(cube);
                cube.RotateCubeHorizontally(cube);
                cube.RotateCubeHorizontally(cube);
                RotateWOBinF21(cube);
                break;
            }

            case 8: {
                cube.RotateCubeVertically(cube);
                cube.RotateCubeVertically(cube);
                RotateWOBinF21(cube);
                break;
            }

            default: System.out.println("Error 1");
        }

        cube.CubePrint(cube);

        //Step 1-1: Find WRB cube and move to correct position and move to Position-5, then apply rotate sequence
        CubeSort(cube);
        System.out.println("Cube WRB position = "+FindCubePos(WRB));
        switch (FindCubePos(WRB)){
			case 2: 
				cube.RotateRight(cube);
				break;

			case 3: 
				cube.RotateRight(cube);
				cube.RotateRight(cube);
				break;
				
			case 4:
				cube.RotateBack(cube);
				cube.RotateBack(cube);
				cube.RotateRightC(cube);
				break;
				
			case 5:
				cube.RotateUpC(cube);
				break;
				
			case 6:
				break;
				
			case 7:
				cube.RotateUp(cube);
				break;
				
			case 8:
				cube.RotateUp(cube);
				cube.RotateUp(cube);
				break;
			default:
				System.out.println("****Error 2");
		}
		
		strSquence=" ";
		switch (cube.Cube_F[1][2]){
			case 'B': 
				//Sequence 1-1: (R U R')
				strSquence= "RUR'";
				break;
				
			case 'W': 
				//Sequence 1-2: (F'U'F)
				strSquence= "F'U'F";
				break;
			
			case 'R': 
				//Sequence 1-3: (R U R')(R U R') U' (R U R')
				strSquence= "RUR'RUR'U'RUR'";
				break;
				
			default:
				System.out.println("****Error 3");
		}
		cube.RotateCubeSequence(strSquence, cube);	//apply rotate sequence
		
		cube.CubePrint(cube);
		
		
		//Step 1-2: Find WRG cube and move to correct position and move to Position-5, then apply rotate sequence
		cube.RotateCubeHorizontally(cube);
		cube.RotateCubeHorizontally(cube);
		cube.RotateCubeHorizontally(cube);
		CubeSort(cube);
		System.out.println("Cube WRG position = "+FindCubePos(WRG));
		switch (FindCubePos(WRG)){
			case 2: 
				cube.RotateRight(cube);
				break;

			case 3: 
				cube.RotateRight(cube);
				cube.RotateRight(cube);
				break;
				
			case 5:
				cube.RotateUpC(cube);
				break;
				
			case 6:
				break;
				
			case 7:
				cube.RotateUp(cube);
				break;
				
			case 8:
				cube.RotateUp(cube);
				cube.RotateUp(cube);
				break;
			default:
				System.out.println("****Error 4");
		}
		
		strSquence=" ";
		switch (cube.Cube_F[1][2]){
			case 'R': 
				//(R U R')
				strSquence= "RUR'";
				break;
				
			case 'W': 
				//(F'U'F)
				strSquence= "F'U'F";
				break;
			
			case 'G': 
				//(R U R')(R U R') U' (R U R')
				strSquence= "RUR'RUR'U'RUR'";
				break;
				
			default:
				System.out.println("****Error 5");
		}
		cube.RotateCubeSequence(strSquence, cube);	//apply rotate sequence
		
		cube.CubePrint(cube);
		
		//Step 1-3: Find WOG cube and move to correct position and move to Position-5, then apply rotate sequence
		cube.RotateCubeHorizontally(cube);
		cube.RotateCubeHorizontally(cube);
		cube.RotateCubeHorizontally(cube);
		CubeSort(cube);
		System.out.println("Cube WOG position = "+FindCubePos(WOG));
		boolean WOGcorrect = false;
		switch (FindCubePos(WOG)){
			case 2: 
				if ((cube.Cube_F[2][2]=='W')||(cube.Cube_F[2][2]=='O')) {
					cube.RotateRight(cube);
					cube.RotateUp(cube);
					cube.RotateRightC(cube);
					cube.RotateUpC(cube);
				}
				else
					if (cube.Cube_F[2][2]=='G'){
						WOGcorrect=true;
						break;
					}
					else
						System.out.println("****Error 6-1");

				break;

			case 5:
				cube.RotateUpC(cube);
				break;
				
			case 6:
				break;
				
			case 7:
				cube.RotateUp(cube);
				break;
				
			case 8:
				cube.RotateUp(cube);
				cube.RotateUp(cube);
				break;
			default:
				System.out.println("****Error 6");
		}
		
		strSquence=" ";
		if (!WOGcorrect){  //  means if the cube WOG is not in correct position, then rotation. 
			
			switch (cube.Cube_F[1][2]){
				case 'G': 
					//(R U R')
					strSquence= "RUR'";
					break;
					
				case 'W': 
					//(F'U'F)
					strSquence= "F'U'F";
					break;
				
				case 'O': 
					//(R U R')(R U R') U' (R U R')
					strSquence= "RUUR'U'RUR'";
					break;
					
				default:
					System.out.println("****Error 7");
			}
			cube.RotateCubeSequence(strSquence, cube);	//apply rotate sequence
		}
		
		cube.CubePrint(cube);
		// Complete Down side and 4 sides at lower layer.
		
		
		//Step 2: Get top side filled with yellow
		int n=0, numberofYellow=0;
		
		for (int i=1; i<=2; i++) {
			for (int j=1; j<=2; j++) {
				if (cube.Cube_U[i][j] =='Y' ){
					//UpSideYellow[n++] =1;
					numberofYellow++;
				}
				//else
					//UpSideYellow[n++] =0;
			}
		}
		
		System.out.println("\n****Start Step 2:\n    number of Yellow in U = "+numberofYellow);
		
		strSquence=" ";
		int SeqType = 0;
		switch (numberofYellow){
			case 0: {
				// move 2 yellow to Front
				for (int i=0; i<4; i++) {
					if ((cube.Cube_F[1][1]=='Y')&&(cube.Cube_F[1][2]=='Y'))
						break;
					else
						cube.RotateUp(cube);
				}
					
				if ((cube.Cube_B[1][1]=='Y')&&(cube.Cube_B[1][2]=='Y'))
					// Figure 205: Sequence "RU'U'R'U'RU'R'+ RU'U'R'U'RU'R'" 
					{strSquence= "RU'U'R'U'RU'U'U'R'U'RU'R'";
					SeqType = 205;}
				else
					if ((cube.Cube_L[1][1]=='Y')&&(cube.Cube_R[1][2]=='Y'))
						// Figure 204: Sequence "R'UURUR'UR + U'+ R'UURUR'UR" 
						{strSquence= "R'UURUR'URU'R'UURUR'UR";
						SeqType = 204;}
					else 
						System.out.println("****Error 8-1");
						
				break;
			}
			
			case 1: {
				// move 1 yellow to U[2][2]
				for (int i=0; i<4; i++) {
					if (cube.Cube_U[2][2]=='Y')
						break;
					else
						cube.RotateUp(cube);
				}
				
				if ((cube.Cube_L[1][2]=='Y')&&(cube.Cube_B[1][2]=='Y')&&(cube.Cube_R[1][2]=='Y'))
					// Condition 2-2: Sequence "R'UURUR'UR" 
					{strSquence= "R'UURUR'UR";
					SeqType = 22;}
				else {
					cube.RotateUpC(cube);
					if ((cube.Cube_L[1][1]=='Y')&&(cube.Cube_F[1][1]=='Y')&&(cube.Cube_R[1][1]=='Y'))
						// Condition 2-1: Sequence "RU'U'R'U'RU'R'" 
						{strSquence= "RU'U'R'U'RU'R'";
						SeqType = 21;}
					else
						System.out.println("****Error 8-2");
				}
				break;
			}
		
			case 2: {
				
				if ((cube.Cube_U[1][2]=='Y')&&(cube.Cube_U[2][1]=='Y')){
					// Condition 201: Sequence "RU'U'R'U'RU'R'"+U+"R'UURUR'UR"
					strSquence= "RU'U'R'U'RU'R'UR'UURUR'UR";
					SeqType = 201;
					if ((cube.Cube_L[1][1]=='Y')&&(cube.Cube_F[1][2]=='Y')){
						cube.RotateUpC(cube);
					}
					else {
						if ((cube.Cube_R[1][1]=='Y')&&(cube.Cube_B[1][2]=='Y'))
							cube.RotateUp(cube);
						else
							System.out.println("****Error 8-4");
						}
				}
				else {
					if ((cube.Cube_U[1][1]=='Y')&&(cube.Cube_U[2][2]=='Y')){
						// Condition 201: Sequence "RU'U'R'U'RU'R'"+U+"R'UURUR'UR"
						strSquence= "RU'U'R'U'RU'R'UR'UURUR'UR";
						SeqType = 201;
						if ((cube.Cube_L[1][2]=='Y')&&(cube.Cube_B[1][1]=='Y')){
							cube.RotateUp(cube);
							cube.RotateUp(cube);
						}
						else {
							if ((cube.Cube_F[1][1]=='Y')&&(cube.Cube_R[1][2]=='Y'))
								;
							else
								System.out.println("****Error 8-5");
						}
					}
					else {
						int rot=0;
						for (rot=0; rot<4; rot++) {
							if ((cube.Cube_R[1][1]=='Y')&&(cube.Cube_R[1][2]=='Y'))
								break;
							else
								cube.RotateUp(cube);
						}
						
						if (rot < 4){  // rot<4 means find 2 yellow cube in R11&R12.
							// Condition 203: Sequence "RU'U'R'U'RU'R'"+U2+"R'UURUR'UR"
							if ((cube.Cube_U[1][1]=='Y')&&(cube.Cube_U[2][1]=='Y'))
								{strSquence= "RU'U'R'U'RU'R'UUR'UURUR'UR";
								SeqType = 203;}
							else
								System.out.println("****Error 8-6");
						}
						else { // rot=4 means no 2 yellow cube in R11&R12, should be Fig.202
							for (rot=0; rot<4; rot++) {
								if ((cube.Cube_U[2][1]=='Y')&&(cube.Cube_U[2][2]=='Y'))
									break;
								else
									cube.RotateUp(cube);
							}
							
							if (rot < 4){  // rot<4 means find 2 yellow cube in U21&U22.
								// Condition 202: Sequence "RU'U'R'U'RU'R'"+"R'UURUR'UR"
								if ((cube.Cube_L[1][1]=='Y')&&(cube.Cube_R[1][2]=='Y'))
									{strSquence= "RU'U'R'U'RU'R'R'UURUR'UR";
									SeqType = 202;}
								else
									System.out.println("****Error 8-6");
							}
							else
								System.out.println("****Error 8-7");
						}
					}
				}		
					
				break;
			}
			
			case 4:
				break;
		
			default:
				System.out.println("****Error 8");
		}
		
		//Apply prepared sequence for step 3
		System.out.println("\n    Step 2 - Figure Type="+SeqType);
		cube.RotateCubeSequence(strSquence, cube);	//apply rotate sequence
		
		cube.CubePrint(cube);

        //Step 3: Complete all 4 sides: F,B,L and R.
		
		System.out.println("****Start Step 3");
		
		strSquence=" ";
		
		// Check if all 4 sides already recovered.
		if ((cube.Cube_F[1][1] == cube.Cube_F[1][2])&&(cube.Cube_R[1][1] == cube.Cube_R[1][2])&&
				(cube.Cube_B[1][1] == cube.Cube_B[1][2])&&(cube.Cube_L[1][1] == cube.Cube_L[1][2])) {
			//All 4 sides are already recovered
			strSquence=" ";
		}
		else
		{	
			strSquence= "RB'RFFR'BRFFRR";	// Only this 1 sequence in Step 3.
			
			do {
				// Check if has 2 same color cube in one side at upper layer.
				for (n=0; n<4; n++) {
					if (cube.Cube_F[1][1] == cube.Cube_F[1][2])
						break;
					else
						cube.RotateUp(cube);
				}
	
				if (n >= 4){  // n=4 means no 2 same cube, apply Sequence "RB'RF2R'BRF2R2" first.
					cube.RotateCubeSequence(strSquence, cube);	//apply rotate sequence
				}
			
			} while (n >= 4);
							
			cube.RotateCubeSequence(strSquence, cube);	//apply rotate sequence
			
			cube.CubePrint(cube);
		}
		
		CubeCheck(cube);
		
		cube.CubePrint(cube);
		System.out.println("   *****   Completed!   *****");
    }


    //Rotate cube when WOB cube is in position F21
    public static void RotateWOBinF21(CubeClass cube){
        switch (cube.Cube_F[2][1]){
            case 'B': break;
            case 'O': {
                cube.RotateCubeClockwise(cube);
				cube.RotateCubeClockwise(cube);
				cube.RotateCubeClockwise(cube);
				cube.RotateCubeHorizontally(cube);
				cube.RotateCubeHorizontally(cube);
				cube.RotateCubeHorizontally(cube);
				break;
            }
            case 'W': {
                cube.RotateCubeVertically(cube);
				cube.RotateCubeVertically(cube);
				cube.RotateCubeVertically(cube);
				cube.RotateCubeHorizontally(cube);
				break;
            }
        }
    }

    //Find cube position with its color combination
    public static int FindCubePos(int iCubeCode){
        for (int pos=1; pos<=8; pos++){
            if (CubeCode[pos] == iCubeCode){
                return pos;
            }
        }
        return 0;
    }

    //Calculate all corner cube position
    public static void CubeSort(CubeClass cube){
        char[] ch1 = new char[3];

        ch1[0] = cube.Cube_F[2][1];
		ch1[1] = cube.Cube_D[1][1];
		ch1[2] = cube.Cube_L[2][2];
		CubeCode[1]= iStrSumCode(ch1);

        ch1[0] = cube.Cube_F[2][2];
		ch1[1] = cube.Cube_D[1][2];
		ch1[2] = cube.Cube_R[2][1];
		CubeCode[2] = iStrSumCode(ch1);
		
		ch1[0] = cube.Cube_B[2][1];
		ch1[1] = cube.Cube_D[2][2];
		ch1[2] = cube.Cube_R[2][2];
		CubeCode[3] = iStrSumCode(ch1);
				
		ch1[0] = cube.Cube_B[2][2];
		ch1[1] = cube.Cube_D[2][1];
		ch1[2] = cube.Cube_L[2][1];
		CubeCode[4] = iStrSumCode(ch1);
		
		ch1[0] = cube.Cube_F[1][1];
		ch1[1] = cube.Cube_U[2][1];
		ch1[2] = cube.Cube_L[1][2];
		CubeCode[5] = iStrSumCode(ch1);
		
		ch1[0] = cube.Cube_F[1][2];
		ch1[1] = cube.Cube_U[2][2];
		ch1[2] = cube.Cube_R[1][1];
		CubeCode[6] = iStrSumCode(ch1);
		
		ch1[0] = cube.Cube_B[1][1];
		ch1[1] = cube.Cube_U[1][2];
		ch1[2] = cube.Cube_R[1][2];
		CubeCode[7] = iStrSumCode(ch1);
		
		ch1[0] = cube.Cube_B[1][2];
		ch1[1] = cube.Cube_U[1][1];
		ch1[2] = cube.Cube_L[1][1];
		CubeCode[8] = iStrSumCode(ch1);	

    }
    
    // Similar to get a string HashCode for compare string value
    protected static int iStrSumCode(char [] str){
        int[] iValString = new int[3];
        int i = 0;

        for (char ch : str){
            iValString[i++] = ch - 65;
        }

        int sum = 0;
        for (int j : iValString){
            sum += j * j * j + 100;
        }
        return(sum);
    }
    
	
	// Input Cube 
	protected static void CubeInput(CubeClass cube){
			

		char inputch[];
		int n;
					
		System.out.println("   *****   Cube Input   *****");	
			
		cube.CubePrint2D();
			
		System.out.println("Cube input according to above cube 2D image, 6 faces and each cubie position(11,12,21,22). ");
		System.out.println("Cubie color: W=white, O=orange, R=red, B=blue, G=green, Y=yellow.");
		System.out.println("Example: Front face Blue, Orange, White, Green, input 'BOWG'");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		{
			
				
			System.out.println("Front face:");
			inputch = (sc.next()).toCharArray();
			n = 0;
			for (int i=1; i<=2;i++) {
				for (int j=1; j<=2; j++) {
					cube.Cube_F[i][j] = inputch[n++];
				}
			}
				
			System.out.println("Left face:");
			inputch = (sc.next()).toCharArray();
			n = 0;
			for (int i=1; i<=2;i++) {
				for (int j=1; j<=2; j++) {
					cube.Cube_L[i][j] = inputch[n++];
				}
			}
				
			System.out.println("Right face:");
			inputch = (sc.next()).toCharArray();
			n = 0;
			for (int i=1; i<=2;i++) {
				for (int j=1; j<=2; j++) {
					cube.Cube_R[i][j] = inputch[n++];
				}
			}
				
			System.out.println("Up face:");
			inputch = (sc.next()).toCharArray();
			n = 0;
			for (int i=1; i<=2;i++) {
				for (int j=1; j<=2; j++) {
					cube.Cube_U[i][j] = inputch[n++];
				}
			}
				
			System.out.println("Down face:");
			inputch = (sc.next()).toCharArray();
			n = 0;
			for (int i=1; i<=2;i++) {
				for (int j=1; j<=2; j++) {
					cube.Cube_D[i][j] = inputch[n++];
				}
			}
				
			System.out.println("Back face:");
			inputch = (sc.next()).toCharArray();
			n = 0;
			for (int i=1; i<=2;i++) {
				for (int j=1; j<=2; j++) {
					cube.Cube_B[i][j] = inputch[n++];
				}
			}

			
			cube.CubePrint(cube);		
		}
	}
	
	//Final check using recursion
	protected static void CubeCheck(CubeClass cube){
		if (cube.Cube_F[1][1] != cube.Cube_F[2][1]){
			cube.RotateUp(cube);
			CubeCheck(cube);
			System.out.print("U");
		}
	}
}
