package com.example.aaap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Archivos extends AppCompatActivity {
    private EditText et1;
    private TextView tv1;
    private RadioButton rb1, rb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archivos);
        et1 = (EditText)findViewById(R.id.et2_nombre);
        tv1 = (TextView)findViewById(R.id.tv2);
        rb1 = (RadioButton)findViewById(R.id.radb3);
        rb2 = (RadioButton)findViewById(R.id.radb4);
        String resultado = getIntent().getStringExtra("tabla");
        tv1.setText(resultado);
    }

}