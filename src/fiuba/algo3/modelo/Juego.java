package fiuba.algo3.modelo;
import fiuba.algo3.modelo.Tablero;
import java.util.ArrayList;


/**
 * Created by usuario on 16/06/2016.
 */
public class Juego {

    private Tablero mapa;
    private ArrayList<AlgoFormer> autobots;
    private ArrayList<AlgoFormer> decepticons;
    private Equipo ganador;
    private String turnoActual;
	private Superion superion;
	private Menasor menasor;




    public Juego(Tablero tablero){
        this.mapa=tablero;
        mapa.obtenerCentroDeTablero().colocarChispaSuprema();
        this.autobots=new ArrayList<AlgoFormer>();
        this.decepticons=new ArrayList<AlgoFormer>();
        this.superion = new Superion();
        this.menasor = new Menasor();
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
        menasor.siguienteTurno();
        menasor.siguienteTurno();
        superion.siguienteTurno();
        superion.siguienteTurno();
        if (turnoActual == "Autobots") {
        	turnoActual = "Decepticons"; 
        }else{
            turnoActual = "Autobots";
        }

    }


public void hayGanador(){
    if (this.equipoEstaMuerto(this.autobots) & this.superion.estaMuerto() ){
       this.ganador = this.ganador.DECEPTICONS;
       throw new JugadorGanoException();
    }
    if (this.equipoEstaMuerto(this.decepticons) & this.menasor.estaMuerto() ){
        this.ganador = this.ganador.AUTOBOTS;
        throw new JugadorGanoException();
    }
  
    if (this.equipoTieneChispaSuprema(this.autobots)){
    	this.ganador = this.ganador.AUTOBOTS;
    	throw new JugadorGanoException();
    }
    else 
    {
    	if (!this.superion.estaMuerto()){
    	    if (this.superion.getPosicion().tieneChispaSuprema()){
    	    	this.ganador = this.ganador.AUTOBOTS;
    	    	throw new JugadorGanoException();
    	    }
    	}
    }
    
    if (this.equipoTieneChispaSuprema(this.decepticons)){
    	this.ganador = this.ganador.DECEPTICONS;
    	throw new JugadorGanoException();
    }
    else 
    {
    	if (!this.menasor.estaMuerto()){
    	    if (this.menasor.getPosicion().tieneChispaSuprema()){
    	    	this.ganador = this.ganador.DECEPTICONS;
    	    	throw new JugadorGanoException();
    	    }
    	}
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
        Casillero posicion = mapa.obtenerCasillero(0, 0);
        superion = new Superion(posicion);
        this.superion.setVida(sumarVidaDelEquipo(this.autobots));
        for (AlgoFormer a : autobots) {
            a.destruir();
        }
        
        autobots.add(superion);
        superion.siguienteTurno();
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

        Casillero posicion = mapa.obtenerCasillero(10, 10);
        this.menasor = new Menasor(posicion);
        this.menasor.setVida(sumarVidaDelEquipo(this.decepticons));
        for (AlgoFormer a : this.decepticons) {
            a.destruir();
        }
        this.decepticons.add(menasor);
        menasor.siguienteTurno();
        return this.menasor;    
    }


	private int sumarVidaDelEquipo(ArrayList<AlgoFormer> equipo) {
		int vidaTotal =0;
		for(int i = 0; i < equipo.size(); i++) {
			vidaTotal += equipo.get(i).getVida();
		}
		return vidaTotal;
	}

}
