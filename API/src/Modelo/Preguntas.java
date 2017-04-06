package Modelo;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

public class Preguntas extends Observable{
	
	private String[] pregunta = new String[5];
	private String[] correcta = new String[5];
	private String[][] falsas = new String[5][3];
	private int vidas = 1;
	private int fase = 0;
	private static Preguntas miPreguntas = new Preguntas();
	
	
	private Preguntas(){
		
	}
	
	public static Preguntas getPreguntas(){
		return miPreguntas;
	}
	
	public String getSolucion(){
		return correcta[fase];
	}
	
	public String getPregunta(){
		return pregunta[fase];
	}
	
	public String[] getFalsas(){
		return falsas[fase];
	}
	
	public int getVidas(){
		return vidas;
	}
	
	public int getFase(){
		return fase;
	}
	
	public void setTablero(ArrayList<String[]> preguntas, int fas){
		Random rd = new Random();
		int pos = 0;
		for(int i = 0; i<5; i++){
			String[] act = preguntas.get(rd.nextInt(preguntas.size()));
			pregunta[i] = act[0];
			correcta[i] = act[1];
			falsas[i][0] = act[2];
			falsas[i][1] = act[3];
			falsas[i][2] = act[4];
			preguntas.remove(act);
		}
		
		fase = fas;
		
		setChanged();
		notifyObservers(null);
	}
	
	public void comprobar(String pEleccion){
		if(!pEleccion.equals(correcta[fase])){
			vidas--;
			
		}
		
		if(vidas<0){
			System.out.println("Acaba el juego perdido");
		}
		
		fase++;
		
		System.out.println("Notifico");
		setChanged();
		notifyObservers(null);
		
		
	}

}
