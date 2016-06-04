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

}

