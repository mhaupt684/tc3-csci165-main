import java.awt.Color;
import java.util.ArrayList;

public abstract class Creature implements Comparable<Creature> {
	
	//abstract classes exist to be extended, they cannot be instantiated
	
	//Creature variables
	private Coordinate coordinate = new Coordinate(0,0);
	private Color color = new Color(0,0,0);
	private int radius = 1;
	private boolean alive = true;
	private int reproduceCounter = 0;
	private int foodCounter = 0;
	
	
	//Creature Constructors
	public Creature(Coordinate c) {
		this.setCoordinate(c);
	}
	
	
	
	//**getters**
	public boolean getAlive() {
		return this.alive;
	}
	
	public int getRadius() {
		return this.radius;
	}
	
	public Coordinate getCoordinate() {
		Coordinate coord = new Coordinate(this.coordinate);
		return coord;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public int getFoodCounter() {
		return this.foodCounter;
	}
	
	public int getReproduceCounter() {
		return this.reproduceCounter;
	}
	
	
	
	//**setters**
	public void setAliveFalse() {
		this.alive = false;
	}
	
	//set the creatures radius
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	//set color
	public void setColor(Color color) {
		this.color = color;
	}
	
	//set Coordinate
	public void setCoordinate(Coordinate newCoordinate) {
		this.coordinate = new Coordinate(newCoordinate);
	}
	
	//set food counter
	public void setFoodCounter(int maxCount) {
		this.foodCounter = maxCount;
	}
	
	//set reproduce counter
	public void setReproductionCounter(int maxCount) {
		this.reproduceCounter = maxCount;
	}
	
	
	//diminish counter by 1
	public void countDown() {
		this.reproduceCounter -= 1;
		this.foodCounter -= 1;
	}
	
	//move to another location
	public void move(Coordinate move) {
		this.setCoordinate(move);
	}
		
	//**Creature abstract methods**
	
	//scan the neighborhood and return a list of Coordinates
	public abstract ArrayList<Coordinate> scanNeighborhood(int maxRows, int maxCols);
	
	//move a creature -- must be implemented by sub class
	public abstract Coordinate determineMove(ArrayList<Coordinate> coordinates, ArrayList<Creature> allCreatures, ArrayList<Item> allItems, int maxRows, int maxCols);
	
	//replicate -- must be implemented by sub class
	public abstract Creature replicate(Coordinate spawnSpot);
	
	//action - basically hurt or consume\
	public abstract void action(ArrayList<Creature> allCreatures, ArrayList<Creature> deadCreatures, ArrayList<Item> allItems, ArrayList<Item> takenItems);
	
	//reset food counter
	public abstract void resetFoodCounter();
	
	//reset reproduction counter
	public abstract void resetReproductionCounter();
	
	//determine color
	public abstract void determineColor();
	
	
	
	
	@Override
	public int compareTo(Creature other) {
		if(this.coordinate.compareTo(other.coordinate) < 0) return -1;
		if(this.coordinate.compareTo(other.coordinate) > 0) return 1;
		return 0;
	}
	
	
	
	
	
}
