//Michael Haupt
public class Address {
	private String street;
	private String city;
	private String state;
	private String zip;
	
	
	//constructors
	public Address() { //no argument constructor
		super();
	}
	public Address(String street, String city, String state, String zip) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	
	//getter methods
	public String getStreet() {
		return street;
	}
	public String getZip() {
		return zip;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	
	
	//setter methods
	public void setStreet(String street) {
		this.street = street;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}

	
	//equals method
	public boolean equals(Address otherAddress) {
		return	this.street.equals(otherAddress.street) &&
				this.city.equals(otherAddress.city) &&
				this.state.equals(otherAddress.state) &&
				this.zip.equals(otherAddress.zip);
	}
	

	@Override
	public String toString() {
		String state = "";
		state = String.format("%s %s%s %s%s %s",
				"Address:",this.street,",",this.city,",",this.state
				);
		
		//"Address:" + street + "," + city + "," + state + zip;
		return state;
	}
	
	
	
}
