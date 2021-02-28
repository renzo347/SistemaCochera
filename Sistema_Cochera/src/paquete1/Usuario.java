package paquete1;

public class Usuario {
	private String nombre;
	public Usuario() {
		nombre="";
	}
	
	public void cambiarUsuario(String nom) {
		nombre=nom;
	}
	public String getNombre() {
		return nombre;
	}
}
