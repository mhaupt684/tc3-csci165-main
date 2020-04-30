import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class Coordinate_test {

	ArrayList<Coordinate> coords = new ArrayList<Coordinate>();
	
	Random random = new Random();
	int coordRow = Math.abs(random.nextInt(100));
	int coordCol = Math.abs(random.nextInt(100));
	
	
	@Test
	void test() {
	
		for(int i = 0; i<10; i++) {
			Coordinate coord = new Coordinate(coordRow,coordCol);
			coords.add(coord);
			coordRow = Math.abs(random.nextInt(100));
			coordCol = Math.abs(random.nextInt(100));
		}
		
		coords.add(new Coordinate(0,0));
		
		Collections.sort(coords);
		
		for(Coordinate coord:coords) {
			System.out.println(coord.toString());
		}
		
		
	}
	
	

}
