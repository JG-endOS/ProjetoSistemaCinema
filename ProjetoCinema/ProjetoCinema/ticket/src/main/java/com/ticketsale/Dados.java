package com.ticketsale;
import java.util.ArrayList;

public class Dados {
    /*apenas separa os dados que quero no arquivo */
    private ArrayList<Venda> vendas;

    public Dados(Cinema cinema){
        this.vendas= cinema.getVendas();
    }

    public ArrayList<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(ArrayList<Venda> vendas) {
        this.vendas = vendas;
    }
}
