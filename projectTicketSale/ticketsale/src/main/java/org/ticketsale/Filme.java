package org.ticketsale;

import java.util.ArrayList;

public class Filme {
    private String titulo;
    private int classificacaoIndicativa;
    private double valorIngresso;
    private boolean disponivel;
    private ArrayList<Sala> salas = new ArrayList<>();
    
    public Filme(String titulo, int classificacaoIndicativa, double valorIngresso, boolean disponivel) {
        this.titulo = titulo;
        this.classificacaoIndicativa = classificacaoIndicativa;
        this.valorIngresso = valorIngresso;
        this.disponivel = disponivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(int classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public double getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(double valorIngresso) {
        this.valorIngresso = valorIngresso;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }

    public void setSalas(ArrayList<Sala> salas) {
        this.salas = salas;
    }
    
    public void adicionarSalas(Sala s){
        salas.add(s);
    }

}
