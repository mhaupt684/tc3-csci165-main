import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
//Michael Haupt
class Address_Test {
	
	//instances
	Address a1 = new Address("123 State Street","Ithaca","NY","14850");
	Address a2 = new Address("123 State Street","Ithaca","NY","14850");
	Address a3 = new Address("124 State Street","Ithaca","NY","14850");

	@Test
	//test Address.equals
	void testAddressEquals() {
		//test if 2 identical addresses are equal
		assertEquals(a1.equals(a2), true);
		//test if 2 different addresses are different
		assertEquals(a2.equals(a3), false);
	}

}
