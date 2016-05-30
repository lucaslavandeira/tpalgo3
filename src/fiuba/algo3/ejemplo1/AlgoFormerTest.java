package fiuba.algo3.ejemplo1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sickness on 30/05/16.
 */
public class AlgoFormerTest {

    @Test
    public void test01CrearUnAlgoFormerYMoverlo(){
        Tablero tablero = new Tablero(10);
        Casillero unCasillero = tablero.obtenerCasillero(1, 1);
        AlgoFormer optimus = new AlgoFormer(unCasillero);

        Assert.assertTrue(optimus.posicion == unCasillero);

        optimus.avanzar(1, 1);
        Casillero otroCasillero = tablero.obtenerCasillero(2,2);
        Assert.assertTrue(optimus.posicion == otroCasillero);

    }
}
