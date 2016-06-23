package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Tablero;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by usuario on 16/06/2016.
 */
public class Juego {

    private Tablero mapa;
    private ArrayList<AlgoFormer> autobots;
    private ArrayList<AlgoFormer> decepticons;
    private Equipo ganador;
    private String turnoActual;


    public Juego(Tablero tablero){
        this.mapa=tablero;
        mapa.obtenerCentroDeTablero().colocarChispaSuprema();
        this.autobots=new ArrayList<AlgoFormer>();
        this.decepticons=new ArrayList<AlgoFormer>();
    }


    public void addAutobots(AlgoFormer formerUno,AlgoFormer formerDos,AlgoFormer formerTres){
        this.autobots.add(formerUno);
        this.autobots.add(formerDos);
        this.autobots.add(formerTres);
        this.autobots.get(0).siguienteTurno();
        this.autobots.get(1).siguienteTurno();
        this.autobots.get(2).siguienteTurno();

    }


    public void addDecepticons(AlgoFormer formerUno,AlgoFormer formerDos,AlgoFormer formerTres){
        this.decepticons.add(formerUno);
        this.decepticons.add(formerDos);
        this.decepticons.add(formerTres);
        this.decepticons.get(0).siguienteTurno();
        this.decepticons.get(1).siguienteTurno();
        this.decepticons.get(2).siguienteTurno();
    }


    public void comenzarJuego(){
        //tal ves deberia instanciarse las posiciones iniciales aqui dado el caso
        this.autobots.get(0).siguienteTurno();
        this.autobots.get(1).siguienteTurno();
        this.autobots.get(2).siguienteTurno();
        turnoActual = "Autobots";
    }


    public String obtenerTurnoActual(){
    	return turnoActual;
    }


    public void proximoTurno(){
        this.decepticons.get(0).siguienteTurno();
        this.decepticons.get(1).siguienteTurno();
        this.decepticons.get(2).siguienteTurno();

        this.autobots.get(0).siguienteTurno();
        this.autobots.get(1).siguienteTurno();
        this.autobots.get(2).siguienteTurno();

        if (turnoActual == "Autobots") {
        	turnoActual = "Decepticons"; 
        }else{
            turnoActual = "Autobots";
        }

    }


public void hayGanador(){
    if (this.equipoEstaMuerto(this.autobots)){
    	this.ganador = this.ganador.DECEPTICONS;
    	throw new GanaDecepticonsException();
    }
    if (this.equipoEstaMuerto(this.decepticons)){
    	this.ganador = this.ganador.AUTOBOTS;
    	throw new GanaAutobotsException();
    }
    if (this.equipoTieneChispaSuprema(this.autobots)){
    	this.ganador = this.ganador.AUTOBOTS;
    	throw new JugadorGanoException();
    }
    if (this.equipoTieneChispaSuprema(this.decepticons)){
    	this.ganador = this.ganador.DECEPTICONS;
    	throw new JugadorGanoException();
    }
}


	private boolean equipoTieneChispaSuprema(ArrayList<AlgoFormer> equipo) {
		boolean equipoGano = false;
		if ( equipo.get(0).getPosicion().tieneChispaSuprema() || equipo.get(1).getPosicion().tieneChispaSuprema() || equipo.get(2).getPosicion().tieneChispaSuprema()){
			equipoGano = true;
		}
     return equipoGano;
	}


	private boolean equipoEstaMuerto(ArrayList<AlgoFormer> equipo) {
		boolean equipoMuerto = false;
		if ( equipo.get(0).estaMuerto() & equipo.get(1).estaMuerto() & equipo.get(2).estaMuerto()){
			equipoMuerto = true;
		}
     return equipoMuerto;
	}


	public Equipo getGanador(){
        return this.ganador;
    }

    public Superion formarSuperion() {
        for(int i = 0; i < autobots.size(); i++) {
            AlgoFormer unRobot = autobots.get(i);
            for(int j = i+1; j < autobots.size(); j++) {
                AlgoFormer otroRobot = autobots.get(j);
                unRobot.getPosicion().calcularDistancia(otroRobot.getPosicion(), 1);
            }
        }

        Casillero posicion = autobots.get(0).getPosicion();
        for (AlgoFormer a : autobots) {
            a.destruir();
            // autobots.remove(a);
        }
        Superion superion = new Superion(posicion);
        autobots.add(superion);
        superion.bloquearTurnos(102);

        return superion;
    }

    public Menasor formarMenasor() {
        for(int i = 0; i < decepticons.size(); i++) {
            AlgoFormer unRobot = decepticons.get(i);
            for(int j = i+1; j < decepticons.size(); j++) {
                AlgoFormer otroRobot = decepticons.get(j);
                unRobot.getPosicion().calcularDistancia(otroRobot.getPosicion(), 1);
            }
        }

        Casillero posicion = decepticons.get(0).getPosicion();
        for (AlgoFormer a : decepticons) {
            a.destruir();
            // autobots.remove(a);
        }
        Menasor menasor = new Menasor(posicion);
        autobots.add(menasor);
        menasor.bloquearTurnos(102);

        return menasor;
    }

}
