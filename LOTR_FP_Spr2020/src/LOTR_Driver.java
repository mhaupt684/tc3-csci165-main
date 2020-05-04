import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class LOTR_Driver {
	
	//set the length and width of the map and the window bezzle size
	public static final int MATRIXROWS = 5;
	public static final int MATRIXCOLUMNS = 5;
	public static final int BEZZEL = 38;
	public static final int TOTALTIME = 10;
	public static final int NOHOBBITSTART = 1;
	public static final int NONAZGULSTART = 1;
	public static final int HOBBITSIGHTRADIUS = 1;
	public static final int NAZGULSIGHTRADIUS = 1;
	
	//create matrix in row major order for placing creatures at start
	public static int[][] map = new int[MATRIXROWS][MATRIXCOLUMNS];
	
	//create arraylist to hold all creatures
	public static ArrayList<Creature> creatures = new ArrayList<Creature>();
	

	public static void main(String[] args) {
		
		//make sure the array contains 0's to start
		//Arrays.fill(map,0);
		
		Hobbit hobbit = new Hobbit();
		//Nazgul nazgul = new Nazgul();
		
		creatures.add(hobbit);
		//creatures.add(nazgul);
		
		
		//loop that will run turns of the simulation
		for(int t = 0; t < TOTALTIME; t++) {
			
			//sort list of creatures so that they move in order
			Collections.sort(creatures);
			
			//take turn for each creature
			for(Creature c: creatures) {
				//if the creature is alive, then take its turn
				if(c.getAlive() == true) {
					ArrayList<Coordinate> neighborhood = new ArrayList<Coordinate>(c.scanNeighborhood(MATRIXROWS,MATRIXCOLUMNS));
					Coordinate move = new Coordinate(c.determineMove(neighborhood, creatures, MATRIXROWS,MATRIXCOLUMNS));
					c.setCoordinate(move);
				}
				
				
			}
			
			//draw the map
			EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() { 
	                Drawer ex = new Drawer(MATRIXROWS, MATRIXCOLUMNS);
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
