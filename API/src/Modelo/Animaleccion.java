package Modelo;

import java.util.ArrayList;
import java.util.Observable;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Vista.VPrincipal;

public class Animaleccion extends Observable{
	
	private String[] solucion;
	private ArrayList<String> opciones;
	private ImageIcon imagen;
	private int vidas = 1;
	private int fase = 0;
	private static Animaleccion miAnimaleccion = new Animaleccion();
	
	//constructora
	private Animaleccion(){}
	
	//getters
	public static Animaleccion getAnimaleccion(){
		return miAnimaleccion;
	}
	
	public int getVidas(){
		return this.vidas;
	}
	
	public String[] getSolucion(){
		return this.solucion;
	}
	
	public String getSolucion2(){
		return this.solucion[fase];
	}
	
	public ArrayList<String> getOpciones(){
		return this.opciones;
	}
	
	public int getFase(){
		return this.fase;
	}
	public Icon getImagen() {
		return this.imagen;
	}
	
	//setter del tablero
	public void setTablero(String[] pSolucion, ArrayList<String> pOpciones, int pFase){
		solucion = pSolucion;
		opciones = pOpciones;
		vidas = 1;
		fase = pFase;
		System.out.println(solucion[fase]);
		imagen = new ImageIcon(getClass().getResource("img//"+solucion[fase].toLowerCase()+".jpg"));
		System.out.println(imagen);
		
		setChanged();
		notifyObservers(null);
	}
	
	public void comprobar(String pEleccion){
		if(!pEleccion.equals(solucion[fase])){
			vidas--;
			
		}
		
		if(vidas<0){
			System.out.println("Acaba el juego perdido");
		}
		fase++;
		if(fase<4){
			changeImg();
		}
		
		setChanged();
		notifyObservers(null);
		
		
	}

	private void changeImg() {
		this.imagen =  new ImageIcon(getClass().getResource("img//"+solucion[fase].toLowerCase()+".jpg"));
		
	}

	
}

