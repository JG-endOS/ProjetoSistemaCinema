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
    private transient DateTimeFormatter br = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); //transient é pra não da problema na hora de passar para o json na exportação
    private String dataFormatada = dataHora.format(br);

    

    public Venda(Cliente cliente, Filme filme, Sala sala) {
        this.cliente = cliente;
        this.filme = filme;
        this.sala = sala;
    }

    //CONSTRUTOR PARA O TESTE
    public Venda(Cliente cliente, Filme filme, Sala sala, LocalDateTime dataHora) {
    this.cliente = cliente;
    this.filme = filme;
    this.sala = sala;
    this.dataHora = dataHora;
    this.dataFormatada = dataHora.format(br);
}

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        this.produtos.remove(produto);
    }

    public double calcularValorTotal() {
        double total = valorIngressoBase;
        DayOfWeek diaSemana = dataHora.getDayOfWeek();//talvez de problema na hroa de salvar no json, por não ser uma string ou algo assim
        if (diaSemana == DayOfWeek.SATURDAY || diaSemana == DayOfWeek.SUNDAY) {
            total += 10;
        }

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

    //========GETTERS&SETTERS=============
    public int getIdVenda() {return idVenda;}

    public void setIdVenda(int idVenda) {this.idVenda = idVenda;}

    public Cliente getCliente() {return cliente;}

    public Filme getFilme() {return filme;}

    public Sala getSala() {return sala;}  
}