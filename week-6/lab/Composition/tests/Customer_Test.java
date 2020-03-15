import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
//Michael Haupt

class Customer_Test {
	
	Address mh = new Address("123 State Street","Ithaca","NY","14850");
	
	Customer customer1 = new Customer();
	Customer customer2 = new Customer("Michael","Haupt","mh@gmail.com", mh);
	Customer customer3 = new Customer("Michael","Haupt","mh@gmail.com", mh);
	Customer customer4 = new Customer("Michael","haupt","mh@gmail.com", mh);
	
	@Test
	void testCustomerEquals(){
		assertTrue(customer2.equals(customer3));
		assertFalse(customer3.equals(customer4));
	}
	
	@Test
	void testTrueEmail() {
		customer1.setEmail("bodonegan82@earthlink.net");
		String testCust1 = customer1.getEmail();
		assertTrue(testCust1.equals("bodonegan82@earthlink.net"));
			
	}
	
	@Test
	void testFalseEmail() {
		customer1.setEmail("bodonegan82@earthlink.netff");
		String testCust1 = customer1.getEmail();
		assertTrue(testCust1.equals("None on file"));
			
	}
	
	@Test
	void testTrueEmail2() {
		customer1.setEmail("rpoundford8x@independent.co.uk");
		String testCust1 = customer1.getEmail();
		assertTrue(testCust1.equals("rpoundford8x@independent.co.uk"));
			
	}
	
	@Test
	void testFalseEmail2() {
		customer1.setEmail("rpoundford8x@independent.co.ukuk");
		String testCust1 = customer1.getEmail();
		assertTrue(testCust1.equals("None on file"));
			
	}
	
	@Test
	void testEqualsTrue() {
		assertTrue(customer2.equals(customer3));
		assertFalse(customer2.equals(customer4));
			
	}
}
