package com.krakedev.artesanal;

public class Negocio {
	// ATRIBUTOS
	private String nombre;
	private Maquina maquinaA;
	private int ultimoCodigo=100;
	//CONSTRUCTOR VACIO
	public Negocio() {
		//vacio
	}
	// CONSTRUCTOR CON APSO DE PARAMETROS
	public Negocio(String nombre, Maquina maquinaA) {
		this.nombre = nombre;
		this.maquinaA = maquinaA;
	}

	// METODOS GET Y SET
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Maquina getMaquinaA() {
		return maquinaA;
	}

	public void setMaquinaA(Maquina maquinaA) {
		this.maquinaA = maquinaA;
	}
	//METODO ASIGNAR CODIGO CLIENTE
	public void asignarCodigoCliente(Cliente cliente) {
		cliente.setCodigo(ultimoCodigo);
		ultimoCodigo++;
	}
	//CARGAR MAQUINA
	public void cargarMaquinaA() {
		maquinaA.llenarMaquina();
	}
	//METODO CONSUMIR CERVEZA 
	public void consumirCervezaMaquinaACliente(Cliente cliente, double ml){
		double valor=maquinaA.servirCerveza(ml);
		cliente.setTotalConsumido(cliente.getTotalConsumido()+valor);
	}

}
