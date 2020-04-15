import java.util.InputMismatchException;
import java.util.Scanner;
public class BadSubscript{

    public static void main(String[] args){

        String[] names = {  "Willy", "Mehetabel", "Matt", "Micah",
                            "Port", "Neile", "Cathi", "Jerrilee",
                            "Malinda", "Gwynne"};
        
        Scanner keyboard = null;
        
        try {
        printMenu(names);
        keyboard = new Scanner(System.in);
        int selection = keyboard.nextInt();
        System.out.println("You chose: " + names[selection - 1]);
        } catch(ArrayIndexOutOfBoundsException aioobe) {
        	System.out.println("Valid choices are: 1 - 10. " + aioobe.getMessage()); 
        } catch(InputMismatchException ime) {
        	System.out.println("Only enter numbers please. " + ime.getMessage());
        } finally {
        	keyboard.close();
        }
    
    }
    
        public static void printMenu(String[] contacts){
           int line = 1;
           System.out.println("\nContact List\n=============");
           for (String contact : contacts)
               System.out.printf("%3s) %-10s\n", line++, contact);
   
           System.out.println("\nSelect a contact by number: ");
        }
    }