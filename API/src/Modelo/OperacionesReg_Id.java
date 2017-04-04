package Modelo;

public class OperacionesReg_Id {

	public OperacionesReg_Id(){
		
	}
	
	static public boolean comprobarSiCamposRellenos(String pUsuario, char[] pPassword) {
		boolean datos = false;
		if (pUsuario.isEmpty() || (pPassword.length==0)) {
			return datos;
		}
		return true;
	}

	static public String getContra(char[] pContra){
		StringBuilder strBuilder = new StringBuilder();
		String pass = "";
		strBuilder.append(pContra);
		pass = strBuilder.toString();
		return pass;
	}
	
	static public boolean comprobarSiCamposRellenos(String pNombre,String pUsuario, char[] pPassword) {
		boolean datos = false;
		if (pUsuario.isEmpty() || (pPassword.length==0) || pNombre.isEmpty()) {
			return datos;
		}
		return true;
	}
	
}
