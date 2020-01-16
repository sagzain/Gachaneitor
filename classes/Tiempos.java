public class Tiempos {
	private Integer tCocinado;
	private EnumTiempo mCocinado;
	private Integer tPreparacion;
	private EnumTiempo mPreparacion;
	private Integer tTotal;
	private EnumTiempo mTotal;

	public Tiempos(Integer tCocinado, EnumTiempo mCocinado, Integer tPreparacion, EnumTiempo mPreparacion, Integer tTotal, EnumTiempo mTotal) {
		this.tCocinado = tCocinado;
		this.mCocinado = mCocinado;
		this.tPreparacion = tPreparacion;
		this.mPreparacion = mPreparacion;
		this.tTotal = tTotal;
		this.mTotal = mTotal;
	}
	
	public Integer getTCocinado() {
		return this.tCocinado;
	}
	
	public void setTCocinado(Integer tCocinado) {
		this.tCocinado = tCocinado;
	}
	
	public EnumTiempo getMCocinado() {
		return this.mCocinado;
	}
	
	public void setMCocinado(EnumTiempo mCocinado) {
		this.mCocinado = mCocinado;
	}
	
	public Integer getTPreparacion() {
		return this.tPreparacion;
	}
	
	public void setTPreparacion(Integer tPreparacion) {
		this.tPreparacion = tPreparacion;
	}
	
	public EnumTiempo getMPreparacion() {
		return this.mPreparacion;
	}
	
	public void setMPreparacion(EnumTiempo mPreparacion) {
		this.mPreparacion = mPreparacion;
	}
	
	public Integer getTTotal() {
		return this.tTotal;
	}		
	
	public void setTTotal(Integer tTotal) {
		this.tTotal = tTotal;
	}
	
	public EnumTiempo getMTotal() {
		return this.mTotal;
	}		
	
	public void setMTotal(EnumTiempo mTotal) {
		this.mTotal = mTotal;
	}
	
}
