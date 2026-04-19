package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestServir {

	public static void main(String[] args) {
		//INSTANCIAR EN UN OBEJTO 
Maquina rubia= new Maquina("Pilsener", "cerveza frias", 0.02, 8000,"COD001");
		
		System.out.println("-----------ESTADO INICIAL-----------");
		rubia.imprimir();
		
		System.out.println("-----------LLENANDO MAQUINA-----------");
		rubia.llenarMaquina();
		System.out.println("Se lleno maquina correctamente ? "+rubia.getCantidadActual());
		rubia.imprimir();
		
		System.out.println("----1-------SERVIR 1000 ML-----------");
		double valor =rubia.servirCerveza(1000);
		System.out.println("Valor a pagar es: "+valor);
		rubia.imprimir();
		
		System.out.println("-----2------SERVIR 2000 ML-----------");
		valor =rubia.servirCerveza(2000);
		System.out.println("Valor a pagar es: "+valor);
		rubia.imprimir();
		
		System.out.println("-----3------SERVIR 6000 ML-----------");
		valor =rubia.servirCerveza(6000);
		System.out.println("Valor a pagar es: "+valor);
		rubia.imprimir();



	}

}
