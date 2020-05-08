import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class Nazgul_Test {
	
	Coordinate coordinate = new Coordinate(0,0);
	Nazgul nazgul1 = new Nazgul(coordinate);
	
	
	@Test
	void test() {
		nazgul1.setRadius(1);
		nazgul1.setCoordinate(coordinate);
		ArrayList<Coordinate> listCoords = nazgul1.scanNeighborhood(50, 50);
		
		for(Coordinate c:listCoords) {
			System.out.println(c.toString());
		}
		
		nazgul1.setCoordinate(new Coordinate(49,49));
		listCoords = nazgul1.scanNeighborhood(50, 50);
		for(Coordinate c:listCoords) {
			System.out.println(c.toString());
		}
	}

}
