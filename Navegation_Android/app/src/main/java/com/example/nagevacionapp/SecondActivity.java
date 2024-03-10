package com.example.nagevacionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.nagevacionapp.modelo.Url;

import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private TextView btnHome;
    private TextView mensaje;
    private TextView titulo;
    private Spinner spinner;
    private Button btnNavegador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //INSTANCIAR VARIABLES
        btnHome = findViewById(R.id.btnHome);
        mensaje = findViewById(R.id.textMensaje);
        titulo = findViewById(R.id.titulo);
        spinner = findViewById(R.id.spinner);
        btnNavegador = findViewById(R.id.btnNavegador);
        //carga metodos
        cargarDatosAlumno();
        cargarDatosSpinner();

    }

    private void cargarDatosSpinner() {
        //declarar las urls
        List<Url> urls = List.of(
                new Url("Home", "https://docs.oracle.com/javase/8/docs/api/"),
                new Url("File","https://docs.oracle.com/javase/8/docs/api/java/io/File.html"),
                new Url("Collection","https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html"),
                new Url("Jframe","https://docs.oracle.com/javase/8/docs/api/javax/swing/JFrame.html")
        );

        //instanciar el arrayAdapter
        ArrayAdapter adapter = new ArrayAdapter<>(this,R.layout.spinner_item,urls);
        spinner.setAdapter(adapter);

    }

    public void onBtnNavegador(View view){
        //almacenar la url seleccionada del spinner
        Url urlSelected = (Url) spinner.getSelectedItem();

        //Llamar pantalla SitioWeb
        Intent pantallaSitioWeb = new Intent(this, SitioWeb.class);
        pantallaSitioWeb.putExtra("urlSelected",urlSelected.getUrl());
        startActivity(pantallaSitioWeb);

    }

    public void cambiarPantallaHome(View view) {
        Intent pantallaHome = new Intent(this, MainActivity.class);
        startActivity(pantallaHome);
    }

    public void cargarDatosAlumno() {
        //almacenar los datos de la pantalla anterior
        String nombre = getIntent().getStringExtra("n");
        String apellido = getIntent().getStringExtra("a");

        mensaje.setText(nombre + " " + apellido + "!");

    }
}