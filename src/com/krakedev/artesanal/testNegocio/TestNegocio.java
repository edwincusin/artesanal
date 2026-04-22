package com.krakedev.artesanal.testNegocio;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.Negocio;

public class TestNegocio {

	public static void main(String[] args) {
		
		//INSTANCIAR OBJETO DE LA CLASE MAQUINA
		Maquina nueva=new Maquina("Cerveza club","Cerveza fria", 0.02, 8000,"COD001");
		//INSTANCIAR  OBJETO DE LA CLASE NEGOCIO
		Negocio negoci01=new Negocio("Mi negocio CSN",nueva);
		
		System.out.println("Nombre:"+ negoci01.getNombre());
		System.out.println("Maquina:"+ negoci01.getMaquinaA());
		
		//INSTANCIAR OBJETO DE LA CLASE MAQUINA=>NULL/VACIAS
		Maquina m1=negoci01.getMaquinaA();
		double capacidad=m1.getCapacidadMaxima();
	}

}
