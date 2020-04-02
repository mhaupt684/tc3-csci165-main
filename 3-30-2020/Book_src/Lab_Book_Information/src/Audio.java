public class Audio extends Book{
   // TODO: Declare private fields
	private int length = 1;
	private String language = "";
   
   // TODO: Define Constructors
	public Audio() {}
	public Audio(String language, int length) {
		this.setLength(length);
		this.setLanguage(language);
	}
	public Audio(String title, String author, String publisher, String publishDate, String language, int length) {
		super(title,author,publisher,publishDate);
		this.setLength(length);
		this.setLanguage(language);
	}
	
   
   // TODO: Define mutator methods - 
	public void setLength(int length) {
		if(length > 0) {
			this.length = length;
		}
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
  
   // TODO: Define accessor methods -
	public int getLength() {
		return length;
	}
	public String getLanguage() {
		return language;
	}
   
   // TODO: Override toString()
	@Override
	public String toString() {
		String state = String.format("%s\n"
				+ "\t%s %s\n"
				+ "\t%s %d %s",
				
				super.toString(),
				"Language:", this.language,
				"length:", this.length, "hours"
				);
		
		return state;
	}
	
   // TODO: Override equals()
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
	    if (obj == null) return false;
	    if (getClass() != obj.getClass()) return false;
	    
	    //test if the book objects are equal
	    if(!super.equals(obj)) {
	    	return false;
	    }
		
	    //test if the audiobook info is equal
	    Audio other = (Audio) obj;
	    if (length == 0) {
	    	if (other.length != 0)
	    		return false;
	    } else if (length != other.length) {
	    	return false;
	    }
	    
	    if (this.language == null) {
	         if (other.language != null)
	            return false;
	      } else if (!this.language.equals(other.language))
	         return false;
	    
	    return true;   
	    
	}
   
   
}