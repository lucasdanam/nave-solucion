package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import modelo.Camuflaje;
import modelo.FabricaNaviera;
import modelo.Nave;

class NaveEspacialTest{
	@Test
	void crearNaveCon100vida() {
		int vida=100;
		Nave nave=new Nave(vida);
		assertEquals(vida,nave.obtenerVida());
	}
	
	void fabricaFabricaNave() {
		int vida=100;
		FabricaNaviera fabrica= FabricaNaviera.getInstance();
		Nave nave=fabrica.fabricarNave(vida);
		assertTrue(nave instanceof Nave);
	}
	
	@Test
	public void naveEspacialAtacaOtraNaveEspacialSinCamuflajeProduciria25DeDanio() {
		int vida=100;
		FabricaNaviera fabrica= FabricaNaviera.getInstance();
		Nave nave=fabrica.fabricarNave(vida);
		Nave naveEnemiga=fabrica.fabricarNave(vida);
		nave.atacar(naveEnemiga);
		Assert.assertEquals(75, naveEnemiga.obtenerVida());
	}
	
	@Test
	public void naveEspacialAtacaOtraNaveEspacialConCamuflajeInactivoProduciria25DeDanio() {
		int vida=100;
		FabricaNaviera fabrica= FabricaNaviera.getInstance();
		Nave nave=fabrica.fabricarNave(vida);
		Nave naveEnemiga=fabrica.fabricarNave(vida);
		Camuflaje camuflaje=fabrica.fabricarCamuflaje();
		naveEnemiga.incorporarCamuflaje(camuflaje);//Nunca activo camuflaje
		nave.atacar(naveEnemiga);
		Assert.assertEquals(75, naveEnemiga.obtenerVida());
	}
	
	@Test
	public void naveEspacialAtacaOtraNaveEspacialConCamuflajeActivoNoProduciriaDanio() {
		int vida=100;
		FabricaNaviera fabrica= FabricaNaviera.getInstance();
		Nave nave=fabrica.fabricarNave(vida);
		Nave naveEnemiga=fabrica.fabricarNave(vida);
		Camuflaje camuflaje=fabrica.fabricarCamuflaje();
		naveEnemiga.incorporarCamuflaje(camuflaje);
		naveEnemiga.activarCamuflaje();
		nave.atacar(naveEnemiga);
		Assert.assertEquals(100, naveEnemiga.obtenerVida());
	}
	
	@Test
	public void naveEspacialSeDesplaza10UnidadesPorTurnoCoCombustible100() {
		int vida=100;
		FabricaNaviera fabrica= FabricaNaviera.getInstance();
		Nave nave=fabrica.fabricarNave(vida);
		nave.cargarCombustible(100);
		int unidadesDesplazadas = nave.moverse();
		Assert.assertEquals(10, unidadesDesplazadas);
	}
	
	@Test
	public void naveEspacialAlDesplazarseUnTurnoGastaria10UnidadesDeCombustible() {
		int vida=100;
		FabricaNaviera fabrica= FabricaNaviera.getInstance();
		Nave nave=fabrica.fabricarNave(vida);
		nave.cargarCombustible(100);
		nave.moverse();
		Assert.assertEquals(90, nave.obtenerCombustible());
	}
	
	@Test
	public void intentarMoverseSinCombustibleNoPermiteMoverse() {
		int vida=100;
		FabricaNaviera fabrica= FabricaNaviera.getInstance();
		Nave nave=fabrica.fabricarNave(vida);
		assertEquals(nave.moverse(),0);
	}
	
	@Test
	public void moverseCon10CombustiblePermiteMoverse5Unidades() {
		int vida=100;
		FabricaNaviera fabrica= FabricaNaviera.getInstance();
		Nave nave=fabrica.fabricarNave(vida);
		nave.cargarCombustible(10);
		assertEquals(nave.moverse(),5);
	}
	
	@Test
	public void moverseCon70CombustiblePermiteMoverse10Unidades() {
		int vida=100;
		FabricaNaviera fabrica= FabricaNaviera.getInstance();
		Nave nave=fabrica.fabricarNave(vida);
		nave.cargarCombustible(70);
		assertEquals(nave.moverse(),10);
	}
	
	@Test
	public void moverse2vecesCon60CombustiblePermiteMoverse10YLuego5() {
		int vida=100;
		FabricaNaviera fabrica= FabricaNaviera.getInstance();
		Nave nave=fabrica.fabricarNave(vida);
		nave.cargarCombustible(60);
		assertEquals(nave.moverse(),10);
		assertEquals(nave.moverse(),5);
	}
	
	@Test
	public void moverse2vecesCon5CombustiblePermiteMoverse5YLuego0() {
		int vida=100;
		FabricaNaviera fabrica= FabricaNaviera.getInstance();
		Nave nave=fabrica.fabricarNave(vida);
		nave.cargarCombustible(5);
		assertEquals(nave.moverse(),5);
		assertEquals(nave.moverse(),0);
	}
	
	@Test
	public void cargar50moversecargar20moversePermiteMoverse5YLuego10() {
		int vida=100;
		FabricaNaviera fabrica= FabricaNaviera.getInstance();
		Nave nave=fabrica.fabricarNave(vida);
		nave.cargarCombustible(50);
		assertEquals(nave.moverse(),5);
		nave.cargarCombustible(20);
		assertEquals(nave.moverse(),10);
	}
	
	@Test
	public void moverseCon100CombustibleGasta10Combustible() {
		int vida=100;
		FabricaNaviera fabrica= FabricaNaviera.getInstance();
		Nave nave=fabrica.fabricarNave(vida);
		nave.cargarCombustible(100);
		nave.moverse();
		assertEquals(nave.obtenerCombustible(),90);
	}
	
	@Test
	public void moverseCon40CombustibleGasta5Combustible() {
		int vida=100;
		FabricaNaviera fabrica= FabricaNaviera.getInstance();
		Nave nave=fabrica.fabricarNave(vida);
		nave.cargarCombustible(40);
		nave.moverse();
		assertEquals(nave.obtenerCombustible(),35);
	}
}
