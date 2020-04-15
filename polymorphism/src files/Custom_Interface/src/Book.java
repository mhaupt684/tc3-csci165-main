
public class Book implements Turnable {
	private int numPages = 1000;
	private int page = 0;
	private boolean pageTurn = false;
	
	//constructor
	public Book(int pageNum) {
		this.page = pageNum;
	}
	
	//get the page number
	public int getPage() {
		return page;
	}
	
	//turn the page forward 1, if you are not at the end of the book
	public void turn() {
		if(this.page < this.numPages){
			this.page += 1;
			this.pageTurn = true;
		}
	}
	
	@Override 
	public String toString() {
		String state = "";
		if(this.pageTurn == false) {
			state = String.format("%s %d","Book is on page:", this.page);
		} else {
			state = String.format("%s\n%s %d","The story has been advanced by one page","Book is on page:", this.page);
		}
		return state;
	}
	
	
}
