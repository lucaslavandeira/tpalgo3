package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lucas on 04/06/16.
 */
public class CasilleroTest {

    @Test
    public void ocuparCasillero() {
        Casillero casillero = new Casillero(1, 1);
        Optimus optimus = new Optimus(casillero);
        Assert.assertTrue(casillero.estaOcupado());
    }

    @Test
    public void moverRobotAlCasilleroLoOcupa() {
        Casillero casillero = new Casillero(2, 2);
        Optimus optimus = new Optimus(new Casillero(1, 1));
        optimus.avanzar(casillero);
        Assert.assertTrue(casillero.estaOcupado());
    }
    @Test
    public void tieneChispaSuprema(){
    	Casillero casilleroConChispaSuprema = new Casillero(5, 5);
    	casilleroConChispaSuprema.colocarChispaSuprema();
    	Assert.assertTrue(casilleroConChispaSuprema.tieneChispaSuprema());
    }
}