import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class Hobbit_Test {

	Hobbit hobbit1 = new Hobbit();
	Coordinate coordinate = new Coordinate(0,0);
	
	@Test
	void test() {
		hobbit1.setRadius(2);
		hobbit1.setCoordinate(coordinate);
		ArrayList<Coordinate> listCoords = hobbit1.scanNeighborhood(50,50);
		
		for(Coordinate c:listCoords) {
			System.out.println(c.toString());
		}
		
		
	}

}
