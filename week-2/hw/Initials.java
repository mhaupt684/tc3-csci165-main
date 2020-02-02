import java.util.Scanner;

//Michael Haupt

public class Initials {
    public static void main(String[] args) {
        Scanner scanNames = new Scanner(System.in); //create Scanner instance
        System.out.println("Please enter your first name.");
        String firstName = scanNames.nextLine(); //save user input to string
        System.out.println("Please enter your last name.");
        String lastName = scanNames.nextLine(); //save user input to string
        char lNChar = lastName.charAt(0);
        String fullName = firstName + lastName; //concatenate two name strings into full name.
        char fLetfName = fullName.charAt(0); //slice the character at position x
        char fLetLName = fullName.charAt(fullName.indexOf(lNChar)); //get the index of 'H' and then slice the char at that index
        int unicodeLetSum = 0; //initialize count for unicode sum at 0

        System.out.println("Initials: " + fLetfName + " " + fLetLName);

        for(int i = 0; i < fullName.length();i++){ //print each character in the full name
            System.out.print(fullName.charAt(i)); //print the character
            System.out.println(" Unicode Value: " + (int)fullName.charAt(i)); //print the unicode sum for the given character
            unicodeLetSum += (int)fullName.charAt(i); //add to the unicode sum
        }

        System.out.println("unicode sum: " + unicodeLetSum); //print the unicode sum

        //chars for the next example
        char M = 'M';
        char i = 'i';
        char c = 'c';
        char h = 'h';
        char a = 'a';
        char e = 'e';
        char l = 'l';

        //concatenate chars into string
        String myName = String.valueOf(M) + String.valueOf(i) + String.valueOf(c) + String.valueOf(h) + String.valueOf(a) + String.valueOf(e) + String.valueOf(l);

        //print String made up of chars
        System.out.println(myName);






    }
}
