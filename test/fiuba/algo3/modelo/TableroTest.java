package fiuba.algo3.modelo;

import org.junit.Test;
import org.junit.Assert;

/**
 * Created by lucas on 31/05/16.
 */
public class TableroTest {

    int tablero_size = 10;


    @Test
    public void testCrearTablero() {
        Tablero tablero = new Tablero(tablero_size);

        for (int i = 0; i < tablero_size; i++) {
            for (int j = 0; j < tablero_size; j++)
                Assert.assertNotNull(tablero.obtenerCasillero(i, j));
        }
    }

    @Test
    public void testBuscarCasillero() {
        Tablero tablero = new Tablero(tablero_size);
        Casillero casillero2_2 = tablero.obtenerCasillero(2, 2);
        Casillero casilleroEncontrado = tablero.buscarCasillero(1, 1, 1, 1);
        Assert.assertTrue(casillero2_2 == casilleroEncontrado);
    }

    @Test(expected = PosicionFueraDelMapaException.class)
    public void testMoverAfueraDelMapa() {
        Tablero tablero = new Tablero(tablero_size);
        tablero.buscarCasillero(1, 1, tablero_size, 0);
    }

}

