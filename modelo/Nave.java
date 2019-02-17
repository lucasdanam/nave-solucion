package modelo;

public class Nave {

	private int vida;
	private Camuflaje camuflaje;
	private Canion canion;
	private Propulsor propulsor;
	private int combustible;
	private int desplazamiento;

	public Nave(int vida) {
		this.vida=vida;
		this.camuflaje=null;
		this.combustible=0;
		this.propulsor=FabricaNaviera.getInstance().fabricarPropulsorEstandar();
		this.canion=FabricaNaviera.getInstance().fabricarCanion();
	}
	
	public int obtenerVida() {
		return this.vida;
	}
	
	public int obtenerCombustible() {
		return this.combustible;
	}
	
	public void cargarCombustible(int combustible) {
		this.combustible+=combustible;
	}

	public void incorporarCamuflaje(Camuflaje camuflaje) {
		this.camuflaje=camuflaje;
	}
	
	public void activarCamuflaje() {	
		try {
			camuflaje.activar();
		}catch(NullPointerException e) {
			//No tiene camuflaje, no hacer nada
		}
	}

	public void atacar(Nave naveEnemiga) {
		canion.causarDanio(naveEnemiga);	
	}

	public void sufrirDanio(int danio) { 
		try {
			camuflaje.proteger(this,danio);
		}catch(NullPointerException e) {
			this.vida-=danio;//No tiene camuflaje, no puede proteger la vida
		}
	}
	
	public void incorporarPropulsor(Propulsor propulsor) {
		this.propulsor= propulsor;
	}

	public int moverse() {
		propulsor.propulsar(this);
		return this.desplazamiento;
	}
	
	public void desplazarse(int desplazamiento) {
		this.combustible-=desplazamiento;
		this.desplazamiento=desplazamiento;
	}

	public void disminuirVida(int vida) {
		this.vida-=vida;
	}
}
