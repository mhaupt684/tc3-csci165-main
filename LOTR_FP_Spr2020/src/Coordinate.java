import java.util.Random;

public class Coordinate implements Comparable<Coordinate> {
	private int row = 0;
	private int column = 0;
	private final int matrix0 = 0;
	
	
	public Coordinate(int coordRow, int coordCol) {
		this.row = coordRow;
		this.column = coordCol;
	}
	
	
	@Override
	public int compareTo(Coordinate other) {
		if(this.row < other.row) return -1;
		if(this.row > other.row) return 1;
		if(this.row == other.row) {
			if(this.column < other.column) return -1;
			if(this.column > other.column) return 1; 
		}
		return 0;
	}
	
	@Override
	public String toString() {
		String state = String.format("Coords (%s,%s)", row, column);
		return state;
	}
	
}
