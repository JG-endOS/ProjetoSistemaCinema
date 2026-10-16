package com.ticketsale;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IdadeIngressoTest {

    @Test
    public void naoDeveriaRegistrarVendaParaMenorDeIdade() {
        Cinema cinema = new Cinema("CineTest");
        Filme filme16 = new Filme("Filme Extremo", "Ação", 16, 120);
        Cliente menorDeIdade = new Cliente("111.111.111-11", "Lucas", 14, false);
        Sala sala = new Sala(50, "IMAX", false);
        
        Venda venda = new Venda(menorDeIdade, filme16, sala);
        cinema.registrarVenda(venda);

        System.out.println("[TESTE IDADE] Quantidade de vendas registradas (esperado 0): " + cinema.getVendas().size());

        assertEquals(0, cinema.getVendas().size(), "A venda não deveria ser registrada para quem tem idade abaixo da classificação.");
    }
}