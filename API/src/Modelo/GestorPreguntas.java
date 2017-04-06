package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestorPreguntas {
	
	private ArrayList<String[]> preguntas = new ArrayList<>();
	private static GestorPreguntas miGestorPreguntas = new GestorPreguntas();
	
	private GestorPreguntas(){
		
	}
	
	public static GestorPreguntas getGestorPreguntas(){
		return miGestorPreguntas;
	}
	
	public void importPreguntas(){
		String query = "SELECT * FROM preguntas";
		Conexion.conectar();
		Statement st = Conexion.conexion();
		try {
			if (st != null) {
				ResultSet rs = Conexion.consultaDatos(st, query);
				while(rs.next()){
					String [] pregunta = new String[5];
					pregunta[0] = rs.getString("pregunta");
					pregunta[1] = rs.getString("respuesta");
					pregunta[2] = rs.getString("respuesta2");
					pregunta[3] = rs.getString("respuesta3");
					pregunta[4] = rs.getString("respuesta4");
					preguntas.add(pregunta);
				}	
				Conexion.cerrar(rs);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
	}
	
	public void initPreguntas(){
		importPreguntas();
		Preguntas.getPreguntas().setTablero(preguntas, 0);
	}

}
	
	


