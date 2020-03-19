import java.math.RoundingMode;
import java.text.DecimalFormat;

//Michael Haupt

public class MyCircle {
	
	//variables for the MyCircle class
	private MyPoint center = new MyPoint(0,0);
	private double radius = 1.0;
	private final int SQUARED = 2;
	
	//Constructors
	public MyCircle() {} //no argument constructor
	public MyCircle(int x, int y, double radius) { //constructor takes given coords and radius
		this.center = new MyPoint(x,y);
		this.radius = radius;
	}
	public MyCircle(MyPoint center, double radius) { //constructor takes given radius and MyPoint object
		this.center = new MyPoint(center);
		this.radius = radius;
	}
	public MyCircle(double radius) { //constructor takes given radius
		this.radius = radius;
		this.center = new MyPoint();
	}
	
	
	//getters
	public MyPoint getCenter() { //privacy protected
		return new MyPoint(center);
	}
	public int getCenterX() {
		return this.center.getX();
	}
	public int getCenterY() {
		return this.center.getY();
	}
	public int[] getCenterXY() {
		return this.center.getXY();
	}
	public double getRadius() {
		return this.radius;
	}
	
	
	//setters
	public void setCenter(MyPoint center) { //privacy protected
		this.center = new MyPoint(center);
	}
	public void setCenterX(int x) {
		this.center.setX(x);
	}
	public void setCenterY(int y) {
		this.center.setY(y);
	}
	public void setCenterXY(int x, int y) {
		this.center.setXY(x, y);
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	
	//methods
	public double getArea() { //gets area of circle - PI*r^2
		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.HALF_UP);
		double expCalc = Math.pow(this.radius, SQUARED);
		double calculation = Math.PI*expCalc;
		double area = Double.parseDouble(df.format(calculation));
		return area; 
	}
	public double getCircumference() { //gets circumference of circle - 2*PI*radius 
		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.HALF_UP);
		double calculation = 2*Math.PI*this.radius;
		double circumference = Double.parseDouble(df.format(calculation));
		return circumference;
	}
	public double distance(MyCircle otherCircle) { //find the distance between two circles
		double distance = center.distance(otherCircle.center);;
		return distance;
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
		MyCircle other = (MyCircle) obj;
		//null checks
		if(this.center == null || this.radius == 0) {
			if(other.center != null || other.radius != 0) {
				return false;
			}
		} else if(this.radius != other.radius || !this.center.equals(other.center)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "MyCircle[radius=" + this.radius + ",center=" + center.toString() + "]";
	}
	
	
	
	
}
