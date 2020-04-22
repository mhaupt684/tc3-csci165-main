public class Person{

      private String fName;
      private String lName;
      private Date DOB;

      public Person ()
      {
         fName = "";
         lName = "";
         DOB = new Date(1,1,1980);
      }

      public Person(String f, String l)
      {
         fName = f;
         lName = l;
      }

      public Person(String f, String l, Date dob)
      {
         fName = f;
         lName = l;
         DOB = new Date(dob);
      }

      public Person(Person theObject)
      {
         fName = theObject.fName;
         lName = theObject.lName;
         DOB = new Date(theObject.getDOB());
      }

      public void setDOB(Date dob){
         DOB = new Date(dob);
      }

      public Date getDOB()
      {
         return new Date(DOB);
      }

      public String getFirstName()
      {
         return fName;
      }
      public String getLastName()
      {
         return lName;
      }

      public void setName(String f, String l)
      {
         fName = f;
         lName = l;
      }
      public String getName(){
    	  return fName + " " + lName;
      }

	// Equals and toStrings

	public boolean equals (Person p) {
		return this.fName.equals(p.fName) 		&&
				this.lName.equals(p.lName) 		&&
				this.DOB.equals(p.DOB);
	}

	public String toString () {
		return "Name: \t" + getName() + "\nBorn: \t" + DOB.toString();
	}

}
