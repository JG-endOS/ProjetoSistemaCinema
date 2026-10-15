package com.ticketsale;

public class Produto {
    private String nome;
    private double preco;
    private String categoria; 

    public Produto(String nome, double preco, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public void infoProduto(){
        System.out.println("["+nome+"]");
        System.out.println("Preço     | "+preco);
        System.out.println("Categoria | "+categoria);
    }

    //==========GETTERS&SETTERS=============
    public void setNome(String nome) {this.nome = nome;}

    public double getPreco() {return preco;}

    public void setPreco(double preco) {this.preco = preco;}

    public void setCategoria(String categoria) {this.categoria = categoria;}
}