package com.cmurt.encryption_protocol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cmurt.encryption_protocol.activities.UserSelectEncodeType;

public class MainActivity extends AppCompatActivity {

    RanGen_Util TADU = new RanGen_Util();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TADU.Main();
        USET();

    }

    // called when the application has finished generating it pre requisites
    private void USET() {
        Intent uset = new Intent(this, UserSelectEncodeType.class);
        startActivity(uset);
    }
}
