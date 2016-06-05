package fiuba.algo3.modelo;


/**
 * Created by sickness on 30/05/16.
 */
public abstract class AlgoFormer {
    private Casillero posicion;
	protected int vida;
    protected int danio;
    protected int velocidad;
    protected int rangoAtaque;
    protected Estado estado;
    protected Equipo equipo;
    protected boolean estaVolando;
    
    public Casillero getPosicion() {
        return posicion;
    }

    public Equipo getEquipo() {
        return equipo;
    }





    // constructor simple usado en tests
    public AlgoFormer(Casillero unCasillero) {
        if(unCasillero.estaOcupado())
            throw new CasilleroInvalidoException();

        this.posicion = unCasillero;
        unCasillero.ocupar();

        this.vida = 500;
    }

    public void avanzar(Casillero destino) {
        int destinoPosicionX = destino.getPosicionX();
        int destinoPosicionY = destino.getPosicionY();


        if (Math.abs(posicion.getPosicionX() - destinoPosicionX) > this.velocidad || Math.abs(posicion.getPosicionY() - destinoPosicionY) > this.velocidad) {
            throw new SobrepasaSuVelocidadException();
        }

        if (destino.estaOcupado())
            throw new CasilleroInvalidoException();

        posicion.desocupar();
        destino.ocupar();
        this.posicion = destino;
    }

    public void cambiarEstado(){
        if(estado == Estado.HUMANOIDE) {
            setEstadoAlternativo();
        } else {
            setEstadoHumanoide();
        }
    }


    public void atacar(AlgoFormer enemigo) {
        if (equipo == enemigo.getEquipo())
            throw new FuegoAmigoException();

        int distanciaX = Math.abs(posicion.getPosicionX() - enemigo.getPosicion().getPosicionX());
        int distanciaY = Math.abs(posicion.getPosicionY() - enemigo.getPosicion().getPosicionY());

        if (distanciaX > rangoAtaque || distanciaY > rangoAtaque)
            throw new SobrepasaDistanciaDeAtaqueException();

        enemigo.recibirAtaque(danio);
    }


    public void recibirAtaque(int danio) {
        this.vida -= danio;

    }

    public Estado getEstado() {
        return estado;
    };

    public abstract void setEstadoHumanoide();
    public abstract void setEstadoAlternativo();


    public int getVida() {
        return vida;
    }
}
