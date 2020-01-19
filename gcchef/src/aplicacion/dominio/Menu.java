package aplicacion.dominio;

import java.util.ArrayList;

public class Menu {
	private String id;
	private String nombre;
	private String nickname;
	private ArrayList<Plato> platos = new ArrayList<Plato>();
	private ArrayList<Ingrediente> ingredientesglobales = new ArrayList<Ingrediente>();
	
	public Menu(String id, String nombre, String nickname, ArrayList<Plato> platos, ArrayList<Ingrediente> ingredientesglobales) {
		this.id = id;
		this.nombre = nombre;
		this.nickname = nickname;
		this.platos = platos;
		this.ingredientesglobales = ingredientesglobales;
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
	
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public ArrayList<Plato> getPlatos() {
		return this.platos;
	}

	public void setPlatos(ArrayList<Plato> platos) {
		this.platos = platos;
	}
	
	public ArrayList<Ingrediente> getIngredientesGlobales() {
		return this.ingredientesglobales;
	}

	public void setIngredientesGlobales(ArrayList<Ingrediente> ingredientesglobales) {
		this.ingredientesglobales = ingredientesglobales;
	}

}

