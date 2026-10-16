package com.ticketsale;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DescontoClienteTest {

    @Test
    public void deveriaAplicarDescontoParaEstudante() {
        Cliente estudante = new Cliente("222.222.222-22", "Beatriz", 20, true);
        Filme filme = new Filme("Comédia", "Comédia", 10, 90);
        Sala sala = new Sala(50, "Normal", false);
        
        Venda venda = new Venda(estudante, filme, sala);
        double valorTotal = venda.calcularValorTotal();

        System.out.println("[TESTE DESCONTO] Valor calculado para estudante (esperado 10): R$ " + valorTotal);

        assertEquals(10.0, valorTotal, 0.001, "O valor para estudante deve ter 50% de desconto.");
    }

    @Test
    public void deveriaAplicarDescontoParaIdoso() {
        Cliente idoso = new Cliente("333.333.333-33", "Carlos", 65, false);
        Filme filme = new Filme("Drama", "Drama", 10, 100);
        Sala sala = new Sala(50, "Normal", false);
        
        Venda venda = new Venda(idoso, filme, sala);
        double valorTotal = venda.calcularValorTotal();

        System.out.println("[TESTE DESCONTO] Valor calculado para idoso (esperado 10): R$ " + valorTotal);

        assertEquals(10.0, valorTotal, 0.001, "O valor para idoso deve ter 50% de desconto.");
    }
}