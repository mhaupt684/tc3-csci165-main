import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Account_Test {
	
	//variables needed to create account
	Address mh = new Address("123 State Street","Ithaca","NY","14850");
	Date date = new Date(12,12,2018);
	Customer customer2 = new Customer("Michael","Haupt","mh@gmail.com", mh);
	Customer customer3 = new Customer("Michael","Haupt","mh@gmail.com", mh);
	Customer customer4 = new Customer("Michael","haupt","mh@gmail.com", mh);
	String id1 = "MHID234";
	double balance = 8.9;
	double balance2 = 4.5;
	double creditLimit = 0.0;
	double discountLevel = 0.0;
	
	//accounts
	Account account1 = new Account(id1,customer2,date,balance,creditLimit,discountLevel);
	Account account2 = new Account(id1,customer3,date,balance,creditLimit,discountLevel);
	Account account3 = new Account(id1,customer4,date,balance2,creditLimit,discountLevel);
	
	@Test
	void testEqualsMethod() {
		assertTrue(account1.equals(account2));
		assertFalse(account2.equals(account3));
	}
	
	@Test 
	void testCompareTo() {
		assertEquals(account1.compareTo(account2),0);
		assertEquals(account1.compareTo(account3),1);
		account3.setBalance(55.5);
		assertEquals(account1.compareTo(account3),-1);
	}
	
	
	
	

}
