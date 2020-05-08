class Customer extends Person{

	private String custID;
	private final char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	private final int numLetters = letters.length;
	private final int idLength = 4;
			

	// Constructors
	public Customer () {
		super();
	}

	public Customer (String fName, String lName, Date dob, String custID) {
		super(fName, lName, dob);
		setID(custID);
	}

	public Customer (Customer clone) {
		super (clone);
		this.custID = clone.custID;
	}

	// Methods
	public void setID (String custID) throws MalformedIDException {
		int length = custID.length();
		if(length != idLength) throw new MalformedIDException();
		
		char[] array = custID.toCharArray();
		boolean firstLetter = false;
		int letterPosition = 0;
		Character firstChar = array[letterPosition];
		
		for(int i = 0; i < numLetters; i++) {
			if(firstChar.equals(letters[i])) firstLetter = true;
		}
		
		if(firstLetter == false) throw new MalformedIDException();
		
		for(int j = 1; j < idLength; j++) {
			try {
				int convertToInt = Integer.parseInt(Character.toString(array[j]));
			} catch(Throwable t) {
				throw new MalformedIDException();
			}
		}
		
		this.custID = custID;
		
	}

	public String getID () {
		return custID;
	}

	public String toString () {
		return 	"Name: " + getName() +
				"\nCustomer ID: " + custID;
	}

	public boolean equals (Customer c) {
		return super.equals(c) 		&&
				this.custID.equals(c.custID);
	}
}
