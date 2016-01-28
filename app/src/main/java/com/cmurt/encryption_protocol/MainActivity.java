package com.cmurt.encryption_protocol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cmurt.encryption_protocol.activities.UserSelectEncodeType;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Viginere_Util V_U = new Viginere_Util();
    TimeAndDateUtil TADU = new TimeAndDateUtil();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TADU.Main();
        V_U.Main();
        USET();

    }

    // called when the application has finished generating it pre requisites
    private void USET() {
        Intent uset = new Intent(this, UserSelectEncodeType.class);
        startActivity(uset);
    }
}
