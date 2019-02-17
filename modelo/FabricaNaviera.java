package modelo;

public class FabricaNaviera {
	
	private static FabricaNaviera fabrica=new FabricaNaviera();
	
	private FabricaNaviera() {
	}
	
	public static FabricaNaviera getInstance(){
		return fabrica;
	}
	
	public Nave fabricarNave(int vida) {
		return new Nave(vida);
	}
	
	public Camuflaje fabricarCamuflaje(){
		return new Camuflaje();
	}
	
	public Propulsor fabricarPropulsorEstandar() {
		return new PropulsorEstandar();
	}
	
	public Propulsor fabricarPropulsorAhorro() {
		return new PropulsorBajoConsumo();
	}
	
	public Canion fabricarCanion() {
		return new Canion();
	}
}
