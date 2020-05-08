
public class PlayingCard implements Turnable {
	private boolean faceUp = true;
	private boolean turnt = false;
	
	public PlayingCard(boolean isFaceUp) {
		this.faceUp = isFaceUp;
	}
	
	public boolean getStatus() {
		return faceUp;
	}
	
	public void turn() {
		if(faceUp == false) {
			this.faceUp = true;
			this.turnt = true;
		} else {
			this.faceUp = false;
			this.turnt = true;
		}
	}
	
	@Override
	public String toString() {
		String state = "";
		if(this.faceUp == true && this.turnt == false){
			state = String.format("%s", "Card is face up");
		} else if(this.faceUp == false && this.turnt == false) {
			state = String.format("%s", "Card is face down");
		} else if(this.faceUp == true && this.turnt == true) {
			state = String.format("%s\n%s", "Turning the card face up","Card is face up");
		} else if(this.faceUp == false && this.turnt == true) {
			state = String.format("%s\n%s", "Turning the card face down","Card is face down");
		}
		return state;
	}
	
}
