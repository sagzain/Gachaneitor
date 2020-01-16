public class PasoMaquina extends Paso {
	private Integer velocidad;
	private Integer temperatura;
	private Integer tiempo;
	private boolean invertir;
	
	public PasoMaquina(String descripcion, Integer velocidad, Integer temperatura, Integer tiempo, boolean invertir) {
		super(descripcion);
		this.velocidad = velocidad;
		this.temperatura = temperatura;
		this.tiempo = tiempo;
		this.invertir = invertir;
	}
	
	public Integer getVelocidad() {
		return this.velocidad;
	}
	
	public void setVelocidad(Integer velocidad) {
		this.velocidad = velocidad;
	}
	
	public Integer getTemperatura() {
		return this.temperatura;
	}
	
	public void setTemperatura(Integer temperatura) {
		this.temperatura = temperatura;
	}
	
	public Integer getTiempo() {
		return this.tiempo;
	}
	
	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}

	public boolean getInvertir() {
		return this.invertir;
	}

	public void setInvertir(boolean invertir) {
		this.invertir = invertir;
	}

}

