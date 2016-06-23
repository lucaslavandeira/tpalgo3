package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;
import fiuba.algo3.modelo.ImposibleAtravesarPantanoException;
public class SuperficieTest {

	@Test (expected = ImposibleAtravesarPantanoException.class)
    public void noSePuedeAtravesarPantanoEnModoHumanoide(){
		
		Tablero tablero;
	    Casillero casillero1_1;
	    Casillero casillero2_2;
	    
	    tablero = new Tablero(11);
        casillero1_1 = tablero.obtenerCasillero(1, 1);
        casillero2_2 = tablero.obtenerCasillero(2, 2);
        
        
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Pantano());
        Optimus optimus=new Optimus(casillero1_1);
        optimus.avanzar(casillero2_2);

    }
	
	
	@Test(expected = SobrepasaRangosException.class)
    public void atravesarPantanoReduceVelocidadEnModoAlternoDeUnidadTerrestre(){
		Tablero tablero;
	    Casillero casillero1_1;
	    Casillero casillero2_2;
	    
	    tablero = new Tablero(11);
        casillero1_1 = tablero.obtenerCasillero(1, 1);
        casillero2_2 = tablero.obtenerCasillero(2, 2);
        
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Pantano());
        Casillero casilleroLejano =tablero.obtenerCasillero(6,6);
        casilleroLejano.asignarSuperficie(new Roca());
        
        Optimus optimus=new Optimus(casillero1_1);
        optimus.cambiarEstadoAlternativo();
        optimus.avanzar(casillero2_2);
        optimus.avanzar(casilleroLejano);
    }
	
	
	@Test
    public void atravesarPantanoNoReduceVelocidadEnModoAlternoDeUnidadAerea(){
		Tablero tablero;
	    Casillero casillero1_1;
	    Casillero casillero2_2;
	    
	    tablero = new Tablero(11);
        casillero1_1 = tablero.obtenerCasillero(1, 1);
        casillero2_2 = tablero.obtenerCasillero(2, 2);
        
        casillero1_1.asignarSuperficie(new Pantano());
        casillero2_2.asignarSuperficie(new Pantano());
        Casillero casilleroLejano =tablero.obtenerCasillero(8,8);
        casilleroLejano.asignarSuperficie(new Pantano());
        
        Megatron megatron=new Megatron(casillero1_1);
        megatron.cambiarEstadoAlternativo();
        megatron.avanzar(casillero2_2);
        megatron.avanzar(casilleroLejano);
        
        Assert.assertTrue(megatron.getPosicion()==casilleroLejano);
    }
	
	
	@Test
    public void atravesarRocaNoReduceVelocidadEnModoAlterno(){
		Tablero tablero;
	    Casillero casillero1_1;
	    Casillero casillero2_2;
	    
	    tablero = new Tablero(11);
        casillero1_1 = tablero.obtenerCasillero(1, 1);
        casillero2_2 = tablero.obtenerCasillero(2, 2);
        
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Roca());
        Casillero casilleroLejano =tablero.obtenerCasillero(6,6);
        casilleroLejano.asignarSuperficie(new Roca());
        
        Optimus optimus=new Optimus(casillero1_1);
        
        optimus.cambiarEstadoAlternativo();
        optimus.avanzar(casillero2_2);
        optimus.avanzar(casilleroLejano);
    }

    
    @Test
    public void atravesarEspinasReduceVidaUnidadTerrestre(){
		Tablero tablero;
	    Casillero casillero1_1;
	    Casillero casillero2_2;
	    Casillero casillero3_3;
	    
	    tablero = new Tablero(11);
        casillero1_1 = tablero.obtenerCasillero(1, 1);
        casillero2_2 = tablero.obtenerCasillero(2, 2);
        casillero3_3 = tablero.obtenerCasillero(3, 3);
        
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Espinas());
        casillero3_3.asignarSuperficie(new Espinas());
        
        Optimus optimus=new Optimus(casillero1_1);
        
        for(int i=0;i<38;i++){
            optimus.avanzar(casillero2_2);
            optimus.avanzar(casillero3_3);
        }

        Assert.assertTrue(optimus.estaMuerto());
    }
    
    
    @Test
    public void atravesarEspinasReduceVidaUnidadTerrestreEnModoAlterno(){
		Tablero tablero;
	    Casillero casillero1_1;
	    Casillero casillero2_2;
	    Casillero casillero3_3;
	    
	    tablero = new Tablero(11);
        casillero1_1 = tablero.obtenerCasillero(1, 1);
        casillero2_2 = tablero.obtenerCasillero(2, 2);
        casillero3_3 = tablero.obtenerCasillero(3, 3);
        
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Espinas());
        casillero3_3.asignarSuperficie(new Espinas());
        
        Optimus optimus=new Optimus(casillero1_1);
        optimus.cambiarEstadoAlternativo();
        
        for(int i=0;i<38;i++){
            optimus.avanzar(casillero2_2);
            optimus.avanzar(casillero3_3);
        }

        Assert.assertTrue(optimus.estaMuerto());
    }
	
	
	@Test
    public void atravesarEspinasReduceVidaUnidadAerea(){
		Tablero tablero;
	    Casillero casillero1_1;
	    Casillero casillero2_2;
	    Casillero casillero3_3;
	    
	    tablero = new Tablero(11);
        casillero1_1 = tablero.obtenerCasillero(1, 1);
        casillero2_2 = tablero.obtenerCasillero(2, 2);
        casillero3_3 = tablero.obtenerCasillero(3, 3);
        
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Espinas());
        casillero3_3.asignarSuperficie(new Espinas());
        
        Ratchet ratched=new Ratchet(casillero1_1);
        
        for(int i=0;i<38;i++){
            ratched.avanzar(casillero2_2);
            ratched.avanzar(casillero3_3);
        }

        Assert.assertTrue(ratched.estaMuerto());
    }
	
	
	@Test
    public void atravesarEspinasReduceVidaUnidadAereaEnModoAlterno(){
		Tablero tablero;
	    Casillero casillero1_1;
	    Casillero casillero2_2;
	    Casillero casillero3_3;
	    
	    tablero = new Tablero(11);
        casillero1_1 = tablero.obtenerCasillero(1, 1);
        casillero2_2 = tablero.obtenerCasillero(2, 2);
        casillero3_3 = tablero.obtenerCasillero(3, 3);
        
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Espinas());
        casillero3_3.asignarSuperficie(new Espinas());
        
        Ratchet ratched=new Ratchet(casillero1_1);
        ratched.cambiarEstadoAlternativo();
        
        for(int i=0;i<38;i++){
            ratched.avanzar(casillero2_2);
            ratched.avanzar(casillero3_3);

        }

        Assert.assertTrue(ratched.estaMuerto());
    }

	
    @Test
    public void unidadHumanoideTerrestreAtraviesaNebulosaAndromeda(){
		Tablero tablero;
	    Casillero casillero1_1;
	    Casillero casillero2_2;
	    
	    tablero = new Tablero(11);
        casillero1_1 = tablero.obtenerCasillero(1, 1);
        casillero2_2 = tablero.obtenerCasillero(2, 2);
               
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new NebulosaAndromeda());
        
        Optimus optimus=new Optimus(casillero1_1);
        optimus.avanzar(casillero2_2);
        Assert.assertTrue(optimus.getPosicion()==casillero2_2);
    }
    
    
    @Test
    public void unidadAlternativoTerrestreAtraviesaNebulosaAndromeda(){
		Tablero tablero;
	    Casillero casillero1_1;
	    Casillero casillero2_2;
	    
	    tablero = new Tablero(11);
        casillero1_1 = tablero.obtenerCasillero(1, 1);
        casillero2_2 = tablero.obtenerCasillero(2, 2);
               
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new NebulosaAndromeda());
        
        Optimus optimus=new Optimus(casillero1_1);
        optimus.cambiarEstadoAlternativo();
        optimus.avanzar(casillero2_2);
        Assert.assertTrue(optimus.getPosicion()==casillero2_2);
    }

      @Test(expected = UnidadTerrestreNoAtraviesaNubeException.class)
    public void unidadTerrestreNoAtraviesaNubeEnModoAlterno(){
		Tablero tablero;
	    Casillero casillero1_1;
	    Casillero casillero2_2;
	    
	    tablero = new Tablero(11);
        casillero1_1 = tablero.obtenerCasillero(1, 1);
        casillero2_2 = tablero.obtenerCasillero(2, 2);
        
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Nube());
        
        Optimus optimus=new Optimus(casillero1_1);
        optimus.cambiarEstadoAlternativo();
        optimus.avanzar(casillero2_2);
        
        //Assert.assertTrue(casillero2_2==optimus.getPosicion());
    }
    
    
    @Test
    public void unidadAereaAtraviesaNubeEnModoAlterno(){
		Tablero tablero;
	    Casillero casillero1_1;
	    Casillero casillero2_2;
	    
	    tablero = new Tablero(11);
        casillero1_1 = tablero.obtenerCasillero(1, 1);
        casillero2_2 = tablero.obtenerCasillero(2, 2);
        
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Nube());
        
        Megatron megatron=new Megatron(casillero1_1);
        megatron.cambiarEstadoAlternativo();
        megatron.avanzar(casillero2_2);
        
        Assert.assertTrue(casillero2_2==megatron.getPosicion());
    }

    
 @Test (expected = UnidadAereaDebeEstarEnModoAlternoException.class)
    public void unidadAereaNoAtraviesaNubeEnModoHumanoide(){
		Tablero tablero;
	    Casillero casillero1_1;
	    Casillero casillero2_2;
	    
	    tablero = new Tablero(11);
        casillero1_1 = tablero.obtenerCasillero(1, 1);
        casillero2_2 = tablero.obtenerCasillero(2, 2);
        
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Nube());
        
        Megatron megatron=new Megatron(casillero1_1);
        megatron.avanzar(casillero2_2);
    }
    
    
   @Test (expected = ImposibleAtravesarPantanoException.class)
    public void unidadAereaNoAtraviesaPantanoEnModoHumanoide(){
		Tablero tablero;
	    Casillero casillero1_1;
	    Casillero casillero2_2;
	    
	    tablero = new Tablero(11);
        casillero1_1 = tablero.obtenerCasillero(1, 1);
        casillero2_2 = tablero.obtenerCasillero(2, 2);
        
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Pantano());
        
        Megatron megatron=new Megatron(casillero1_1);
        megatron.avanzar(casillero2_2);
    }

    
    @Test (expected = UnidadTerrestreNoAtraviesaNubeException.class)
    public void unidadTerrestreNoPuedeAtravesarNubeEnModoHumanoide(){
		Tablero tablero;
	    Casillero casillero1_1;
	    Casillero casillero2_2;
	    
	    tablero = new Tablero(11);
        casillero1_1 = tablero.obtenerCasillero(1, 1);
        casillero2_2 = tablero.obtenerCasillero(2, 2);
        
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Nube());
        
        Optimus optimus=new Optimus(casillero1_1);
        optimus.avanzar(casillero2_2);
    }
    
    
    @Test 
    public void unidadAereaAtraviesaRocaEnModoHumanoide(){
		Tablero tablero;
	    Casillero casillero1_1;
	    Casillero casillero2_2;
	    
	    tablero = new Tablero(11);
        casillero1_1 = tablero.obtenerCasillero(1, 1);
        casillero2_2 = tablero.obtenerCasillero(2, 2);
        
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Roca());
        
        Megatron megatron=new Megatron(casillero1_1);
        megatron.avanzar(casillero2_2);
        
        Assert.assertTrue(casillero2_2==megatron.getPosicion());
    }
    
    
    @Test(expected = ImposibleAtravesarTormentaPsionicaException.class)
    public void unidadHumanoideTerrestreNoAtraviesaTormentaPsionica(){
		Tablero tablero;
	    Casillero casillero1_1;
	    Casillero casillero2_2;
	    
	    tablero = new Tablero(11);
        casillero1_1 = tablero.obtenerCasillero(1, 1);
        casillero2_2 = tablero.obtenerCasillero(2, 2);
        
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new TormentaPsionica());
        
        Optimus optimus=new Optimus(casillero1_1);
        optimus.avanzar(casillero2_2);
    }
    
    
   @Test(expected = ImposibleAtravesarTormentaPsionicaException.class)
    public void unidadAlternativoTerrestreNoAtraviesaTormentaPsionica(){
		Tablero tablero;
	    Casillero casillero1_1;
	    Casillero casillero2_2;
	    
	    tablero = new Tablero(11);
        casillero1_1 = tablero.obtenerCasillero(1, 1);
        casillero2_2 = tablero.obtenerCasillero(2, 2);
        
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new TormentaPsionica());
        
        Frenzy frenzy=new Frenzy(casillero1_1);
        frenzy.cambiarEstadoAlternativo();
        frenzy.avanzar(casillero2_2);
    }
    

}
