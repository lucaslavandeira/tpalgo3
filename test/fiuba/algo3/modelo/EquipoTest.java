package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Diego on 01/06/2016.
 */
public class EquipoTest {

    Tablero tablero;

    @Before
    public void setUp() {
        tablero = new Tablero(11);
    }
    //se asignan lugares iniciales especificos para cada robot en el tablero al comenzar el juego
    //lugares especificos para tablero de 11
    @Test
    public void test00crearEquipoAutoBots(){
            EquipoAutobots autobots=new EquipoAutobots(tablero);
            Assert.assertTrue( autobots.optimus.posicion  ==  tablero.obtenerCasillero(1,6));

    }

    @Test
    public void test01crearEquipoDecepticons(){
            EquipoDecepticons decepticons=new EquipoDecepticons(tablero);
            Assert.assertTrue( decepticons.megatron.posicion  ==  tablero.obtenerCasillero(9,6));
    }

    @Test
    public void test02moverUnMiembroDeAutobots(){
        EquipoAutobots autobots = new EquipoAutobots(tablero);
        autobots.optimus.avanzar(1,1);
        Assert.assertTrue(autobots.optimus.posicion == tablero.obtenerCasillero(2,7));
    }

    @Test(expected = PosicionFueraDelMapaException.class)
    public void test03moverUnRobotFueraDelTablero(){
        EquipoAutobots autobots = new EquipoAutobots(tablero);
        autobots.optimus.avanzar(-2,0);
    }

    @Test(expected = SobrepasaSuVelocidadException.class)
    public void test04moverUnRobotSuperandoVelocidad(){
        EquipoAutobots autobots = new EquipoAutobots(tablero);
        autobots.bumblebee.avanzar(0,3);
    }



}
