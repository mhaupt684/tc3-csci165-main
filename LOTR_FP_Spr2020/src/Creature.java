import java.awt.Color;

public class Creature implements Comparable<Creature> {
	
	//Creature variables
	private int counter = 0;
	private Color color = null;
	private Coordinate coordinate = null;
	
	
	//Creature Constructors
	public Creature() {}
	
	
	//Creature methods
	
	//move a creature
	public void move() {
		
	}
	
	//attack another creature
	public void attack(Creature other) {
		
	}
	
	//replicate
	public Creature replicate() {
		Creature creature = new Creature();
		return creature;
	}
	
	@Override
	public int compareTo(Creature other) {
		if(this.coordinate.compareTo(other.coordinate) < 0) return -1;
		if(this.coordinate.compareTo(other.coordinate) > 0) return 1;
		return 0;
	}
	
	
	
}
