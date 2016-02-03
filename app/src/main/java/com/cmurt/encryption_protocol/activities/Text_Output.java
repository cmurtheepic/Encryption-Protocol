package com.cmurt.encryption_protocol.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.cmurt.encryption_protocol.R;

public class Text_Output extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text__output);
        TextView OriginalText;
        TextView key;
        TextView EncryptedText;

        OriginalText = (TextView)findViewById(R.id.OriginalText);
        key = (TextView)findViewById(R.id.KeyText);
        EncryptedText = (TextView)findViewById(R.id.EncryptedText);

        Intent in = getIntent();

        Bundle extras = in.getExtras();

        String Text = extras.getString("Text");
        String Key = extras.getString("Key");
        String OutputStream = extras.getString("OutputStream");

        OriginalText.setText(Text);
        key.setText(Key);
        EncryptedText.setText(OutputStream);

    }
}
