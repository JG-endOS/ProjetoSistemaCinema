package com.ticketsale;

public class App {
    public static void main(String[] args) {
        Produto p1 = new Produto("Pipoca G", 30.50, "Alimentação");
        Produto p2 = new Produto("Refrigerante 500ml", 10.30, "Bebidas");

        Cliente c1 = new Cliente("012.983.765-01", "João Gabriel", 17,false);
        Cliente c2 = new Cliente("002.183.982-07", "Isabela", 18,true);
        //Cliente c3 = new Cliente("190.503.567-91", "Kali", 17,true);

        Sala s1 = new Sala(1, 100, "2D", false);
        Sala s2 = new Sala(2, 100, "3D", false);
        //Sala s3 = new Sala(3, 100, "IMAX", true);

        Filme f1 = new Filme("Filme 1", "Terror", 18, 180);
        Filme f2 = new Filme("Filme 2", "Comédia", 12, 120);
        //Filme f3 = new Filme("Filme 3", "Ação", 0, 90);

        Venda v1 = new Venda(c1, f1, s1);
        v1.adicionarProduto(p1);
        Venda v2 = new Venda(c2, f2, s2);
        v2.adicionarProduto(p1);
        v2.adicionarProduto(p2);
               
        Cinema ci1 = new Cinema("CineMax");
        ci1.registrarVenda(v1);
        ci1.registrarVenda(v2);

        ci1.listarVendas();
    }
}