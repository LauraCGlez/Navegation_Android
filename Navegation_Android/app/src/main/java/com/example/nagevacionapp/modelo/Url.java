package com.example.nagevacionapp.modelo;

public class Url {
    private String titulo;
    private String url;

    public Url(String titulo, String url) {
        this.titulo = titulo;
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return this.getTitulo();
    }
}
