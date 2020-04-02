public class Cat extends Pet{
    private int numLives = 9;
    private String petType = "Cat";
    
    public Cat(String name, int age) {
 	   super(name,age);
    }

    public void removeLife(){
        if(getLives() > 0) numLives -= 1;
    }

    public int getLives(){
        return numLives;
    }
    
    @Override
    public String toString() {
 	   String state = String.format(
 			  "%s\n"
 	   		+ "\t%s %s\n"
 	   		+ "\t%s %d",
 	   		
 			   super.toString(),
 			   "Type:", this.petType,
 			   "Lives:", this.getLives()
 			   );
 	   return state;
    }

}
