import java.awt.Color;
import java.util.ArrayList;

public class Nazgul extends Creature {

	
	public Nazgul() {}
	
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
	public Coordinate determineMove(ArrayList<Coordinate> coordinates, ArrayList<Creature> allCreatures, int maxRows, int maxCols) {
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
		
		return move;
	}

	@Override
	public Creature replicate() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void resetFoodCounter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetReproductionCounter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Color determineColor() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
