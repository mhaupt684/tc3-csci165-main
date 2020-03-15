//Michael Haupt

public class Customer {
	private String firstName;
	private String lastName;
	private String email;
	private Address address;


	//Constructors
	public Customer() {}
	public Customer(String firstName, String lastName, String email, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.setEmail(email);												//email must be validated with setter method
		this.address = address;
	}
	public Customer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	//Getters
	public String getName() {
		String fullName = String.format("%s %s",firstName,lastName);
		return fullName;
	}
	public String getEmail() {
		return email;
	}

	
	//Setters
	public void setName(String firstName, String lastName) {
		this.firstName = firstName;
	}
	public void setEmail(String email) {
		String[] splitAt = email.split("@");								//split by @ , and save it into a String array
		int arrayLen = splitAt.length;
		int validNumOfParts = 2;
		int domain = 1;
		if(arrayLen == validNumOfParts) {									//if String array length is greater than 2 -> invalid
			String domainName = splitAt[domain];
			String[] domainArray = domainName.split("\\.");					//split String array[2] by .
			String topLevelDomain = domainArray[domainArray.length - 1];
			int tLDLength = topLevelDomain.length();						//measure length of last element in the array which should be, should be 2 or 3
			if(tLDLength == 2 || tLDLength == 3) {
				this.email = email;											//if email is valid, set to this email
			} else {
				this.email = "None on file";
			}		
		} else {															//if email is invalid, set to none
			this.email = "None on file";
		}
		
		
	}
	
	public boolean equals(Customer otherCustomer) {
		return 	this.firstName.equals(otherCustomer.firstName) &&
				this.lastName.equals(otherCustomer.lastName) &&
				this.email.equals(otherCustomer.email) &&
				this.address.equals(otherCustomer.address);
	}
	
	@Override
	public String toString() {
		String state = "";
		state = String.format("%-9s %-12s%-15s %s %-35s %s",
				"Customer:", this.firstName, this.lastName,"Email:", this.email,this.address
				);
		
		return state; 
	}
	
	
}

