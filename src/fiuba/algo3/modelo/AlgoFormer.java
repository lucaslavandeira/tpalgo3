package fiuba.algo3.modelo;

/**
 * Created by sickness on 30/05/16.
 */
public class AlgoFormer implements UnidadJuego {
    Estado estadoActual;
    Estado estadoAlternativo;
    Casillero posicion;
	int vida;



    public AlgoFormer(Casillero unCasillero, Estado estadoInicial, Estado estadoAlternativo, int vida){
        this.estadoActual = estadoInicial;
        this.estadoAlternativo = estadoAlternativo;
        this.posicion = unCasillero;
        this.vida = vida;
        if (unCasillero.enteContenido != null) throw new CasilleroInvalidoException();
        unCasillero.colocarEnte(this);
    }

    public AlgoFormer(Casillero unCasillero) {
        this.estadoActual = new Estado();
        this.estadoAlternativo = new Estado();
        this.posicion = unCasillero;
        this.vida = 500;
    }

    public void avanzar(int direccionX, int direccionY){
        if (Math.abs(direccionX) > this.estadoActual.velocidad || Math.abs(direccionY) > this.estadoActual.velocidad){
            throw new SobrepasaSuVelocidadException();
        }
        if (this.posicion.buscarCasillero(direccionX, direccionY).enteContenido != null)
        	throw new CasilleroInvalidoException();
        this.posicion = this.posicion.buscarCasillero(direccionX, direccionY);
    }

    public void cambiarEstado(){
        Estado estadoTemporal;

        estadoTemporal = this.estadoAlternativo;
        this.estadoAlternativo = this.estadoActual;
        this.estadoActual = estadoTemporal;
    }
	
	public void atacar(int direccionX,int direccionY) {
        if (Math.abs(direccionX) > this.estadoActual.distanciaDeAtaque || Math.abs(direccionY) > this.estadoActual.distanciaDeAtaque){
            throw new SobrepasaDistanciaDeAtaqueException();
        }

        Casillero casilleroAtacado = posicion.buscarCasillero(direccionX, direccionY);


		casilleroAtacado.propiciarAtaque(this);
		
		
    }

    public void procesarAtaque(int danio) {
        this.vida -= danio;
        if(this.vida <= 0) {
            posicion.destruirUnidad();
        }
    }

    public boolean esAlgoFormer() {
        return true;
    }

    public boolean esChispaSuprema() {
        return false;
    }

    public boolean esBonus(){return false;}

    public boolean esAutobot(){return true;}

    public boolean esDesepticon(){return true;}


}
