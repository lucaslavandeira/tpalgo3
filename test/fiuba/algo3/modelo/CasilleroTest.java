package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sickness on 30/05/16.
 */

public class CasilleroTest {
	
	@Test
    public void test00CrearUnCasillero() {
		Tablero unTablero = new Tablero(10);
        Casillero unCasillero = new Casillero(1, 5, unTablero);
        
        Assert.assertTrue(unCasillero.posicionX == 1);
        Assert.assertTrue(unCasillero.posicionY == 5);
        
        Assert.assertFalse(unCasillero.posicionX == 2);
        Assert.assertFalse(unCasillero.posicionY == 1);
    }

	
	@Test
    public void test01BuscarUnCasilleroEnElTablero() {
		Tablero unTablero = new Tablero(10);
        Casillero unCasillero = new Casillero(0, 0, unTablero);
        
        unCasillero = unCasillero.buscarCasillero(1, 5);
        
        Assert.assertTrue(unCasillero.posicionX == 1);
        Assert.assertTrue(unCasillero.posicionY == 5);
        
        Assert.assertFalse(unCasillero.posicionX == 2);
        Assert.assertFalse(unCasillero.posicionY == 1);
    }
	
	
	@Test
    public void test02AtacarDesdeUnCasillero() {
		Tablero tablero = new Tablero(11);
	    Casillero casillero1_1 = tablero.obtenerCasillero(1, 1);
	    Casillero casillero2_2 = tablero.obtenerCasillero(2, 2);
	    Estado estadoHumanoideOptimus = new Estado(50, 2, 2);
	    Estado estadoAlternoOptimus = new Estado(15, 4, 5);
	    Estado estadoHumanoideMegatron = new Estado( 10, 3, 1);
	    Estado estadoAlternoMegatron = new Estado( 55, 2, 8);
	    
	    Autobot optimus = new Autobot(casillero1_1, estadoHumanoideOptimus, estadoAlternoOptimus, 500);
        Decepticon megatron = new Decepticon(casillero2_2, estadoHumanoideOptimus, estadoAlternoOptimus, 550);
        int vidaMegatronAnteriorAlAtaque = megatron.vida;
        
        casillero2_2.propiciarAtaque(optimus);
        
        Assert.assertTrue(megatron.vida == vidaMegatronAnteriorAlAtaque - optimus.estadoActual.danioAtaque);
	    
    }
	
	
	@Test
    public void test03InsertarUnContenido() {
		Tablero tablero = new Tablero(11);
	    Casillero casillero1_1 = tablero.obtenerCasillero(1, 1);
	    Casillero casillero2_2 = tablero.obtenerCasillero(2, 2);
	    Estado estadoHumanoideOptimus = new Estado(50, 2, 2);
	    Estado estadoAlternoOptimus = new Estado(15, 4, 5);
	    Estado estadoHumanoideMegatron = new Estado( 10, 3, 1);
	    Estado estadoAlternoMegatron = new Estado( 55, 2, 8);
	    
	    Autobot optimus = new Autobot(casillero1_1, estadoHumanoideOptimus, estadoAlternoOptimus, 500);
        Decepticon megatron = new Decepticon(casillero2_2, estadoHumanoideOptimus, estadoAlternoOptimus, 550);
        
        casillero1_1.colocarEnte(optimus);
        casillero2_2.colocarEnte(megatron);
        
        Assert.assertTrue(casillero1_1.enteContenido == optimus);
        Assert.assertTrue(casillero2_2.enteContenido == megatron);
        
        Assert.assertFalse(casillero1_1.enteContenido == megatron);
        Assert.assertFalse(casillero1_1.enteContenido == null);
        Assert.assertFalse(casillero2_2.enteContenido == optimus);
        Assert.assertFalse(casillero2_2.enteContenido == null);
        
	    
    }
	
	
}
