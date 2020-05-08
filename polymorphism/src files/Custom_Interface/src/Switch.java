
public class Switch implements Turnable {
	private boolean on = false;
	private boolean flipped = false;
	
	public Switch(boolean switchPosition) {
		this.on = switchPosition;
	}
	
	public boolean getStatus() {
		return this.on;
	}
	
	public void turn(){
		if(on == false) {
			this.on = true;
			this.flipped = true;
		} else {
			this.on = false;
			this.flipped = true;
		}
	}
	
	@Override
	public String toString() {
		String state = "";
		if(this.on == false && this.flipped == false) {
			state = String.format("%s","Switch is off");
		} else if(this.on == true && this.flipped == false) {
			state = String.format("%s","Switch is on");
		} else if(this.on == true && this.flipped == true) {
			state = String.format("%s\n%s","Switch has been turned on","Switch is on");
		} else if(this.on == false && this.flipped == true) {
			state = String.format("%s\n%s","Switch has been turned off","Switch is off");
		}
		return state;
	}
}
