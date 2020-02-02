import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.LocalDateTime;

//Michael Haupt

public class GMT {
    public static void main(String[] args) {

        // long currentTime = System.currentTimeMillis();
        // System.out.println(currentTime.toString());

        TimeZone gmt = TimeZone.getTimeZone("GMT"); //create an instance of TimeZone name gmt and getTimeZone GMT
        SimpleDateFormat dateFMT = new SimpleDateFormat("yyyy-MM-dd EEEEEEEEE hh:mm:ss a"); //create an instance of SimpleDateFormat and format what the output will look like.
        dateFMT.setTimeZone(gmt); //set the timezone for the SimpleDateFormat instance
        Date currentDate = new Date(); //create an instance of Date
        String printDateTime = dateFMT.format(currentDate); //save to a string: the current date formated by dateFMT
        System.out.println("GMT: " + printDateTime); //print out the date string

        //Do it with milliseconds
        long currentTime = System.currentTimeMillis(); //capture the current time in milliseconds
        Date curTimeMillis = new Date(currentTime); //create a new Date instance
        String printDateMillis = dateFMT.format(curTimeMillis);
        System.out.println(printDateMillis);

        //using java.time
        ZoneId gmtZone = ZoneId.of("Europe/London");
        ZonedDateTime gmtDateTime = ZonedDateTime.of(LocalDateTime.now(),gmtZone);
        System.out.println(gmtDateTime);

        //Sorry Proffessor - I've spent way too much time on this already... have to move on 
    }
}
