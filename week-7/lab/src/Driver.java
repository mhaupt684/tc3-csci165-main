//Michael Haupt

import java.util.ArrayList;

public class Driver {
	public static ArrayList<MyPoint> points = new ArrayList<MyPoint>();					//ArrayList of type MyPoint
	public static final int NUMOFPOINTS = 10;
	
	public static ArrayList<MyCircle> circles = new ArrayList<MyCircle>();				//ArrayList of type MyCircle
	public static final int NUMOFCIRCLES = 10;
	
	public static ArrayList<MyCircle> cylinders = new ArrayList<MyCircle>(); 			//ArrayList of type MyCircle
	
	public static ArrayList<Object> objects = new ArrayList<Object>();					//ArrayList of type Object
	public static final int NUMOFOBJECTS = 9;
	
	public static void main(String[] args) {
			
		Driver driver = new Driver();													//instance of driver
		
		driver.fillPointArray();														//fill and print MyPoint array
		driver.printPointArray();
		
		driver.fillCircleArray();														//fill and print MyCircle array
		driver.printCircleArray();
		
		MyPoint point = new MyPoint(10,10);												//instances of Cylinder showing that constructors work
		Cylinder cylinder1 = new Cylinder();
		Cylinder cylinder2 = new Cylinder(10);
		Cylinder cylinder3 = new Cylinder(5,20);
		Cylinder cylinder4 = new Cylinder(point,30,50);
		
		System.out.println();
		System.out.println("Cylinder4 Area: " + cylinder4.getArea() + " units^2");		//use methods from MyCircle class through Cylinder object instances
		System.out.println("Cylinder4 Volume: " + cylinder4.getVolume()+ " units^3");
		System.out.println(cylinder4.toString());
		System.out.println();
		
		driver.fillCylinderArray();														//fill and print Cylinder Array
		driver.printCylinderArray();													//5 Cylinder Objects, 5 MyCircle objects
		
		MyCircle cylinder = cylinders.get(0);											//why cant I call Cylinder methods using the MyCircle class
		
		//Call a method located only in Cylinder
//		cylinder.getHeight();
//		Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
//			The method getHeight() is undefined for the type MyCircle
//
//			at Driver.main(Driver.java:39)
		
		//The compiler is saying that getHeight does not exist in the class MyCircle
		//I think we would need to downcast from MyCircle to Cylinder to use getHeight()
		
		System.out.println();
		driver.fillObjectArray();														//fill and print the Object Array
		driver.printObjectArray();
		
		//Java knows which toString to print because we overrode the toString for each subclass. 
		//toString is part of the Object class, so that's we can use it for subclasses, but we can't use
		//methods that are specific to the subclass only
		
	}

	//fill array of MyPoint
	public void fillPointArray() {
		for(int i = 0; i < NUMOFPOINTS; i++) {
			MyPoint point = new MyPoint((i+1),(i+1));
			points.add(point);
		}
	}
	
	//print array of MyPoint
	public void printPointArray() {
		for(int i = 0; i < NUMOFPOINTS; i++) {
			MyPoint point = points.get(i);
			System.out.println(point.toString());
		}
		
	}
	
	//fill array of MyCircle
	public void fillCircleArray() {
		for(int i = 0; i < NUMOFCIRCLES; i++) {
			MyPoint point = points.get(i);
			MyCircle circle = new MyCircle(point,(i+1));
			circles.add(circle);
		}
	}
	
	//print array of MyCircle
	public void printCircleArray() {
		for(int i = 0; i < NUMOFCIRCLES; i++) {
			MyCircle circle = circles.get(i);
			System.out.println(circle.toString());
		}
	}
	
	//fills the cylinder array with 5 cylinder object instances and 5 MyCircle object instances
	public void fillCylinderArray() {
		for(int i = 0; i < NUMOFCIRCLES; i++) {
			if(i%2 == 0) {
				MyCircle circle = circles.get(i);
				cylinders.add(circle);
			} else {
				Cylinder cylinder = new Cylinder(i+2,i+1);
				cylinders.add(cylinder);
			}
		}
	}
	
	//prints cylinder array
	public void printCylinderArray() {
		for(int i = 0; i < NUMOFCIRCLES; i++) {
			MyCircle cylinder = cylinders.get(i);
			System.out.println(cylinder.toString());
		}
	}
	
	//fills the object array with 3 Object objects, 3 Cylinder objects, 3 MyCircle objects
	public void fillObjectArray() {
		for(int i = 0; i < NUMOFOBJECTS; i++) {
			if(i%3 == 0) {
				MyCircle circle = circles.get(i);
				objects.add(circle);
			} else if(i%3 == 1) {
				Cylinder cylinder = new Cylinder(i+2,i+1);
				objects.add(cylinder);
			} else {
				Object obj = new Object();
				objects.add(obj);
			}
		}
	}
	
	//print object array
	public void printObjectArray() {
		for(int i = 0; i < NUMOFOBJECTS; i++) {
			Object obj = objects.get(i);
			System.out.println(obj.toString());
		}
	}
}
