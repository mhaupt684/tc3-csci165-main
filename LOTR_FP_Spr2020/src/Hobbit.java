import java.awt.Color;
import java.util.ArrayList;

public class Hobbit extends Creature {
	
	

	
	public Hobbit() {}
	
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
	public Coordinate determineMove(ArrayList<Coordinate> coordinates, ArrayList<Creature> allCreatures, int maxRows, int maxCols) {
		//variable to save the coordinate the is farthest away from the nazgul(s)
		Coordinate move = super.getCoordinate();
		//variable to save highest move score
		double bestScore = 0.0;
		//variable to store radius
		int radius = super.getRadius();
		double farthestCoord = radius*2; 
		
		
		//create list to hold nazgul in the neighborhood
		ArrayList<Creature> nazguls = new ArrayList<Creature>();
		
		//look through list of coordinates and check if any Nazgul are in the area
		for(Coordinate potentialMove: coordinates) {
			for(Creature potentialThreat: allCreatures) {
				if(potentialMove.equals(potentialThreat.getCoordinate()) && potentialThreat.getClass().toString().equals("class Nazgul")) {
					nazguls.add(potentialThreat);
				}
			}
		}
		
		//go through each potential move and calculate which cell is the farthest away from the nazguls
		for(Coordinate potentialMove: coordinates) {
			//highest score is the best move
			double totalScore = 0.0;
			
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
			
			//save the score and coord if it's the best move
			if(totalScore >= bestScore) {
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
	
	//use hashmap to map food counter number to color
	
	
	
}
