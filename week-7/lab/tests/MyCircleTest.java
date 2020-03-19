import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyCircleTest {
	MyCircle testNoArg = new MyCircle();
	MyCircle testGivenValues = new MyCircle(1,2,5);
	MyPoint testConstructor = new MyPoint(5,5);
	MyCircle givenMyPoint = new MyCircle(testConstructor,10);
	
	
	@Test //NoArg constructor should equal
	void testNArgConstructor() {
		int radiusResult = 1;
		assertEquals(testNoArg.getRadius(),radiusResult);
		assertEquals(testNoArg.getCenter().toString(),"(0,0)");
	}
	
	@Test //MyCircle constructor -should equal given coords and radius of MyCicle testGivenValues
	void testGivenValuesConstuctor() {
		int radiusResult = 5;
		assertEquals(testGivenValues.getRadius(),radiusResult);
		assertEquals(testGivenValues.getCenter().toString(),"(1,2)");
	}
	
	@Test //MyCircle constructor -should equal given MyPoint coords and radius of MyCicle givenMyPoint
	void testGivenMyPointConstuctor() {
		int radiusResult = 10;
		assertEquals(givenMyPoint.getRadius(),radiusResult);
		assertEquals(givenMyPoint.getCenter().toString(),"(5,5)");
	}
	
	@Test //test area method
	void testArea() {
		testGivenValues.setRadius(10);
		double areaResult = 314.159;
		assertEquals(testGivenValues.getArea(),areaResult);
	}
	
	@Test //test circumference method
	void testCircumference() {
		testGivenValues.setRadius(10);
		double circumferenceResult = 62.832;
		assertEquals(testGivenValues.getCircumference(),circumferenceResult);
	}
	
	@Test //test distance method
	void testDistance() {
		testNoArg.setCenterX(10);
		testNoArg.setCenterY(10);
		testGivenValues.setCenterXY(20, 20);
		double result = 14.142;
		assertEquals(testNoArg.distance(testGivenValues),result);
	}
	
	@Test  //test equals method
	void testEquals() {
		testNoArg.setCenterXY(10, 10);
		testGivenValues.setCenterXY(10, 10);
		testNoArg.setRadius(10);
		testGivenValues.setRadius(10);
		assertTrue(testNoArg.equals(testGivenValues));
		assertFalse(testNoArg.equals(testConstructor));
		testGivenValues.setRadius(11);
		assertFalse(testNoArg.equals(testGivenValues));
	}
	
	@Test //copy constructor test
	void testPrivacyLeak() {
		MyPoint testPoint = new MyPoint();
		MyCircle circle = new MyCircle(testPoint,1);
		assertTrue(circle.getCenter().equals(testPoint));
		assertFalse(circle.getCenter() == testPoint);
	}
	
}
