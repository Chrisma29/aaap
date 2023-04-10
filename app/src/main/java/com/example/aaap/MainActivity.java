package com.example.aaap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        tv1 = (TextView)findViewById(R.id.tv1);
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
    //metodo ir a guardar
    public void archivos (View view){
        String numero = et1_numero.getText().toString();

        int valor1 = Integer.parseInt(numero);
        int calc;
        String resultado = "";
        for (int i = 0; i<11;i++) {
            calc = i * valor1;
            resultado += numero + " X " + i + " = " + calc + "\n";
        }
        Intent i = new Intent(this,Archivos.class);
        i.putExtra("tabla",resultado);
        startActivity(i);
    }
}