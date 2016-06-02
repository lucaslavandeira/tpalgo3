package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Created by Diego on 01/06/2016.
 */
public class juegoTest {

    Tablero tablero;

    @Before
    public void setUp() {
        tablero = new Tablero(11);
    }

    @Test
    public void test00GenerarCorrectamenteMiembrosDelEquipo(){
        EquipoAutobots autobots= new EquipoAutobots(tablero);
        EquipoDecepticons desepticons= new EquipoDecepticons(tablero);


        Assert.assertTrue(autobots.optimus.posicion == tablero.obtenerCasillero(1,6));
        Assert.assertTrue(autobots.bumblebee.posicion == tablero.obtenerCasillero(0,5));
        Assert.assertTrue(autobots.ratchet.posicion == tablero.obtenerCasillero(0,7));


        Assert.assertTrue(desepticons.megatron.posicion == tablero.obtenerCasillero(9,6));
        Assert.assertTrue(desepticons.bonecrusher.posicion == tablero.obtenerCasillero(10,5));
        Assert.assertTrue(desepticons.frenzy.posicion == tablero.obtenerCasillero(10,7));


    }

    @Test
    public void test01MoverMiembrosDeEquipos(){
        EquipoAutobots autobots= new EquipoAutobots(tablero);
        EquipoDecepticons desepticons= new EquipoDecepticons(tablero);

        autobots.optimus.avanzar(2,0);
        autobots.bumblebee.avanzar(2,0);
        autobots.ratchet.avanzar(1,0);
        Assert.assertTrue(autobots.optimus.posicion == tablero.obtenerCasillero(3,6));
        Assert.assertTrue(autobots.bumblebee.posicion == tablero.obtenerCasillero(2,5));
        Assert.assertTrue(autobots.ratchet.posicion == tablero.obtenerCasillero(1,7));

        desepticons.megatron.avanzar(-1,0);
        desepticons.bonecrusher.avanzar(-1,0);
        desepticons.frenzy.avanzar(-2,0);
        Assert.assertTrue(desepticons.megatron.posicion == tablero.obtenerCasillero(8,6));
        Assert.assertTrue(desepticons.bonecrusher.posicion == tablero.obtenerCasillero(9,5));
        Assert.assertTrue(desepticons.frenzy.posicion == tablero.obtenerCasillero(8,7));

    }



}
