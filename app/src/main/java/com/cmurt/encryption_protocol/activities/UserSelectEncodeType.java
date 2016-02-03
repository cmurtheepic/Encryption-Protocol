package com.cmurt.encryption_protocol.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
//import android.view.View;

import com.cmurt.encryption_protocol.R;

public class UserSelectEncodeType extends AppCompatActivity {

    // this method is triggered when this java class is initialized
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_select_encode_type);
    }

    // called when the user clicks the Text button
    @SuppressWarnings("unused")
    public void Text(View view) {
        Intent text = new Intent(this, Text.class);
        startActivity(text);
    }

    // called when the user clicks the File button
    @SuppressWarnings("unused")
    public void File(View view) {
        Intent file = new Intent(this, File.class);
        startActivity(file);
    }
}
