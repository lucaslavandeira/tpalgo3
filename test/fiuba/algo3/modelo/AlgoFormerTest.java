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
        estadoHumanoideOptimus = new Estado(50, 2, 2);
        estadoAlternoOptimus = new Estado(15, 4, 5);
        estadoHumanoideMegatron = new Estado( 10, 3, 1);
        estadoAlternoMegatron = new Estado( 55, 2, 8);
    }

    @Test
    public void test00CrearUnAlgoFormer() {
        optimus = new AlgoFormer(casillero1_1);
        Assert.assertTrue(optimus.posicion == casillero1_1);
    }

    @Test
    public void test01MoverAlgoFormerEnUnaDireccion(){
        AlgoFormer optimus = new AlgoFormer(casillero1_1);

        optimus.avanzar(1, 0);
        Casillero otroCasillero = tablero.obtenerCasillero(2,1);
        Assert.assertTrue(optimus.posicion == otroCasillero);
    }

    @Test
    public void test02MoverAlgoFormerEnAmbasDirecciones() {
        AlgoFormer optimus = new AlgoFormer(casillero1_1);

        optimus.avanzar(1, 1);
        Assert.assertTrue(optimus.posicion == casillero2_2);
    }

    @Test
    public void test03MoverAlgoFormerParaAtras() {
        AlgoFormer optimus = new AlgoFormer(casillero2_2);
        optimus.avanzar(-1, -1);
        Assert.assertTrue(optimus.posicion == casillero1_1);
    }

    @Test(expected = SobrepasaSuVelocidadException.class)
    public void test04QueElAlgoFormerSobrepaseSuVelocidad(){
        Tablero tablero = new Tablero(10);
        Casillero unCasillero = tablero.obtenerCasillero(1, 1);
        AlgoFormer optimus = new AlgoFormer(unCasillero);
        optimus.avanzar(2, 1);
    }

    @Test
    public void test05AlgoFormerCambiaEstado() {
        AlgoFormer optimus = new AlgoFormer(casillero1_1, estadoHumanoideOptimus, estadoAlternoOptimus, vidaOptimus);

        Assert.assertTrue(optimus.estadoActual == estadoHumanoideOptimus);
        optimus.cambiarEstado();
        Assert.assertTrue(optimus.estadoActual == estadoAlternoOptimus);
    }

    @Test
    public void test06AlgoFormerCambiarEstadoDosVeces() {
        AlgoFormer optimus = new AlgoFormer(casillero1_1, estadoHumanoideOptimus, estadoAlternoOptimus, vidaOptimus);
        optimus.cambiarEstado();
        optimus.cambiarEstado();
        Assert.assertTrue(optimus.estadoActual == estadoHumanoideOptimus);
    }

    @Test public void test07AlgoFormerMoverseEnEstadoAlterno() {
        AlgoFormer optimus = new AlgoFormer(casillero1_1, estadoHumanoideOptimus, estadoAlternoOptimus, vidaOptimus);
        optimus.cambiarEstado();

        optimus.avanzar(4, 4);
        Assert.assertTrue(optimus.posicion == tablero.obtenerCasillero(5, 5));
    }
	
	@Test(expected = SobrepasaDistanciaDeAtaqueException.class)
    public void test08SiAlgoFormerSobrepasaSuDistanciaDeAtaqueLanzaException(){
        AlgoFormer optimus = new AlgoFormer(casillero1_1, estadoHumanoideOptimus, estadoAlternoOptimus, vidaOptimus);
        optimus.atacar(3,3);
    }


    @Test
    public void test09AlgoFormerAtacaOtroAlgoFormer() {
        AlgoFormer optimus = new AlgoFormer(casillero1_1, estadoHumanoideOptimus, estadoAlternoOptimus, vidaOptimus);
        AlgoFormer megatron = new AlgoFormer(casillero2_2, estadoHumanoideOptimus, estadoAlternoOptimus, vidaMegatron);

        optimus.atacar(1, 1);
        Assert.assertTrue(megatron.vida == vidaMegatron - optimus.estadoActual.danioAtaque);
    }

    @Test(expected = CasilleroInvalidoException.class)
    public void test10AlgoFormerAtacaCasilleroVacio() {
        AlgoFormer optimus = new AlgoFormer(casillero1_1, estadoHumanoideOptimus, estadoAlternoOptimus, vidaOptimus);
        optimus.atacar(1, 1);
    }

    @Test(expected = CasilleroInvalidoException.class)
    public void test11AlgoFormerIntentaAtacarseASiMismo() {
        AlgoFormer optimus = new AlgoFormer(casillero1_1, estadoHumanoideOptimus, estadoAlternoOptimus, vidaOptimus);
        optimus.atacar(0, 0);
    }

    @Test
    public void test12AlgoFormerAtacaHaciaAtras() {
        AlgoFormer optimus = new AlgoFormer(casillero1_1, estadoHumanoideOptimus, estadoAlternoOptimus, vidaOptimus);
        AlgoFormer megatron = new AlgoFormer(casillero2_2, estadoHumanoideOptimus, estadoAlternoOptimus, vidaMegatron);

        megatron.atacar(-1, -1);
        Assert.assertTrue(optimus.vida == vidaOptimus - megatron.estadoActual.danioAtaque);
    }

    @Test
    public void test13AlgoFormerAtacaEnEstadoAlterno() {
        AlgoFormer optimus = new AlgoFormer(casillero1_1, estadoHumanoideOptimus, estadoAlternoOptimus, vidaOptimus);
        AlgoFormer megatron = new AlgoFormer(casillero2_2, estadoHumanoideOptimus, estadoAlternoOptimus, vidaOptimus);

        optimus.cambiarEstado();
        optimus.atacar(1, 1);
        Assert.assertTrue(megatron.vida == vidaOptimus - optimus.estadoActual.danioAtaque);
    }

    @Test
    public void test14AlgoFormerEnEstadoAlternoTieneMasRango() {
        AlgoFormer optimus = new AlgoFormer(casillero1_1, estadoHumanoideOptimus, estadoAlternoOptimus, vidaOptimus);
        AlgoFormer megatron = new AlgoFormer(tablero.obtenerCasillero(4, 4), estadoHumanoideOptimus, estadoAlternoOptimus, vidaOptimus);

        optimus.cambiarEstado();
        optimus.atacar(3, 3);
        Assert.assertTrue(megatron.vida == vidaOptimus - optimus.estadoActual.danioAtaque);
    }

    @Test
    public void test15DestruirAlgoFormer() {
        AlgoFormer optimus = new AlgoFormer(casillero1_1, estadoHumanoideOptimus, estadoAlternoOptimus, vidaOptimus);
        new AlgoFormer(casillero2_2, estadoHumanoideOptimus, estadoAlternoOptimus, 50);
        
        optimus.atacar(1, 1);
        Assert.assertTrue(casillero2_2.enteContenido == null);
    }

    @Test(expected = CasilleroInvalidoException.class)
    public void test17AlgoFormerSuperpuestos(){
    	AlgoFormer optimus = new AlgoFormer(casillero1_1, estadoHumanoideOptimus, estadoAlternoOptimus, vidaOptimus);
		AlgoFormer megatron = new AlgoFormer(casillero1_1, estadoHumanoideMegatron, estadoAlternoMegatron,vidaMegatron);
    }
    @Test (expected = CasilleroInvalidoException.class)
    public void test18AlgoFormerSeMueveEnPosicionDeOtroAlgoFormer(){
    	AlgoFormer optimus = new AlgoFormer(casillero1_1, estadoHumanoideOptimus, estadoAlternoOptimus, vidaOptimus);
		AlgoFormer megatron = new AlgoFormer(casillero2_2, estadoHumanoideMegatron, estadoAlternoMegatron,vidaMegatron);
		optimus.avanzar(1, 1);
    }
    
}
