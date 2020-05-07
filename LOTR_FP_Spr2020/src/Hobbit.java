import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Hobbit extends Creature {
	
	Color green = new Color(0,128,0);
	private int hobbitMaxFoodCount = 3;
	private int hobbitMaxRepCount = 3;

	
	public Hobbit(Coordinate c) {
		super(c);
		this.determineColor();
		this.resetFoodCounter();
		this.resetReproductionCounter();
	}
	
	//scan the neighborhood and return a list of Coordinates
	@Override
	public ArrayList<Coordinate> scanNeighborhood(int maxRows, int maxCols){
		ArrayList<Coordinate> neighborhood = new ArrayList<Coordinate>();
		int numRow = maxRows;
		int numCol = maxCols;
		Coordinate homeCoord = super.getCoordinate();
		int homeRow = homeCoord.getRow();
		int homeCol = homeCoord.getCol();
		
				
		for(int i = (0 - super.getRadius()); i <= (0 + super.getRadius()); i++) {
			for(int j = (0 - super.getRadius()); j <= (0 + super.getRadius()); j++) {
				int row = ((homeRow + i)%numRow+numRow)%numRow;
				int column = ((homeCol + j)%numCol+numCol)%numCol;
				Coordinate coord = new Coordinate(row,column);
				neighborhood.add(coord);
			}
		}

		return neighborhood;
	}
	
	
	@Override
	public Coordinate determineMove(ArrayList<Coordinate> coordinates, ArrayList<Creature> allCreatures, ArrayList<Item> allItems, int maxRows, int maxCols) {
		//variable to save the coordinate the is farthest away from the nazgul(s)
		Coordinate move = super.getCoordinate();
		//variable to save highest move score
		double bestScore = 0.0;
		//variable to store radius
		int radius = super.getRadius();
		double farthestCoord = radius*2; 
		
		
		//create list to hold nazgul in the neighborhood
		ArrayList<Creature> nazguls = new ArrayList<Creature>();
		ArrayList<Coordinate> otherCreatureCoords = new ArrayList<Coordinate>();
		
		//look through list of coordinates and check if any Nazgul/hobbit are in the area
		for(Coordinate potentialMove: coordinates) {
			for(Creature potentialThreat: allCreatures) {
				if(potentialMove.equals(potentialThreat.getCoordinate()) && potentialThreat.getClass().toString().equals("class Nazgul")) {
					nazguls.add(potentialThreat);
					otherCreatureCoords.add(potentialThreat.getCoordinate());
				} else if (potentialMove.equals(potentialThreat.getCoordinate()) && potentialThreat.getClass().toString().equals("class Hobbit")) {
					otherCreatureCoords.add(potentialThreat.getCoordinate());
				}
			}
		}
		
		//remove coords that have hobbit already
		coordinates.removeAll(otherCreatureCoords);
		
		//go through each potential move and calculate which cell is the farthest away from the nazguls
		for(Coordinate potentialMove: coordinates) {
			//highest score is the best move
			double totalScore = 0.0;
			
			//this loop calculates points by distance from a nazgul
			for(Creature escapeDanger: nazguls) {
				//nazgul position at x1,y1
				Coordinate nazgul = escapeDanger.getCoordinate();
				double x1 = nazgul.getCol();
				double y1 = nazgul.getRow();
				
				//potential move x2, y2
				double x2 = potentialMove.getCol();
				double y2 = potentialMove.getRow();
				
				//determine if a possible move is wrapping around the array. if so, then adjust it to reflect the true distance
				if(x2-x1 > farthestCoord) x2 -= maxCols;
				if(x2-x1 < farthestCoord*(-1)) x2 += maxCols;
				if(y2-y1 > farthestCoord) y2 -= maxRows;
				if(y2-y1 < farthestCoord*(-1)) y2 += maxRows;
				
				
				//calculate distance formula
				double distance = Math.sqrt( Math.pow( (x2-x1),2 ) + Math.pow( (y2-y1), 2 ) );
				totalScore += distance;				
			}
			
			//this loop calculates point by whether or not food exists
			for(Item item: allItems) {
				Coordinate itemCoord = item.getCoordinate();
				if(potentialMove.equals(itemCoord)) {
					//specific item worth*maxfood counter / food counter
					totalScore += (item.getWorth()*this.hobbitMaxFoodCount)/super.getFoodCounter();
				}
			}
			
			
			//figure out what to do if there are no nazgul or food
			
			//save the score and coord if it's the best move
			if(totalScore >= bestScore) {
				bestScore = totalScore;
				move = potentialMove;
			}
		}	
		
		//if every square has a score of 0 and there is no winner. pick move randomly
		if(bestScore == 0.0) {
			int size = coordinates.size();
			Random random = new Random();
			int randomMove = Math.abs(random.nextInt(size-1));
			Coordinate randomMoveCoord = coordinates.get(randomMove);
			move = randomMoveCoord;
		}
		
		return move;
	}
	
	@Override
	public void action(ArrayList<Creature> allCreatures, ArrayList<Creature> deadCreatures, ArrayList<Item> allItems, ArrayList<Item> takenItems) {
		Coordinate currentLocation = super.getCoordinate();
		
		for(Item item: allItems) {
			if(currentLocation.equals(item.getCoordinate())) {
				String[] creatureAbleToPickUp = item.getPickupAble();
				for(String creature: creatureAbleToPickUp) {
					String className = this.getClass().toString();
					if(creature.equals(className)) {
						takenItems.add(item);
						//different items can be added in if else statement
						if(item.getClass().toString().equals("class Food")) {
							this.resetFoodCounter();
						}
					}
				}
			}
		}
	}

	@Override
	public Creature replicate(Coordinate spawnSpot) {
		Hobbit newHobbit = new Hobbit(spawnSpot);
		return newHobbit;
	}


	@Override
	public void resetFoodCounter() {
		super.setFoodCounter(hobbitMaxFoodCount);
	}

	@Override
	public void resetReproductionCounter() {
		super.setReproductionCounter(hobbitMaxRepCount);
		
	}

	@Override
	public void determineColor() {
		super.setColor(this.green);
	}
	
	
	
	
	
}
