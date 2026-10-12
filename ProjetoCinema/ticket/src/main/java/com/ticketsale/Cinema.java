package com.ticketsale;

import java.util.ArrayList;

public class Cinema {
    private String nomeCinema;
    private ArrayList<Venda> vendas;

    public Cinema(String nomeCinema) {
        this.nomeCinema = nomeCinema;
        this.vendas = new ArrayList<>();
    }

    public void registrarVenda(Venda venda) {
        if (venda == null || venda.getCliente() == null) {
            System.out.println("Venda inválida!");
            return;
        }
        
        Cliente cliente = venda.getCliente();
        Filme filme = venda.getFilme();
        Sala sala = venda.getSala();

        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
            System.out.println("Nome inválido!");
        } else if (cliente.getIdade() <= 0) {
            System.out.println("Idade inválida!");
        } else if (cliente.getIdade() < filme.getClassificacaoIndicativa()) {
            System.out.println("Venda não registrada: Idade insuficiente para o filme!");
        } else if (sala.getCapacidadeTotal() <= 0) {
            System.out.println("Venda não registrada: Sala lotada!");
        } else {
            sala.setCapacidadeTotal(sala.getCapacidadeTotal() - 1);
            this.vendas.add(venda);
            venda.setIdVenda(2026000 + vendas.size());
            System.out.println("Venda registrada com sucesso!");
        }
    }

    public void removerVenda(Venda venda) {
        this.vendas.remove(venda);
    }

    public double calcularFaturamentoTotal() {
        double faturamento = 0.0;
        for (Venda v : vendas) {
            faturamento += v.calcularValorTotal();
        }
        return faturamento;
    }

    public double mediaValorVendas(){
        double media = 0;
        for (Venda venda : vendas) {
            media += venda.calcularValorTotal();
        }
        media = media/vendas.size();
        return media;
    }

    public void listarVendas(){
        System.out.println("=".repeat(20));
        System.out.println("[Vendas "+nomeCinema+"]");
        System.out.println("=".repeat(20));
        for (Venda venda : vendas) {
            venda.infoVenda();
            System.out.println("=".repeat(20));
        }
    }

    public String getNomeCinema() {
        return nomeCinema;
    }

    public void setNomeCinema(String nomeCinema) {
        this.nomeCinema = nomeCinema;
    }

    public ArrayList<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(ArrayList<Venda> vendas) {
        this.vendas = vendas;
    }
}