import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class StudentDriver{

    final static int ID    = 0;
    final static int FIRST = 1;
    final static int LAST  = 2;
    final static int DOB   = 3;
    final static int CLASS = 4;
    final static int MONTH = 0;
    final static int DAY   = 1;
    final static int YEAR  = 2;
    public static void main(String[] args){

        try{
            Student[] students = new Student[10];
            int index = 0;
            Scanner scanner = new Scanner(new File("MOCK_DATA.csv"));
            while(scanner.hasNext()){
                String line     = scanner.nextLine();
                String[] tokens = line.split(",");
                String[] date   = tokens[DOB].split("/");
                Date d      = new Date(Integer.parseInt(date[MONTH]), Integer.parseInt(date[DAY]), Integer.parseInt(date[YEAR]));
                Person p    = new Person(tokens[FIRST], tokens[LAST], d);
                Student s   = new Student(p, tokens[ID], Student.CLASS_LEVEL.valueOf(tokens[CLASS]));
                students[index++] = s;
            }

            Arrays.sort(students);
            System.out.println(Arrays.toString(students));

        }catch(IOException ie){
            System.out.println("There was a problem with the file: " + ie.getMessage());
        }
    }
}
