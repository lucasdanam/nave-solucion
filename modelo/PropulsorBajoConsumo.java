package modelo;

public class PropulsorBajoConsumo extends Propulsor{
	
	PropulsorBajoConsumo(){
		this.desplazamiento=5;
	}
	
	public void propulsar(Nave nave) {
		if (nave.obtenerCombustible()<=modoAhorro) {
			nave.desplazarse(this.obtenerDesplazamiento(nave));
		}else{
			propulsorCambio.guardarPropulsor(this);
			nave.incorporarPropulsor(propulsorCambio);
			nave.moverse();
		}
	}
	
	private int obtenerDesplazamiento(Nave nave) {
		if (nave.obtenerCombustible()<this.desplazamiento) {
			return 0;
		}else {
			return this.desplazamiento;
		}
	}
}
