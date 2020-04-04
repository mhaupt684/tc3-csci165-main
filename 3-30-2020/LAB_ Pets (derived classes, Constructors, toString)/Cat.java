public class Cat extends Pet{
    private int numLives;

    public void removeLife(){
        if(getLives() > 0) numLives -= 1;
    }

    public int getLives(){
        return numLives;
    }
    
   // TO DO: Add a constructor and toString //

}
