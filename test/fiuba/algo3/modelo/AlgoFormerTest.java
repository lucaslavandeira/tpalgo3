package fiuba.algo3.modelo;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;


/**
 * Created by sickness on 30/05/16.
 */
public class AlgoFormerTest {

    Tablero tablero;
    AlgoFormer optimus;
    Casillero casillero1_1;
    Casillero casillero2_2;
    Casillero casillero3_3;
    Casillero casillero4_4;
    Casillero casillero5_5;

    @Before
    public void setUp() {
        tablero = new Tablero(11);
        casillero1_1 = tablero.obtenerCasillero(1, 1);
        casillero2_2 = tablero.obtenerCasillero(2, 2);
        casillero3_3 = tablero.obtenerCasillero(3, 3);
        casillero4_4 = tablero.obtenerCasillero(4, 4);
        casillero5_5 = tablero.obtenerCasillero(5, 5);
    }

    
    @Test
    public void crearUnAlgoFormer() {
        optimus = new Optimus(casillero1_1);
        Assert.assertTrue(optimus.getPosicion() == casillero1_1);

    }

    
    @Test
    public void moverAlgoFormer(){
        AlgoFormer optimus = new Optimus(casillero1_1);
        casillero2_2.asignarSuperficie(new Roca());
        optimus.avanzar(casillero2_2);
        Assert.assertTrue(optimus.getPosicion() == casillero2_2);
    }

    
    @Test(expected = SobrepasaRangosException.class)
    public void sobrepasarVelocidadLanzaExcepcion(){

        casillero1_1.asignarSuperficie(new Roca());
        casillero5_5.asignarSuperficie(new Roca());

        AlgoFormer optimus = new Optimus(casillero1_1);

        optimus.avanzar(casillero5_5);
    }

    
    @Test
    public void cambiarEstadoYMover() {
        casillero1_1.asignarSuperficie(new Roca());
        casillero4_4.asignarSuperficie(new Roca());
        AlgoFormer optimus = new Optimus(casillero1_1);
        optimus.cambiarEstadoAlternativo();
        optimus.avanzar(casillero4_4);
        Assert.assertTrue( casillero4_4 == optimus.getPosicion() );
    }

    
    @Test(expected =  SobrepasaRangosException.class)
    public void avanzoEnModoAlternoUnaDistanciaPeroNoPuedoVolverLaMismaEnModoHumanoide() {
       casillero1_1.asignarSuperficie(new Roca());
       casillero4_4.asignarSuperficie(new Roca());
       AlgoFormer optimus = new Optimus(casillero1_1);

       optimus.cambiarEstadoAlternativo();
       optimus.avanzar(casillero4_4);

       optimus.cambiarEstadoHumanoide();
       optimus.avanzar(casillero1_1);
    }

   
    @Test 
    public void moverseEnEstadoAlterno() {
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Roca());
        AlgoFormer optimus = new Optimus(casillero1_1);
        optimus.cambiarEstadoAlternativo();

        optimus.avanzar(casillero2_2);
        Assert.assertTrue(optimus.getPosicion() == casillero2_2);
    }
    
    
    @Test 
    public void AtravesarRocaEnEstadoAlternativoAereo() {
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Roca());
        AlgoFormer megatron = new Megatron(casillero1_1);
        megatron.cambiarEstadoAlternativo();

        megatron.avanzar(casillero2_2);
        Assert.assertTrue(megatron.getPosicion() == casillero2_2);
    }


	@Test(expected = SobrepasaRangosException.class)
    public void siAlgoFormerSobrepasaSuDistanciaDeAtaqueLanzaException(){
        AlgoFormer optimus = new Optimus(casillero1_1);
        AlgoFormer megatron = new Megatron(tablero.obtenerCasillero(6, 5));
        optimus.atacar(megatron);
    }


    @Test
    public void algoFormerAtacaOtroAlgoFormer() {
        Optimus optimus = new Optimus(casillero1_1);
        Megatron megatron = new Megatron(casillero2_2);

       for(int i=0;i<11;i++) {
           optimus.atacar(megatron);
       }

        Assert.assertTrue(megatron.estaMuerto());
    }


    @Test(expected = FuegoAmigoException.class)
    public void algoFormerIntentaAtacarseASiMismoLanzaExcepcion() {
        AlgoFormer optimus = new Optimus(casillero2_2);
        optimus.atacar(optimus);
    }

    
    @Test
    public void algoFormerAtacaEnEstadoAlterno() {
        Optimus optimus = new Optimus(casillero1_1);
        Megatron megatron = new Megatron(casillero2_2);
        optimus.cambiarEstadoAlternativo();
        for(int i=0;i<37;i++) {
            optimus.atacar(megatron);
        }
        Assert.assertTrue(megatron.estaMuerto());
    }

    
    @Test(expected = CasilleroInvalidoException.class)
    public void crearRobotEnEspacioOcupadoLanzaExcepcion(){
            AlgoFormer optimus = new Optimus(casillero1_1);
            AlgoFormer megatron = new Megatron(casillero1_1);
    }

    
    @Test (expected = CasilleroInvalidoException.class)
    public void moverseAEspacioOcupadoLanzaExcepcion(){
    	AlgoFormer optimus = new Optimus(casillero1_1);
		AlgoFormer megatron = new Megatron(casillero2_2);

        optimus.avanzar(casillero2_2);
    }


    @Test (expected = FuegoAmigoException.class)
    public void noSePermiteFuegoAmigo(){
        Optimus optimus = new Optimus(casillero1_1);
        Bumblebee bumblebee = new Bumblebee(casillero2_2);

        optimus.atacar(bumblebee);
    }


    @Test (expected = FuegoAmigoException.class)
    public void noSePermiteFuegoAmigoAunqueCambieDeEstado(){
        Megatron megatron = new Megatron(casillero1_1);
        Bonecrusher bonecrusher = new Bonecrusher(casillero2_2);

        bonecrusher.cambiarEstadoAlternativo();
        megatron.atacar(bonecrusher);
    }

    
    /*@Test (expected = ImposibleAtravesarPantanoException.class)
    public void noSePuedeAtravesarPantanoEnModoHumanoide(){
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Pantano());
        Optimus optimus=new Optimus(casillero1_1);
        optimus.avanzar(casillero2_2);

    }*/

    
    @Test(expected = SobrepasaRangosException.class)
    public void atravesarPantanoReduceVelocidadEnModoAlternoDeUnidadTerrestre(){
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

	
   /* @Test(expected = ImposibleAtravesarNebulosaAndromedaException.class)
    public void unidadHumanoideTerrestreNoAtraviesaNebulosaAndromeda(){
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new NebulosaAndromeda());
        Optimus optimus=new Optimus(casillero1_1);
        optimus.avanzar(casillero2_2);
    }*/
    
    
    /*@Test(expected = ImposibleAtravesarNebulosaAndromedaException.class)
    public void unidadAlternativoTerrestreNoAtraviesaNebulosaAndromeda(){
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new NebulosaAndromeda());
        Optimus optimus=new Optimus(casillero1_1);
        optimus.cambiarEstadoAlternativo();
        optimus.avanzar(casillero2_2);
    }*/
    
    
   /* @Test(expected = UnidadTerrestreNoAtraviesaNubeException.class)
    public void unidadTerrestreNoAtraviesaNubeEnModoAlterno(){
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Nube());
        Optimus optimus=new Optimus(casillero1_1);
        optimus.cambiarEstadoAlternativo();
        optimus.avanzar(casillero2_2);
        Assert.assertTrue(casillero2_2==optimus.getPosicion());
    }*/
    
    
    @Test
    public void unidadAereaAtraviesaNubeEnModoAlterno(){
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Nube());
        Megatron megatron=new Megatron(casillero1_1);
        megatron.cambiarEstadoAlternativo();
        megatron.avanzar(casillero2_2);
        Assert.assertTrue(casillero2_2==megatron.getPosicion());
    }

    
    /*@Test (expected = UnidadAereaDebeEstarEnModoAlternoException.class)
    public void unidadAereaNoAtraviesaNubeEnModoHumanoide(){
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Nube());
        Megatron megatron=new Megatron(casillero1_1);
        megatron.avanzar(casillero2_2);
    }*/
    
    
    /*@Test (expected = ImposibleAtravesarPantanoException.class)
    public void unidadAereaNoAtraviesaPantanoEnModoHumanoide(){
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Pantano());
        Megatron megatron=new Megatron(casillero1_1);
        megatron.avanzar(casillero2_2);
    }*/
    
    
   /* @Test (expected = UnidadTerrestreNoAtraviesaNubeException.class)
    public void unidadTerrestreNoPuedeAtravesarNubeEnModoHumanoide(){
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Nube());
        Optimus optimus=new Optimus(casillero1_1);
        optimus.avanzar(casillero2_2);
    }*/
    
    
    @Test 
    public void unidadAereaAtraviesaRocaEnModoHumanoide(){
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Roca());
        Megatron megatron=new Megatron(casillero1_1);
        megatron.avanzar(casillero2_2);
        Assert.assertTrue(casillero2_2==megatron.getPosicion());
    }
    
    
  /*  @Test(expected = ImposibleAtravesarTormentaPsionicaException.class)
    public void unidadHumanoideTerrestreNoAtraviesaTormentaPsionica(){
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new TormentaPsionica());
        Optimus optimus=new Optimus(casillero1_1);
        optimus.avanzar(casillero2_2);
    }*/
    
    
   /* @Test(expected = ImposibleAtravesarTormentaPsionicaException.class)
    public void unidadAlternativoTerrestreNoAtraviesaTormentaPsionica(){
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new TormentaPsionica());
        Frenzy frenzy=new Frenzy(casillero1_1);
        frenzy.cambiarEstadoAlternativo();
        frenzy.avanzar(casillero2_2);
    }*/
    
    
    @Test
    public void unidadDestruida(){
    	Megatron megatron=new Megatron(casillero1_1);
    	megatron.reducirVida(100);
    	 Assert.assertTrue(megatron.estaMuerto());
    }



    //estos tests seran modificados cuando se implemente la logica de turnos

    @Test
    public void unidadAereaBloqueadaEnNebulosaEnModoHumanoide(){
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new NebulosaAndromeda());
        Megatron megatron=new Megatron(casillero1_1);
        megatron.avanzar(casillero2_2);
        Assert.assertTrue(megatron.getMovDisponibles()==96);
    }

    
    @Test
    public void unidadAereaBloqueadaEnNebulosaEnModoAlterno(){      //sin usar el juego el former tiene 100 movimientos disponibles
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new NebulosaAndromeda());
        Megatron megatron=new Megatron(casillero1_1);
        megatron.cambiarEstadoAlternativo();            //1° mov
        megatron.avanzar(casillero2_2);                 //2° mov -3 turnos bloqueados
        Assert.assertTrue(megatron.getMovDisponibles()==95);
    }

    
    @Test
    public void unidadAereaAfectadaPorTormentaPisionicaEnModoAlterno(){
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new TormentaPsionica());
        Megatron megatron=new Megatron(casillero1_1);
        megatron.cambiarEstadoAlternativo();
        megatron.avanzar(casillero2_2);
        Assert.assertTrue(megatron.estaPisionico());
    }

    
    @Test
    public void unidadAereaAfectadaPorTormentaPisionicaEnModoHumanoide(){
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new TormentaPsionica());
        Megatron megatron=new Megatron(casillero1_1);
        megatron.avanzar(casillero2_2);
        Assert.assertTrue(megatron.estaPisionico());
    }

    
    @Test (expected = JugadorGanoException.class)
    public void unidadGanaLapartidaAlCaerEnCasilleroConChispa(){
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Roca());
        casillero2_2.colocarChispaSuprema();
        Megatron megatron=new Megatron(casillero1_1);
        megatron.avanzar(casillero2_2);
    }

    
    @Test
    public void unidadRecogeDobleCanionYDuplicaSuAtaque(){
        casillero1_1.asignarSuperficie(new Roca());
        casillero2_2.asignarSuperficie(new Roca());
        casillero2_2.asignarEquipamiento(new DobleCanion());
        optimus=new Optimus(casillero1_1);
        Megatron megatron=new Megatron(casillero3_3);
        optimus.avanzar(casillero2_2);
        for(int i=0;i<6;i++) {
            optimus.atacar(megatron);
        }

        Assert.assertTrue(megatron.estaMuerto());
    }


    @Test
    public void destruirAlgoFormer() {
        optimus = new Optimus(casillero1_1);
        optimus.destruir();
        Assert.assertTrue(casillero1_1.estaOcupado() == false);
    }
}
