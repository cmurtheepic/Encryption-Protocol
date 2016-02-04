package com.cmurt.encryption_protocol;

// imports dependencies

import android.support.annotation.NonNull;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

class RanGen_Util { //declares the public class 'RanGen_Util'

    // below are the declarations for most of the variables in this java class
    private long Prandom; // declares a long with the name of 'Prandom'

    private String LN; // declares a string with the name of 'LN'

    private int g = 0; // declares an integer with the name of 'g' and the value of '0'

    private boolean wt = true;
    //private boolean done = false;

    private final Random RN = new Random();
    // above are the declarations for most of the variables in this java class

    /**
     * returns the Date and Time,
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
            System.out.println(dateFormat.format(calendar.getTime())); // gets the value of the current system time
                                                                       // and then prints it out to the system

            // creates the first "truly" random number
            // then logs the value of Prandom
            Prandom = (calendar.get(Calendar.MILLISECOND) * (calendar.get(Calendar.YEAR) *
                    (calendar.get(Calendar.MILLISECOND) + 1)) * calendar.get(Calendar.YEAR)) *
                    ((calendar.get(Calendar.HOUR) + 1) * (calendar.get(Calendar.MINUTE) + 1) *
                            (calendar.get(Calendar.SECOND) + 1));
            Log.d("RanGen_Util", "PseudoRandomNumber: " + Long.toString(Prandom)); // logs the value of Prandom to the logcat
                                                                                   // under log level debug

            LN = Long.toString(Prandom); // converts the value of Long Prandom
                                         // to the string LN

            // determines if Prandom is less than 0, and LN (short for Long number)
            // is even or odd by modding it to 2, and determining if there is a remainder
            // if there is a remainder then the LN is not even. thus reverting back to the
            // to the top of the loop stack
            if(Prandom > 0 && LN.length()%2 == 0) {
                Log.d("RanGen_Util", "Prandom = true");
                wt = false;
                break;
            } else {
                Log.d("RanGen_Util", "Prandom = false");
            }
        }
    }

    // Main method of the class
    @NonNull
    public String[] Main() {

        // calls to the method calendar
        calendar();

        // resets the value of Integer 'k' back to 1
        int k = 1;

        // logs the value of Long Prandom to logcat under log level debug
        Log.d("RanGen_Util", "PseudoRandomNumber: " + Long.toString(Prandom));

        // converts the value of Long Prandom into a String
        String LongNum = Long.toString(Prandom);

        Log.d("RanGen_Util", "LongNum length: " + LongNum.length());

        // declares the array(s) 'numbers1' & 'numbers2' and makes the array
        // the size of the pseudo-randomly generated number
        // by taking the number of digit places in the integer
        String[] numbers1 = new String[LongNum.length()+1];
        final String[] numbers2 = new String[LongNum.length()];

//        if((LongNum.length())%2 == 0) {
//            numbers2 = new String[LongNum.length() / 2];
//        } else {
//            numbers2 = new String[(LongNum.length() + 1) / 2];
//        }

        // gets the size of array(s) 'numbers1' & 'numbers2' and stores it into a integer
        final int numbers1Size = numbers1.length;
        final int numbers2Size = numbers2.length;

        // logs the value of Integer(s) 'numbers1Size' & 'numbers2Size'
        // to the logcat under log level debug
        Log.d("RanGen_Util", "numbers1 Size: " + numbers1Size);
        Log.d("RanGen_Util", "numbers2 Size: " + numbers2Size);

        // splits the value of ln into single digits then stores it in the array 'numbers1'
        numbers1 = LN.split("");

        // logs the value of array 'numbers'1 to the logcat under log level debug
        Log.d("RanGen_Util", "numbers1 array: " + Arrays.toString(numbers1));

        // moves the data values in the numbers1 array into numbers2 array
        // by taking a element and adding the value of the very next element
        // on to the end of the first element and then storing the value into
        // the indicated numbers2 array element.
        for(int i = 1; i < LongNum.length() - 1; i++) {
            if(k < LongNum.length()) {
                boolean singleDigit = RN.nextBoolean();
                Log.d("RanGen_Util", "singleDigit: " + singleDigit);
                String numberArray1 = numbers1[k];
                String numberArray2 = numbers1[k +1];
                Integer numArray1 = Integer.parseInt(numberArray1);
                Integer numArray2 = Integer.parseInt(numberArray2);
                Integer nums;
                if(!singleDigit) {
                    nums = ((10 * numArray1) + numArray2)%26;
                    numbers2[i-1] = Integer.toString(nums);
                    k = k + 2;
                    Log.d("RanGen_Util", "size of K: " + k);
                } else {
                    numbers2[i-1] = numbers1[k];
                    k = k + 1;
                    Log.d("Size of 'k' 2", "K: " + k);
                }
            }
        }

        // logs the value of array 'numbers2' to the logcat under log level debug
        Log.d("RanGen_Util", "numbers2 array: " + Arrays.toString(numbers2));

        g = g+1; // set the value of integer 'g' to the value of integer 'g' + 1

        // logs the value of integer 'g' as a string to the logcat under log level debug
        Log.d("RanGen_Util", "value of g: " + String.valueOf(g));

        return numbers2; // returns the integer array 'numbers2'
    }
}