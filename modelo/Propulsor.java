package modelo;

public abstract class Propulsor {
	protected int desplazamiento;
	protected int modoAhorro;
	protected Propulsor propulsorCambio;
	
	public Propulsor() {
		this.modoAhorro=50;
	}
	
	public void propulsar(Nave nave){
	}
	
	protected void guardarPropulsor(Propulsor propulsor) {
		this.propulsorCambio=propulsor;
	}
}
