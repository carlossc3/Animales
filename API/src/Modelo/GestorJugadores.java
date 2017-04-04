package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestorJugadores {
	private Jugador jugador;
	private static GestorJugadores mGestorJ = new GestorJugadores();

	private GestorJugadores() {

	}

	public static GestorJugadores getGestorJugadores() {
		return mGestorJ;
	}

	public String obtUsuarioAct() {
		return jugador.obtenerNombre();
	}
	/* Nos devuelve los usuarios de la BD
	public ArrayList<String> obtUsuarios() {
		ArrayList<String> usuarios = new ArrayList<String>();
		String cadena = "SELECT usuario FROM Usuarios ORDER BY usuario ASC";
		Conexion.conectar();
		Statement st = Conexion.conexion();
		if (st != null) {
			try {
				ResultSet rs = null;
				rs = Conexion.consultaDatos(st, cadena);
				while (rs.next()) {
					usuarios.add(rs.getString("usuario"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		Conexion.cerrar(st);
		return usuarios;
	}*/
	// Buscamos si existe el usuario con dicha clave.
	public boolean datosCorrectos(String pUsuario, String pPassword) {
		boolean re = true;
		String cadena = "SELECT usuario FROM Usuarios WHERE usuario='" + pUsuario + "' AND pass='" + pPassword
				+ "'";
		Conexion.conectar();
		Statement st = Conexion.conexion();
		if (st != null) {
			try {
				ResultSet rs = null;
				rs = Conexion.consultaDatos(st, cadena);
				if (!rs.next()) {
					re = false;
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		Conexion.cerrar(st);
		return re;
	}
	// Metodo para buscar un usuario en la base de datos
	public boolean buscarSiExisteUsuario(String pUsuario) {
		boolean re = true;
		String cadena = "Select usuario FROM Usuarios WHERE usuario='" + pUsuario + "'";
		Conexion.conectar();
		Statement st = Conexion.conexion();
		if (st != null) {
			try {
				ResultSet rs = null;
				rs = Conexion.consultaDatos(st, cadena);
				if (!rs.next()) {
					re = false;
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		Conexion.cerrar(st);
		return re;
	}
	// Metodo para realizar el insert a la base de datos
	public boolean anadirJugador(String pUsuario, String pNombre, String pPass) {
		boolean bien = false;
		String cadena = "INSERT INTO Usuarios (usuario,nombre,pass) VALUES" + "('" + pNombre + "', '"
				+ pNombre + "', '" + pPass + "')";
		Conexion.conectar();
		Statement st = Conexion.conexion();
		if (st != null) {
			int rs = Conexion.consultaActualiza(st, cadena);
			if (rs != -1) {
				bien = true;
			}
		}
		Conexion.cerrar(st);
		return bien;
	}
}
