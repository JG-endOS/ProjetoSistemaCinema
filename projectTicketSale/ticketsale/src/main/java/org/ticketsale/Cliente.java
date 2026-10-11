package org.ticketsale;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private int idade;
    private int ing = 0;
    private int c = 0;
    ArrayList<Filme> ingressos = new ArrayList<>();
    ArrayList<Produto> com = new ArrayList<>();
    
    public Cliente(String nome, String cpf, int idade){
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getContCompra() {
        return contCompra;
    }

    public void setContCompra(int contCompra) {
        this.contCompra = contCompra;
    }

    public ArrayList<Filme> getIngressos() {
        return ingressos;
    }

    public void setIngressos(ArrayList<Filme> ingressos) {
        this.ingressos = ingressos;
    }

    public ArrayList<Produto> getCom() {
        return com;
    }

    public void setCom(ArrayList<Produto> com) {
        this.com = com;
    }

    public int getIng() {
        return ing;
    }

    public void setIng(int ing) {
        this.ing = ing;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public void comprarIngresso(){
        ingressos.add(ing);
        if (ingressos.get(ing).isDisponivel() == false) {
            System.out.println("Este filme não possui mais sessão disponível.");
            ingressos.remove(ing);
        }else if (ingressos.get(ing).getClassificacaoIndicativa() > idade) {
            System.out.println("O cliente não possui idade suficiente para assistir a esse filme.");
            ingressos.remove(ing);
        }else{
            ing++;
        }
    }

    public void comprarComida(){
        com.add(c);
        if (com.get(c).getQuantidade() == 0) {
            System.out.println("Este item já acabou.");
            com.remove(c);
        }else{
            c++;
        }
    }

}
