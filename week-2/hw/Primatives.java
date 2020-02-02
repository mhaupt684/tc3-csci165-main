//Notes
//Primitive data types - includes byte, short, int, long, float, double, boolean and char

import java.util.Scanner;

public class Primatives{
    public static void main(String[] args) {
        //#1
        //define and initialize each java primative type
        byte hw1Byte = 3;
        short hw1Short = 5;
        int hw1Int = 7;
        long hw1Long = 9;
        float hw1Float = 1.1f;
        double hw1Double = 13.13131313;
        boolean hw1Bool = true;
        char hw1Char = 'h';

        //print out java primative types
        System.out.printf(
        "byte:" + hw1Byte +
        " short:" + hw1Short +
        " int:" + hw1Int +
        " long:" + hw1Long +
        " float:" + hw1Float +
        " double:" + hw1Double +
        " boolean:" + hw1Bool +
        " char:" + hw1Char + "\n"
        );

        //Demonstrate both character and numeric literals for the char type.
        char numLit = '8';
        char charLit = 'e';
        System.out.printf("Printing the character: " + numLit + " and " + charLit +
        "\nThe ascii value of each is " + "8:" + (int)numLit + " e:" + (int)charLit);
        System.out.println("");

        //Demonstrate some widening and narrowing type casts.
        byte widenByte = 1;
        int intFromByte = (int)widenByte;
        System.out.println("Widening byte to int: " + intFromByte);
        double narrowDouble = .520349872304987;
        float doubleToFloat = (float)narrowDouble;
        System.out.println("Narrowing double to float: double:" + narrowDouble + "\nfloat:" + doubleToFloat);

        //---------
        //2. Ask the user to enter an integer and display the square, cube, and fourth power. Research the
        // Math class and use the pow method for each calculation. Use a loop if you’d like.

        int userInput;
        Scanner scanR = new Scanner(System.in);
        System.out.println("Please enter an integer: ");
        userInput = scanR.nextInt();
        System.out.println("You have entered the number " + userInput);
        for(int i = 2; i < 5; i++){
          if(i == 2){
            System.out.println("The square root of " + userInput + " is " + Math.pow(userInput,2));
          } else if(i == 3){
            System.out.println("The cubed root of " + userInput + " is " + Math.pow(userInput,3));
          } else if(i == 4){
            System.out.println("The fourth root of " + userInput + " is " + Math.pow(userInput,4));
          } else {}
        }

        //-------
        //3. Create two variables of type int. Assign these variables the maximum and minimum values of
        //this data type. Use the MIN_VALUE and MAX_VALUE defined constants in the Integer class.
        //Research the API for this.
        //3a. Print the values

        int maxInt = Integer.MAX_VALUE;
        int minInt = Integer.MIN_VALUE;

        System.out.println("maxInt: " + maxInt + " minInt " + minInt);

        // 3b. Research and experiment with the compare and compareUnsigned methods of the Integer
        // class. Demonstrate that you can call these methods correctly. Display the results along with
        // a descriptive message. Include comments that describe the issues surrounding comparing
        // signed and unsigned values.

        //Note: Returns 1 if parameter 1 > parameter 2, Returns -1 if parameter 1 < parameter 2, Returns 0 if equal. Does not return the actual difference
        System.out.println("compare(): " + Integer.compare(maxInt,minInt));
        System.out.println("compareUnsigned(): " + Integer.compareUnsigned(maxInt,minInt));
        System.out.println("compare(): " + Integer.compare(15,10));

        //-----
        // 4. Write a Java code to test whether a given double/float value is a finite floating-point value or
        // not. Research the isFinite method of the Float and Double classes. Each primitive type has an
        // associated class that contains methods that operate of values of that type. These classes are
        // called wrappers, as they wrap a primitive value with appropriate methods. A floating point
        // number is finite if it has a fixed number of fractional digits ie. a rational number. Ask the user to
        // enter two floating point numbers. Store one in a variable of type double, store the other one in a
        // variable of type float. Define the fraction 0/number and pass the result into the appropriate
        // isFinite method. Store the result of that method call into a variable of type boolean. Print the
        // result with a descriptive message using printf. Demonstrate a value that is finite and one that is
        // not.

        double userInput2;
        float userInput3;
        Scanner scanR2 = new Scanner(System.in);
        System.out.println("Please enter the first float: ");
        userInput2 = scanR2.nextDouble();
        System.out.println("Please enter the second float: ");
        userInput3 = scanR2.nextFloat();
        System.out.println("You have entered: first:" + userInput2 + " second:" + userInput3);
        boolean ui2isFinite = Double.isFinite(0/userInput2);
        boolean ui3isFinite = Float.isFinite(0/userInput3);
        boolean notFinite = Float.isFinite(userInput3/0);
        System.out.println("Is user input #1 finite: " + ui2isFinite);
        System.out.println("Is user input #2 finite: " + ui3isFinite);
        System.out.println("Is programmer's input finite: " + notFinite);

        //--------
        // 5. Ask the user to enter an integer dividend and divisor. Compute floor division and the floor
        // modulus. Use both the operators (/ and %) and the floor methods from the Math class. Look
        // this up in the API. Print the result with a descriptive message using printf

        int userInput4;
        int userInput5;
        Scanner scanR3 = new Scanner(System.in);
        System.out.println("Please enter the first int: ");
        userInput4 = scanR3.nextInt();
        System.out.println("Please enter the second int: ");
        userInput5 = scanR3.nextInt();
        System.out.println("You have entered: first:" + userInput4 + " second:" + userInput5);
        int floorDivision = Math.floorDiv(userInput4,userInput5);
        int floorModulus = Math.floorMod(userInput4,userInput5);
        //floor division gives you the maximum times the divisor can fully be divided into the dividend. floor modulus returns the remainder.
        System.out.println("floor division:" + floorDivision + " floor modulus:" + floorModulus);
        System.out.println("using / and % ->" + "division:" + (userInput4/userInput5) + " modulus:" + (userInput4%userInput5));


    }
}
