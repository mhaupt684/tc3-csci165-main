import java.math.RoundingMode;
import java.text.DecimalFormat;

//Michael Haupt

public class Cylinder extends MyCircle {
	
	//variable for Cylinder class
	private double height = 0.0;
	private final int SQUARED = 2;
	
	
	//Constructors
	public Cylinder() { //no argument constructor
		super();
		height = 1.0;
	}
	public Cylinder(double height) { //constructor that takes given height
		super();
		this.height = height;
	}
	public Cylinder(double radius, double height) { //constructor that takes given radius and height
		super(radius);
		this.height = height;
	}
	public Cylinder(MyPoint point, double radius, double height) { //constructor that takes given MyPoint, radius, and height
		super(point,radius);
		this.height = height;
	}
	
	
	//getters
	public double getHeight() {
		return height;
	}
	
	//calculates and returns volume
	public double getVolume() { 
		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.HALF_UP);
		double expCalc = Math.pow(this.getRadius(),SQUARED);
		double calculation = Math.PI*expCalc*this.height;
		double circumference = Double.parseDouble(df.format(calculation));
		return circumference;
	}
	
	
	//setters
	public void setHeight(double height) {
		this.height = height;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		//identity check
		if(this == obj)							return true;
		//null check
		if(obj == null)							return false;
		//origin check
		if(this.getClass() != obj.getClass())	return false;
		//Down cast
		Cylinder other = (Cylinder) obj;
		if(this.height == 0.0 || this.getCenter() == null) {
			if(other.height != 0.0 || other.getCenter() != null) {
				return false;
			}
		} else if(this.height != other.height || !this.getCenter().equals(other.getCenter()) || this.getRadius() != other.getRadius()) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Cylinder [Height=" + height + " Radius=" + this.getRadius() + " Center=" + this.getCenter().toString() + " Area=" + this.getArea() + " Volume=" + this.getVolume() + "]";
	}
	
	
	
	
	
	
	
	
}
