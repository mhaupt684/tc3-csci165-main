import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.io.IOException;
import java.io.FileWriter;

//Michael Haupt

public class FoodTruck {
    public static void main(String[] args) {
        int numItemsAvailable = 3;
        String[] itemNames = new String[numItemsAvailable]; //initialize array of String type to keep item Names
        int[] quantityPurchased = new int[numItemsAvailable]; //initialize array of int type to keep quantity purchased of each item
        float[] itemPrices = new float[numItemsAvailable]; //initialize array of float type to keep prices

        try{
            //initialize File and Scanner instances
            File menu = new File("menu.txt"); //create File instance to reference menu txt file
            File prices = new File("prices.txt"); //create File instance to reference prices txt file
            //File receipt = new File("receipt.txt");
            Scanner menuScanr = new Scanner(menu); //scan menu.txt
            Scanner pricesScanr = new Scanner(prices); //scan prices.txt
            Scanner fTScanner = new Scanner(System.in); //create instance of food truck scanner
            FileWriter receiptWriter = new FileWriter("receipt.txt"); // create instance of FileWriter to write to receipt external file


            //Greeting and Input
            System.out.print("Welcome to CS food truck.\n \nEnter your full name: "); //prompt the user to enter their name
            String customerName = fTScanner.nextLine(); //input the entire nextLine
            System.out.println("\nEnter the quantity of each item \n=============================="); //prompt user to enter the quantity of each item on the menu
            String menuLine; //initialize string for while loop
            String priceLine; //initialize string for while loop
            boolean intEntered = false; //boolean value used to control while loop
            int quantityOrdered; //used to test and store user int input
            int wLArrayCounter = 0; //count how many time the while loop has run for writing to arrays

            while(menuScanr.hasNext()){ //loop while there is another line in menu.txt to read
                menuLine = menuScanr.nextLine(); //read line from menu.txt
                priceLine = pricesScanr.nextLine(); //read line from prices.txt
                float price = Float.parseFloat(priceLine); //convert priceLine to a float
                System.out.print(menuLine + "-" + priceLine + ":"); //print output and prompt user to input quantity of item wanted
                while(intEntered == false){ //repeats while the user has not entered an integer
                    try{
                        Scanner scanInt = new Scanner(System.in); //create a new scanner every time to avoid infinite loop -- why is this?
                        quantityOrdered = scanInt.nextInt(); //scan user input for int value
                        itemNames[wLArrayCounter] = menuLine; //save to item names array
                        itemPrices[wLArrayCounter] = price; //save to item prices array
                        quantityPurchased[wLArrayCounter] = quantityOrdered; //save to quantity purchased array
                        intEntered = true; //change intEntered to true to break out of the loop
                        wLArrayCounter++; //add 1 to the counter
                    } catch(InputMismatchException ime){ //catch exception throw if input is not int
                        System.out.print("Please enter the order quantity of " + menuLine + ": ");
                    } catch(NoSuchElementException nee){
                        System.out.print("Please enter the order quantity of " + menuLine + ": ");
                    }


                }
                intEntered = false; //reset the intEntered variable

            }

            //invoice number line
            String invoiceLine = "";


            //print out the array
            for(int i = 0; i < numItemsAvailable; i++){
              String receiptString = itemNames[i] + " " + itemPrices[i] + " " + quantityPurchased[i];
              receiptWriter.write(receiptString + "\n");
              System.out.println(receiptString);
            }

            //close scanners
            menuScanr.close();
            pricesScanr.close();
            fTScanner.close();
            receiptWriter.close();


        } catch(FileNotFoundException fnf){ //catch exception if files cannot be opened
            System.out.println("File cannot be read!!!");
        } catch(IOException ioe){
            System.out.println("Cannot write to file!!!");
        }




    }
}
