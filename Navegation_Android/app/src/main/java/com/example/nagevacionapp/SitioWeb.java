package com.example.nagevacionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SitioWeb extends AppCompatActivity {

    private WebView webView;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitio_web);
        cagarDatosPantallaSecondActivity();
        webView = findViewById(R.id.webview);
        ejecutarSitioWeb();
    }

    private void ejecutarSitioWeb() {
        //establecer el navegador dentro de la app
        webView.setWebViewClient(new WebViewClient());
        //instanciar webSetting
        WebSettings webSettings = webView.getSettings();
        //configura el browser
        webSettings.setJavaScriptEnabled(true);
        //cargar url seleccionada
        webView.loadUrl(url);

    }

    private void cagarDatosPantallaSecondActivity() {
        //almacenar url seleccionada
        this.url = getIntent().getStringExtra("urlSelected");

    }

    /**
     * Metodo para controlar las pantallas
     * al deslizar para atras
     */
    @Override
    public void onBackPressed() {
        //comprobar si el navegador puede ir hasta atras
        if(webView.canGoBack()){
            webView.goBack();
        }else {//en caso contrario volvemos a la app
            finish();
        }

    }
}