import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Nazgul extends Creature {

	Color white = new Color(25,255,0);
	private int nazgulMaxFoodCount = 8;
	
	public Nazgul(Coordinate c) {
		super(c);
		this.determineColor();
		this.resetFoodCounter();
	}
	
	//use hashmap to map food counter number to color
	
	//attack another creature
	public void attack(Creature other) {
		
	}
	
	@Override
	public ArrayList<Coordinate> scanNeighborhood(int maxRows, int maxCols) {
		ArrayList<Coordinate> neighborhood = new ArrayList<Coordinate>();
		int numRow = maxRows;
		int numCol = maxCols;
		Coordinate homeCoord = super.getCoordinate();
		int homeRow = homeCoord.getRow();
		int homeCol = homeCoord.getCol();
		
		for(int i = (0 - super.getRadius()); i <= (0 + super.getRadius()); i++) {
			for(int j = (0 - super.getRadius()); j <= (0 + super.getRadius()); j++) {
				int row = homeRow + i;
				int column = homeCol + j;
				if(row >= 0 && row < maxRows && column >= 0 && column < maxCols) {
					Coordinate coord = new Coordinate(row,column);
					neighborhood.add(coord);
				}
			}
		}
		return neighborhood;
	}
	
	@Override
	public Coordinate determineMove(ArrayList<Coordinate> coordinates, ArrayList<Creature> allCreatures, ArrayList<Item> allItems, int maxRows, int maxCols) {
		//variable to save the coordinate the is closest to a hobbit
		Coordinate move = super.getCoordinate();
		//variable to save highest move score
		double bestScore = 0.0;
		//variable to store radius
		int radius = super.getRadius();
		double farthestCoord = radius*2;
		
		//create list to hold hobbits in the neighborhood
		ArrayList<Creature> hobbits = new ArrayList<Creature>();
		
		//look through list of coordinates and check if any hobbits are in the area
		for(Coordinate potentialMove: coordinates) {
			for(Creature potentialMeal: allCreatures) {
				if(potentialMove.equals(potentialMeal.getCoordinate()) && potentialMeal.getClass().toString().equals("class Hobbit")) {
					hobbits.add(potentialMeal);
				}
			}
		}
		
		//go through each potential move and calculate which cell is the closest to hobbit
		for(Coordinate potentialMove: coordinates) {
			//lowest score is the best move
			double totalScore = 0.0;
			
			for(Creature mealPrep: hobbits) {
				//hobbit position at x1,y1
				Coordinate hobbit = mealPrep.getCoordinate();
				double x1 = hobbit.getCol();
				double y1 = hobbit.getRow();
				
				//potential move x2, y2
				double x2 = potentialMove.getCol();
				double y2 = potentialMove.getRow();
				
				//calculate distance formula
				double distance = Math.sqrt( Math.pow( (x2-x1),2 ) + Math.pow( (y2-y1), 2 ) );
				totalScore += distance;				
			}
			
			//save the score and coord if it's the best move
			if(totalScore <= bestScore) {
				bestScore = totalScore;
				move = potentialMove;
			}
		}
		
		if(bestScore == 0.0) {
			int size = coordinates.size();
			Random random = new Random();
			int randomMove = Math.abs(random.nextInt(size-1));
			Coordinate randomMoveCoord = coordinates.get(randomMove);
			move = randomMoveCoord;
		}
		
		return move;
	}
	
	public void action(ArrayList<Creature> allCreatures, ArrayList<Creature> deadCreatures, ArrayList<Item> allItems, ArrayList<Item> takenItems) {
		Coordinate currentLocation = super.getCoordinate();
		
		for(Creature creature: allCreatures) {
			//loop through creature and kill eem
		}
	}

	@Override
	public Creature replicate(Coordinate spawnSpot) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void resetFoodCounter() {
		super.setFoodCounter(nazgulMaxFoodCount);
		
	}

	@Override
	public void resetReproductionCounter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void determineColor() {
		super.setColor(this.white);
	}

	
	
}
