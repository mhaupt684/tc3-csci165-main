import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;
import java.util.Random;

//Michael Haupt

class Drawer extends JPanel {

    private static final long serialVersionUID = 1L;
    private JFrame window = new JFrame();


    //static variables
    public static int ROWS;
    public static int COLUMNS;
    public static int[][] GSMATRIX;                                             //greyscale matrix
    public static int[][] DATAMATRIX;                                           //original data stored here
    public static int[][] PATHSMATRIX;                                          //array of coordinates for a path
    public static int LEASTELEVCHANGE = 2147483647;                             //holds the total elevation change for the path with the least change
    public static int[][] BESTPATH;                                             //array of coordinated for the path with the least elevation change
    public static int TOPBEZEL = 38;                                            //accounts for the size of the top bar when creating the graphics window


    //Constructor
    public Drawer() {
    	initUI();
    }


    //initialize UI
    private void initUI() {
        window.add(this);
        window.setTitle("2D Drawing");
        window.setSize(COLUMNS,ROWS+TOPBEZEL);                                  //sets size of the pop up window
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }


    //paint window with code in doDrawing function
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }


    //draws the map
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;                                        //instance of Graphics2D
        int squareSize = 1;                                                     //set the size of the squares to be 1 pixel
        //draw the map using greyscale
        for(int i = 0; i < COLUMNS; i++) {
        	for(int j = 0; j < ROWS; j++) {
        		int currentColor = GSMATRIX[j][i];                                  //sets the shade for this pixel
        		g2d.drawRect(i,j,squareSize,squareSize);                            //draws the rectangle - 1 pixel wide
        		g2d.setColor(new Color(currentColor, currentColor, currentColor));  //sets color
                g2d.fillRect(i, j, squareSize, squareSize);                     //fills rectange with necessary color
        	}
        }
        g2d.setColor(Color.RED);                                                //set the color to red
        //draws a red path starting at every row, west to east
        for(int paths = 0; paths < ROWS; paths++) {
        	PATHSMATRIX = generatePathway(DATAMATRIX,ROWS,COLUMNS,paths);         //genrate the path
	        for(int i = 0; i < COLUMNS-1; i++){                                   //draw the line
	        		int x1 = PATHSMATRIX[i][0];                                       //start of line
	        		int y1 = PATHSMATRIX[i][1];
	        		int x2 = PATHSMATRIX[i+1][0];                                     //end of line
	        		int y2 = PATHSMATRIX[i+1][1];
	        		g2d.drawLine(x1,y1,x2,y2);                                        //draws the line
	        }
        }
        g2d.setColor(Color.GREEN);                                              //set the color to green
        for(int paths = 0; paths < ROWS; paths++) {
	        for(int i = 0; i < COLUMNS-1; i++){                                   //draw the path with the least elevation change
	        		int x1 = BESTPATH[i][0];                                          //start of line
	        		int y1 = BESTPATH[i][1];
	        		int x2 = BESTPATH[i+1][0];                                        //end of line
	        		int y2 = BESTPATH[i+1][1];
	        		g2d.drawLine(x1,y1,x2,y2);                                        //draws the line
	        }
        }
        int startingRow = BESTPATH[0][1];                                       //save the starting row from the best path array
        System.out.println("The path with the least elevation change starts at row " + startingRow + " Total elevation change: " + LEASTELEVCHANGE);
    }//end doDrawing


    public static void main(String[] args) {

       if(args.length == 0) {														                        //if there is no argument passed, end the program before anything runs
			System.out.println("No file name specified...aborting");
			System.exit(0); 														                              //end the program
		}
		int[] matrixDimensions = new int[2];										                    //array to store the dimensions of the matrix
		String cmdLinArg = args[0];													                        //save the command line argument as a string
		matrixDimensions = parseDimensions(cmdLinArg);								              //fill array will row and column integer values
		COLUMNS = matrixDimensions[0];											                        //number of rows
		ROWS = matrixDimensions[1];											              	            //number of columns
		DATAMATRIX = new int[ROWS][COLUMNS];								                        //create matrix that will hold data
		fillMatrix(DATAMATRIX,ROWS,COLUMNS,cmdLinArg);								              //fill the data matrix
		GSMATRIX = mapGreyscale(DATAMATRIX,ROWS,COLUMNS);                           //fill the grey scale matrix

		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Drawer ex = new Drawer();
                ex.setVisible(true);
            }
        });
    } // end main


    //generate a path, take in a starting row
    public static int[][] generatePathway(int[][] matrix, int numRows, int numCols, int startRow){
    	int[][] pathway = new int[numCols][2];                                    //coords num of columns by 2
      int colCoordinate = 0;
      int rowCoordinate = 1;
      int cTracker = 0;                                                         //column tracker starts at 0
    	int rTracker = startRow;                                                  //row tracker starts at the row passed into the method --startRow
    	int lastColChoice = numCols - 1;                                          //tells the method when to stop based on column location
    	int firstRowChoice = 0;                                                   //tells the method when its positioned at the top of the matrix
    	int lastRowChoice = numRows - 1;                                          //tells the method when its position at the bottom of the matrix
    	int totalElevChange = 0;                                                  //keeps track of the total elevation change for this path

      /*
      How pathway works:
        pathway is an array of length 2 arrays -- an array of coordinates
        pathway[column][0] -> holds the column value for the coordinate
        pathway[column][1] -> holds the row value for the coordinate
      */

    	pathway[cTracker][colCoordinate] = cTracker;                              //set starting column of pathway to 0
    	pathway[cTracker][rowCoordinate] = rTracker;                                          //set starting row of pathway to 0

      //loop until position is at the end of columns
    	for(int c = cTracker; c < lastColChoice; c++) {
        	int moveRight = c + 1;                                                //move to the right - column
    			int upRow = rTracker - 1;                                             //move up -row
    			int downRow = rTracker + 1;                                           //move down -row
    			int straight = rTracker;                                              //move straight -row
    			int currentLoc = matrix[rTracker][c];                                 //current location in DATAMATRIX row,column

          //if the row position is at the top row of the matrix
    			if(rTracker == firstRowChoice) {
      				int choiceStraight = matrix[straight][moveRight];                 //elevation if position shifts right 1 column, row stays
      				int choiceDown = matrix[downRow][moveRight];                      //elevation if position shifts right 1 column, down 1 row
      				int[] changeArray = {currentLoc,choiceStraight,choiceDown};       //array holds current location and move choices
      				int[] choiceAndChange = leastChange(changeArray);                 //make best choice
      				int choice = choiceAndChange[0];                                  //save choice to variable
      				totalElevChange += choiceAndChange[1];                            //keep track of the total change in elevation for this path

              //save choice coordinates to pathway matrix
              if(choice == 1) { //choiceStraight
        					pathway[moveRight][colCoordinate] = moveRight;
      			    	pathway[moveRight][rowCoordinate] = straight;
      				} else if(choice == 2) { //choiceDown
      					  pathway[moveRight][colCoordinate] = moveRight;
      			    	pathway[moveRight][rowCoordinate] = downRow;
      					  rTracker = downRow;
      				}
          //else if the row position is at the bottom row of the matrix
    			} else if(rTracker == lastRowChoice) {
      				int choiceUp = matrix[upRow][moveRight];                          //elevation if position shifts right 1 columns, up 1 row
      				int choiceStraight = matrix[straight][moveRight];                 //elevation if position shifts right 1 column, row stays
      				int[] changeArray = {currentLoc,choiceUp,choiceStraight};         //array holds current location and move choices
      				int[] choiceAndChange = leastChange(changeArray);                 //make best choice
      				int choice = choiceAndChange[0];                                  //save choice to variable
      				totalElevChange += choiceAndChange[1];                            //keep track of the total change in elevation for this path

              //save choice coordinates to pathway matrix
      				if(choice == 1) { //choiceUp
      					pathway[moveRight][colCoordinate] = moveRight;
      			    	pathway[moveRight][rowCoordinate] = upRow;
      				} else if(choice == 2) { //choiceStraight
      					pathway[moveRight][colCoordinate] = moveRight;
      			    	pathway[moveRight][rowCoordinate] = straight;
      				}
          //else the row position is anywhere else in the matrix
    			} else {
      				int choiceUp = matrix[upRow][moveRight];                          //elevation if position shifts right 1 columns, up 1 row
      				int choiceStraight = matrix[straight][moveRight];                 //elevation if position shifts right 1 column, row stays
      				int choiceDown = matrix[downRow][moveRight];                      //elevation if position shifts right 1 column, down 1 row
      				int[] changeArray = {currentLoc,choiceUp,choiceStraight,choiceDown};  //array holds current location and move choices, positions coorspond to the choice numbers below
      				int[] choiceAndChange = leastChange(changeArray);                 //make best choice
      				int choice = choiceAndChange[0];                                  //save choice to variable
      				totalElevChange += choiceAndChange[1];                            //keep track of the total change in elevation for this path

              //save choice coordinates to pathway matrix
      				if(choice == 1) { //choiceUp
      					  pathway[moveRight][colCoordinate] = moveRight;
      			    	pathway[moveRight][rowCoordinate] = upRow;
      					  rTracker = upRow;
      				} else if(choice == 2) { //choiceStraight
      					  pathway[moveRight][colCoordinate] = moveRight;
      			    	pathway[moveRight][rowCoordinate] = straight;
      				} else if(choice == 3) { //choiceDown
      					  pathway[moveRight][colCoordinate] = moveRight;
      			    	pathway[moveRight][rowCoordinate] = downRow;
      					  rTracker = downRow;
      				}
			    }//endif
    	}//endfor

    	if(totalElevChange < LEASTELEVCHANGE) {                                   //if total elevation change for this path is the lowest
    		LEASTELEVCHANGE = totalElevChange;                                      //reassign LEASTELEVCHANGE
    		BESTPATH = pathway;                                                     //save the coordinates of the best path to print in green
    	}
    	return pathway;
    }






    //takes an array of possible moves and return an integer that signifies which choice
    public static int[] leastChange(int[] array) {
    	int length = array.length;                                                //finds the length of the array
    	int choicePos = 0;                                                        //initialize choicePos
    	int smallestChange = 2147483647;                                          //keep track of the smallestChange

    	for(int i = 1; i < length; i++) {                                         //loop through array, but we don't want to consider element 0 since that is the current location
    		int change = Math.abs(array[0]-array[i]);                               //find the absolute value of change
    		if(change < smallestChange) {                                           //if change is smaller than the smallestChange, then reassign value as smallestChange
    			choicePos = i;                                                        //save the choice
    			smallestChange = change;                                              //reassign value to smallestChange
    		} else if(change == smallestChange) {                                   //if the values are the same, randomly choose one
          Random random = new Random();                                         //instance of random
          int randomizer = Math.abs(random.nextInt(100))%2;                     //pick a random number between 0-100 with modulus division by 2 resulting in either 0 or 1
    			if(randomizer == 0) {                                                 //if the result is 0 , then take the new value
    				choicePos = i;
    			}
    		}
    	}

    	int[] choiceAndChange = {choicePos,smallestChange};                       //prepare to return choice and the amount of change
    	return choiceAndChange;
    }


    //returns an int matrix of greyscale values based on data matrix
  	public static int[][] mapGreyscale(int[][] matrix, int numRows, int numCols){
  		int maxValue = findMaxMatrix(matrix,numRows,numCols);							        //save the max value of the matrix
  		int minValue = findMinMatrix(matrix,numRows,numCols);							        //save the min value of the matrix
  		int matrixValueRange = maxValue - minValue;								                //calculate the range of values in the matrix
  		int greyscaleValueRange = 255;                                            //set the greyscale range
  		int[][] greyscaleMatrix = new int[numRows][numCols];                      //create matrix to hold greyscale values
  		for(int i = 0; i < numRows; i++){
              for(int j = 0; j < numCols; j++){
                  greyscaleMatrix [i][j] = (greyscaleValueRange*(matrix [i][j] - minValue))/matrixValueRange; //calculate and save gs value to appropriate matrix location
              }
          }
  		return greyscaleMatrix;
  	}


  	//parses rows and columns from the command line argument
  	public static int[] parseDimensions(String argument){
  		int rows = 0;																                              //integer for number of matrix rows
  		int columns = 0;															                            //integer for number of matrix columns
  		final int notFilled = 0;                                                  //represents rows or columns values not being filled
  		String[] parsedStrings = argument.split("_|x|\\.");							          //parse argument String using delimiters _ x .
  		int arrayLength = parsedStrings.length;										                //find the length of the array of Strings
  		for(int i = 0; i < arrayLength; i++) {										                //loop through the array of parsedStrings
  			try {
  				String parsed = parsedStrings[i];									                    //save current array element to a String
  				Scanner scan = new Scanner(parsed);									                  //new instance of Scanner
  				if(scan.hasNextInt() && columns == notFilled) {						            //if scanner reads an integer and rows == 0
  					columns = Integer.parseInt(parsed);								                  //save new value for columns
  				} else if(scan.hasNextInt() && rows == notFilled) {				            //if scanner reads an integer and columns == 0
  					rows = Integer.parseInt(parsed);								                    //save new value for rows
  				}
  				scan.close();														                              //close scanner
  			}catch(InputMismatchException ime) {									                  //catch errors from when scan.hasNextInt fails
  			}
  		}
  		return new int[]{columns, rows};
  	}


  	//fills matrix with data from file
  	public static void fillMatrix(int[][] matrix, int numRows, int numCols, String argument) {
  		try{
        //create FileReader and Scanner instances
  			FileReader readFile = new FileReader(argument);
  			Scanner scan = new Scanner(readFile);
  			for(int i = 0; i < numRows; i++){                                       //loop through data to fill matrix
            for(int j = 0; j < numCols; j++){
                matrix[i][j] = scan.nextInt();
            }
        }
        //close instances
        readFile.close();
        scan.close();

  		}catch(FileNotFoundException fnf) {
  			System.out.println("Cannot find file...");
  			System.exit(0);
  		}catch(IOException ioe) {
  			System.out.println("Cannot read file...");
  			System.exit(0);
  		}
  	}


  	//find maximum value in a 2D matrix
  	public static int findMaxMatrix(int[][] matrix, int numRows, int numCols){
        int highestValue = 0;                                                   //set variable to lowest non negative value
        for(int i = 0; i < numRows; i++){                                       //loop through the 2D array
            for(int j = 0; j < numCols; j++){
                if(matrix[i][j] > highestValue){                                //if element > highestValue, save value
                  highestValue = matrix[i][j];
                }
            } //end nested
        } //end outer
        return highestValue;                                                    // return the highest value
    } //end of findMaxMatrix


  	//find minimum value in a 2D matrix
  	public static int findMinMatrix(int[][] matrix, int numRows, int numCols){
    		int lowestValue = 2147483647;                                           //set variable to highest signed integer value
    		for(int i = 0; i < numRows; i++){                                       //loop through the 2D array
      			for(int j = 0; j < numCols; j++){
        				if(matrix[i][j] < lowestValue){                                 //if element > highestValue, save value
        					lowestValue = matrix[i][j];
        				}
      			} //end nested
    		} //end outer
    		return lowestValue;                                                     // return the lowest value
  	} //end of findMinMatrix


} // end class
