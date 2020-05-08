import java.util.Random;

public class Coordinate implements Comparable<Coordinate> {
	private int row = 0;
	private int column = 0;
	
	
	public Coordinate(int coordRow, int coordCol) {
		this.row = coordRow;
		this.column = coordCol;
	}
	
	public Coordinate(Coordinate other) {
		this.row = other.row;
		this.column = other.column;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getCol() {
		return this.column;
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
	
	
	public boolean equals(Coordinate other) {
		if(this == other) return true;
		if(other == null) return false;
		if(this.getClass() != other.getClass()) return false;
		if(this.row == other.row && this.column == other.column) return true;
		return false;
	}
	
	@Override
	public String toString() {
		String state = String.format("Coords (%s,%s)", row, column);
		return state;
	}
	
}
