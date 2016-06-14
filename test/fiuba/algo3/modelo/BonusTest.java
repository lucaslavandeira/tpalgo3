package fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class BonusTest {

	
	

	@Test
	public void RealizaDobleDanioConBonusDeDobleCanion() {
		Tablero tablero;
	    Casillero casillero1_1;
	    Casillero casillero2_2;
	    Casillero casillero3_3;
	    
	    tablero = new Tablero(11);
        casillero1_1 = tablero.obtenerCasillero(1, 1);
        casillero2_2 = tablero.obtenerCasillero(2, 2);
        casillero3_3 = tablero.obtenerCasillero(3, 3);
        
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Roca());
        casillero3_3.asignarSuperficie(new Roca());
        casillero3_3.asignarEquipamiento(new DobleCanion());
        
        Optimus optimus   = new Optimus(casillero1_1);
        Megatron megatron = new Megatron(casillero2_2);
        
        optimus.avanzar(casillero3_3);
        
        for(int i=0;i<5;i++) {
            optimus.atacar(megatron);
            Assert.assertFalse(megatron.estaMuerto());
        }
        optimus.atacar(megatron);

        Assert.assertTrue(megatron.estaMuerto()); 
	}
	
	
	@Test
	public void NoRealizaDobleDanioSinBonusDeDobleCanion() {
		Tablero tablero;
	    Casillero casillero1_1;
	    Casillero casillero2_2;
	    Casillero casillero3_3;
	    
	    tablero = new Tablero(11);
        casillero1_1 = tablero.obtenerCasillero(1, 1);
        casillero2_2 = tablero.obtenerCasillero(2, 2);
        casillero3_3 = tablero.obtenerCasillero(3, 3);
        
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Roca());
        casillero3_3.asignarSuperficie(new Roca());
        
        Optimus optimus   = new Optimus(casillero1_1);
        Megatron megatron = new Megatron(casillero2_2);
        
        optimus.avanzar(casillero3_3);
        
        for(int i=0;i<10;i++) {
            optimus.atacar(megatron);
            Assert.assertFalse(megatron.estaMuerto());
        }
        optimus.atacar(megatron);

        Assert.assertTrue(megatron.estaMuerto()); 
	}
	
	
	
	@Test
	public void AlgoFormerNoMuereAlEncontraseConBonusDeBurbuja() {
		Tablero tablero;
	    Casillero casillero1_1;
	    Casillero casillero2_2;
	    Casillero casillero3_3;
	    
	    tablero = new Tablero(11);
        casillero1_1 = tablero.obtenerCasillero(1, 1);
        casillero2_2 = tablero.obtenerCasillero(2, 2);
        casillero3_3 = tablero.obtenerCasillero(3, 3);
        
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Roca());
        casillero3_3.asignarSuperficie(new Roca());
        casillero3_3.asignarEquipamiento(new BurbujaInmaculada());
        
        Optimus optimus   = new Optimus(casillero1_1);
        Megatron megatron = new Megatron(casillero2_2);
        
        optimus.avanzar(casillero3_3);
        
        for(int i=0;i<99;i++) {
            megatron.atacar(optimus);
        }

        Assert.assertFalse(optimus.estaMuerto()); 
	}

	
	@Test(expected = SobrepasaRangosException.class)
    public void AlgoFormerPuedeMoverElTripleDeSuVelocidadAlObtenerElBonusFlash(){
		Tablero tablero;
	    Casillero casillero1_1;
	    Casillero casillero2_2;
	    Casillero casillero5_5;
	    Casillero casillero10_10;

	    tablero = new Tablero(11);
	    casillero1_1 = tablero.obtenerCasillero(1, 1);
	    casillero2_2 = tablero.obtenerCasillero(2, 2);
	    casillero5_5 = tablero.obtenerCasillero(5, 5);
	    casillero10_10 = tablero.obtenerCasillero(10, 10);
	    
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Roca());
        casillero5_5.asignarSuperficie(new Roca());
        casillero10_10.asignarSuperficie(new Roca());
        casillero2_2.asignarEquipamiento(new Flash());

        AlgoFormer optimus = new Optimus(casillero1_1);

        optimus.avanzar(casillero5_5); //No puede avanzar porque sobrepasa su velocidad
        Assert.assertFalse(optimus.getPosicion() == casillero5_5);
        
        optimus.avanzar(casillero2_2); //Avanza para obtener el Bonus
        optimus.avanzar(casillero10_10);
        Assert.assertTrue(optimus.getPosicion() == casillero10_10);
    }
}
