import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;

//Michael Haupt

public class arraysHW4 {

    //static int variables for column major 2D array
    final static int ARRAY_LENGTH = 50;
    final static int ARRAY_WIDTH = 20;
    final static int LIST_LENGTH = 1000;


    public static void main(String[] args) {
        String inputFile = "number_list.txt";
        int[] arrayOfNumbers1D = new int[LIST_LENGTH];
        int[][] array2DRowMaj = new int[ARRAY_LENGTH][ARRAY_WIDTH]; //create 50x20 array
        int[][] array2DColMaj = new int[ARRAY_LENGTH][ARRAY_WIDTH]; //create 50x20 array
        fillArray1D(arrayOfNumbers1D,inputFile); // fill 1D array

        for(int i = 0; i < LIST_LENGTH; i++){
            System.out.println(arrayOfNumbers1D[i]);
        }

    } //end of main

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

    // public static int findMax(int[] array){
    //
    //
    //
    // } //end of findMax
    //
    // public static int findMin(int[] array){
    //
    //
    //
    // } //findMin
    //
    // public static int[] percentChange(int[] array){
    //
    //
    // } //percentChange





} //end of arraysHW4
