
public class Pancake implements Turnable {
	private int brownPercent = 0;
	private boolean pancakeFlipped = false;
	
	
	public Pancake(int brownPercentage) {
		this.setBrown(brownPercentage);
	}
	
	public int getBrowned() {
		return this.brownPercent;
	}
	
	public void setBrown(int percentage) {
		this.brownPercent = percentage;
	}
	
	//implement Turnable to flip pancake if it is 50% - 75% brown
	public void turn() {
		if(this.brownPercent >= 50 && this.brownPercent <= 75) {
			this.brownPercent = 0;
			this.pancakeFlipped = true;
		}
	}
	
	@Override 
	public String toString() {
		String state = "";
		if(this.pancakeFlipped == false) {
			state = String.format("%s %d%s", "Pancake is", this.brownPercent,"% brown" );
		} else {
			state = String.format("%s\n%s %d%s","The pancake has been flipped","Pancake is", this.brownPercent,"% brown" );
		}
		return state;
	}
	
}
