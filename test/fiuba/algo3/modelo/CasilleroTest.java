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
        Efecto rocas=new Roca();
        casillero.asignarEfecto(rocas);
        Optimus optimus = new Optimus(casillero);
        Assert.assertTrue(casillero.estaOcupado());
    }

    @Test
    public void moverRobotAlCasilleroLoOcupa() {
        Casillero destino = new Casillero(2, 2);
        Casillero casillero = new Casillero(1, 1);
        Efecto rocas=new Roca();
        destino.asignarEfecto(rocas);
        casillero.asignarEfecto(rocas);
        Optimus optimus = new Optimus(new Casillero(1, 1));

        optimus.avanzar(destino);
        Assert.assertTrue(destino.estaOcupado());
    }


}