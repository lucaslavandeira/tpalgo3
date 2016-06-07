package fiuba.algo3.modelo;

import java.util.HashMap;

/**
 * Created by lucas on 04/06/16.
 */
public class Juego {

    private Tablero tablero;
    private Equipo equipoConTurno;

    private HashMap<Robots, AlgoFormer> robots;

    private Casillero posicionChispaSuprema;
    public Juego(int tamanioTablero) {
        this.tablero = new Tablero(tamanioTablero);
        this.robots = new HashMap<Robots, AlgoFormer>();
        this.equipoConTurno = Equipo.AUTOBOTS;
        crearRobots();
        colocarChispaSuprema();
    }

    private void colocarChispaSuprema() {
        this.posicionChispaSuprema = this.tablero.obtenerCasillero(5, 5);
        this.posicionChispaSuprema.colocarChispaSuprema();
	}


	private void crearRobots() {
        this.robots.put(Robots.OPTIMUS, new Optimus(tablero.obtenerCasillero(1, 1)));
        this.robots.put(Robots.BUMBLEBLEE, new Bumblebee(tablero.obtenerCasillero(1, 3)));
        this.robots.put(Robots.RATCHET, new Ratchet(tablero.obtenerCasillero(1, 5)));
        this.robots.put(Robots.MEGATRON, new Megatron(tablero.obtenerCasillero(9, 2)));
        this.robots.put(Robots.BONECRUSHER, new Bonecrusher(tablero.obtenerCasillero(9, 4)));
        this.robots.put(Robots.FRENZY, new Frenzy(tablero.obtenerCasillero(9, 6)));
    }

    public void moverRobot(Robots identificador, int posicionX, int posicionY) {

        AlgoFormer robot = robots.get(identificador);
        if (this.equipoConTurno != robot.getEquipo()) {
            throw new TurnoInvalidoException();
        }

        Casillero destino = tablero.obtenerCasillero(posicionX, posicionY);
        robot.avanzar(destino);

        if (destino.tieneChispaSuprema()){
        	 throw new JugadorGanoException();
        }
        actualizarEquipoConTurno();
    }

    public void procesarAtaque(Robots identificadorAtacante, Robots identificadorVictima) {
        AlgoFormer atacante = this.robots.get(identificadorAtacante);
        if (this.equipoConTurno != atacante.getEquipo()) {
            throw new TurnoInvalidoException();
        }
        AlgoFormer victima = this.robots.get(identificadorVictima);

        atacante.atacar(victima);
        actualizarEquipoConTurno();
    }

    public void cambiarEstado(Robots identificador) {
        AlgoFormer robot = this.robots.get(identificador);


        robot.cambiarEstado();
    }

    public Estado getEstado(Robots identificador) {
        return this.robots.get(identificador).getEstado();
    }

    public int[] getPosicion(Robots identificador) {
        Casillero casillero = this.robots.get(identificador).getPosicion();
        int posiciones[] = new int[2];
        posiciones[0] = casillero.getPosicionX();
        posiciones[1] = casillero.getPosicionY();
        return posiciones;
    }

    public int[] getPosicionDeChispaSuprema() {
        int[] posicion = {this.posicionChispaSuprema.getPosicionX(), this.posicionChispaSuprema.getPosicionY()};
        return posicion;
    }
    public int getVida(Robots identificador) {
        return this.robots.get(identificador).getVida();
    }

    private void actualizarEquipoConTurno() {
        if(this.equipoConTurno == Equipo.AUTOBOTS) {
            this.equipoConTurno = Equipo.DECEPTICONS;
        }
        else {
            this.equipoConTurno = Equipo.AUTOBOTS;
        }
    }


}
