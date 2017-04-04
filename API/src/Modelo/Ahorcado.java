package Modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

import javax.swing.ImageIcon;

public class Ahorcado extends Observable {

	private String solucion;
	private String[] ahorcado;
	private ImageIcon imagen;
	private int intentos;
	private static Ahorcado miAhorcado = new Ahorcado();
	
	private Ahorcado(){
		
	}
	
	public static Ahorcado getAhorcado(){
		return miAhorcado;
	}
	
	public void setTablero(String animal){
		this.solucion = animal;
		this.ahorcado = setGaps(animal);
		this.intentos = 5;
		this.imagen =  new ImageIcon(getClass().getResource("img//5.png"));
		setChanged();
		notifyObservers(1);
	
	}
	
	
	private String[] setGaps(String animal){
		
		String[] gaps = new String[animal.length()];
		for(int i = 0; i<animal.length();i++){
			gaps[i]="__";
		}
		return gaps;
	}
	
	private void changeImg(){
		if(this.intentos>-1){
		this.imagen =  new ImageIcon(getClass().getResource("img//"+Integer.toString(this.intentos)+".png"));
		}
		
	}
	
	public void comprobar(char letra){
		ArrayList<Integer> posGaps = new ArrayList<Integer>();
		int cont = 0;
		for(char act: this.solucion.toCharArray()){
			if(letra == act){
				posGaps.add(cont);
				
			}
			cont++;
		}
		
		if(posGaps.size()==0){
			this.intentos--;
			changeImg();
			
		}
		else{
			Iterator<Integer> it = posGaps.iterator();
			int pos=-1;
			while(it.hasNext()){
				pos = it.next();
				this.ahorcado[pos]= ""+this.solucion.charAt(pos);
				
			}
		}
		
		int resul = posGaps.size();
		if(checkAhorcado()){
			resul = -1;
		}
		
		if(this.intentos==0){
			resul = -2;
		}
		setChanged();
		notifyObservers(resul);
	}

	private boolean checkAhorcado() {

		for(String act : this.ahorcado){
			if(act.equals("__")){
				return false;
			}
		}
		return true;
	}

	public ImageIcon getImg() {
		return this.imagen;
		
	}

	public int getIntentos() {
		
		return this.intentos;
	}

	public String[] getGame() {
		return this.ahorcado;
	}

	public String getSolucion() {
		return this.solucion;
	}
	
}
