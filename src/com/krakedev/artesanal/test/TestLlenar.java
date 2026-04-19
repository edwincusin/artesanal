package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestLlenar {

	public static void main(String[] args) {
		//con el constructor 1
		Maquina rubia= new Maquina("Pilsener", "cerveza frias", 0.02, 8000,"COD001");
		rubia.imprimir();
		rubia.llenarMaquina();
		rubia.imprimir();
		//con el segundo constructor valor por defecto de capaxidad maxima
		Maquina negra=new Maquina("Club", "cerveza buena", 0.03,"COD002");
		negra.imprimir();
		negra.llenarMaquina();
		negra.imprimir();
	}

}
