package com.ticketsale;
import java.util.Comparator;//pra mexer com arrayList
import java.util.Collections;
import java.util.ArrayList;

public class Cinema {
    private String nomeCinema;
    private ArrayList<Venda> vendas = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Filme> filmes = new ArrayList<>();
    private ArrayList<Produto> produtos = new ArrayList<>();
    private ArrayList<Sala> salas = new ArrayList<>();
    
    int indexcliente=0;
    int indexvenda=0;
    int indexfilme=0;

    int numSala = 1;


    public Cinema(String nomeCinema) {
        this.nomeCinema = nomeCinema;
    }
    //===============SALAS=====================
    public void registrarSala(Sala sala){
        salas.add(sala);
        sala.setNumeroSala(numSala);
        numSala++;
    }

    public void removerSala(Sala sala){
        salas.remove(sala);
    }

    public void listarSalas(){
        System.out.println("=".repeat(20));
        System.out.println("[ Salas "+nomeCinema+" ]");
        System.out.println("=".repeat(20));
        for (Sala sala : salas) {
            sala.infoSala();
            System.out.println("=".repeat(20));
        }
    }

    public void editarSala(int novaCapacidadeTotal, boolean novoVip, String novoTipoTela, int index) {
        Sala s = salas.get(index);
        s.setCapacidadeTotal(novaCapacidadeTotal);
        s.setVip(novoVip);
        s.setTipoTela(novoTipoTela);
    }

    //================FILME======================
    public void listaFilmesOrdenado(){
        filmes.sort(Comparator.comparing(Filme::getDuracaoMinutos));
        Collections.reverse(filmes);
    }

    public void editarFilme(String novoTitulo, String novoGenero, int novaClassificacaoIndicativa, int novaDuracaoMinutos,int index) {
        Filme f = filmes.get(index);
        f.setTitulo(novoTitulo);
        f.setGenero(novoGenero);
        f.setClassificacaoIndicativa(novaClassificacaoIndicativa);
        f.setDuracaoMinutos(novaDuracaoMinutos);
    }

    public void registrarFilme(Filme filme){
        filmes.add(filme);
    }

    public void removerFilme(Filme filme){
        filmes.remove(filme);
    }

    public void listarFilmes(){
        int index = 0;
        System.out.println("=".repeat(20));
        System.out.println("[ Filmes "+nomeCinema+" ]");
        System.out.println("=".repeat(20));
        for (Filme filme : filmes) {
            System.out.println(index+".");
            filme.infoFilme();
            System.out.println("=".repeat(20));
            index++;
        }
    }

    public int consultarfilme(String nomeFilme){
        boolean encontrado = false;
        indexfilme=0;
        for (Filme filme : filmes) {
            if (filme.getTitulo().equalsIgnoreCase(nomeFilme)) {
                System.out.println("Filme encontrado:");
                filme.infoFilme();
                encontrado = true;
                break;
            }
            indexfilme++;
        }
        if (!encontrado) {
            System.out.println("Filme não encontrado com o nome: " + nomeFilme);
        }
        return indexfilme;
    }

    //=============PRODUTO================
    public void listaProdutosOrdenado(){
        produtos.sort(Comparator.comparing(Produto::getPreco));
        Collections.reverse(produtos);
    }

    public void editarProduto(String novoNome, double novoPreco, String novaCategoria, int index) {
        Produto p = produtos.get(index);
        p.setCategoria(novaCategoria);
        p.setPreco(novoPreco);
        p.setNome(novoNome);
    }

    public void registrarProduto(Produto produto){
        produtos.add(produto);
    }

    public void removerProduto(Produto produto){
        produtos.remove(produto);
    }

    public void listarProdutos(){
        int index = 0;
        System.out.println("=".repeat(20));
        System.out.println("[ Produtos "+nomeCinema+" ]");
        System.out.println("=".repeat(20));
        for (Produto produto : produtos) {
            System.out.println(index+".");
            produto.infoProduto();
            System.out.println("=".repeat(20));
            index++;
        }
    }

    public double mediaValorProdutos(){
        double media = 0;
        for (Produto produto : produtos) {
            media += produto.getPreco();
        }
        media = media/produtos.size();
        return media;
    }

    //============VENDA=================
    public void listaVendasOrdenado(){
        vendas.sort(Comparator.comparing(Venda::calcularValorTotal));
        Collections.reverse(vendas);
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
            sala.setCapacidadeTotal(sala.getCapacidadeTotal()-1);
            this.vendas.add(venda);
            venda.setIdVenda(2026000 + vendas.size());
            System.out.println("Venda registrada com sucesso!");
        }
    }

    public void removerVenda(Venda venda) {
        this.vendas.remove(venda);
    }

    //FATURAMENTO TOTAL DO CINEMA
    public double calcularFaturamentoTotal() {
        double faturamento = 0.0;
        for (Venda v : vendas) {
            faturamento += v.calcularValorTotal();
        }
        return faturamento;
    }

    //MEDIA VALOR VENDAS
    public double mediaValorVendas(){
        double media = 0;
        for (Venda venda : vendas) {
            media += venda.calcularValorTotal();
        }
        media = media/vendas.size();
        return media;
    }

    public void listarVendas(){
        int index = 0;
        System.out.println("=".repeat(20));
        System.out.println("[ Vendas "+nomeCinema+" ]");
        System.out.println("=".repeat(20));
        for (Venda venda : vendas) {
            System.out.println(index+".");
            venda.infoVenda();
            System.out.println("=".repeat(20));
            index++;
        }
    }

    public void rankingVendas(){
        vendas.sort(Comparator.comparing(Venda::calcularValorTotal).reversed());
        System.out.println("=".repeat(20));
        System.out.println("[MELHOR VENDA]");
        vendas.get(0).infoVenda();
        System.out.println("=".repeat(20));
        System.out.println("[PIOR VENDA]");
        vendas.get(vendas.size()-1).infoVenda();

    }

    public int consultarVenda(int idVenda){
        boolean encontrado = false;
        indexvenda=0;
        for (Venda venda : vendas) {
            if (venda.getIdVenda() == idVenda) {
                System.out.println("Venda encontrada:");
                venda.infoVenda();
                encontrado = true;
                indexvenda++;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Venda não encontrada com o ID: " + idVenda);
        }
        return indexvenda;
    }
    
    // =============CLIENTES======================
    public void listaClientesOrdenado(){
        clientes.sort(Comparator.comparing(Cliente::getNome));
    }

    public void listarClientes(){
        System.out.println("=".repeat(20));
        System.out.println("[ Clientes "+nomeCinema+" ]");
        System.out.println("=".repeat(20));
        int index = 0;
        for (Cliente cliente : clientes) {
            System.out.println(index+".");
            cliente.infoCliente();
            System.out.println("=".repeat(20));
            index++;
        }
    }

    
    public Cliente buscarClienteCpf(String cpf){
        Cliente retorno = null;
        for (Cliente cliente : clientes) {
            if(cliente.getCpf().equals(cpf)){
                retorno = cliente;
            } 
        }
        return retorno;
    }
    
    public void registrarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
    
    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public void editarCliente(String novoCpf, String novoNome, int novaIdade, int index) {
        Cliente c = clientes.get(index);
        c.setCpf(novoCpf);
        c.setNome(novoNome);
        c.setIdade(novaIdade);
    }

    //=========GETTERS&SETTERS==============
    public String getNomeCinema() {return nomeCinema;}

    public ArrayList<Cliente> getClientes() {return clientes;}

    public ArrayList<Filme> getFilmes() {return filmes;}

    public ArrayList<Produto> getProdutos() {return produtos;}

    public ArrayList<Sala> getSalas() {return salas;}

    public ArrayList<Venda> getVendas() {return vendas;}
}