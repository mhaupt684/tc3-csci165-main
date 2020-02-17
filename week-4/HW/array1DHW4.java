import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;

//Michael Haupt

public class array1DHW4 {

    final static int LIST_LENGTH = 1000;


    public static void main(String[] args) {
        String inputFile = "number_list.txt";
        int[] arrayOfNumbers1D = new int[LIST_LENGTH]; //initial 1D array

        fillArray1D(arrayOfNumbers1D,inputFile); // fill 1D array with numbers files

        //print the filled array
        for(int i = 0; i < LIST_LENGTH; i++){
            System.out.println(arrayOfNumbers1D[i]);
        }


        System.out.println("Max = " + findMax1D(arrayOfNumbers1D)); //find the max number in the array
        System.out.println("Min = " + findMin1D(arrayOfNumbers1D)); //find the min number in the array
        System.out.println("Percentage Change:");
        percentChange1D(arrayOfNumbers1D); //find the percent change and return it as an array


    } //end of main


    //****start -- 1D Array methods ****//


    // fill 1D array
    public static void fillArray1D(int[] array, String fileName){
      try{
          FileReader fA1D = new FileReader(fileName); //FileReader instance that allows us to read txt file
          Scanner scanner1D = new Scanner(fA1D); //Scanner instance that will read the FileReader by line
          int loopCounter = 0; //count the number of iterations of the while loop

          while(scanner1D.hasNext()){
              String line = scanner1D.nextLine(); //scan next line
              int convertToInt = Integer.parseInt(line); //convert string to integer
              array[loopCounter] = convertToInt; //save the integer into the 1 D array
              loopCounter ++; //increase the loop counter by 1
          }
          //close instances
          fA1D.close();
          scanner1D.close();
      }catch(IOException ioe){
          System.out.println("Cannot read file to fill 1D array");
      } //end try/catch
    } //end of fillArray


    //find maximum value in a 1D array
    public static int findMax1D(int[] array){
        int highestValue = 0; //set variable to lowest non negative value
        for(int i = 0; i < LIST_LENGTH; i++){ //loop through the 1D array
            if(array[i] > highestValue){ //if element > highestValue, save value
              highestValue = array[i];
            }
        }
        return highestValue; // return the highest value
    } //end of findMax


    //find lowest value in 1D array
    public static int findMin1D(int[] array){
        int lowestValue = 2147483647; //set variable to highest signed int value
        for(int i = 0; i < LIST_LENGTH; i++){ //if element < lowestValue, save it
            if(array[i] < lowestValue){
              lowestValue = array[i];
            }
        }
        return lowestValue; //return the lowest value


    } //findMin


    //return a list of the percent change from array element n to n+1
    public static double[] percentChange1D(int[] arrayValues){
        double[] arrayPercentChange = new double[LIST_LENGTH-1]; //create double array of percent value change

        //index 0 in double array = arrayValues[i]-arrayValues[i-1]
        //This means arrayPercentChange will have 1 less value than arrayValues
        for(int i = 0; i < LIST_LENGTH-1; i++){ // loop through arrayValues
            int change = arrayValues[i+1] - arrayValues[i]; //find the int change between two elements
            double percentChange = (double)change / (double)arrayValues[i]; //calculate percent change = change/initial value
            arrayPercentChange[i] = percentChange; //save it to the array
        }

        for(int i = 0; i < LIST_LENGTH-1; i++){ // print array
            System.out.println(arrayPercentChange[i]);
        }
        return arrayPercentChange;
    }// end percentChange


    //****end -- 1D Array methods ****//



} //end of array1DHW4
