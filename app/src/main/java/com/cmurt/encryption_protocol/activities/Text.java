package com.cmurt.encryption_protocol.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.cmurt.encryption_protocol.R;

public class Text extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        EditText ET;

        ET = (EditText)findViewById(R.id.editText);
    }
}
