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


    Estado estadoHumanoideOptimus;
    Estado estadoAlternoOptimus;
    Estado estadoHumanoideMegatron;
    Estado estadoAlternoMegatron;

    int vidaOptimus = 500;
    int vidaMegatron = 550;
    int vida = 50;
    @Before
    public void setUp() {
        tablero = new Tablero(11);
        casillero1_1 = tablero.obtenerCasillero(1, 1);
        casillero2_2 = tablero.obtenerCasillero(2, 2);
    }

    @Test
    public void crearUnAlgoFormer() {
        optimus = new Optimus(casillero1_1);
        Assert.assertTrue(optimus.posicion == casillero1_1);
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
        optimus.cambiarEstado();
        Assert.assertTrue(optimus.getEstado() == Estado.ALTERNATIVO);
    }

    @Test
    public void cambiarEstadoDosVeces() {
        AlgoFormer optimus = new Optimus(casillero1_1);
        optimus.cambiarEstado();
        optimus.cambiarEstado();
        Assert.assertTrue(optimus.getEstado() == Estado.HUMANOIDE);
    }

    @Test public void moverseEnEstadoAlterno() {
        AlgoFormer optimus = new Optimus(casillero1_1);
        optimus.cambiarEstado();

        optimus.avanzar(casillero2_2);
        Assert.assertTrue(optimus.getPosicion() == casillero2_2);
    }
	
	@Test(expected = SobrepasaDistanciaDeAtaqueException.class)
    public void siAlgoFormerSobrepasaSuDistanciaDeAtaqueLanzaException(){
        AlgoFormer optimus = new Optimus(casillero1_1);
        AlgoFormer megatron = new Megatron(tablero.obtenerCasillero(5, 5));
        optimus.atacar(megatron);
    }




    @Test
    public void algoFormerAtacaOtroAlgoFormer() {
        Optimus optimus = new Optimus(casillero1_1);
        Megatron megatron = new Megatron(casillero2_2);

        optimus.atacar(megatron);
        Assert.assertTrue(megatron.getVida() == 500);
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
        optimus.cambiarEstado();
        optimus.atacar(megatron);
        Assert.assertTrue(megatron.vida == 535);
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


    @Test
    public void cambiarEstadoPreservaVida() {
        Optimus optimus = new Optimus(casillero1_1);
        Megatron megatron = new Megatron(casillero2_2);

        megatron.atacar(optimus);
        int vidaAntes = optimus.getVida();
        optimus.cambiarEstado();
        int vidaDespues = optimus.getVida();
        Assert.assertTrue(vidaAntes == vidaDespues);
    }
}
