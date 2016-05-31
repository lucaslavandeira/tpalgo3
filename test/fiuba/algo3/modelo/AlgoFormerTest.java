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
    Estado estadoTierra;
    Estado estadoAire;
    @Before
    public void setUp() {
        tablero = new Tablero(10);
        casillero1_1 = tablero.obtenerCasillero(1, 1);
        casillero2_2 = tablero.obtenerCasillero(2, 2);
        estadoTierra = new Estado(500, 50, 2, 2);
        estadoAire = new Estado(500, 15, 4, 5);
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
        AlgoFormer optimus = new AlgoFormer(casillero1_1, estadoTierra, estadoAire);

        Assert.assertTrue(optimus.estadoActual == estadoTierra);
        optimus.cambiarEstado();
        Assert.assertTrue(optimus.estadoActual == estadoAire);
    }

    @Test
    public void test06AlgoFormerCambiarEstadoDosVeces() {
        AlgoFormer optimus = new AlgoFormer(casillero1_1, estadoTierra, estadoAire);
        optimus.cambiarEstado();
        optimus.cambiarEstado();
        Assert.assertTrue(optimus.estadoActual == estadoTierra);
    }

    @Test public void test07AlgoFormerMoverseEnEstadoAlterno() {
        AlgoFormer optimus = new AlgoFormer(casillero1_1, estadoTierra, estadoAire);
        optimus.cambiarEstado();

        optimus.avanzar(4, 4);
        Assert.assertTrue(optimus.posicion == tablero.obtenerCasillero(5, 5));
    }
	
	@Test(expected = SobrepasaDistanciaDeAtaqueException.class)
    public void test08SiAlgoFormerSobrepasaSuDistanciaDeAtaqueLanzaException(){

        AlgoFormer optimus = new AlgoFormer(casillero1_1, estadoTierra, estadoAire);

        optimus.atacar(3,3);
    }
}
