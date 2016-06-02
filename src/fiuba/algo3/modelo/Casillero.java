package fiuba.algo3.modelo;

/**
 * Created by sickness on 30/05/16.
 */
public class Casillero {
    Tablero elTablero;
    //UnidadJuego algoFormerContenido;
    UnidadJuego enteContenido;
    int posicionX;
    int posicionY;

    public Casillero(int posicionX, int posicionY, Tablero unTablero) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.elTablero = unTablero;
    }

    public Casillero buscarCasillero(int direccionX, int direccionY){
        return this.elTablero.buscarCasillero(this.posicionX, this.posicionY, direccionX, direccionY);
    }
	
	
	public void propiciarAtaque(AlgoFormer atacante){

		AlgoFormer victimaAtacada = (AlgoFormer) enteContenido;
		if(    victimaAtacada == null   ||  !victimaAtacada.esAlgoFormer()    ||  victimaAtacada.equals(atacante) )
            throw new CasilleroInvalidoException();

        if(  victimaAtacada.esAutobot()==atacante.esAutobot()  ||  victimaAtacada.esDecepticon() == atacante.esDecepticon())
            throw new FuegoAmigoException();

        victimaAtacada.procesarAtaque(atacante.estadoActual.danioAtaque);


	}
	
	

    public void colocarEnte(UnidadJuego ente) {
        this.enteContenido = ente;
    }

    public void destruirUnidad() {
        this.enteContenido = null;
    }


}
