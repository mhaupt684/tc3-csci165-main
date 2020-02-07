import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.io.IOException;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


//Michael Haupt

public class FoodTruck {
    public static void main(String[] args) {


        //initialize File, FileWriter, and Scanner instances
        File menu; //create File instance to reference menu txt file
        File prices; //create File instance to reference prices txt file
        Scanner menuScanr; //scan menu.txt
        Scanner pricesScanr; //scan prices.txt
        Scanner fTScanner; //create instance of food truck scanner
        FileWriter receiptWriter; // create instance of FileWriter to write to receipt external file


        try{
            //File, scanner, filewriters
            menu = new File("menu.txt"); //create File instance to reference menu txt file
            prices = new File("prices.txt"); //create File instance to reference prices txt file
            menuScanr = new Scanner(menu); //scan menu.txt
            pricesScanr = new Scanner(prices); //scan prices.txt
            fTScanner = new Scanner(System.in); //create instance of food truck scanner
            receiptWriter = new FileWriter("receipt.txt"); // create instance of FileWriter to write to receipt external file


            //Greeting and Input
            System.out.print("Welcome to CS food truck.\n \nEnter your first and last name: "); //prompt the user to enter their name
            String customerName = fTScanner.nextLine(); //input the entire nextLine
            System.out.println("\nEnter the quantity of each item \n=============================="); //prompt user to enter the quantity of each item on the menu
            String menuLine; //initialize string for while loop
            String priceLine; //initialize string for while loop
            int quantityOrdered; //used to test and store user int input
            int wLArrayCounter = 0; //count how many time the while loop has run for writing to arrays

            //int variables used to initialize size of arrays
            int numItemsAvailable = 3;
            int numOfNames = 2;
            double salesTax = 0.0625;

            //arrays
            String[] itemNames = new String[numItemsAvailable]; //initialize array of String type to keep item Names
            int[] quantityPurchased = new int[numItemsAvailable]; //initialize array of int type to keep quantity purchased of each item
            double[] itemPrices = new double[numItemsAvailable]; //initialize array of float type to keep prices
            String[] customerNameSplit = new String[numOfNames]; //numOfNames = 2 -- assuming person has 1 first name and one last name

            //loop while there is another line in menu.txt to read
            while(menuScanr.hasNext()){
                menuLine = menuScanr.nextLine(); //read line from menu.txt
                priceLine = pricesScanr.nextLine(); //read line from prices.txt
                float price = Float.parseFloat(priceLine); //convert priceLine to a float
                System.out.print(menuLine + "-" + priceLine + ":"); //print output and prompt user to input quantity of item wanted
                quantityOrdered = fTScanner.nextInt(); //scan user input for int value
                itemNames[wLArrayCounter] = menuLine; //save to item names array
                itemPrices[wLArrayCounter] = price; //save to item prices array
                quantityPurchased[wLArrayCounter] = quantityOrdered; //save to quantity purchased array
                wLArrayCounter++; //add 1 to the counter
            }

            //Date
            LocalDateTime foodTruckTime = LocalDateTime.now(); //generate the time from now
            DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/YYYY"); //formatting for date
            DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("kk:mm"); //formatting for time
            DateTimeFormatter formatInvoiceNo = DateTimeFormatter.ofPattern("MMddkkmm"); //formatting for date time in invoice number
            String dateString = formatDate.format(foodTruckTime); //formatting for date
            String timeString = formatTime.format(foodTruckTime); //formatting for time
            String invoiceTimeDateStr = formatInvoiceNo.format(foodTruckTime); //formatting for date time in invoice number

            //invoice number
            customerNameSplit = customerName.split(" "); //customer name is in one string and must be split into first and last name
            String custFirstName = customerNameSplit[0]; //save customer first name into string
            String custLastName = customerNameSplit[1]; //save customer last name into string
            String cFNInitials = custFirstName.substring(0,2); //string containing first two characters of the first name
            String cLNInitials = custLastName.substring(0,2); //string containing second two characters of the last name
            int cFNUnicode = (int)cFNInitials.charAt(0); //get the unicode decimal value of the first character of the first name
            int cLNUnicode = (int)cLNInitials.charAt(0); //get the unicode decimal value of the last character of the last name
            int nameLength = customerName.length(); //length of the customer's name
            String sumCustIniUnicode = Integer.toString((cFNUnicode + cLNUnicode)*nameLength); //sum unicode values of initials * customer name length

            //invoice ID output
            String invoiceID = cFNInitials.toUpperCase() + cLNInitials.toUpperCase() + sumCustIniUnicode + invoiceTimeDateStr; //build the invoice number
            String invNumOutput = String.format("%-30s%s%n","Invoice Number:",invoiceID); //format invoice number string
            System.out.print(invNumOutput); //print to the console
            receiptWriter.write(invNumOutput); //write to receipt output text file

            //total bill
            double totalBillWoTax = 0.0; //initialize double variable that will keep track of the total cost without sales tax included

            //date output
            String dateOutput = String.format("%-30s%s%n","Date:",dateString); //format string for output
            System.out.print(dateOutput); //print to the console
            receiptWriter.write(dateOutput); //write to receipt output text file

            //time output
            String timeOutput = String.format("%-30s%s%n","Time:",timeString); //format string for output
            System.out.print(timeOutput); //print to the console
            receiptWriter.write(timeOutput); //write to receipt output text file

            //menu headings output
            String menuHeadings = String.format("%n%-30s%-10s%-11s%-10s%n%n","Item","Quantity","Price","Total"); //format string for output
            System.out.print(menuHeadings); //print to the console
            receiptWriter.write(menuHeadings); //write to receipt output text file

            System.out.println("===========================================================\n"); //print to the console
            receiptWriter.write("===========================================================\n"); //write to receipt output text file

            //print out the array
            for(int i = 0; i < numItemsAvailable; i++){
              double totalPriceWoTax = (double)quantityPurchased[i]*itemPrices[i]; //calculate the total cost of each menu item
              totalBillWoTax += totalPriceWoTax; //add the cost for this item to the total cost
              String receiptString = String.format("%-30s%-10s%s%-10.2f%s%-10.2f%n",itemNames[i],quantityPurchased[i],"$",itemPrices[i],"$",totalPriceWoTax); //format output string
              receiptWriter.write(receiptString + "\n"); //print to the console
              System.out.println(receiptString); //write to receipt output text file
            }

            System.out.println("===========================================================\n"); //print to the console
            receiptWriter.write("===========================================================\n"); //write to receipt output text file

            String subTotal = String.format("%s%44s%-10.2f%n%n","Subtotal","$",totalBillWoTax); //format string for output
            System.out.print(subTotal); //print to the console
            receiptWriter.write(subTotal); //write to receipt output text file

            double taxAdded = salesTax * totalBillWoTax;  //sales tax calculation
            String salesTaxAdded = String.format("%s%37s%-10.2f%n%n","6.25% sales tax","$",taxAdded); //format string for output
            System.out.print(salesTaxAdded); //print to the console
            receiptWriter.write(salesTaxAdded); //write to receipt output text file

            double totalBillIncludTax = taxAdded + totalBillWoTax; //final bill
            String finalBill = String.format("%s%47s%-10.2f%n%n","Total","$",totalBillIncludTax); //format string for output
            System.out.print(finalBill); //print to the console
            receiptWriter.write(finalBill); //write to receipt output text file


            //close scanners
            menuScanr.close();
            pricesScanr.close();
            fTScanner.close();
            receiptWriter.close();


        } catch(FileNotFoundException fnf){ //catch exception if files cannot be opened
            System.out.println("File cannot be read!!!");
        } catch(IOException ioe){ //catch exception if file cannot be written to
            System.out.println("Cannot write to file!!!");
        }




    }
}
