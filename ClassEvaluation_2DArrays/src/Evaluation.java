/**
 * 
 */
import java.util.concurrent.ThreadLocalRandom;
/**
 * @author L_Lunatic
 *
 */
public class Evaluation {
	
	public static void main(String[] args){
		int[][] marksForStudents = new int[4] [6];
		int rows, columns;
		
		for (columns = 0; columns < 6; columns ++){
			for (rows = 0; rows < 4; rows ++){
				int rdnMarks = ThreadLocalRandom.current().nextInt(0, 100 + 1);
				marksForStudents [rows][columns] = rdnMarks;
			}	
		}
		
		for (columns = 0; columns < 6; columns ++){
			for (rows = 0; rows < 4; rows ++){
				System.out.print(marksForStudents[4][6] + " ");
			}
			System.out.println();
		}
	}
	
}
