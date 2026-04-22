package com.krakedev.artesanal.testNegocio;

import java.util.ArrayList;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestNegocioMejorado {

	public static void main(String[] args) {
		
		NegocioMejorado negocio=new NegocioMejorado();
		
		negocio.agregarMaquina("Pilzener","cerveza sin alcohol", 0.025);
		negocio.agregarMaquina("Club", "Verde", 0.014);
		negocio.cargarMaquinas();
		
		ArrayList<Maquina> maquinas=negocio.getMaquinas();
		for(Maquina maquina : maquinas) {
			maquina.imprimir();
		}
		
		negocio.registrarCliente("Edwin", "1753081056");
		negocio.registrarCliente("Daniel", "1753081057");
		
		ArrayList<Cliente> listaClientes = negocio.getClientes();
		for(Cliente cliente : listaClientes) {
			System.out.println(cliente.getNombre()+"  "+cliente.getCedula()+"  "+cliente.getCodigo());
		}
		
		Cliente clienteEncontrado=negocio.buscarClientePorCedula("1753081056");
		System.out.println(clienteEncontrado.getNombre());
		
		Cliente clienteEncontrado2=negocio.buscarClientePorCodigo(101);
		System.out.println(clienteEncontrado2.getNombre());
		
		negocio.consumirCerveza(101, "M-29",5);
		negocio.consumirCerveza(101, "M-7",5);
		negocio.consumirCerveza(101, "M-42",5);
		negocio.consumirCerveza(101, "M-91",5);
		
		for(Cliente cliente : listaClientes) {
			System.out.println(cliente.getNombre()+"  "+cliente.getCedula()+"  "+cliente.getCodigo()+"  "+ cliente.getTotalConsumido());
		}
		
		System.out.println("total vendido "+ negocio.consultarValorVendido());
	}

}
