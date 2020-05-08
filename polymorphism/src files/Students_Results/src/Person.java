
public class Person {

	private Date	birthDate;
	private String 	firstName;
	private String 	lastName;

	public Person(){}

	public Person(String fName, String lName){
		firstName   = fName;
		lastName    = lName;
	}

	public Person(String fName, String lName, Date dob){
		this(fName, lName);
		this.birthDate = new Date(dob);
	}

	public Person(Person other){
		this(other.firstName, other.lastName, other.birthDate);
	}

	public Date getBirthDate(){
		return new Date(this.birthDate);
	}

	public String getName(){
		return this.firstName + " " + this.lastName;
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

		Person other = (Person) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + "\nDOB: " + birthDate;
	}
}
