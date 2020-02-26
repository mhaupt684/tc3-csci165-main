import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//Michael Haupt

class TemperatureTest {
	
	//create instances
	Temperature temp1 = new Temperature();
	Temperature temp2 = new Temperature(Temperature.Scale.C);
	Temperature temp3 = new Temperature(Temperature.Scale.F,287.3945f);
		
	//compareTo test - less than
	@Test
	void test1CompareTo() {
		temp1.setBothScaleValue(Temperature.Scale.C,25.3f);
		temp2.setValue(66.9f);
		int realResult = temp1.compareTo(temp2);
		int desiredResult = -1;
		assertEquals(desiredResult,realResult);
	}

	//compareTo test - greater than
	@Test
	void test2CompareTo() {
		temp1.setBothScaleValue(Temperature.Scale.C,205.3f);
		int realResult = temp1.compareTo(temp3);
		int desiredResult = 1;
		assertEquals(desiredResult,realResult);
	}
		
	//compareTo test - equal to
	@Test
	void test3CompareTo() {
		temp1.setBothScaleValue(Temperature.Scale.C,141.94139f);
		int realResult = temp1.compareTo(temp3);
		int desiredResult = 0;
		assertEquals(desiredResult,realResult);
	}
	
	//equals test - true
	@Test
	void equalsTrueTest() {
		temp1.setBothScaleValue(Temperature.Scale.F,287.3945f);
		boolean realResult = temp1.equals(temp3);
		boolean desiredResult = true;
		assertEquals(realResult,desiredResult);
	}
	
	//equals test - false
	@Test
	void equalsFalseTest() {
		temp1.setBothScaleValue(Temperature.Scale.F,288.3945f);
		boolean realResult = temp1.equals(temp3);
		boolean desiredResult = false;
		assertEquals(realResult,desiredResult);
	}
	
}
