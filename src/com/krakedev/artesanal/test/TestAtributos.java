package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestAtributos {

	public static void main(String[] args) {
	//Instanciar maquina con primer constructor
		Maquina rubia=new Maquina("Pilsener","cerveza rubia",0.02,10000,"COD001");
		rubia.imprimir();
		rubia.setNombreCerveza("Golden Ale");
		rubia.setDescripcion("Cerveza con aroma mas intensa");
		rubia.imprimir();
		
	}

}
