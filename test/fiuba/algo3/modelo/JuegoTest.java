package fiuba.algo3.modelo;

/**
 * Created by usuario on 16/06/2016.
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JuegoTest {

    Tablero tablero;
    AlgoFormer optimus;
    AlgoFormer bumblebee;
    AlgoFormer ratchet;
    AlgoFormer megatron;
    AlgoFormer bonecrusher;
    AlgoFormer frenzy;
    Juego game;


    @Before
    public void setUp() {
        tablero = new Tablero(10);
        game=new Juego(tablero);
        optimus=new Optimus(tablero.obtenerCasillero(0,4));
        bumblebee=new Bumblebee(tablero.obtenerCasillero(0,5));
        ratchet=new Ratchet(tablero.obtenerCasillero(0,6));
        megatron=new Megatron(tablero.obtenerCasillero(9,4));
        bonecrusher=new Bonecrusher(tablero.obtenerCasillero(9,5));
        frenzy=new Frenzy(tablero.obtenerCasillero(9,6));



    }

    @Test(expected=BloqueadoException.class)
    public void ningunAutobotMueveSinComenzarElJuego(){
        game.addAutobots(optimus,bumblebee,ratchet);
        game.addDecepticons(megatron,bonecrusher,frenzy);
        optimus.avanzar(tablero.obtenerCasillero(1,4));
    }

    @Test(expected=BloqueadoException.class)
    public void ningunDecepticonMueveSinComenzarElJuego(){
        game.addAutobots(optimus,bumblebee,ratchet);
        game.addDecepticons(megatron,bonecrusher,frenzy);
        megatron.avanzar(tablero.obtenerCasillero(1,4));
    }

    @Test
    public void alCrearJuegoAutobotsComienza(){
        game.addAutobots(optimus,bumblebee,ratchet);
        game.addDecepticons(megatron,bonecrusher,frenzy);
        game.comenzarJuego();
        optimus.avanzar(tablero.obtenerCasillero(1,4));
        Assert.assertTrue(this.optimus.getPosicion()     ==   tablero.obtenerCasillero(1,4));

    }

    @Test
    public void alCrearJuegoAutobotsAtacaAlComienzo(){
        game.addAutobots(optimus,bumblebee,ratchet);
        game.addDecepticons(megatron,bonecrusher,frenzy);
        game.comenzarJuego();
        AlgoFormer desepticon=new Megatron(tablero.obtenerCasillero(2,4));
        optimus.atacar(desepticon);
        Assert.assertTrue(this.optimus.getPosicion()     ==   tablero.obtenerCasillero(0,4));
    }

    @Test
    public void alCrearJuegoAutobotsCambiaModoAlternoAlComienzo(){      //modificar test para realizar movimiento
        game.addAutobots(optimus,bumblebee,ratchet);
        game.addDecepticons(megatron,bonecrusher,frenzy);
        game.comenzarJuego();
        optimus.cambiarEstadoAlternativo();
        Assert.assertTrue(this.optimus.getPosicion()     ==   tablero.obtenerCasillero(0,4));
    }


    @Test(expected = BloqueadoException.class)
    public void alCrearJuegoDesepticonNoPuedeCambiarAlComienzo(){

        Juego game=new Juego(tablero);
        game.addAutobots(optimus,bumblebee,ratchet);
        game.addDecepticons(megatron,bonecrusher,frenzy);
        game.comenzarJuego();
        megatron.cambiarEstadoAlternativo();
    }



    @Test(expected = BloqueadoException.class)
    public void alCrearJuegoDesepticonNoPuedeAvanzarAlComienzo(){
        Juego game=new Juego(tablero);
        game.addAutobots(optimus,bumblebee,ratchet);
        game.addDecepticons(megatron,bonecrusher,frenzy);
       game.comenzarJuego();
        megatron.avanzar(tablero.obtenerCasillero(9,5));
    }



    @Test(expected = BloqueadoException.class)
    public void alCrearJuegoDesepticonNoPuedeAtacarAlComienzo(){
        Juego game=new Juego(tablero);
        AlgoFormer autobot=new Optimus(tablero.obtenerCasillero(8,5));
        game.addAutobots(optimus,bumblebee,ratchet);
        game.addDecepticons(megatron,bonecrusher,frenzy);
        game.comenzarJuego();
        megatron.atacar(autobot);
    }

    @Test(expected=BloqueadoException.class)
    public void autobotNoSePuedeMoverDosVecesSeguidas(){
        Juego game=new Juego(tablero);
        game.addAutobots(optimus,bumblebee,ratchet);
        game.addDecepticons(megatron,bonecrusher,frenzy);
        game.comenzarJuego();
        optimus.avanzar(tablero.obtenerCasillero(1, 5));
        optimus.avanzar(tablero.obtenerCasillero(2, 5));

    }

    @Test(expected=BloqueadoException.class)
    public void decepticonNoSePuedeMoverDosVecesSeguidas(){
        Juego game=new Juego(tablero);
        game.addAutobots(optimus,bumblebee,ratchet);
        game.addDecepticons(megatron,bonecrusher,frenzy);
        game.comenzarJuego();
        optimus.avanzar(tablero.obtenerCasillero(1, 5));
        game.proximoTurno();
        bonecrusher.avanzar(tablero.obtenerCasillero(8, 5));
        bonecrusher.avanzar(tablero.obtenerCasillero(7,5));

    }

    @Test(expected=BloqueadoException.class)
    public void autobotNoSePuedeMoverDosVecesSeguidasEntreTurnos(){
        Juego game=new Juego(tablero);
        game.addAutobots(optimus,bumblebee,ratchet);
        game.addDecepticons(megatron,bonecrusher,frenzy);
        game.comenzarJuego();
        optimus.avanzar(tablero.obtenerCasillero(1, 5));
        game.proximoTurno();
        optimus.avanzar(tablero.obtenerCasillero(2,5));
    }

    @Test(expected=BloqueadoException.class)
    public void decepticonNoSePuedeMoverDosVecesSeguidasEntreTurnos(){
        Juego game=new Juego(tablero);
        game.addAutobots(optimus,bumblebee,ratchet);
        game.addDecepticons(megatron,bonecrusher,frenzy);
        game.comenzarJuego();
        optimus.avanzar(tablero.obtenerCasillero(1, 5));
        game.proximoTurno();
        megatron.avanzar(tablero.obtenerCasillero(8,5));
        game.proximoTurno();
        megatron.avanzar(tablero.obtenerCasillero(7,5));
    }

}
