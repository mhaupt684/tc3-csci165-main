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

class Drawer extends JPanel {

    private static final long serialVersionUID = 1L;
    private JFrame window = new JFrame();
    
    public static int ROWS;
    public static int COLUMNS;
    public static int[][] GSMATRIX;
    public static int[][] DATAMATRIX;
    public static int[][] PATHSMATRIX;
    
    
    //Constructor
    public Drawer() { 	
    	initUI();
    }

    //initialize UI
    private void initUI() {
        window.add(this);
        window.setTitle("2D Drawing");
        window.setSize(COLUMNS,ROWS);
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

        /*
            RGB Colors:
            ================================================
            Black       => (0, 0, 0)        => low elevation
            Mid Grey    => (128, 128, 128)  => mid elevation
            White       => (255, 255, 255)  => high elevation

            Grey Scale colors are scaled in matching set of 3 numeric values
        */

        Graphics2D g2d = (Graphics2D) g;
         
        
        int squareSize = 2;
        
        System.out.println("Columns are " + COLUMNS + "  rows are " + ROWS);
        
        for(int i = 0; i < COLUMNS; i++) {
        	for(int j = 0; j < ROWS; j++) {
        		int currentColor = GSMATRIX[j][i];
        		g2d.drawRect(i,j,squareSize,squareSize);
        		g2d.setColor(new Color(currentColor, currentColor, currentColor));
                g2d.fillRect(i, j, squareSize, squareSize);      
        	}
        }
    }
        
       
    
    public static void main(String[] args) {
        
//        if(args.length == 0) {														//if there is no argument passed, end the program before anything runs
//			System.out.println("No file name specified...aborting");				
//			System.exit(0); 														//end the program
//		}
        
		int[] matrixDimensions = new int[2];										//array to store the dimensions of the matrix
		
		//String cmdLinArg = args[0];													//save the command line argument as a string
		String cmdLinArg = "Colorado_844x480.dat";
		
		//System.out.println("Original argument: " + cmdLinArg);
		matrixDimensions = parseDimensions(cmdLinArg);								//fill array will row and column integer values
		System.out.println(matrixDimensions[0] + " " + matrixDimensions[1]);
		
		COLUMNS = matrixDimensions[0];											//number of rows
		ROWS = matrixDimensions[1];												//number of columns
		DATAMATRIX = new int[ROWS][COLUMNS];								//create matrix that will hold data
		
		fillMatrix(DATAMATRIX,ROWS,COLUMNS,cmdLinArg);								//fill the data matrix 
		GSMATRIX = mapGreyscale(DATAMATRIX,ROWS,COLUMNS);
		PATHSMATRIX = generatePathway(DATAMATRIX,ROWS,COLUMNS);
		
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() { 
                Drawer ex = new Drawer();
                ex.setVisible(true);
            }
        });
    
    
    } // end main
    
    
    //given a column, find the index of the row with min elevation
    public static int[][] generatePathway(int[][] matrix, int numRows, int numCols){
    	int[][] pathway = new int[numRows][numCols];
    	int cTracker = 0;
    	int rTracker = 0;
    	int lastColChoice = numCols - 2;
    	int firstRowChoice = 0;
    	int lastRowChoice = numRows - 1;
    	
    	pathway[cTracker][rTracker] = matrix[cTracker][rTracker];
    	
    	for(int c = cTracker; c < lastColChoice; c++) {
    		int moveRight = c + 1;
			int upRow = rTracker - 1;
			int downRow = rTracker + 1;
			int straight = rTracker;
			int currentLoc = matrix[c][rTracker];
			
			if(rTracker == firstRowChoice) {
				int choiceStraight = matrix[moveRight][straight];
				int choiceDown = matrix[moveRight][downRow];
				int[] changeArray = {currentLoc,choiceStraight,choiceDown};
				int choice = leastChange(changeArray);
				
				if(choice == 1) { //choiceStraight
					pathway[moveRight][straight] = matrix[moveRight][straight];
					
				} else if(choice == 2) { //choiceDown
					pathway[moveRight][downRow] = matrix[moveRight][downRow];
					rTracker = downRow;
				}
				
			} else if(rTracker == lastRowChoice) {
				int choiceUp = matrix[moveRight][upRow];
				int choiceStraight = matrix[moveRight][straight];
				int[] changeArray = {currentLoc,choiceUp,choiceStraight};
				int choice = leastChange(changeArray);
				
				if(choice == 1) { //choiceUp
					pathway[moveRight][upRow] = matrix[moveRight][upRow];
				} else if(choice == 2) { //choiceStraight
					pathway[moveRight][straight] = matrix[moveRight][straight];
				}
				
			} else {
				int choiceUp = matrix[moveRight][upRow];
				int choiceStraight = matrix[moveRight][straight];
				int choiceDown = matrix[moveRight][downRow];
				int[] changeArray = {currentLoc,choiceUp,choiceStraight,choiceDown};
				int choice = leastChange(changeArray);
				
				if(choice == 1) { //choiceUp
					pathway[moveRight][upRow] = matrix[moveRight][upRow];
					rTracker = upRow;
				} else if(choice == 2) { //choiceStraight
					pathway[moveRight][straight] = matrix[moveRight][straight];
				} else if(choice == 3) { //choiceDown
					pathway[moveRight][downRow] = matrix[moveRight][downRow];
					rTracker = downRow;
				}
			
			}//endif
    			
    		if(c%100 == 0) {
    			System.out.println("Column: " + c + " Row: " + rTracker + " Matrix: " + matrix[c][rTracker]);
    			System.out.println(currentLoc);
    		}
    	}//endfor
    	
    	
    	return pathway;
    }
    
    
    
    
    
    
    //takes an array of possible moves and return an integer that signifies which choice
    public static int leastChange(int[] array) {
    	int length = array.length;
    	int choicePos = 0;
    	int smallestChange = 2147483647;
    	
    	for(int i = 0; i < length; i++) {
    		int change = Math.abs(array[0]-array[1]);
    		if(change < smallestChange) {
    			choicePos = i;
    			smallestChange = change;
    		} else if(change == smallestChange) {
    			int randomizer = smallestChange%2;
    			if(randomizer == 0) {
    				choicePos = i;
    			}
    		}
    	}
    	return choicePos;
    }
    
    
    //returns an int matrix of greyscale values based on data matrix
  	public static int[][] mapGreyscale(int[][] matrix, int numRows, int numCols){
  		int maxValue = findMaxMatrix(matrix,numRows,numCols);							//save the max value of the matrix
  		int minValue = findMinMatrix(matrix,numRows,numCols);							//save the min value of the matrix
  		int matrixValueRange = maxValue - minValue + 1;								//calculate the range of values in the matrix
  		int greyscaleValueRange = 256;
  		
  		int[][] greyscaleMatrix = new int[numRows][numCols];
  		
  		for(int i = 0; i < numRows; i++){
              for(int j = 0; j < numCols; j++){
                  greyscaleMatrix [i][j] = (greyscaleValueRange*(matrix [i][j] - minValue))/matrixValueRange;
              }
          }	
  		return greyscaleMatrix;
  	}
  	
  	
  	//parses rows and columns from the command line argument
  	public static int[] parseDimensions(String argument){
  		int rows = 0;																//integer for number of matrix rows
  		int columns = 0;															//integer for number of matrix columns
  		final int notFilled = 0;
  		
  		String[] parsedStrings = argument.split("_|x|\\.");							//parse argument String using delimiters _ x .
  		int arrayLength = parsedStrings.length;										//find the length of the array of Strings
  		
  		for(int i = 0; i < arrayLength; i++) {										//loop through the array of parsedStrings
  			try {
  				String parsed = parsedStrings[i];									//save current array element to a String
  				Scanner scan = new Scanner(parsed);									//new instance of Scanner
  				if(scan.hasNextInt() && columns == notFilled) {						//if scanner reads an integer and rows == 0
  					columns = Integer.parseInt(parsed);								//save new value for columns
  				} else if(scan.hasNextInt() && rows == notFilled) {				//if scanner reads an integer and columns == 0
  					rows = Integer.parseInt(parsed);								//save new value for rows	
  				}
  				scan.close();														//close scanner			
  			}catch(InputMismatchException ime) {									//catch errors from when scan.hasNextInt fails
  			}
  			
  		}		
  		return new int[]{columns, rows};
  	}

  	
  	//fills matrix with data from file
  	public static void fillMatrix(int[][] matrix, int numRows, int numCols, String argument) {
  		try{
  			FileReader readFile = new FileReader(argument);
  			Scanner scan = new Scanner(readFile);
  			
  			for(int i = 0; i < numRows; i++){
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
      int highestValue = 0; //set variable to lowest non negative value
      for(int i = 0; i < numRows; i++){ //loop through the 2D array
          for(int j = 0; j < numCols; j++){
              if(matrix[i][j] > highestValue){ //if element > highestValue, save value
                highestValue = matrix[i][j];
              }

          } //end nested

      } //end outer
      return highestValue; // return the highest value
  } //end of findMaxMatrix

  
  	//find minimum value in a 2D matrix
  	public static int findMinMatrix(int[][] matrix, int numRows, int numCols){
  		int lowestValue = 2147483647; //set variable to highest signed integer value
  		for(int i = 0; i < numRows; i++){ //loop through the 2D array
  			for(int j = 0; j < numCols; j++){
  				if(matrix[i][j] < lowestValue){ //if element > highestValue, save value
  					lowestValue = matrix[i][j];
  				}
  			} //end nested
  		} //end outer
  		return lowestValue; // return the lowest value
  	} //end of findMinMatrix


} // end class
