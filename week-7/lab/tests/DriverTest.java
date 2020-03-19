import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class DriverTest {
	
	String[] toStrings = {
		"(1,1)",
		"(2,2)",
		"(3,3)",
		"(4,4)",
		"(5,5)",
		"(6,6)",
		"(7,7)",
		"(8,8)",
		"(9,9)",
		"(10,10)"
	};
	
	public static final int NUMOFPOINTS = 10;
	Driver driverTest = new Driver();
	
	
	@Test  //test if toString is working and formatted as intended
	void testToString() {
		driverTest.fillPointArray();
		for(int i = 0; i<NUMOFPOINTS; i++) {
			assertEquals(driverTest.points.get(i).toString(),toStrings[i]);
		}
	}

}
