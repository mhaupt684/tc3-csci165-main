import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

class MyPointTest {
	MyPoint origin = new MyPoint();
	MyPoint givenCoords = new MyPoint(5,5);
	MyPoint zeroZero = new MyPoint(0,0);
	
	
	@Test  //NoArg Constr should set point to (0,0)
	void testNoArgConstructor() { 
		assertEquals(origin.getX(),0);
		assertEquals(origin.getY(),0);
	}
	
	@Test  //should set point to (5,5)
	void testGivCoordConstructor() { 
		assertEquals(givenCoords.getX(),5);
		assertEquals(givenCoords.getY(),5);
	}
	
	@Test  //should set and get x and y
	void testSetterXY() { 
		givenCoords.setXY(10,10);
		int[] result = {10,10};
		assertTrue(Arrays.equals(givenCoords.getXY(),result));
	}
	
	@Test  //test the toString output
	void testToStrOutput() { 
		String result = "(5,5)";
		assertEquals(givenCoords.toString(),result);
	}

	//distance method tests
	@Test  //test distance()
	void testDistance1() { 
		givenCoords.setXY(10,10);
		double result = 14.142;
		assertEquals(givenCoords.distance(),result);
	}
	
	@Test  //test distance(int x, int y)
	void testDistance2() { 
		givenCoords.setXY(10,10);
		double result = 7.071;
		assertEquals(givenCoords.distance(5,5),result);
	}
	
	@Test  //test distance(MyPoint)
	void testDistance3() { 
		givenCoords.setXY(10,10);
		double result = 14.142;
		assertEquals(givenCoords.distance(origin),result);
	}
	
	@Test  //test equals method
	void testEquals() {
		assertTrue(origin.equals(zeroZero));
		assertFalse(origin.equals(givenCoords));
	}
	
	
	
	
}
