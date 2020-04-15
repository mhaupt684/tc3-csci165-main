import java.util.InputMismatchException;
import java.util.Scanner;
public class EmployeeDriver{

    public static void main(String[] args){
    	
    	Scanner keyboard = null;
    	
    	try {
        keyboard = new Scanner(System.in);

        String  name    = keyboard.next();
        int     id      = keyboard.nextInt();
        double  wage    = keyboard.nextDouble();

        Employee e = new Employee();
        
        e.setName(name);
        e.setId(id);
        e.setWage(wage);
        
        System.out.println(e);
        
        } catch(EmployeeRecordException ere) {
        	System.out.println(ere.getMessage());
        } catch(InputMismatchException ime) {
        	System.out.println(ime.getMessage());
        } finally {
        	keyboard.close();
        }

        

    }
}
