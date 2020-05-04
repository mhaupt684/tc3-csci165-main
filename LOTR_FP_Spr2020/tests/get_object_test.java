import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class get_object_test {
	
	Hobbit hobbit2 = new Hobbit();
	Nazgul nazgul2 = new Nazgul();
	
	@Test
	void test() {
		ArrayList<Creature> cr = new ArrayList<Creature>();
		cr.add(hobbit2);
		cr.add(nazgul2);
		for(Creature c:cr) {
			System.out.println(c.getClass().toString());
		}
		
	}

}
