package com.cmurt.encryption_protocol;

// imports dependencies
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

public class TimeAndDateUtil { //declares the public class 'TimeAndDateUtil'

    // below are the declarations for most of the variables in this java class
    private long Prandom;

    String ln;
    String LN;

    int k = 1;

    boolean wt = true;
    boolean done = false;
    // above are the declarations for most of the variables in this java class

    /**
     * @return the Date and Time,
     * as well as the pseudo-random number generated.
     * as a String
     */

    private void calendar() { // declares the private void type method 'calendar'

        // declares a SimpleDateFormat called 'dateFormat' with the string patter
        // year/month/day hour:minute:second, then it gets the system's default locale
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());

        while(wt) { // declares a while loop with the condition of Boolean wt being true or false

            // declares a Calendar instance called 'calendar'
            Calendar calendar = Calendar.getInstance();
//            int hour = calendar.get(Calendar.HOUR);
//            int minute = calendar.get(Calendar.MINUTE);
//            int second = calendar.get(Calendar.SECOND);
//            int milisecond = calendar.get(Calendar.MILLISECOND);
//            int nanosecond = calendar.get(Calendar.YEAR);
            System.out.println(dateFormat.format(calendar.getTime())); // gets the value of the current system time
                                                                       // and then prints it out to the system

            // creates the first "truly" random number
            // then logs the value of Prandom
            Prandom = (calendar.get(Calendar.MILLISECOND) * (calendar.get(Calendar.YEAR) *
                    (calendar.get(Calendar.MILLISECOND) + 1)) * calendar.get(Calendar.YEAR)) *
                    (calendar.get(Calendar.HOUR) * (calendar.get(Calendar.MINUTE) + 1) *
                            (calendar.get(Calendar.SECOND) + 1));
            Log.d("PseudoRandomNumber", Long.toString(Prandom)); // logs the value of Prandom to the logcat
                                                                 // under log level debug

            LN = Long.toString(Prandom); // converts the value of Long Prandom
                                         // to the string LN

            // determines if Prandom is less than 0, and LN (short for Long number)
            // is even or odd by modding it to 2, and determining if there is a remainder
            // if there is a remainder then the LN is not even. thus reverting back to the
            // to the top of the loop stack
            if(Prandom > 0 && LN.length()%2 == 0) {
                Log.d("Prandom", "true");
                wt = false;
                break;
            } else {
                Log.d("Prandom", "false");
            }
        }

        // sets the Boolean 'done' to true, then calls back to the Main method
        done = true;
        Main();
    }

    // Main method of the class
    public String Main() {

        // checks to see if the calendar method is done with its intended task
        if(!done) {
            calendar();
        }

        // logs the value of Long Prandom to logcat under log level debug
        Log.d("PseudoRandomNumber", Long.toString(Prandom));

        // converts the value of Long Prandom into a String
        String LongNum = Long.toString(Prandom);

        // declares the array(s) 'numbers1' & 'numbers2' and makes the array
        // the size of the pseudo-randomly generated number
        // by taking the number of digit places in the integer
        String[] numbers1 = new String[LongNum.length()+1];
        String[] numbers2 = new String[LongNum.length()+1];

        // gets the size of array(s) 'numbers1' & 'numbers2' and stores it into a integer
        int numbers1Size = numbers1.length;
        int numbers2Size = numbers2.length;

        // logs the value of Integer(s) 'numbers1Size' & 'numbers2Size'
        // to the logcat under log level debug
        Log.d("numbers1Size", "Size: " + numbers1Size);
        Log.d("numbers2Size", "Size: " + numbers2Size);

        // splits the value of ln into single digits then stores it in the array 'numbers1'
        numbers1 = ln.split("");
        Log.d("Long Num", "Long Num: " + ln.split(""));

        Log.d("numbers1 array", "array: " + Arrays.toString(numbers1));

        // moves the data values in the numbers1 array into numbers2 array
        // by taking a element and adding the value of the very next element
        // on to the end of the first element and then storing the value into
        // the indicated numbers2 array element
        for(int i = 1; i < LongNum.length() - 1; i++) {
            if(k < LongNum.length()) {
                numbers2[i - 1] = numbers1[k] + numbers1[k + 1];
                k = k + 2;
                Log.d("Size of 'k'", "K: " + k);
            }
        }

        Log.d("numbers2 array", "array: " + Arrays.toString(numbers2));

        return Long.toString(Prandom);
    }
}
