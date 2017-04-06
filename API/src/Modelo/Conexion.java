package Modelo;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
	/**********************************************/
	/*  	CONEXION CON LA BASE DE DATOS		  */
	/**********************************************/
	private static Conexion mConexion = new Conexion();
	
	private static Connection conexion; 
	private static Statement statement;
	private static String  usuario = "Xumateos002"; 
	private static String password = "yic3cp8T";
	private static String server = "jdbc:mysql://galan.ehu.eus:3306/Xumateos002_API_Animalitos";
	
	private Conexion(){
		
	}
	
	public static Conexion getConexion(){
		return mConexion;
	}
	
	/*******************************************************/
	/* METODO PARA CONECTARSE AL DRIVER Y PODER USAR MYSQL */
	/*******************************************************/
	
	public static void conectar(){
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
			//Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
			//e.printStackTrace();
			e.getMessage();
		}
		// Open connection
		try{
			conexion= DriverManager.getConnection(server,usuario,password);
			conexion.setAutoCommit(true);
			statement=conexion.createStatement();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/***********************************************************/
	/* METODO PARA ESTABLECER LA CONEXION CON LA BASE DE DATOS */
	/***********************************************************/

	public static Statement conexion() {
        Statement st = null;
        try {
            st = conexion.createStatement();
        } catch (SQLException e) {
            System.out.println("Error: Conexion incorrecta.");
            e.printStackTrace();
        }
        return st;
    }
 
	/*************************************************************************
     * M�todo para realizar consultas del tipo: SELECT * FROM tabla WHERE..."*
     *************************************************************************/
     
	public static ResultSet consultaDatos(Statement st, String cadena) {
        ResultSet rs = null;
        try {
            rs = st.executeQuery(cadena);
        } catch (SQLException e) {
            System.out.println("Error con: " + cadena);
            System.out.println("SQLException: " + e.getMessage());
            e.printStackTrace();
        }
        return rs;
    }
	
	/*****************************************************************************************************************
     * M�todo para realizar consultas de actualizaci�n, creaci�n o eliminaci�n (DROP,INSERT INTO, ALTER...,NO SELECT * 
     *****************************************************************************************************************/
    
    public static int consultaActualiza(Statement st, String cadena) {
        int rs = -1;
        try {
            rs = st.executeUpdate(cadena);
        } catch (SQLException e) {
            System.out.println("Error con: " + cadena);
            System.out.println("Clave repetida, saldr� ventana de avisto");
            //e.printStackTrace();
            
            
        }
        return rs;//si devuelve -1 mal si devuelve otro valor bien
    }
    
    
    /*********************************
     * M�todo para cerrar la consula *
     *********************************/
    static void cerrar(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                System.out.print("Error: No es posible cerrar la consulta.");
            }
        }
    }
    
    /***********************************
     * M�todo para cerrar la conexi�n. *
     ***********************************/
    public static void cerrar(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (Exception e) {
                System.out.print("Error: No es posible cerrar la conexi�n.");
            }
        }
    }
    
    
}
