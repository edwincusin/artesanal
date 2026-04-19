package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestRecargarJUnit {
	//cuando es exitoso la recarga
	@Test
	public void testRecargarExitoso() {
		Maquina rubia = new Maquina("PILSNER", "CERVEZA", 0.02, 8000,"COD001");
		boolean resultado=rubia.recargarCerveza(3000);
		assertTrue(resultado);//valida que se haya llenado con un true o false
		assertEquals(3000, rubia.getCantidadActual(),0.0001);
	}
	//cuando es fallida la recarga
	@Test
	public void testRecargarFallidaPorDesborde() {
		Maquina negra = new Maquina("CLUBS", "cerveza fria", 0.03, 8000,"COD001");
		negra.recargarCerveza(7000);
		boolean resultado=negra.recargarCerveza(7000);
		assertTrue(resultado);//valida que se haya llenado con un true o false
		assertEquals(14000, negra.getCantidadActual(),0.0001);
	}
}
