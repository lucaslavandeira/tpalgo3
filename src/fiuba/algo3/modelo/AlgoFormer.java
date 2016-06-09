package fiuba.algo3.modelo;


/**
 * Created by sickness on 30/05/16.
 */
public abstract class AlgoFormer {
    protected Casillero posicion;
	protected int vida;
    protected int danio;
    protected int velocidad;
    protected int rangoAtaque;
    protected Estado estado = new Estado();
    protected EstadoHumanoide estadoHumanoide = new EstadoHumanoide();
    protected EstadoAlternativo estadoAlternativo = new EstadoAlternativo();
    protected EstadoAlternativoVuela estadoAlternativoVuela;
    protected Equipo equipo;
    protected boolean estaVolando;


    public Casillero getPosicion() {
        return this.posicion;
    }


    public Equipo getEquipo() {
        return this.equipo;
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

        if (this.velocidad < this.posicion.calcularDistancia(destino)){
            throw new SobrepasaSuVelocidadException();
        }

        if (destino.estaOcupado())
            throw new CasilleroInvalidoException();

        this.posicion.desocupar();
        destino.ocupar();
        this.posicion = destino;
        estado.aplicarEfecto(this.posicion);
    }


    public void cambiarEstadoAlternativo(){
        setEstadoAlternativo();
    }
    public void cambiarEstadoHumanoide(){
    	setEstadoHumanoide();
    }

    public void atacar(AlgoFormer enemigo) {
        if (equipo == enemigo.getEquipo())
            throw new FuegoAmigoException();

        if (posicion.calcularDistancia(enemigo.posicion) > this.rangoAtaque)
            throw new SobrepasaDistanciaDeAtaqueException();

        enemigo.recibirAtaque(danio);
    }


    public void recibirAtaque(int danio) {
        this.vida -= danio;

    }




    public abstract void setEstadoHumanoide();
    public abstract void setEstadoAlternativo();


    public int getVida() {
        return vida;
    }
}
