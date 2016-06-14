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
        Superficie rocas=new Roca();
        casillero.asignarSuperficie(rocas);
        Optimus optimus = new Optimus(casillero);
        Assert.assertTrue(casillero.estaOcupado());
    }

    @Test
    public void moverRobotAlCasilleroLoOcupa() {
        Casillero destino = new Casillero(2, 2);
        Casillero casillero = new Casillero(1, 1);
        Superficie rocas=new Roca();
        destino.asignarSuperficie(rocas);
        destino.asignarEquipamiento(new SinEquipamiento());
        casillero.asignarSuperficie(rocas);
        casillero.asignarEquipamiento(new SinEquipamiento());
        Optimus optimus = new Optimus(new Casillero(1, 1));

        optimus.avanzar(destino);
        Assert.assertTrue(destino.estaOcupado());
    }


}