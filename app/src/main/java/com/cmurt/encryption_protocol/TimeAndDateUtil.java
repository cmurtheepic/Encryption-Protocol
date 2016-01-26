package com.cmurt.encryption_protocol;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

/**
 * Created by cmurt on 1/26/2016.
 */
public class TimeAndDateUtil {

    /**
     * @return the Date and Time,
     * as well as the pseudo-random number generated.
     * as a String
     */

    // Main method of the class
    public String Main() {
        Random rand = new Random();

        int randomNum = rand.nextInt(99) + 1;

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime())); //2014/08/06 16:00:22

        String Date = dateFormat.toString();
        int date = Integer.getInteger(Date);

        int Rnum = date * randomNum;
        System.out.println(Rnum);

        String returnable = Rnum + ":-:" + Date;

        return returnable;
    }
}
