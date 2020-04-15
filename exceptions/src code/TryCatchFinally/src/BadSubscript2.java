import java.util.InputMismatchException;
import java.util.Scanner;
public class BadSubscript2{

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
    
    public static void printMenu(String[] names) {
    	int length = names.length;
    	System.out.println("\nContact List\n=============");
    	for(int i = 0; i < length; i++) {
    		System.out.printf("% 3d%s%s\n",(i+1),") ",names[i]);
    	}
    	System.out.println("\nSelect a contact by number:");
    }
    
}