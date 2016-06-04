package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by lucas on 04/06/16.
 */
public class JuegoTest {

    Juego juego;
    Tablero tablero;
    Casillero c2_2;
    @Before
    public void setUp() {
        juego = new Juego(10);
        tablero = juego.getTablero();
        c2_2 = tablero.obtenerCasillero(2, 2);
    }


    @Test
    public void moverRobot() {
        juego.moverRobot(Robots.OPTIMUS, c2_2);
        Assert.assertTrue(juego.getPosicion(Robots.OPTIMUS) == c2_2);
    }

    @Test
    public void cambiarEstadoDeRobot() {
        juego.cambiarEstado(Robots.OPTIMUS);
        Assert.assertTrue(juego.getEstado(Robots.OPTIMUS) == Estado.ALTERNATIVO);
    }

    @Test(expected = TurnoInvalidoException.class)
    public void moverFueraDeTurnoLanzaExcepcion() {
        juego.moverRobot(Robots.MEGATRON, c2_2);
    }

    @Test(expected = TurnoInvalidoException.class)
    public void atacarFueraDeTurnoLanzaExcepcion() {
        juego.procesarAtaque(Robots.MEGATRON, Robots.OPTIMUS);
    }

    @Test
    public void cambiarEstadoFueraDeTurnoNoLanzaExcepcion() {
        juego.cambiarEstado(Robots.MEGATRON);
    }

    @Test
    public void procesarAtaqueEntreRobots() {
        juego.moverRobot(Robots.OPTIMUS, c2_2);
        juego.cambiarEstado(Robots.BONECRUSHER);
        juego.moverRobot(Robots.BONECRUSHER, tablero.obtenerCasillero(2, 3));
        juego.procesarAtaque(Robots.OPTIMUS, Robots.BONECRUSHER);
        int vida = juego.getVida(Robots.BONECRUSHER);
        Assert.assertTrue(vida == 150);
    }

}
