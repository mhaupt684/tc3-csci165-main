
public class Food extends Item {
	private String[] pickupAble = {"class Hobbit"};
	private double worth = .24;
	
	public Food(Coordinate c) {
		super(c);
	}
	
	//get the worth of this item
	public double getWorth() {
		return this.worth;
	}
	
	//get which creatures can take the item
	public String[] getPickupAble() {
		return this.pickupAble;
	}
	
	
}
