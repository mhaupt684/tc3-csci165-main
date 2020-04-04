public class Encyclopedia extends Book{
   // TODO: Declare private fields: edition, numVolumes
	private String edition = "";
	private int numVolumes = 1;
   
   // TODO: Define Constructors
   //       No Argument, Overloaded
	public Encyclopedia() {}
	public Encyclopedia(String edition, int volumes) {
		this.setEdition(edition);
		this.setNumVolumes(volumes);
	}
	public Encyclopedia(String title, String author, String publisher, String publishDate, String edition, int volumes) {
		super(title, author, publisher, publishDate);
		this.setEdition(edition);
		this.setNumVolumes(volumes);
	}
  
   
   // TODO: Define mutator methods - 
   //       setEdition(), setNumVolumes()
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public void setNumVolumes(int volumes) {
		this.numVolumes = volumes;
	}
   
  
   // TODO: Define accessor methods -
   //       getEdition(), getNumVolumes()
	public String getEdition() {
		return this.edition;
	}
	public int getNumVolumes() {
		return this.numVolumes;
	}
   
   
   // TODO: Override toString()
	@Override
	public String toString() {
		String state = String.format("%s\n"
				+ "\t%s%s\n"
				+ "\t%s %s",
				
				super.toString(),
				"Edition:", this.edition,
				"Number of Volumes:", this.numVolumes
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
		
	    //test if the encyclopedia info is equal
	    Encyclopedia other = (Encyclopedia) obj;
	    if (numVolumes == 0) {
	    	if (other.numVolumes != 0)
	    		return false;
	    } else if (numVolumes != other.numVolumes) {
	    	return false;
	    }
	    
	    if (this.edition == null) {
	         if (other.edition != null)
	            return false;
	      } else if (!this.edition.equals(other.edition))
	         return false;
	    
	    return true; 
	}
   
   
}