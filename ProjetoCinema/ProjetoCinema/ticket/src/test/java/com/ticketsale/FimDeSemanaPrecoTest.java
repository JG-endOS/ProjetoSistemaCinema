package com.ticketsale;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class FimDeSemanaPrecoTest {

    @Test
    public void deveriaCalcularPrecoNormalDuranteDiaDeSemana() {
        Cliente cliente = new Cliente("444.444.444-44", "Mariana", 25, false);
        Filme filme = new Filme("Filme Chato", "Aventura", 10, 110);
        Sala sala = new Sala(50, "3D", false); // Sala comum (não VIP)
        
        // TERÇA
        LocalDateTime dataDiaDeSemana = LocalDateTime.of(2026, 10, 13, 20, 0);
        
        Venda venda = new Venda(cliente, filme, sala, dataDiaDeSemana);
        double valorTotal = venda.calcularValorTotal();

        System.out.println("[TESTE DIA DE SEMANA] Valor total (esperado 20.0): R$ " + valorTotal);

        assertEquals(20.0, valorTotal, 0.001, "Em dia de semana o valor deve ser apenas o preço base de R$ 20,00.");
    }

    @Test
    public void deveriaAcrescentarDezReaisNoFinalDeSemana() {
        Cliente cliente = new Cliente("444.444.444-44", "Mariana", 25, false);
        Filme filme = new Filme("Aventura", "Aventura", 10, 110);
        Sala sala = new Sala(50, "2D", false); // Sala comum (não VIP)
        
        // SÁBADO
        LocalDateTime dataFimDeSemana = LocalDateTime.of(2026, 10, 17, 20, 0);
        
        Venda venda = new Venda(cliente, filme, sala, dataFimDeSemana);
        double valorTotal = venda.calcularValorTotal();

        System.out.println("[TESTE FIM DE SEMANA] Valor total (esperado 30.0): R$ " + valorTotal);

        assertEquals(30.0, valorTotal, 0.001, "No final de semana o preço deve somar R$ 10,00 a mais.");
    }
}