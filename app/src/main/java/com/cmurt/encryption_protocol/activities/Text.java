package com.cmurt.encryption_protocol.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.cmurt.encryption_protocol.R;
import com.cmurt.encryption_protocol.Viginere_Util;

public class Text extends AppCompatActivity {

    private final Viginere_Util V_U = new Viginere_Util();

    @SuppressWarnings("unused")
    public void Viginere(View view) { // method is called when user clicks the 'Continue' button
        String Text;
        EditText ET;

        ET = (EditText)findViewById(R.id.editText);
        Text = ET.getText().toString();
        Log.d("text class:", "Text value: " + Text);

        String[] strings; // declares the array 'strings'

        strings = (V_U.Main(Text));

        V_U.Main(Text);

        Intent T_U = new Intent(this, Text_Output.class);
        Bundle bundle = new Bundle();
        bundle.putString("Text", Text);
        bundle.putString("Key", strings[2]);
        bundle.putString("OutputStream", strings[1]);
        T_U.putExtras(bundle);
        startActivity(T_U);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
    }
}