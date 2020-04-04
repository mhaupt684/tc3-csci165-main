import java.util.Scanner;

public class PetInformation {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      
      String petName, dogName, dogBreed, catName;
      int petAge, dogAge, catAge;

      petName = scnr.nextLine();
      petAge = scnr.nextInt();
      scnr.nextLine();
      dogName = scnr.next();
      dogAge = scnr.nextInt();
      scnr.nextLine();
      dogBreed = scnr.nextLine();
      catName = scnr.nextLine();
      catAge = scnr.nextInt();
      
      // TODO: Create generic pet and then print toString
      Pet myPet = new Pet(petName, petAge);
      System.out.println(myPet.toString());

      // TODO: Create dog pet and then print toString
      Dog myDog = new Dog(dogName, dogAge, dogBreed);
      System.out.println(myDog.toString());

      // TODO: Create cat pet and then print toString
      Cat myCat = new Cat(catName, catAge);
      System.out.println(myCat);
   }
}