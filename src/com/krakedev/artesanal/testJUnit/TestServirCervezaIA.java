package com.krakedev.artesanal.testJUnit;

import com.krakedev.artesanal.Maquina;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestServirCervezaIA {

	// Tolerancia para comparar valores double
	private static final double DELTA = 0.01;

	/*
	 * CASO 1: Servicio correcto con suficiente cerveza disponible.
	 * 
	 * Se valida que: - Cuando la máquina tiene suficiente cantidad de cerveza, el
	 * método sirve correctamente la cantidad solicitada. - Se descuenta esa
	 * cantidad del total disponible. - Se calcula correctamente el valor a pagar
	 * multiplicando la cantidad servida por el precio por ml.
	 */
	@Test
	void testServirCervezaCorrectamente() {
		Maquina maquina = new Maquina("Pilsener", "Rubia", 0.5, 1000,"COD001");

		maquina.recargarCerveza(500);

		double valor = maquina.servirCerveza(200);

		assertEquals(100, valor, DELTA);
		assertEquals(300, maquina.getCantidadActual(), DELTA);
	}

	/*
	 * CASO 2: No se puede servir por falta de cerveza.
	 * 
	 * Se valida que: - Si la cantidad solicitada es mayor a la disponible, la
	 * máquina no debe servir nada. - El método debe retornar 0. - La cantidad
	 * actual de cerveza no debe modificarse.
	 */
	@Test
	void testNoSirvePorFaltaDeCerveza() {
		Maquina maquina = new Maquina("Pilsener", "Rubia", 0.5, 1000,"COD001");

		maquina.recargarCerveza(100);

		double valor = maquina.servirCerveza(200);

		assertEquals(0, valor, DELTA);
		assertEquals(100, maquina.getCantidadActual(), DELTA);
	}

	/*
	 * CASO 3: Se sirve exactamente la cantidad disponible.
	 * 
	 * Se valida que: - Si la cantidad solicitada es igual a la disponible, la
	 * máquina debe servir todo sin problema. - El valor retornado debe ser
	 * correcto. - La cantidad actual debe quedar en 0.
	 */
	@Test
	void testServirExactamenteLoDisponible() {
		Maquina maquina = new Maquina("Pilsener", "Rubia", 1.0, 1000,"COD001");

		maquina.recargarCerveza(300);

		double valor = maquina.servirCerveza(300);

		assertEquals(300, valor, DELTA);
		assertEquals(0, maquina.getCantidadActual(), DELTA);
	}

	/*
	 * CASO 4: Máquina sin cerveza (cantidad actual = 0).
	 * 
	 * Se valida que: - Si no hay cerveza en la máquina, no se debe servir nada. -
	 * El método debe retornar 0. - La cantidad actual debe mantenerse en 0.
	 */
	@Test
	void testNoSirveCuandoEstaVacia() {
		Maquina maquina = new Maquina("Pilsener", "Rubia", 0.5, 1000,"COD001");

		double valor = maquina.servirCerveza(100);

		assertEquals(0, valor, DELTA);
		assertEquals(0, maquina.getCantidadActual(), DELTA);
	}

	/*
	 * CASO 5: Validación del cálculo del precio.
	 * 
	 * Se valida que: - El valor retornado corresponde exactamente al producto entre
	 * la cantidad servida y el precio por ml. - Se verifica específicamente la
	 * fórmula de cálculo.
	 */
	@Test
	void testCalculoCorrectoDelPrecio() {
		Maquina maquina = new Maquina("IPA", "Artesanal", 0.75, 1000,"COD001");

		maquina.recargarCerveza(400);

		double valor = maquina.servirCerveza(100);

		assertEquals(75, valor, DELTA);
	}

}
