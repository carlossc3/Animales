package Modelo;

import java.util.ArrayList;
import java.util.Random;

public class GestorAnimaleccion {

	private ArrayList<String> animales = new ArrayList<>();
	private static GestorAnimaleccion miGestorAhorcado = new GestorAnimaleccion();
	
	
	private GestorAnimaleccion(){
		
	}
	
	public static GestorAnimaleccion getGestorAnimaleccion(){
		return miGestorAhorcado;
	}
	
	public void importAnimales(String path){
		
		animales.add("RINOCERONTE");
		animales.add("GALLINA");
		animales.add("PERRO");
		animales.add("CAMALEON");
		animales.add("IGUANA");
		animales.add("SALTAMONTES");
		animales.add("TIBURON");
		animales.add("MARIPOSA");
		animales.add("MARIQUITA");
		animales.add("ARAÑA");
		animales.add("HIPOPOTAMO");
		animales.add("MORSA");
		animales.add("PINGUINO");
		animales.add("MARIQUITA");
		animales.add("ARAÑA");
		animales.add("HIPOPOTAMO");
		animales.add("MORSA");
		animales.add("PINGUINO");
	}
	
	
	public void initAnnimaleccion(){
		Random rm = new Random();
		ArrayList<String> opciones = animales;
		String[] soluciones = new String[5];
		System.out.println(animales.size());
		int pos = 0;
		for(int i =0; i<5;i++){
			pos = rm.nextInt(opciones.size());
			soluciones[i] = opciones.get(pos);
			opciones.remove(pos);
			
		}
		Animaleccion.getAnimaleccion().setTablero(soluciones, opciones, 0);
	}
}
