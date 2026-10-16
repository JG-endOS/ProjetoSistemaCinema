package com.ticketsale;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FaturamentoFuncionariosTest {

    @Test
    void deveriaCalcularDezPorCentoDoFaturamentoTotalParaFuncionarios() {
        Cinema cinema = new Cinema("CineTest");
        Cliente cliente = new Cliente("444.444.444-44", "Mariana", 25, false);
        Filme filme = new Filme("Aventura", "Aventura", 10, 110);
        Sala sala = new Sala(50, "Normal", false);
        
        Venda venda = new Venda(cliente, filme, sala); 
        cinema.registrarVenda(venda);

        double faturamentoTotal = cinema.calcularFaturamentoTotal();
        double faturamentoFuncionarios = faturamentoTotal * 0.10;

        System.out.println("[TESTE FATURAMENTO] Faturamento Total: R$ " + faturamentoTotal);
        System.out.println("[TESTE FATURAMENTO] 10% para funcionários: R$ " + faturamentoFuncionarios);

        assertEquals(2.0, faturamentoFuncionarios, 0.001, "10% de R$ 20,00 de faturamento deve ser R$ 2,00.");
    }
}