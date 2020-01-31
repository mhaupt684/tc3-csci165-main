import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GMT {
    public static void main(String[] args) {
        //System.out.println(System.currentTimeMillis());
        // long currentTime = System.currentTimeMillis();
        // System.out.println(currentTime.toString());

        TimeZone gmt = TimeZone.getTimeZone("GMT");
        SimpleDateFormat dateFMT = new SimpleDateFormat("yyyy-MM-dd EEEEEEEEE hh:mm:ss a");
        dateFMT.setTimeZone(gmt);
        Date currentDate = new Date();
        String printDateTime = dateFMT.format(currentDate);
        System.out.println("GMT: " + printDateTime);


    }
}
