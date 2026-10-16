package com.ticketsale;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SalaLotadaTest {

    @Test
    public void naoDeveriaPermitirVendaQuandoSalaEstiverLotada() {
        Cinema cinema = new Cinema("CineTest");
        Cliente cliente = new Cliente("444.444.444-44", "Mariana", 25, false);
        Filme filme = new Filme("Bob Esponja", "Aventura", 10, 110);
        Sala salaLotada = new Sala(0, "IMAX", false); 
        
        Venda venda = new Venda(cliente, filme, salaLotada);
        cinema.registrarVenda(venda);

        System.out.println("[TESTE SALA] Vendas registradas com sala lotada (esperado 0): " + cinema.getVendas().size());

        assertEquals(0, cinema.getVendas().size(), "A venda não deve ser registrada se a capacidade da sala for <= 0.");
    }
}