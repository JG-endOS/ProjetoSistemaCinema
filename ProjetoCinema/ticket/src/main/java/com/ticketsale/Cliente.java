package com.ticketsale;

public class Cliente {
    private String cpf ;
    private String nome;
    private int idade;
    private boolean estudante;

    public Cliente(String cpf, String nome, int idade, boolean estudante) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.estudante = estudante;
    }

    public void infoCliente(){
        System.out.println("["+nome+"]");
        System.out.println("CPF     | "+cpf);
        System.out.println("Idade   | "+idade);
        if(estudante){
            System.out.println("50%OFFE | "+estudante);
        } else if(idade >= 60){
            System.out.println("50%OFFI | "+true);
        } else {
            System.out.println("50%OFFN | "+false);
        }
        
    }

    //=======GETTERS&SETTERS========
    public String getCpf() {return cpf;}

    public void setCpf(String cpf) {this.cpf = cpf;}

    public String getNome() {return nome;}
    
    public void setNome(String nome) {this.nome = nome;}

    public int getIdade() {return idade;}

    public void setIdade(int idade) {this.idade = idade;}

    public boolean isEstudante() {return estudante;}
}