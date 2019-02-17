package modelo;

public class Camuflaje {
	private int coefDanio;
	
	Camuflaje(){
		this.coefDanio=1;//INACTIVO
	}

	public void activar() {
		this.coefDanio=0;
	}

	public void proteger(Nave nave, int danio) {
		nave.disminuirVida(danio*this.coefDanio);	
	}

}
