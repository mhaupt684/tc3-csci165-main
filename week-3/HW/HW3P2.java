import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

//Michael Haupt
//Problem 2

public class HW3P2 {
    public static void main(String[] args) {

        try{
            //Initialize instance of File,Scanner,FileWriter,BufferedWriter
            File numbers = new File("numbers.txt"); //contains numbers to encode
            Scanner numbersScanner = new Scanner(numbers); //scans numbers.txt file
            BufferedWriter bw = new BufferedWriter(new FileWriter("encodedNumbers.txt")); //writes to encodedNumbers.txt file

            char[] kenSpeakArray = {'*','B','E','A','@','F','K','%','R','M'}; //correlate kenSpeak char array index values and their respective symbol

            while(numbersScanner.hasNext()){ //while there is another line to read in the numbers.txt file
                  String digits = numbersScanner.nextLine(); //takes the entire line of input from numbers.txt
                  int digitStrLen = digits.length(); //find the length of the line
                  //System.out.println(digits);

                  for(int i = 0; i < digitStrLen; i++){ //loop through all characters in the line
                    char singleCharDigit = digits.charAt(i); //save char from String location i in the string
                    int convertCharDigit =  Character.getNumericValue(singleCharDigit); //convert char to an int
                    char encodedDigit = kenSpeakArray[convertCharDigit];
                    bw.write(encodedDigit); //output
                  }
                  bw.newLine(); //input a new line
            }

            //close instances
            numbersScanner.close();
            bw.close();

        } catch(FileNotFoundException fnf){
          System.out.println("File cannot be read");
        } catch(IOException ioe){
          System.out.println("File cannot be written to");
        }


    }
}
