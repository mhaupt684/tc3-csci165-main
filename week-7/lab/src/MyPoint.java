//Michael Haupt

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MyPoint {
	//variables for the MyPoint class
	private int x = 0;
	private int y = 0;
	private final int originX = 0;
	private final int originY = 0;
	private final int powerOfTwo = 2;
	
	//Constructors
	public MyPoint(){} //no argument constructor
	public MyPoint(int x, int y) { //constructor takes given coords
		this.x = x;
		this.y = y;
	}
	public MyPoint(MyPoint point) { //copy constructor
		this.x = point.x;
		this.y = point.y;
	}
	
	//getters
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int[] getXY() {
		int[] coordinates = {this.x,this.y};
		return coordinates;
	}
	
	
	//setters
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setXY(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	//methods
	public double distance() { //returns distance from this.point to 0,0
		double distance = distanceFormula(originX,originY,this.x,this.y);
		return distance;
	}
	
	public double distance(int x, int y) { //returns distance from a given point
		double distance = distanceFormula(x,y,this.x,this.y);
		return distance;
	}
	
	public double distance(MyPoint otherPoint) { //returns distance from another MyPoint object instance
		double distance = distanceFormula(otherPoint.x,otherPoint.y,this.x,this.y);
		return distance;
	}
	
	//calculates and return the distance between 2 points
	private double distanceFormula(int x1, int y1, int x2, int y2) {
		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.HALF_UP);
		double expCalc = Math.pow(Math.abs(x2-x1),powerOfTwo) + Math.pow(Math.abs(y2-y1),powerOfTwo);
		double sqrtCalc = Math.sqrt(expCalc);
		double distance = Double.parseDouble(df.format(sqrtCalc));
		return distance;
	}
	
	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
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
		MyPoint other = (MyPoint) obj;
		//null checks
		if(this.x == 0 || this.y == 0) {
			if(other.x != 0 || other.y != 0) {
				return false;
			}
		} else if(this.x != other.x || this.y != other.y) {
			return false;
		}
		return true;
		
	}
	
	
	
}
