public class Dog extends Pet {
   private String dogBreed;
   private String petType = "Dog";
   
   public Dog(String name, int age, String breed) {
	   super(name,age);
	   this.setBreed(breed);
   }

   public void setBreed(String userBreed) {
      dogBreed = userBreed;
   }

   public String getBreed() {
      return dogBreed;
   }
   
   @Override
   public String toString() {
	   String state = String.format(
			  "%s\n"
	   		+ "\t%s %s\n"
	   		+ "\t%s %s",
	   		
			   super.toString(),
			   "Type:", this.petType,
			   "Breed:", this.dogBreed
			   );
	   return state;
   }
}
