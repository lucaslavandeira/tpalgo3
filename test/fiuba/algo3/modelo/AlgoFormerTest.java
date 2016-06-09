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

        optimus.avanzar(casillero2_2);
        Assert.assertTrue(optimus.getPosicion() == casillero2_2);
    }

    @Test(expected = SobrepasaSuVelocidadException.class)
    public void sobrepasarVelocidadLanzaExcepcion(){
        Tablero tablero = new Tablero(10);
        Casillero unCasillero = tablero.obtenerCasillero(1, 1);
        AlgoFormer optimus = new Optimus(unCasillero);
        optimus.avanzar(tablero.obtenerCasillero(4, 4));
    }

    @Test
    public void cambiarEstado() {
        AlgoFormer optimus = new Optimus(casillero1_1);
        optimus.cambiarEstadoAlternativo();
        optimus.avanzar(casillero4_4);
        Assert.assertTrue( casillero4_4 == optimus.getPosicion() );
        }

   @Test(expected =  SobrepasaSuVelocidadException.class)
    public void cambiarEstadoDosVeces() {
        AlgoFormer optimus = new Optimus(casillero1_1);
        optimus.cambiarEstadoAlternativo();
        optimus.avanzar(casillero4_4);
        Assert.assertTrue( casillero4_4 == optimus.getPosicion() );
        optimus.cambiarEstadoHumanoide();
        optimus.avanzar(casillero1_1);
    }

    @Test public void moverseEnEstadoAlterno() {
        AlgoFormer optimus = new Optimus(casillero1_1);
        optimus.cambiarEstadoAlternativo();

        optimus.avanzar(casillero2_2);
        Assert.assertTrue(optimus.getPosicion() == casillero2_2);
    }
	
	@Test(expected = SobrepasaDistanciaDeAtaqueException.class)
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

        Assert.assertTrue(megatron.estaMuerto());/////++++++++++++++++
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
        Assert.assertTrue(megatron.estaMuerto());//*****************
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




}
