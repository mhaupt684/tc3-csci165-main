import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LOTR_Driver {
	
	//set the length and width of the map and the window bezzle size
	public static final int MATRIXROWS = 20;
	public static final int MATRIXCOLUMNS = 20;
	public static final int BEZZEL = 38;
	public static final int TOTALTIME = 5;
	public static final int NOHOBBITSTART = 1;
	public static final int NONAZGULSTART = 1;
	public static final int NOFOODSTART = 5;
	public static final int FOODRESPAWNNO = 2;
	public static final int HOBBITSIGHTRADIUS = 1;
	public static final int NAZGULSIGHTRADIUS = 1;
	
	//create matrix in row major order for placing creatures at start
	public static int[][] map = new int[MATRIXROWS][MATRIXCOLUMNS];
	
	//create arraylist to hold all creatures
	public static ArrayList<Creature> creatures = new ArrayList<Creature>();
	
	//create arraylist to hold all items
	public static ArrayList<Item> items = new ArrayList<Item>();
	

	public static void main(String[] args) {
		
		//fill the playing field
		fillPlayingField();
		
		//loop that will run turns of the simulation
		for(int t = 0; t < TOTALTIME; t++) {
			
			//make sure the array contains all 0's
			for(int[] row : map) {
				Arrays.fill(row, 0);
			}
			
			//sort list of creatures 
			Collections.sort(creatures);
			
			//**write 1 where objects are in the matrix
			for(Creature c: creatures) {
				int row = c.getCoordinate().getRow();
				int column = c.getCoordinate().getCol();
				map[row][column] = 1;
			}
			
			//list to hold new creatures, built every loop
			ArrayList<Creature> newCreatures = new ArrayList<Creature>();
			
			//**reproduce and place new characters where necessary
			for(Creature c: creatures) {
				if(c.getReproduceCounter() == 0) {
					ArrayList<Coordinate> neighborhood = c.scanNeighborhood(MATRIXROWS, MATRIXCOLUMNS);
					boolean spaceAvailable = false;
					int row = 0;
					int column = 0;
					for(Coordinate space: neighborhood) {
						row = space.getRow();
						column = space.getCol();
						if(map[row][column] == 0) {
							spaceAvailable = true;
						}
					}
					if(spaceAvailable == true) {
						Coordinate spawn = c.determineMove(neighborhood, creatures, items, MATRIXROWS, MATRIXCOLUMNS);
						Creature newCreature = c.replicate(spawn);
						newCreatures.add(newCreature);
						row = newCreature.getCoordinate().getRow();
						column = newCreature.getCoordinate().getCol();
						map[row][column] = 1;
					}					
				}
			}
			
			//add new creatures to the all creatures
			creatures.addAll(newCreatures);
			
			//sort list of creatures so that they move in order
			Collections.sort(creatures);
			 
			//list to hold dead creatures
			ArrayList<Creature> dead = new ArrayList<Creature>();
			//list to hold taken items
			ArrayList<Item> takenItems = new ArrayList<Item>();
			
			//take turn for each creature
			for(Creature c: creatures) {
				//check if the creatures food counter is 0 , add to dead
				if(c.getFoodCounter() == 0) c.setAliveFalse();
				//if reproduce counter is 0, then reproduce
				
				//if the creature is alive, then take its turn
				if(c.getAlive() == true) {
					ArrayList<Coordinate> neighborhood = new ArrayList<Coordinate>(c.scanNeighborhood(MATRIXROWS,MATRIXCOLUMNS));
					Coordinate move = new Coordinate(c.determineMove(neighborhood, creatures, items, MATRIXROWS,MATRIXCOLUMNS));
					c.move(move);
					c.countDown();
					c.action(creatures, dead, items, takenItems);
					
				} else {
					dead.add(c);
				}				
			}
			
			//make collection of dead creatures while going through the loop
			//then remove them from the creatures list
			creatures.removeAll(dead);
			
			//make collection of taken items and remove
			items.removeAll(takenItems);
			
			//draw the map
			EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() { 
	                Drawer ex = new Drawer(MATRIXROWS, MATRIXCOLUMNS);
	                ex.setVisible(true);
	            }
	        });
			
			//wait one second
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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
	
	
	//fill up the playing field
	public static void fillPlayingField() {
		//make sure the array contains all 0's to start
		for(int[] row : map) {
			Arrays.fill(row, 0);
		}
	
		//fill the playing field with hobbits, randomly selected start
		for(int i = 0; i < NOHOBBITSTART; i++) {
			Coordinate startingPosition = new Coordinate(getRandomVacantPostion());
			Hobbit hobbit = new Hobbit(startingPosition);
			creatures.add(hobbit);
		}
		
		//fill the playing field with nazgul, randomly selected start
		for(int i = 0; i < NONAZGULSTART; i++) {
			Coordinate startingPosition = new Coordinate(getRandomVacantPostion());
			Nazgul nazgul = new Nazgul(startingPosition);
			creatures.add(nazgul);
		}
		
		//fill the playing field with item, randomly selected start
		for(int i = 0; i < NOFOODSTART; i++) {
			Coordinate startingPosition = new Coordinate(getRandomVacantPostion());
			Food food = new Food(startingPosition);
			items.add(food);
		}
		
		//**start Gandolf
		
		//**start eagle
	}
	
	

}
