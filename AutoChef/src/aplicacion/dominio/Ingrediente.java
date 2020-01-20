package aplicacion.dominio;

public class Ingrediente {
	private String id;
	private String nombre;
	private EnumMedida medida;
	private double cantidad;

	public Ingrediente(String id, String nombre, double cantidad, EnumMedida medida) {
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.medida = medida;
	}
	
	public String getID() {
		return this.id;
	}

	public void setID(String id) {
		this.id = id;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	public EnumMedida getMedida() {
		return this.medida;
	}

	public void setMedida(EnumMedida medida) {
		this.medida = medida;
	}

}

