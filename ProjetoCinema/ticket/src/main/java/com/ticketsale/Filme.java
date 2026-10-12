package com.ticketsale;

public class Filme {
    private String titulo;
    private String genero;
    private int classificacaoIndicativa;
    private int duracaoMinutos;

    public Filme(String titulo, String genero, int classificacaoIndicativa, int duracaoMinutos) {
        this.titulo = titulo;
        this.genero = genero;
        this.classificacaoIndicativa = classificacaoIndicativa;
        this.duracaoMinutos = duracaoMinutos;
    }

    public void infoFilme(){
        System.out.println("["+titulo+"]");
        System.out.println("Gênero        | "+genero);
        System.out.println("Classificação | "+classificacaoIndicativa);
        System.out.println("Tempo         | "+duracaoMinutos+"min");
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(int classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }
}