import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class copyConstructorTest {
	
	Date d1 = new Date("January",4,2010);
	
	@Test
	void testClone() {
		Date clone = new Date(d1);
		assertFalse(clone == d1);
		assertTrue(clone.equals(d1));
		//assertEquals(clone.compareTo(d1),0);
	}

}
