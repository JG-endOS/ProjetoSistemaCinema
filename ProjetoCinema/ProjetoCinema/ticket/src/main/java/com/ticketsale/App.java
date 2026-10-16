package com.ticketsale;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        LocalDateTime dataHora = LocalDateTime.now();
        DateTimeFormatter br = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = dataHora.format(br);

        Produto p1 = new Produto("Pipoca G", 30.50, "Alimentação");
        Produto p2 = new Produto("Refrigerante 500ml", 10.30, "Bebidas");
        Produto p3 = new Produto("Amendoim Japonês", 5.50, "Alimentação");
        Produto p4 = new Produto("Nachos com queijo", 12.00, "Alimentação");

        Sala s1 = new Sala(50, "2D", false);
        Sala s2 = new Sala( 100, "3D", false);
        Sala s3 = new Sala(130, "IMAX", true);

        Filme f1 = new Filme("Terrifier", "Terror", 18, 100);
        Filme f2 = new Filme("Bob Esponja", "Comédia", 0, 90);
        Filme f3 = new Filme("Missão Impossível", "Ação", 12, 200);

        Cliente c1 = new Cliente("xxx.xxx.xxx-xx", "Isabela", 18, true);
        Cliente c2 = new Cliente("000.000.000-00", "Kali", 17, false);
        Cliente c3 = new Cliente("111.111.111-11", "João Gabriel", 19, true);

        Venda v1 = new Venda(c2, f2, s2);
        Venda v2 = new Venda(c3, f3, s3);

               
        Cinema ci1 = new Cinema("CineJava");
        ci1.registrarCliente(c1);
        ci1.registrarCliente(c2);
        ci1.registrarCliente(c3);

        ci1.registrarFilme(f1);
        ci1.registrarFilme(f2);
        ci1.registrarFilme(f3);

        ci1.registrarSala(s1);
        ci1.registrarSala(s2);
        ci1.registrarSala(s3);

        ci1.registrarProduto(p1);
        ci1.registrarProduto(p2);
        ci1.registrarProduto(p3);
        ci1.registrarProduto(p4);

        ci1.registrarVenda(v1);
        ci1.registrarVenda(v2);
     
        Scanner sc = new Scanner(System.in);
        
        int rodando = 1;
        while(rodando!=0){
            System.out.flush();
            System.out.println("=".repeat(12));
            System.out.println("  "+ci1.getNomeCinema());
            System.out.println("=".repeat(12));

            System.out.println("1 - Clientes");
            System.out.println("2 - Filmes");
            System.out.println("3 - Salas");
            System.out.println("4 - Produtos");
            System.out.println("5 - Vendas");
            System.out.println("6 - Relatório/Indicadores");
            System.out.println("7 - Buscar cliente");
            System.out.println("8 - Exportar vendas para JSON");
            System.out.println("0 - Encerrar Programa");
            int entrada = Integer.parseInt(sc.nextLine());

            switch (entrada) { 
                
                case 0:
                    System.out.println("Programa encerrado!");
                    rodando = 0;
                    break;

                case 1:
                    ci1.listarClientes();
                    System.out.println("Consulta | há "+ci1.getClientes().size()+" clientes");
                    System.out.println("Digite 1 para editar, 2 para excluir, 3 para registrar, 4 para ordenar(alfabeticamente) ou 0 para voltar: ");
                    int decisaoCliente = Integer.parseInt(sc.nextLine());

                    if(decisaoCliente == 1){
                        int index;
                        do {
                            System.out.println("Digite o index do cliente que deseja editar: ");
                            index = Integer.parseInt(sc.nextLine());

                        } while (index < 0 || index >ci1.getClientes().size()-1);
                        
                        String novoNome;
                        do {
                            System.out.println("Digite o novo nome: ");
                            novoNome = sc.nextLine();
                        } while(novoNome.isBlank() == true || novoNome.length() < 3);

                        String novoCpf;
                        do {
                            System.out.println("Digite o novo cpf (xxx.xxx.xxx-xx): ");
                            novoCpf = sc.nextLine();
                        } while (novoCpf.isBlank() == true || novoCpf.length() < 14);
                        
                        int novaIdade;
                        do {
                            System.out.println("Digite a nova idade: ");
                            novaIdade = Integer.parseInt(sc.nextLine());
                        } while(novaIdade < 1 || novaIdade > 120);
                        
                        ci1.editarCliente(novoCpf, novoNome, novaIdade, index);

                    } else if (decisaoCliente == 2){
                        int index;
                        do {
                            System.out.println("Digite o Index do cliente que deseja excluir: ");
                            index = Integer.parseInt(sc.nextLine());
                        } while (index < 0 || index > ci1.getClientes().size()-1);
 
                        ci1.removerCliente(ci1.getClientes().get(index));
                    } else if (decisaoCliente == 3){
                        String nome;
                        do {
                            System.out.println("Nome do cliente: ");
                            nome = sc.nextLine();
                        } while (nome.isBlank() == true || nome.length() < 3);
                        
                        String cpf;
                        do {
                            System.out.println("CPF do cliente (xxx.xxx.xxx-xx): ");
                            cpf = sc.nextLine();
                        } while(cpf.isBlank() == true || cpf.length() != 14);
                        
                        int idade;
                        do {
                            System.out.println("Idade do cliente: ");
                            idade = Integer.parseInt(sc.nextLine());
                        } while (idade < 1 || idade > 120);   
                        
                        String estudanteStr;
                        do {
                            System.out.println("É estudante (true | false):");
                            estudanteStr = sc.nextLine();
                        } while (estudanteStr.equals("true") == false && estudanteStr.equals("false") == false );
                        boolean estudante = Boolean.parseBoolean(estudanteStr);

                        Cliente c = new Cliente(cpf, nome, idade, estudante);
                        ci1.registrarCliente(c);

                    } else if (decisaoCliente == 4) {
                        ci1.listaClientesOrdenado();
                        System.out.println("Clientes ordenados com sucesso!");

                    } else {
                        continue;
                    }
                    break;

                case 2:
                    ci1.listarFilmes();
                    System.out.println("Consulta | há "+ci1.getFilmes().size()+" filmes");
                    System.out.println("Digite 1 para editar, 2 para excluir, 3 para resgitrar, 4 para ordenar(minutagem) ou 0 para voltar: ");
                    int decisaoFilme = Integer.parseInt(sc.nextLine());

                    if(decisaoFilme == 1){
                        int index;
                        do {
                            System.out.println("Digite o index do filme que deseja editar: ");
                            index = Integer.parseInt(sc.nextLine());

                        } while (index < 0 || index > ci1.getFilmes().size()-1);
                        
                        String novoTitulo;
                        do {
                            System.out.println("Digite o novo titulo: ");
                            novoTitulo = sc.nextLine();
                        } while(novoTitulo.isBlank() == true || novoTitulo.length() < 3);

                        String novoGenero;
                        do {
                            System.out.println("Digite o novo genero: ");
                            novoGenero = sc.nextLine();
                        } while (novoGenero.isBlank() == true || novoGenero.length() < 3);

                        int novaClassificacaoIndicativa;
                        do {
                            System.out.println("Digite o nova classificação indicativa (0 | 6 | 10 | 12| 14 | 16 |18): ");
                            novaClassificacaoIndicativa = Integer.parseInt(sc.nextLine());
                        } while (novaClassificacaoIndicativa != 0 && novaClassificacaoIndicativa != 6 && novaClassificacaoIndicativa != 10 && novaClassificacaoIndicativa != 12 
                            && novaClassificacaoIndicativa != 14 && novaClassificacaoIndicativa != 16 &&novaClassificacaoIndicativa != 18);
                        
                        System.out.println("Digite o novo tempo (em minutos): ");
                        int novaDuracaoMinutos = Integer.parseInt(sc.nextLine());
                        
                        ci1.editarFilme(novoTitulo, novoGenero, novaClassificacaoIndicativa, novaDuracaoMinutos, index);

                    } else if (decisaoFilme == 2){
                        int index;
                        do {
                            System.out.println("Digite o Index do filme que deseja excluir: ");
                            index = Integer.parseInt(sc.nextLine());
                        } while (index < 0 || index > ci1.getFilmes().size()-1);
                        
                        ci1.removerFilme(ci1.getFilmes().get(index));

                    } else if (decisaoFilme == 3){
                        
                        String titulo;
                        do {
                            System.out.println("Titulo do Filme: ");
                            titulo = sc.nextLine();
                        } while (titulo.isBlank() == true || titulo.length() < 2);
                        
                        String genero;
                        do {
                            System.out.println("Genero do filme: ");
                            genero = sc.nextLine();
                        } while (genero.isBlank() == true || genero.length() < 3);

                        int classificacaoIndicativa;
                        do {
                            System.out.println("Classificação do filme (0 | 6 | 10 | 12| 14 | 16 |18): ");
                            classificacaoIndicativa = Integer.parseInt(sc.nextLine());
                        } while (classificacaoIndicativa != 0 && classificacaoIndicativa != 6 && classificacaoIndicativa != 10 && classificacaoIndicativa != 12 
                            && classificacaoIndicativa != 14 && classificacaoIndicativa != 16 && classificacaoIndicativa != 18);
                        
                        int duracaoMinutos;
                        do {
                            System.out.println("Tempo do filme (em minutos): ");
                            duracaoMinutos = Integer.parseInt(sc.nextLine());
                        } while (duracaoMinutos < 60 || duracaoMinutos > 300);
                        
                        Filme f = new Filme(titulo, genero, classificacaoIndicativa, duracaoMinutos);
                        ci1.registrarFilme(f);
                    } else if(decisaoFilme == 4){
                        ci1.listaFilmesOrdenado();
                        System.out.println("Filmes ordenados com sucesso!");
                    } else {
                        continue;
                    }
                    break;

                case 3:
                    ci1.listarSalas();
                    System.out.println("Consulta | há "+ci1.getSalas().size()+" salas");
                    System.out.println("Digite 1 para editar, 2 para excluir, 3 para registrar, ou 0 para voltar: ");
                    int decisaoSala = Integer.parseInt(sc.nextLine());

                    if(decisaoSala == 1){
                        int index;
                        do {
                            System.out.println("Digite o número da sala que deseja editar: ");
                            index = Integer.parseInt(sc.nextLine())-1;
                        } while (index < 0 || index > ci1.getSalas().size()-1);
                        
                        int novoCapacidadeTotal;
                        do {
                            System.out.println("Digite a nova capacidade total (50 a 130): ");
                            novoCapacidadeTotal = Integer.parseInt(sc.nextLine());
                        } while(novoCapacidadeTotal < 50 || novoCapacidadeTotal > 130);

                        String novoVipStr;
                        do {
                            System.out.println("Digite se a sala é VIP (true | false): ");
                            novoVipStr = sc.nextLine();
                        } while (novoVipStr.equals("true") == false && novoVipStr.equals("false") == false );
                        boolean novoVip = Boolean.parseBoolean(novoVipStr);

                        String novoTipoTela;
                        do {
                            System.out.println("Digite o tipo de tela (IMAX | 3D | 2D): ");
                            novoTipoTela = sc.nextLine();
                        } while (novoTipoTela.equals("IMAX") == false && novoTipoTela.equals("3D") == false && novoTipoTela.equals("2D") == false);
                        ci1.editarSala(novoCapacidadeTotal, novoVip, novoTipoTela, index);

                    } else if (decisaoSala == 2){
                        int index;
                        do {
                            System.out.println("Digite o número da sala que deseja excluir: ");
                            index = Integer.parseInt(sc.nextLine())-1;
                        } while (index < 0 || index > ci1.getSalas().size());

                        ci1.removerSala(ci1.getSalas().get(index));

                    } else if (decisaoSala == 3){
                        int capacidadeTotal;
                        do {
                            System.out.println("Capacidade da sala (50 a 130): ");
                            capacidadeTotal = Integer.parseInt(sc.nextLine());
                        } while (capacidadeTotal < 50 || capacidadeTotal > 130);
                        
                        String vipStr;
                        do {
                            System.out.println("Sala VIP (true | false): ");
                            vipStr = sc.nextLine();
                        } while (vipStr.equals("true") == false && vipStr.equals("false") == false );
                        boolean vip = Boolean.parseBoolean(vipStr);

                        String tipoTela;
                        do {
                            System.out.println("Tipo de tela (IMAX | 3D | 2D): ");
                             tipoTela = sc.nextLine();
                        } while(tipoTela.equals("IMAX") == false && tipoTela.equals("3D") == false && tipoTela.equals("2D") == false);

                        Sala s = new Sala(capacidadeTotal, tipoTela, vip);
                        ci1.registrarSala(s);
                    } else {
                        continue;
                    }
                    break;

                case 4:
                    ci1.listarProdutos();
                    System.out.println("Consulta | há "+ci1.getProdutos().size()+" produtos");
                    System.out.println("Digite 1 para editar, 2 para excluir, 3 para registrar, 4 para ordenar(valor) ou 0 para voltar: ");
                    int decisaoProduto = Integer.parseInt(sc.nextLine());

                    if(decisaoProduto == 1){
                        int index;
                        do {
                            System.out.println("Digite o index do produto que deseja editar: ");
                            index = Integer.parseInt(sc.nextLine());
                        } while (index < 0 || index > ci1.getSalas().size()-1);
                        
                        String novoNomeProduto;
                        do {
                            System.out.println("Digite o novo nome do produto: ");
                            novoNomeProduto = sc.nextLine();
                        } while(novoNomeProduto.isBlank() == true || novoNomeProduto.length() < 5);

                        double novoPreco;
                        do {
                            System.out.println("Digite o novo preco do produto: ");
                            novoPreco = Double.parseDouble(sc.nextLine());
                        } while (novoPreco < 1 || novoPreco > 200);

                        String novaCategoria;
                        do {
                            System.out.println("Digite a categoria (Alimentação | Bebidas): ");
                            novaCategoria = sc.nextLine();
                        } while (novaCategoria.equals("Alimentação") == false && novaCategoria.equals("Bebidas") == false);

                        ci1.editarProduto(novoNomeProduto, novoPreco, novaCategoria, index);
                    } else if (decisaoProduto == 2) {
                        int index;
                        do {
                            System.out.println("Digite o index do produto que deseja excluir: ");
                            index = Integer.parseInt(sc.nextLine());
                        } while (index < 0 || index > ci1.getProdutos().size()-1);

                        ci1.removerProduto(ci1.getProdutos().get(index));

                    } else if (decisaoProduto == 3){

                        String nome;
                        do {
                            System.out.println("Digite o nome do produto: ");
                            nome = sc.nextLine();
                        } while(nome.isBlank() == true || nome.length() < 5);

                        double preco;
                        do {
                            System.out.println("Digite o preco do produto: ");
                            preco = Double.parseDouble(sc.nextLine());
                        } while (preco < 1 || preco > 200);

                        String categoria;
                        do {
                            System.out.println("Digite a categoria (Alimentação | Bebidas): ");
                            categoria = sc.nextLine();
                        } while (categoria.equals("Alimentação") == false && categoria.equals("Bebidas") == false);

                        Produto p = new Produto(nome, preco, categoria);
                        ci1.registrarProduto(p);

                    } else if(decisaoProduto == 4){
                        ci1.listaProdutosOrdenado();
                        System.out.println("Produtos ordenados com sucesso!");
                    } else {
                        continue;
                    }

                    break;

                case 5:
                    ci1.listarVendas();
                    System.out.println("Consulta | há "+ci1.getVendas().size()+" vendas");
                    System.out.println("Digite 1 para registrar uma venda, 2 para ordenar(valor) ou 0 para voltar: ");
                    int decisãoVenda = Integer.parseInt(sc.nextLine());

                    if(decisãoVenda == 1){

                        ci1.listarClientes();
                        Cliente cliente;
                        int indexCliente;
                        do {
                            System.out.println("Digite o index do cliente: ");
                            indexCliente = Integer.parseInt(sc.nextLine());
                        } while (indexCliente < 0 || indexCliente > ci1.getClientes().size()-1);
                        cliente = ci1.getClientes().get(indexCliente);

                        ci1.listarFilmes();
                        Filme filme;
                        int indexFilme;
                        do {
                            System.out.println("Digite o index do filme: ");
                            indexFilme = Integer.parseInt(sc.nextLine());
                        } while (indexFilme < 0 || indexFilme > ci1.getClientes().size()-1);
                        filme = ci1.getFilmes().get(indexFilme);

                        ci1.listarSalas();
                        Sala sala;
                        int indexSala;
                        do {
                            System.out.println("Digite o número da sala: ");
                            indexSala = Integer.parseInt(sc.nextLine())-1;
                        } while (indexSala < 0 || indexSala > ci1.getClientes().size());
                        sala = ci1.getSalas().get(indexSala);

                        Venda v = new Venda(cliente, filme, sala);
                        ci1.registrarVenda(v);

                        int escolhaProdutoVenda;
                        do {
                            System.out.println("Vai ter produto [1]SIM [2]NÃO: ");
                            escolhaProdutoVenda = Integer.parseInt(sc.nextLine());
                        } while(escolhaProdutoVenda < 1 || escolhaProdutoVenda > 2);
                        if (escolhaProdutoVenda == 1){
                            ci1.listarProdutos();
                            int produtoEscolhido;
                            do {
                                System.out.println("Digite o index do produto: ");
                                produtoEscolhido = Integer.parseInt(sc.nextLine());
                            } while (produtoEscolhido < 0 || produtoEscolhido > ci1.getProdutos().size()-1);
                            v.adicionarProduto(ci1.getProdutos().get(produtoEscolhido));
                        } else {
                            continue;
                        }
                        
                    } else if(decisãoVenda == 2){
                        ci1.listaVendasOrdenado();
                        System.out.println("Vendas ordenas com sucesso!");
                    } else {
                        continue;
                    }

                    break;

                case 6:
                    System.out.println("=".repeat(20));
                    System.out.println("[Relatório | Indicadores]");
                    System.out.println("=".repeat(20));
                    System.out.println(dataFormatada);
                    System.out.println("Faturamento Total    | "+ci1.calcularFaturamentoTotal()+"R$");
                    System.out.println("Valor médio vendas   | "+ci1.mediaValorVendas()+"R$");
                    System.out.println("Valor médio produtos | "+ci1.mediaValorProdutos()+"R$");
                    System.out.println("Comissão funcionário | "+ci1.calcularFaturamentoTotal()*0.10+"R$");
                    ci1.rankingVendas();
                    ci1.listaRakeadaVendas();
                    break;

                case 7:
                    String cpf;
                        do {
                            System.out.println("Digite o CPF do cliente(xxx.xxx.xxx-xx): ");
                            cpf = sc.nextLine();
                        } while(cpf.isBlank() == true || cpf.length() != 14);

                        Cliente buscado = ci1.buscarClienteCpf(cpf);
                        if(buscado == null){
                            System.out.println("Cliente não encontrado com CPF "+cpf);
                        } else {
                            buscado.infoCliente();
                        }
                    break;

                case 8:
                    Dados dados = new Dados(ci1);
                    ArmazenamentoJson.exportar(dados, "dados_cinema.json");
                    //teoricamente é isso
                    break;

                default:
                    sc.close();
                    break;
            }
        }
    }
}