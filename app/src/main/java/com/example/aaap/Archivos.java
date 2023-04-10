package com.example.aaap;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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
    public void Guardar (View view){
        String nombre = et1.getText().toString();
        String contenido = getIntent().getStringExtra("tabla");
        if (rb1.isChecked() == true){
            try{
                File tarjetaSD = Environment.getExternalStorageDirectory();

                File rutaArchivo = new File(tarjetaSD.getPath(),nombre);

                OutputStreamWriter crearArchivo = new OutputStreamWriter(openFileOutput(nombre, Activity.MODE_PRIVATE));

                crearArchivo.write(contenido);

                crearArchivo.flush();
                crearArchivo.close();
                Toast.makeText(this, "El archivo se ha guardado correctamente", Toast.LENGTH_SHORT).show();

                et1.setText("");
                tv1.setText("");
            }catch (IOException e){
                Toast.makeText(this, "No se pudo guardar el archivo", Toast.LENGTH_LONG).show();
            }
        }
    }
    public void Consultar (View view){
        String nombre = et1.getText().toString();
        if(rb1.isChecked() == true) {
            try {
                File tarjetaSD = Environment.getExternalStorageDirectory();
                File rutaArchivo = new File(tarjetaSD.getPath(), nombre);
                InputStreamReader abrirArchivo = new InputStreamReader(openFileInput(nombre));
                BufferedReader leerArchivo = new BufferedReader(abrirArchivo);
                String linea = leerArchivo.readLine();
                String contenidoCompleto = "";

                while (linea != null) {
                    contenidoCompleto += linea + "\n";
                    linea = leerArchivo.readLine();
                }
                leerArchivo.close();
                abrirArchivo.close();
                tv1.setText(contenidoCompleto);
            } catch (IOException e) {
                Toast.makeText(this, "No se ha encontrado el archivo", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void Volver (View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}