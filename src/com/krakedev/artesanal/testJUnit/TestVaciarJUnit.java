package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestVaciarJUnit {

    double TOLERANCIA = 0.001;

    @Test
    public void testVaciarMaquinaConContenido() {
        Maquina maquina = new Maquina("Pilsener", "Cerveza rubia", 0.02, 5000, "COD01");
        
        maquina.recargarCerveza(1000); // llenamos un poco
        
        maquina.vaciarMaquina();
        
        assertEquals(0, maquina.getCantidadActual(), TOLERANCIA);
        assertEquals(1000, maquina.getCantidadDesperdicio(), TOLERANCIA);
    }

    @Test
    public void testVaciarMaquinaVacia() {
        Maquina maquina = new Maquina("Pilsener", "Cerveza rubia", 0.02, 5000, "COD02");
        
        maquina.vaciarMaquina();
        
        assertEquals(0, maquina.getCantidadActual(), TOLERANCIA);
        assertEquals(0, maquina.getCantidadDesperdicio(), TOLERANCIA);
    }

    @Test
    public void testVaciarMaquinaConDesperdicioPrevio() {
        Maquina maquina = new Maquina("Pilsener", "Cerveza rubia", 0.02, 5000, "COD03");
        
        maquina.recargarCerveza(500);
        maquina.setCantidadDesperdicio(200); // ya tenía desperdicio
        
        maquina.vaciarMaquina();
        
        assertEquals(0, maquina.getCantidadActual(), TOLERANCIA);
        assertEquals(700, maquina.getCantidadDesperdicio(), TOLERANCIA);
    }
}