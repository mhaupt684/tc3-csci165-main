import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;

//Michael Haupt

public class array2DHW4{

    //static int variables for column major 2D array
    final static int ROWS = 50;
    final static int COLUMNS = 20;


    public static void main(String[] args) {
        String inputFile = "number_list.txt";
        int[][] rowMajor = new int[ROWS][COLUMNS]; //create row major array
        int[][] columnMajor = new int[ROWS][COLUMNS]; //create column major array

        fillMatrix2DRowMaj(rowMajor,inputFile); //fill the array using row major
        fillMatrix2DColMaj(columnMajor,inputFile); //fill the array using column major
        printRow(columnMajor,3,COLUMNS); //user input required for which row you want to print
        printAllRows(rowMajor); //print all rows in a matrix
        printAllColumns(columnMajor); //print all columns in a matrix

        System.out.println("\nMax in entire 2d matrix: " + findMax(rowMajor));
        System.out.println("Min in entire 2d matrix: " + findMin(rowMajor));

        System.out.println("Row index with the least change: " + smallestChange(rowMajor));

    } //end of main

    //find the row with the smallest amount of change
    public static int smallestChange(int[][] matrix){
        int rowIndex = 0; //row index of the row with the least change
        int[] changeArray = new int[ROWS]; //array to save total change for each row
        int leastChange = 2147483647; //set leastChange to the highest int value
        for(int i = 0; i < ROWS; i++){ //iterate through each row
            int totalChange = 0; //create int to keep track of total change for current row
            for(int j = 0; j < COLUMNS-1; j++){ //iterate through each column of 1 row
                int change = Math.abs(matrix[i][j] - matrix[i][j+1]); //calculate the absolute value of the change from element n to n+1
                totalChange += change; //add the change to the total change for the current row
            }
            changeArray[i] = totalChange; //save total change for this row into the array
            if(changeArray[i] < leastChange){ //if current total change for this row is less
                leastChange = changeArray[i]; //set the new value for leastChange
                rowIndex = i; //save the current row number as the row
            }
        }
        return rowIndex;
    }

    //print all columns in a given matrix
    public static void printAllColumns(int[][] matrix){
      for(int i = 0; i < COLUMNS; i++){ //iterate through columns
          System.out.println("\nColumn " + i);
          System.out.println("Highest in Column: " + findMaxOfColumn(matrix,i)); //print max value of column
          System.out.println("Lowest in Column: " + findMinOfColumn(matrix,i)); //print max value of column
          for(int j = 0; j < ROWS; j++){ //iterate through rows
              System.out.print(matrix[j][i]+" "); //print element

          }
      }
    }

    //print all rows in a given matrix
    public static void printAllRows(int[][] matrix){
        for(int i = 0; i < ROWS; i++){ //iterate through rows
            System.out.println("\nRow " + i);
            System.out.println("Highest in Row: " + findMaxOfRow(matrix,i)); //print max value of row
            System.out.println("Lowest in Row: " + findMinOfRow(matrix,i)); //print min value of column
            for(int j = 0; j < COLUMNS; j++){ //iterate through columns
                System.out.print(matrix[i][j]+" "); //print element
            }
        }
    }

    //print a single row chosen by the user
    public static void printRow(int[][] matrix, int row, int num_cols){
        System.out.println("Row " + row + ":");
        for(int i = 0; i < num_cols; i++){ //print the array row
            System.out.print(matrix[row][i] + " ");
        }
        System.out.println("");
    }

    //fill 2D matrix row major style
    public static void fillMatrix2DRowMaj(int[][] matrix, String fileName){
        try{
            FileReader numArray = new FileReader(fileName); //FileReader instance that allows us to read txt file
            Scanner scanner2D = new Scanner(numArray); //Scanner instance that will read the FileReader by line

            for(int i = 0; i < ROWS; i++){
                for(int j = 0; j < COLUMNS; j++){
                    String line = scanner2D.nextLine(); //scan next line
                    int convertToInt = Integer.parseInt(line); //convert string to integer
                    matrix[i][j] = convertToInt;
                }
            }
            //close instances
            numArray.close();
            scanner2D.close();
        }catch(IOException ioe){
            System.out.println("Cannot read file to fill 2D array - Row Major");
        }

    } //end of fillArray2DRow

    //fill 2D matrix column major style
    public static void fillMatrix2DColMaj(int[][] matrix, String fileName){
        try{
            FileReader numArray = new FileReader(fileName); //FileReader instance that allows us to read txt file
            Scanner scanner2D = new Scanner(numArray); //Scanner instance that will read the FileReader by line

            for(int i = 0; i < COLUMNS; i++){
                for(int j = 0; j < ROWS; j++){
                    String line = scanner2D.nextLine(); //scan next line
                    int convertToInt = Integer.parseInt(line); //convert string to integer
                    matrix[j][i] = convertToInt;
                }
            }
            //close instances
            numArray.close();
            scanner2D.close();
        }catch(IOException ioe){
            System.out.println("Cannot read file to fill 2D array - Column Major");
        }

    } //end of fillArray2DColMaj

    //find maximum value in a 2D matrix
    public static int findMax(int[][] matrix){
        int highestValue = 0; //set variable to lowest non negative value
        for(int i = 0; i < ROWS; i++){ //loop through the 2D array
            for(int j = 0; j < COLUMNS; j++){
                if(matrix[i][j] > highestValue){ //if element > highestValue, save value
                  highestValue = matrix[i][j];
                }

            } //end nested

        } //end outer
        return highestValue; // return the highest value
    } //end of findMax

    //find minimum value in a 2D matrix
    public static int findMin(int[][] matrix){
        int lowestValue = 2147483647; //set variable to highest signed integer value
        for(int i = 0; i < ROWS; i++){ //loop through the 2D array
            for(int j = 0; j < COLUMNS; j++){
                if(matrix[i][j] < lowestValue){ //if element > highestValue, save value
                  lowestValue = matrix[i][j];
                }

            } //end nested

        } //end outer
        return lowestValue; // return the lowest value
    } //end of findMin

    //find maximum value in a 2D matrix row
    public static int findMaxOfRow(int[][] matrix, int row){
        int highestValue = 0; //set variable to lowest non negative value
        for(int i = 0; i < COLUMNS; i++){ //loop through the 2D array row
            if(matrix[row][i] > highestValue){ //if element > highestValue, save value
              highestValue = matrix[row][i];
            }
        } //end outer
        return highestValue; // return the highest value
    } //end of findMaxofRow

    //find minimum value in a 2D matrix row
    public static int findMinOfRow(int[][] matrix, int row){
        int lowestValue = 2147483647; //set variable to lowest non negative value
        for(int i = 0; i < COLUMNS; i++){ //loop through the 2D array row
            if(matrix[row][i] < lowestValue){ //if element > highestValue, save value
              lowestValue = matrix[row][i];
            }
        } //end outer
        return lowestValue; // return the highest value
    } //end of findMinofRow

    //find maximum value in a 2D matrix column
    public static int findMaxOfColumn(int[][] matrix, int column){
        int highestValue = 0; //set variable to lowest non negative value
        for(int i = 0; i < ROWS; i++){ //loop through the 2D array column
            if(matrix[i][column] > highestValue){ //if element > highestValue, save value
              highestValue = matrix[i][column];
            }
        } //end outer
        return highestValue; // return the highest value
    } //end of findMaxofColumn

    //find minimum value in a 2D matrix column
    public static int findMinOfColumn(int[][] matrix, int column){
        int lowestValue = 2147483647; //set variable to lowest non negative value
        for(int i = 0; i < ROWS; i++){ //loop through the 2D array column
            if(matrix[i][column] < lowestValue){ //if element > highestValue, save value
              lowestValue = matrix[i][column];
            }
        } //end outer
        return lowestValue; // return the highest value
    } //end of findMaxofColumn


} //end of arraysHW4
