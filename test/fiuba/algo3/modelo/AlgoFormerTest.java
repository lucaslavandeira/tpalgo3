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

    @Before
    public void setUp() {
        tablero = new Tablero(10);
        casillero1_1 = tablero.obtenerCasillero(1, 1);
        casillero2_2 = tablero.obtenerCasillero(2, 2);
    }
    @Test
    public void testCrearUnAlgoFormer() {
        optimus = new AlgoFormer(casillero1_1);
        Assert.assertTrue(optimus.posicion == casillero1_1);
    }

    @Test
    public void testMoverAlgoFormerEnUnaDireccion(){
        AlgoFormer optimus = new AlgoFormer(casillero1_1);

        optimus.avanzar(1, 0);
        Casillero otroCasillero = tablero.obtenerCasillero(2,1);
        Assert.assertTrue(optimus.posicion == otroCasillero);
    }

    @Test
    public void testMoverAlgoFormerEnAmbasDirecciones() {

        AlgoFormer optimus = new AlgoFormer(casillero1_1);

        optimus.avanzar(1, 1);
        Assert.assertTrue(optimus.posicion == casillero2_2);
    }

    @Test
    public void testMoverAlgoFormerParaAtras() {
        AlgoFormer optimus = new AlgoFormer(casillero2_2);
        optimus.avanzar(-1, -1);
        Assert.assertTrue(optimus.posicion == casillero1_1);
    }

    @Test(expected = SobrepasaSuVelocidadException.class)
    public void test02QueElAlgoFormerSobrepaseSuVelocidad(){

        Tablero tablero = new Tablero(10);
        Casillero unCasillero = tablero.obtenerCasillero(1, 1);
        AlgoFormer optimus = new AlgoFormer(unCasillero);
        optimus.avanzar(2, 1);

    }
}
