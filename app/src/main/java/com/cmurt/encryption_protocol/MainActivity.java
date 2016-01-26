package com.cmurt.encryption_protocol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
<<<<<<< HEAD
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
=======
import java.util.Date;
import java.util.Locale;
>>>>>>> origin/master

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
        Random rand = new Random();

        int randomNum = rand.nextInt(99) + 1;

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime())); //2014/08/06 16:00:22

        String Date = dateFormat.toString();
        int date = Integer.getInteger(Date);

        int Rnum = date * randomNum;
        System.out.println(Rnum);
=======
        // Gets the Date and Time
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss",Locale.getDefault());
        Date date = new Date();
        System.out.println(dateFormat.format(date));
>>>>>>> origin/master
    }
}
