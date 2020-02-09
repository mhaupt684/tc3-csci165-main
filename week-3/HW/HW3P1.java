import java.util.Scanner;

//Michael Haupt

public class HW3P1 {
    public static void main(String[] args) {
        //Initialize instance of File,Scanner, or FileWriters
        Scanner userDigitScanner = new Scanner(System.in);

        char[] kenSpeakArray = {'*','B','E','A','@','F','K','%','R','M'}; //correlate kenSpeak char array index values and their respective symbol

        System.out.println("Problem 1 -- Please enter a sequence of base 10 digits"); //prompt the user for input
        String userDigits = userDigitScanner.nextLine(); //takes the entire line of input from the userDigits
        int digitStrLen = userDigits.length(); //find the length of the line

        for(int i = 0; i < digitStrLen; i++){ //loop through all characters in the line
          char singleCharDigit = userDigits.charAt(i); //save char from String location i in the string
          int convertCharDigit =  Character.getNumericValue(singleCharDigit); //convert char to an int
          System.out.print(kenSpeakArray[convertCharDigit]); //print the output to the terminal
        }
        System.out.println(); //move down to a new line

        userDigitScanner.close(); //close dat scanner

    }
}
