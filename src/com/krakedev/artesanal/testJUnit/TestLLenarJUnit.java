package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestLLenarJUnit {

	@Test
	public void testLLenarMaquina() {
		Maquina rubia = new Maquina("PILSNER", "CERVEZA", 0.02, 8000,"COD001");
		rubia.llenarMaquina();
		// assertEquals(LO QUE ESPERO COMO RESULTADO, CANTIDAD AGREGADO A LA MAQUINA,
		// MARGEN DE ERROR);
		assertEquals(7800, rubia.getCantidadActual(), 0.0001);
	}
}
