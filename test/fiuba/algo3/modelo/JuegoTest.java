package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lucas on 04/06/16.
 */
public class JuegoTest {

    @Test
    public void crearJuegoGeneraUnTablero() {
        Juego j = new Juego(10);
        Tablero tablero = j.getTablero();
        Assert.assertNotNull(tablero);
    }


}
