package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	//ATRIBUTO MAQUINA DE TIPO ARRAY
	private ArrayList<Maquina> maquinas;
	private ArrayList<Cliente> clientes;
	private int ultimoCodigo=100;
	
	//CONSTRUCTOR
	public NegocioMejorado() {
		this.maquinas=new ArrayList<Maquina>();
		this.clientes=new ArrayList<Cliente>();
	}
	
	//METODOS GET Y SET
	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public int getUltimoCodigo() {
		return ultimoCodigo;
	}

	public void setUltimoCodigo(int ultimoCodigo) {
		this.ultimoCodigo = ultimoCodigo;
	}

	//METODO GENERAR CODIGO
	public String generarCodigo() {
		int numero=(int)(Math.random()*100)+1;
		return "M-"+numero;
	}
	//METODO AGREGAR MAQUINA
	public boolean  agregarMaquina(String nombre, String descripcion, double precioMl) {
		String codigo=generarCodigo();
		Maquina maquinaRecuperada = recuperarMaquina(codigo);
		if(maquinaRecuperada==null) {
			Maquina maquina= new Maquina(nombre, descripcion, precioMl, codigo);
			maquinas.add(maquina);
			return true;
		}
		return false;
				
	}
	//METODO CARGAR MAQUINAS
	public void cargarMaquinas() {
		for(int i=0;i<maquinas.size();i++) {
			maquinas.get(i).llenarMaquina();
		}
	}
	//METODO RECUPERAR MAQUINA
	public Maquina recuperarMaquina(String codigoMaquina) {
		Maquina maquina=null;
			for(Maquina maq : maquinas) {
				if(maq.getCodigo().equals(codigoMaquina)) {
					maquina=maq;
					return maquina;
				}
			}
		return maquina; 
	}
	// METODO REGISTRAR CLIENTE
	public void registrarCliente(String nombre, String cedula) {
		Cliente cliente=new Cliente(nombre,cedula);
		cliente.setCodigo(ultimoCodigo);
		ultimoCodigo++;
		clientes.add(cliente);		
	}
	
	//METODO BUSCAR CLIENTE POR CEDULA
	public Cliente buscarClientePorCedula(String cedula) {
		for(Cliente cli:clientes) {
			if(cli.getCedula().equals(cedula)) {
				return cli;
			}
		}
		return null;
	}
	//METODO BUSCAR CLIENTE POR CODIGO
	public Cliente buscarClientePorCodigo(int codigo) {
		for(Cliente cli:clientes) {
			if(cli.getCodigo()==codigo) {
				return cli;
			}
		}
		return null;
	}
	
	//METODO COSUMIR CERVEZA
	public void consumirCerveza(int codCliente, String codMaquina, int cantidad) {
		Maquina maquina=recuperarMaquina(codMaquina);
		Cliente cliente=buscarClientePorCodigo(codCliente);
		if(maquina!=null && cliente!=null) {
			double valor= maquina.servirCerveza(cantidad);
			registrarConsumo(codCliente, valor);
		}
		return;
	}
	
	//METODO REGISTRAR CONSUMO
	public void registrarConsumo(int codigo, double valor) {
		Cliente cliente =buscarClientePorCodigo(codigo);
		cliente.setTotalConsumido(cliente.getTotalConsumido()+valor);
	}
	
	//METODO CONSULTAR VALOR VENDIDO
	public double consultarValorVendido() {
		double totalVendido=0;
		for(Cliente cliente:clientes) {
			totalVendido+=cliente.getTotalConsumido();
		}
		
		return totalVendido;		
	}
	
}
