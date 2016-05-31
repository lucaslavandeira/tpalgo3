package fiuba.algo3.modelo;

/**
 * Created by sickness on 30/05/16.
 */
public class AlgoFormer {
    Estado estadoActual;
    Estado estadoAlternativo;
    Casillero posicion;

    public AlgoFormer(Casillero unCasillero, Estado estadoInicial, Estado estadoAlternativo){
        this.estadoActual = estadoInicial;
        this.estadoAlternativo = estadoAlternativo;
        this.posicion = unCasillero;
    }

    public AlgoFormer(Casillero unCasillero) {
        this.estadoActual = new Estado();
        this.estadoAlternativo = new Estado();
        this.posicion = unCasillero;
    }

    public void avanzar(int direccionX, int direccionY){

        if (Math.abs(direccionX) > this.estadoActual.velocidad || Math.abs(direccionY) > this.estadoActual.velocidad){
            throw new SobrepasaSuVelocidadException();
        }

        this.posicion = this.posicion.buscarCasillero(direccionX, direccionY);
    }

    

    public void cambiarEstado(){
        Estado estadoTemporal;

        estadoTemporal = this.estadoAlternativo;
        this.estadoAlternativo = this.estadoActual;
        this.estadoActual = estadoTemporal;
    }
	
	public void atacar(int direccionX,int direccionY){
        if (Math.abs(direccionX) > this.estadoActual.distanciaDeAtaque || Math.abs(direccionY) > this.estadoActual.distanciaDeAtaque){
            throw new SobrepasaDistanciaDeAtaqueException();
        }
    }
}
