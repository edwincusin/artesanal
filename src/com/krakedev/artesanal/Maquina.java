package com.krakedev.artesanal;

public class Maquina {
	// ATRIBUTOS
	private String codigo;
	private String nombreCerveza;
	private String descripcion;
	private double precioPorMl;
	private double capacidadMaxima;
	private double cantidadActual;
	
	//CONSTRUCTOR VACIO
	public Maquina() {
		//vacio o null
	}

	// CONSTRUCTOR CON PARAMETROS-* MOLDES
	public Maquina(String nombreCerveza, String descripcion, double precioPorMl, double capacidadMaxima,String codigo) {
		this.nombreCerveza=nombreCerveza;
		this.descripcion=descripcion;
		this.precioPorMl=precioPorMl;
		this.capacidadMaxima=capacidadMaxima;
		this.cantidadActual=0;
		this.codigo=codigo;

	}
	
	// CONSTRUCTOR CON PARAMETROS-* MOLDES
	public Maquina(String nombreCerveza, String descripcion, double precioPorMl, String codigo) {
		this.nombreCerveza=nombreCerveza;
		this.descripcion=descripcion;
		this.precioPorMl=precioPorMl;
		this.capacidadMaxima=100000;
		this.cantidadActual=0;
		this.codigo=codigo;
	}



	// METODOS GET Y SET
	public String getNombreCerveza() {
		return nombreCerveza;
	}

	public void setNombreCerveza(String nombreCerveza) {
		this.nombreCerveza = nombreCerveza;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioPorMl() {
		return precioPorMl;
	}

	public void setPrecioPorMl(double precioPorMl) {
		this.precioPorMl = precioPorMl;
	}

	public double getCapacidadMaxima() {
		return capacidadMaxima;
	}
	
	public String getCodigo() {
		return codigo;
	}


	// SE ELIMINA EL METODO DEL SET CAPACIDAD MAXIMA PARA EVITAR MODIFICACIONES EN EL ATRIBUTO
	public double getCantidadActual() {
		return cantidadActual;
	}
	// SE ELIMINA EL METODO DEL SET DE CANTIDAD ACTUAL PARA EVITAR QUE MODIFIQUEN EL ATRIBUTO

	// METDODO PARA IMPRIMIR
	public void imprimir() {
		String mensaje = "Nombre cerveza:" + nombreCerveza + ", Descripcion: " + descripcion + ", Precio por ML: "
				+ precioPorMl + ", Capacidad maxima: " + capacidadMaxima + ", Cantidad actual: " + cantidadActual+ ", Codigo: "+codigo;
		System.out.println(mensaje);
	}
	
	//METODO PARA LLENAR MAQUINA
	public void llenarMaquina() {
		this.cantidadActual=this.capacidadMaxima-100;
	}
	
	//RECARGAR CERVEZA: RETORNA T | F
	public boolean recargarCerveza(double cantidad) {
		double limitePermitido;
		limitePermitido=capacidadMaxima-100;
			
		if(cantidadActual + cantidad<=limitePermitido) {
			cantidadActual=cantidadActual+cantidad;
			return true;
		}else {
			
			return false;
		}
	}
	//PRECIO CALCULADO DE LO QUE SE SIRVIO EL USUARIO
	public double servirCerveza (double cantidadDespachar) {
		if(cantidadActual>=cantidadDespachar) {
			cantidadActual-=cantidadDespachar;
			double valor= cantidadDespachar*precioPorMl;
			return valor;
		} else {
			return 0;
		}
	}

}
