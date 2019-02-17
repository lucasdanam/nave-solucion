package modelo;

public class Canion {
	
	private int danio;
	
	public Canion(){
		this.danio=25;
	}
	
	public void causarDanio(Nave nave) {
		nave.sufrirDanio(this.danio);
	}
}
