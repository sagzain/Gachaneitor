package aplicacion.dominio;

public class PasoIntroducir extends Paso {

	public PasoIntroducir(String nombre, double cantidad, EnumMedida medida) {
		super("Introducir "+cantidad+" "+medida.toString()+" de "+nombre);
	}

}

