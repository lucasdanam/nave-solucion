package modelo;

public class PropulsorEstandar extends Propulsor{
	
	PropulsorEstandar(){
		this.desplazamiento=10;
		this.propulsorCambio=FabricaNaviera.getInstance().fabricarPropulsorAhorro();
	}
	
	public void propulsar(Nave nave) {
		if (nave.obtenerCombustible()>modoAhorro) {
			nave.desplazarse(desplazamiento);
		}else{
			propulsorCambio.guardarPropulsor(this);
			nave.incorporarPropulsor(propulsorCambio);
			nave.moverse();
		}
	}
}
