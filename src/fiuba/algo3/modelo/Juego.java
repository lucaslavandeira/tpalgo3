package fiuba.algo3.modelo;

import java.util.HashMap;

/**
 * Created by lucas on 04/06/16.
 */
public class Juego {

    Tablero tablero;
    Equipo equipoConTurno;

    HashMap<Robots, AlgoFormer> robots;

    public Juego(int tamanioTablero) {
        tablero = new Tablero(tamanioTablero);
        robots = new HashMap<Robots, AlgoFormer>();
        equipoConTurno = Equipo.AUTOBOTS;
        crearRobots();
    }

    public void crearRobots() {
        robots.put(Robots.OPTIMUS, new Optimus(tablero.obtenerCasillero(1, 1)));
        robots.put(Robots.BUMBLEBLEE, new Bumblebee(tablero.obtenerCasillero(1, 3)));
        robots.put(Robots.RATCHET, new Ratchet(tablero.obtenerCasillero(1, 5)));
        robots.put(Robots.MEGATRON, new Megatron(tablero.obtenerCasillero(9, 2)));
        robots.put(Robots.BONECRUSHER, new Bonecrusher(tablero.obtenerCasillero(9, 4)));
        robots.put(Robots.FRENZY, new Frenzy(tablero.obtenerCasillero(9, 6)));
    }

    public Tablero getTablero() {
        return tablero;
    }


    public void moverRobot(Robots identificador, Casillero destino) {
        AlgoFormer robot = robots.get(identificador);
        if (equipoConTurno != robot.getEquipo()) {
            throw new TurnoInvalidoException();
        }

        robot.avanzar(destino);
        actualizarEquipoConTurno();
    }

    public void procesarAtaque(Robots identificadorAtacante, Robots identificadorVictima) {
        AlgoFormer atacante = robots.get(identificadorAtacante);
        if (equipoConTurno != atacante.getEquipo()) {
            throw new TurnoInvalidoException();
        }
        AlgoFormer victima = robots.get(identificadorVictima);

        atacante.atacar(victima);
        actualizarEquipoConTurno();
    }

    public void cambiarEstado(Robots identificador) {
        AlgoFormer robot = robots.get(identificador);


        robot.cambiarEstado();
    }

    public Estado getEstado(Robots identificador) {
        return robots.get(identificador).getEstado();
    }

    public Casillero getPosicion(Robots identificador) {
        return robots.get(identificador).getPosicion();
    }

    public int getVida(Robots identificador) {
        return robots.get(identificador).getVida();
    }

    private void actualizarEquipoConTurno() {
        if(equipoConTurno == Equipo.AUTOBOTS) {
            equipoConTurno = Equipo.DECEPTICONS;
        }
        else {
            equipoConTurno = Equipo.AUTOBOTS;
        }
    }


}
