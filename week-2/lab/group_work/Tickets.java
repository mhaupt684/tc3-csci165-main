import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

//Michael Haupt

public class Tickets{

    public static void main(String[] args){

        /*
            The following code steps you through the String processing
            and math neccessary to determine if a single ticket number is valid.
            Your job with this code is to:

            ~   Closely study the code. Reverse engineer it. Use the API for guidance
                to understand the classes and methods that are being used.
            ~   Add comments for each statement, describing in detail what the line is doing
                I want to know DETAILS, not generalizations. RESEARCH!
            ~   When you have completed that, add code to complete the following

                1) Using a Scanner, open the file: tickets.txt
                2) Using a while(hasNext) loop, read each ticket number
                3) Run the ticket number through the provided math and String processing
                4) If the ticket number is valid write it to a new file called: valid_tix.txt
                5) Ignore the invalid ticket numbers

            ~   Additional code must also be commented. But I am more interested in why you are doing
                something, not the details of how.

            Check your work: There are 101 valid ticket numbers among the 1000 provided ticket numbers
                             These people make mistakes!!!

            Submit only Java source code files. Also submit valid_tix.txt

        */

        int countValidTik = 0; //keep track of the number of valid tickets

        try{
            File ticketList = new File("tickets.txt"); //create File instance to reference txt file
            Scanner ticketScanner = new Scanner(ticketList); //pass File object into the Scanner
            FileWriter validTicket = new FileWriter("valid_tix.txt"); //creat FileWriter instance to reference txt file


            while(ticketScanner.hasNext()){ //while loop will run while hasNext remains true
                String line = ticketScanner.nextLine(); //get the next line and save it to a string
                String  last = line.substring(line.length() - 1); //save the last digit of the ticket number in a string
                int     last_digit = Integer.valueOf(last); //change last digit string to integer
                String  reduced_ticket = line.substring(0, line.length() - 1); //create string of ticket without last number
                int     ticket_number = Integer.valueOf(reduced_ticket); //convert reduced ticket to an integer
                int     remainder = ticket_number % 7; //modulus division on the reduced ticket number
                boolean validity = remainder == last_digit; //checks if remainder is identical to the last digit
                if(validity == true){ //if
                    countValidTik++;
                    validTicket.write(line + "\n");
                }
            }

            ticketScanner.close(); //close the Scanner
            validTicket.close(); //close the file writer

        } catch(FileNotFoundException fnf){ //catch read file error
            System.out.println("Error: file not found");
        }
        catch(IOException ioE) { //catch write file error
            System.out.println("Error: Cannot print to output");
        }
        
        System.out.println("Valid Ticket Count: " + countValidTik); //print out the valid ticket count

    }
}
