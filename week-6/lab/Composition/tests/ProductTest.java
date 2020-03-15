import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
//Michael Haupt
class ProductTest {
	
	Product product1 = new Product("product1","off the charts",4.5,"123456rt");
	Product product2 = new Product("product1","off the charts",4.5,"123456rt");
	Product product3 = new Product("product3","off the charts",4.5,"110456rt");
	Product product4 = new Product("product4","off the charts",-4.5,"110456rt");
	
	
	//test if the skus are being setting correctly, add 0's to the end until they are 10 characters long
	@Test
	void testSetSku() {
		assertTrue(product1.equals(product2));
		assertFalse(product1.equals(product3));
		assertEquals(product3.getSku(),"110456rt00");
	}
	
	@Test
	void testSetPrice(){
		assertEquals(product3.getPrice(),4.5);
		assertEquals(product4.getPrice(),0);
	}
}
