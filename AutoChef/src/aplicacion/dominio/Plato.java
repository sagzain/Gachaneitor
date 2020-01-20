package aplicacion.dominio;

import java.util.ArrayList;

public class Plato {
	private String id;
	private String nombre;
	private EnumTipo tipo;
	private Integer comensales;
	private Tiempos tiempos;
	private ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	private ArrayList<Paso> pasos = new ArrayList<Paso>();
	
	public Plato(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
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
	
	public EnumTipo getTipo() {
		return this.tipo;
	}
	
	public void setTipo(EnumTipo tipo) {
		this.tipo = tipo;
	}
	
	public Integer getComensales() {
		return this.comensales;
	}
	
	public void setComensales(Integer comensales) {
		this.comensales = comensales;
	}
	
	public Tiempos getTiempos() {
		return this.tiempos;
	}
	
	public void setTiempos(Tiempos tiempos) {
		this.tiempos = tiempos;
	}
	
	public ArrayList<Ingrediente> getIngredientes() {
		return this.ingredientes;
	}

	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public ArrayList<Paso> getPasos() {
		return this.pasos;
	}

	public void setPasos(ArrayList<Paso> pasos) {
		this.pasos = pasos;
	}

}

