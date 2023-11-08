package ar.edu.unlam.tienda;

public class Cliente {

	private String cuit;
	private String nombre;

	public Cliente(String cuit, String nombre) {
		super();
		this.cuit = cuit;
		this.nombre = nombre;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
