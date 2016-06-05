package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by lucas on 04/06/16.
 */
public class JuegoTest {

    Juego juego;

    static int X = 0;
    static int Y = 1;

    @Before
    public void setUp() {
        juego = new Juego(10);
    }


    @Test
    public void moverRobot() {
        juego.moverRobot(Robots.OPTIMUS, 2, 2);
        int[] posicion = juego.getPosicion(Robots.OPTIMUS);
        Assert.assertTrue(posicion[X] == 2 && posicion[Y] == 2);
    }

    @Test
    public void cambiarEstadoDeRobot() {
        juego.cambiarEstado(Robots.OPTIMUS);
        Assert.assertTrue(juego.getEstado(Robots.OPTIMUS) == Estado.ALTERNATIVO);
    }

    @Test(expected = TurnoInvalidoException.class)
    public void moverFueraDeTurnoLanzaExcepcion() {
        juego.moverRobot(Robots.MEGATRON, 9, 2);
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
        juego.moverRobot(Robots.OPTIMUS, 2, 2);
        juego.cambiarEstado(Robots.BONECRUSHER);
        juego.moverRobot(Robots.BONECRUSHER, 2, 3);
        juego.procesarAtaque(Robots.OPTIMUS, Robots.BONECRUSHER);
        int vida = juego.getVida(Robots.BONECRUSHER);
        Assert.assertTrue(vida == 150);
    }

    @Test (expected = JugadorGanoException.class)
    public void jugadorGano() {
        // posición de la chispa en 5, 5. Cuando Optimus llega, se lanza la excepción
    	juego.moverRobot(Robots.OPTIMUS, 2, 2);
    	juego.moverRobot(Robots.MEGATRON, 9, 1);
    	juego.moverRobot(Robots.OPTIMUS, 3, 3);
    	juego.moverRobot(Robots.MEGATRON, 9, 2);
    	juego.moverRobot(Robots.OPTIMUS, 4, 4);
    	juego.moverRobot(Robots.MEGATRON, 9, 1);
    	juego.moverRobot(Robots.OPTIMUS, 5, 5);
    }

    @Test
    public void crearJuegoConTodasLasPiezasEnElTablero(){
        int[] posicionOptimus = juego.getPosicion(Robots.OPTIMUS);
        int[] posicionBumblebee = juego.getPosicion(Robots.BUMBLEBLEE);
        int[] posicionRatchet = juego.getPosicion(Robots.RATCHET);
        int[] posicionMegatron = juego.getPosicion(Robots.MEGATRON);
        int[] posicionBonechusher = juego.getPosicion(Robots.BONECRUSHER);
        int[] posicionFrenzy = juego.getPosicion(Robots.FRENZY);

        int[] posicionChispa = juego.getPosicionDeChispaSuprema();
        Assert.assertTrue(posicionOptimus[X] == 1 && posicionOptimus[Y] == 1);
        Assert.assertTrue(posicionBumblebee[X] == 1 && posicionBumblebee[Y] == 3);
        Assert.assertTrue(posicionRatchet[X] == 1 && posicionRatchet[Y] == 5);
        Assert.assertTrue(posicionMegatron[X] == 9 && posicionMegatron[Y] == 2);
        Assert.assertTrue(posicionBonechusher[X] == 9 && posicionBonechusher[Y] == 4);
        Assert.assertTrue(posicionFrenzy[X] == 9 && posicionFrenzy[Y] == 6);
        Assert.assertTrue(posicionChispa[X] == 5 && posicionChispa[Y] == 5);
    }
}
