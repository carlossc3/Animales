package Modelo;

import Vista.Reg_id;
import Vista.VPrincipal;

public class prueba {

	public static void main(String[] args) {
		GestorAhorcado.getGestorAhorcado().importAnimales("path de animales");
		GestorAnimaleccion.getGestorAnimaleccion().importAnimales(null);;
		VPrincipal.main(null);
		
		
	}
}

