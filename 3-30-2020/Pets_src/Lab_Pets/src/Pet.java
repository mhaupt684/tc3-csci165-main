public class Pet {

   protected String petName;
   protected int petAge;
   
   public Pet(String name, int age) {
	   this.setName(name);
	   this.setAge(age);
   }

   public void setName(String userName) {
      petName = userName;
   }

   public String getName() {
      return petName;
   }

   public void setAge(int userAge) {
      petAge = userAge;
   }

   public int getAge() {
      return petAge;
   }
   
   @Override
   public String toString() {
	   String state = String.format(
			  "%s\n"
	   		+ "\t%s %s\n"
	   		+ "\t%s %d",
	   		
			   "Pet Information:",
			   "Name:", this.petName,
			   "Age:", this.petAge
			   );
	   
	   return state;
   }


}