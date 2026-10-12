package com.ticketsale;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Venda {
    private int idVenda;
    private Cliente cliente;
    private Filme filme;
    private Sala sala;
    private double valorIngressoBase = 20;
    private ArrayList<Produto> produtos = new ArrayList<>();
    private LocalDateTime dataHora = LocalDateTime.now();
    private DateTimeFormatter br = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private String dataFormatada = dataHora.format(br);

    public Venda(Cliente cliente, Filme filme, Sala sala) {
        this.cliente = cliente;
        this.filme = filme;
        this.sala = sala;
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        this.produtos.remove(produto);
    }

    public double calcularValorTotal() {
        double total = valorIngressoBase;
        if(this.sala.isVip()){
            total += 10;
        } 

        if(cliente.getIdade() >= 60){
            total = total*0.50;
        }

        if(cliente.isEstudante()){
            total = total*0.50;
        }
        for (Produto p : produtos) {
            total += p.getPreco();
        }
        return total;
    }

    public void infoVenda(){
        System.out.println("["+idVenda+"]");
        System.out.println("Valor | "+calcularValorTotal());
        System.out.println("Data  | "+dataFormatada);
        filme.infoFilme();
        cliente.infoCliente();
        sala.infoSala();
        for (Produto produto : produtos) {
            produto.infoProduto();
        }
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getValorIngressoBase() {
        return valorIngressoBase;
    }

    public void setValorIngressoBase(double valorIngressoBase) {
        this.valorIngressoBase = valorIngressoBase;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}