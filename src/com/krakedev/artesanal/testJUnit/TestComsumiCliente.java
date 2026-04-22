package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.Negocio;

public class TestComsumiCliente {
	double TOLERANCIA=0.001;
	
	@Test
	public void probarConsumo() {
		Maquina maquinaA=new Maquina("Pilsener", "Rubia",0.002, 8000, "01");
		Negocio barDeMooe=new Negocio("Bar de Moe",maquinaA);
		Cliente cliente=new Cliente ("Edwin", "1234567890");
		
		maquinaA.llenarMaquina();
		
		barDeMooe.consumirCervezaMaquinaACliente(cliente, 100);
		//maquinaA.imprimir(); //rpueba consola
		assertEquals(7800, maquinaA.getCantidadActual(),TOLERANCIA);
		assertEquals(0.2, cliente.getTotalConsumido(),TOLERANCIA);
		
		
		barDeMooe.consumirCervezaMaquinaACliente(cliente, 200);
		//maquinaA.imprimir(); //rpueba consola
		assertEquals(7600, maquinaA.getCantidadActual(),TOLERANCIA);
		assertEquals(0.6, cliente.getTotalConsumido(),TOLERANCIA);
		
	}
}
