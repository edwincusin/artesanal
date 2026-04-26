package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.Negocio;

public class TestVaciar {

	public static void main(String[] args) {

		// con el constructor 1 
		Maquina rubia = new Maquina("Pilsener", "cerveza frias", 0.02, 8000, "COD001");
		rubia.imprimir();
		rubia.llenarMaquina(); // llenamos
		rubia.imprimir(); // impresion despues de llenar
		
		
		Negocio negoci01=new Negocio("Mi negocio CSN",rubia);
		
		System.out.println("Nombre:"+ negoci01.getNombre());
		System.out.println("Maquina:"+ negoci01.getMaquinaA());
		
		
		//vaciamos 
		rubia.vaciarMaquina();
		rubia.imprimir();		

	}

}
