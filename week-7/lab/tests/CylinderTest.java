import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CylinderTest {
	
	MyPoint point = new MyPoint(20,20);
	Cylinder cylinderTest = new Cylinder();
	Cylinder cylinderTest1 = new Cylinder(3.0);
	Cylinder cylinderTest2 = new Cylinder(10.0, 5.0);
	Cylinder cylinderTest3 = new Cylinder(point,30,100);
	
	@Test  //test no arg constructor
	void testNArgConstructor() {
		assertEquals(cylinderTest.getHeight(),1.0);
		assertEquals(cylinderTest.getRadius(),1.0);
		assertEquals(cylinderTest.getCenter().toString(),"(0,0)");
	}

	@Test  //test constructor which takes height
	void testHeightConstructor() {
		assertEquals(cylinderTest1.getHeight(),3.0);
		assertEquals(cylinderTest1.getRadius(),1.0);
		assertEquals(cylinderTest1.getCenter().toString(),"(0,0)");
	}
	
	@Test  //test constructor which takes radius, height
	void testRadiusHeightConstructor() {
		assertEquals(cylinderTest2.getHeight(),5.0);
		assertEquals(cylinderTest2.getRadius(),10.0);
		assertEquals(cylinderTest2.getCenter().toString(),"(0,0)");
	}
	
	@Test  //test constructor which takes MyPoint, radius, height
	void testMyPointRadiusHeightConstructor() {
		assertEquals(cylinderTest3.getHeight(),100.0);
		assertEquals(cylinderTest3.getRadius(),30.0);
		assertEquals(cylinderTest3.getCenter().toString(),"(20,20)");
	}
	
	@Test  //test constructor which takes MyPoint, radius, height
	void testMyPointRadiusHeight_getVolume() {
		cylinderTest3.setHeight(97.456);
		assertEquals(cylinderTest3.getVolume(),275550.348);
		
	}
	
	@Test  //test equals method
	void testEquals() {
		cylinderTest.setCenterXY(20,20);
		cylinderTest.setRadius(30);
		cylinderTest.setHeight(100);
		assertTrue(cylinderTest.equals(cylinderTest3));
		assertFalse(cylinderTest.equals(cylinderTest1));
		cylinderTest.setRadius(29);
		assertFalse(cylinderTest.equals(cylinderTest3));
		cylinderTest.setRadius(30);
		cylinderTest.setHeight(99);
		assertFalse(cylinderTest.equals(cylinderTest3));
		
	}
	
	
	
	
	
	
}
