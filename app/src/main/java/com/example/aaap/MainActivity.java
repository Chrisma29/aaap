package com.example.aaap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText et1_numero,et2_nombre;
    private TextView tv1;
    private RadioButton radb1,radb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1_numero = (EditText)findViewById(R.id.et1_numero);
        et2_nombre = (EditText)findViewById(R.id.et2_nombre);
        tv1 = (TextView)findViewById(R.id.tv1);
        radb1 = (RadioButton)findViewById(R.id.radb1);
        radb2 = (RadioButton)findViewById(R.id.radb2);
    }

    //metodo Tabla
    public void Tabla(View view){
        String numero = et1_numero.getText().toString();

        int valor1 = Integer.parseInt(numero);
        int calc;
        String resultado = "";
        for (int i = 0; i<11;i++){
            calc = i*valor1;
            resultado += numero + " X " + i + " = " + calc + "\n";
        }
        tv1.setText(resultado);
    }
}