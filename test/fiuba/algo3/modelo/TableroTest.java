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

    
    @Test(expected = CasilleroInvalidoException.class)
    public void obtenerCasilleroInvalidoLanzaExcepcion() {
        Tablero tablero = new Tablero(tablero_size);
        tablero.obtenerCasillero(-1, 0);
    }
	
    
    @Test
    public void obtenerTamanioDeTablero() {
        Tablero tablero = new Tablero(tablero_size);
        Assert.assertTrue(tablero.tamanio() == 10);
    }
    
    
    @Test
    public void asignarEfectoAleatorios	() {
        Tablero tablero = new Tablero(tablero_size);
        tablero.asignarEfectosAleatorios();
    }

}

