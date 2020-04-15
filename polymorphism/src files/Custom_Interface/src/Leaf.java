
public class Leaf implements Turnable {
	private int month = 0;
	private String color = "brown";
	private boolean leafTurn = false;
	private String brown = "brown";
	private String green = "green";
	private String red = "red";
	
	public Leaf(int month) {
		this.month = month;
		this.setColor();
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setColor() {
		if(this.month < 6 || this.month > 10) {
			this.color = brown;
		} else if(this.month >= 6 && this.month <= 10) {
			this.color = green;
		} 
	}
	
	public void turn() {
		if(this.month == 4 || this.month == 5) {
			this.color = "green";
			this.leafTurn = true;
		} else if(this.month == 9 || this.month == 10) {
			this.color = "red";
			this.leafTurn = true;
		}
	}
	
	@Override 
	public String toString() {
		String state = "";
		if(this.leafTurn == false) {
			state = String.format("%s %s","Leaf is", this.color);
		} else if(this.leafTurn == true && this.color.equals(green)) {
			state = String.format("%s %s\n%s %s","The leaf is turning", this.color, "Leaf is", this.color);
		} else if(this.leafTurn == true && this.color.equals(red)) {
			state = String.format("%s %s\\n%s %s","The leaf is turning", this.color, "Leaf is", this.color);
		} 
		return state;
	}
}
