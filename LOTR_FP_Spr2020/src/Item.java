
public abstract class Item implements Comparable<Item>{

	private Coordinate coordinate = new Coordinate(0,0);
	
	public Item(Coordinate c) {
		this.setCoordinate(c);
	}
	
	
	//get item Coordinate
	public Coordinate getCoordinate() {
		Coordinate coord = new Coordinate(this.coordinate);
		return coord;
	}
	
	//get specific item worth from subclass
	public abstract double getWorth();
	
	//get which creatures can pick item up
	public abstract String[] getPickupAble();
	
	
	//set Coordinate
	public void setCoordinate(Coordinate newCoordinate) {
		this.coordinate = new Coordinate(newCoordinate);
	}
	
	
	@Override
	public int compareTo(Item other) {
		if(this.coordinate.compareTo(other.coordinate) < 0) return -1;
		if(this.coordinate.compareTo(other.coordinate) > 0) return 1;
		return 0;
	}
}
