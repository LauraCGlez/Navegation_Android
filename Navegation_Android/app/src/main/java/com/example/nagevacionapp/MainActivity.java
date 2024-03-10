package com.example.nagevacionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText apellido;
    private TextView btnInformatica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INSTANCIAR VARIABLES
        nombre = findViewById(R.id.nombre);
        apellido = findViewById(R.id.apellido);
        btnInformatica = findViewById(R.id.btnInformatica);

        btnInformatica.setOnClickListener(view -> {
            cambiarPantallaAPI(view);
        });


    }

    public void cambiarPantallaAPI(View view) {
        //comprobar si los campos estan rellenos
        if(nombre.getText().toString().isEmpty() || apellido.getText().toString().isEmpty()){
            Toast.makeText(this, "Por favor, ingresar tus datos", Toast.LENGTH_SHORT).show();
            return;
        }else {
            Intent pantallaAPI = new Intent(this, SecondActivity.class);
            //compartir los datos a la pantalla APIJava
            pantallaAPI.putExtra("n",nombre.getText().toString());
            pantallaAPI.putExtra("a",apellido.getText().toString());

            startActivity(pantallaAPI);
        }

    }
}