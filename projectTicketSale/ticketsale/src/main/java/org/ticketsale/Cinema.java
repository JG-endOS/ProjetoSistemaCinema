package org.ticketsale;

import java.util.ArrayList;

public class Cinema {
    private String nome;
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Filme> filmes = new ArrayList<>();
    ArrayList<Produto> produtos = new ArrayList<>();
    public Cinema(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(ArrayList<Filme> filmes) {
        this.filmes = filmes;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProduto(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public void cadastrarClientes(Cliente c){
        clientes.add(c);
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNome().isBlank() == true) {
                System.out.println("Nome inválido.");
                clientes.remove(c);
            }else if (clientes.get(i).getIdade() < 0) {
                System.out.println("Idade inválida.");
                clientes.remove(c);
            }else if (clientes.get(i).getCpf().isBlank() == true) {
                System.out.println("CPF inválido.");
                clientes.remove(c);
            }
        }
    }

    public void cadastrarFilmes(Filme f){
        filmes.add(f);
        for (int i = 0; i < filmes.size(); i++) {
            if(filmes.get(i).getTitulo().isBlank() == true){
                System.out.println("Título inválido.");
                filmes.remove(f);
            }else if (filmes.get(i).getClassificacaoIndicativa() < 0 || filmes.get(i).getClassificacaoIndicativa() > 18) {
                System.out.println("Classificação indicativa inválida.");
                filmes.remove(f);
            }else if (filmes.get(i).getValorIngresso() < 0) {
                System.out.println("Valor inválido para ingresso.");
                filmes.remove(f);
            }
        }
    }

    public void cadastrarProdutos(Produtos p){
        produtos.add(p);
        for (int i = 0; i < produtos.size(); i++) {
            if(produtos.get(i).getNome().isBlank() == true){
                System.out.println("Nome inválido.");
                produtos.remove(p);
            }else if (produtos.get(i).getValor() < 0) {
                System.out.println("Valor inválido.");
                produtos.remove(p);
            }else if (produtos.get(i).getQuantidade() < 0) {
                System.out.println("Quantidade inválida.");
                produtos.remove(p);
            }
        }
    }

    public void listarProdutos(){
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println((i+1)+" - "+produtos.get(i).getNome()+" | R$"+produtos.get(i).getValor()+" | "+produtos.get(i).getQuantidade()+" unidades disponíveis");
        }
    }

    public void listarClientes(){
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("Cliente "+(i+1)+":");
            for (int j = 0; j < clientes.size(); j++) {
                System.out.println("Nome: "+clientes.get(j).getNome());
                System.out.println("CPF: "+clientes.get(j).getCpf());
                System.out.println("Idade: "+clientes.get(j).getIdade());
                System.out.println("Compras realizadas: "+clientes.get(j).getContCompra());
            }
        }
    }

    public void listarFilmes(){
        System.out.println("Filmes disponíveis:");
        for (int i = 0; i < filmes.size(); i++) {
            System.out.println(filmes.get(i).getTitulo()+" - "+filmes.get(i).getClassificacaoIndicativa()+" Anos");
        }
    }
}
