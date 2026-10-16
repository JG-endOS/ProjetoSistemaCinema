package com.ticketsale;

public class Sala {
    private int numeroSala;
    private int capacidadeTotal;
    private boolean vip;
    private String tipoTela; 

    public Sala(int capacidadeTotal, String tipoTela, boolean vip) {
        this.capacidadeTotal = capacidadeTotal;
        this.tipoTela = tipoTela;
        this.vip = vip;
    }

    public void infoSala(){
        System.out.println("[Sala "+numeroSala+"]");
        System.out.println("Capacidade | "+capacidadeTotal);
        System.out.println("Tela       | "+tipoTela);
        System.out.println("Vip        | "+vip);
    }

    //==========GETTERS&SETTERS=============
    public void setNumeroSala(int numeroSala) {this.numeroSala = numeroSala;}

    public int getCapacidadeTotal() {return capacidadeTotal;}

    public void setCapacidadeTotal(int capacidadeTotal) {this.capacidadeTotal = capacidadeTotal;}

    public void setTipoTela(String tipoTela) {this.tipoTela = tipoTela;}

    public boolean isVip() {return vip;}

    public void setVip(boolean vip) {this.vip = vip;}
}
