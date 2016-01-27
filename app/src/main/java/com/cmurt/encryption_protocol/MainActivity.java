package com.cmurt.encryption_protocol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Vigenere_Util V_U = new Vigenere_Util();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();

        int randomNum = rand.nextInt(99) + 1;

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss",Locale.getDefault());
        Date Date = new Date();
        System.out.println(dateFormat.format(Date));

        V_U.Main();

//        String date = dateFormat.toString(Date);
//        int dat = Integer.getInteger(date);
//
//        int Rnum = dat * randomNum;
//        System.out.println(Rnum);
//        // Gets the Date and Time

    }
}
