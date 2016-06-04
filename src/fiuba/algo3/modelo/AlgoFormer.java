package fiuba.algo3.modelo;


/**
 * Created by sickness on 30/05/16.
 */
public abstract class AlgoFormer {
    Estado estadoActual;
    Estado estadoAlternativo;
    Casillero posicion;

	int vida;

    int danio;
    int velocidad;
    int rangoAtaque;

    public Casillero getPosicion() {
        return posicion;
    }

    public Equipo getEquipo() {
        return equipo;
    }


    Estado estado;
    Equipo equipo;
    boolean estaVolando;


    // constructor simple usado en tests
    public AlgoFormer(Casillero unCasillero) {
        if(unCasillero.estaOcupado())
            throw new CasilleroInvalidoException();

        this.posicion = unCasillero;
        unCasillero.colocarRobot(this);
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

        destino.colocarRobot(this);
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

        int distanciaX = Math.abs(posicion.posicionX - enemigo.getPosicion().getPosicionX());
        int distanciaY = Math.abs(posicion.posicionY - enemigo.getPosicion().getPosicionY());

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
