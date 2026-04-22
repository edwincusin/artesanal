package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Negocio;

public class TestAsignarCodigoCliente {
	
	@Test
	public void asignarCodigo() {
		Negocio barDeMoe=new Negocio();
		
		Cliente mario= new Cliente("Mario", "123456789");
		Cliente daniel= new Cliente("Daniel", "8888888888");
		
		barDeMoe.asignarCodigoCliente(mario);
		barDeMoe.asignarCodigoCliente(daniel);
		
		assertEquals(100, mario.getCodigo(),0.001);
		assertEquals(101, daniel.getCodigo(),0.001);
		
		System.out.println(mario.getCodigo());
		System.out.println(daniel.getCodigo());
	}
}
