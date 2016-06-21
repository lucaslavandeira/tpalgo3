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
    private String ganador;
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


    public String getGanador(){
        return this.ganador;
    }

}
