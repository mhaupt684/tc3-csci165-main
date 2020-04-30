import java.awt.EventQueue;
import java.util.Arrays;
import java.util.Random;

public class LOTR_Driver {
	
	//set the length and width of the map and the window bezzle size
	public static final int MATRIXROWS = 50;
	public static final int MATRIXCOLUMNS = 50;
	public static final int BEZZEL = 38;
	public static int totalTime = 10;
	
	//create matrix in row major order
	public static int[][] map = new int[MATRIXROWS][MATRIXCOLUMNS];
	

	public static void main(String[] args) {
		
		//make sure the array contains 0's to start
		Arrays.fill(map,0);
		
		
		
		//loop that will run turns of the simulation
		for(int t = 0; t < totalTime; t++) {
			
			
			
			//draw the map
			EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() { 
	                Drawer ex = new Drawer();
	                ex.setVisible(true);
	            }
	        });
		}
		
		
		
		

	}
	
	//get matrix rows
	public static int getMRows() {
		return MATRIXROWS;
	}
	
	//get matrix columns
	public static int getMCols() {
		return MATRIXCOLUMNS;
	}
	
	//get bezzle size
	public static int getBezzle() {
		return BEZZEL;
	}
	
	//return empty space in matrix to place a creature
	public static Coordinate getRandomVacantPostion() {
		boolean positionFound = false;
		Random random = new Random();
		int coordRow = Math.abs(random.nextInt(MATRIXROWS-1));
		int coordCol = Math.abs(random.nextInt(MATRIXCOLUMNS-1));
		
		while(!positionFound) {
			if(map[coordRow][coordCol] == 0) {
				positionFound = true;
				map[coordRow][coordCol] = 1;
			} else {
				coordRow = Math.abs(random.nextInt(MATRIXROWS-1));
				coordCol = Math.abs(random.nextInt(MATRIXCOLUMNS-1));
			}
			
		}
		
		Coordinate coordinate = new Coordinate(coordRow,coordCol);
		return coordinate;
	}

}
