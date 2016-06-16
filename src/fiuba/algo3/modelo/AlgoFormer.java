package fiuba.algo3.modelo;


/**
 * Created by sickness on 30/05/16.
 */
public abstract class AlgoFormer implements ObjetoDependienteDeTurno{
	
    protected Casillero posicion;
	protected int vida;
    protected int ataque;
    protected int velocidad;
    protected int rangoAtaque;
	protected int movDisponibles;
	protected boolean pisionico;
	
	protected Estado estadoActual;
    protected Estado estadoAlternativo;
    protected Estado estadoHumanoide;
	protected Equipo equipo;

    protected Bonus bonus;


    public AlgoFormer(Casillero unCasillero) {
        this.bonus=new Bonus();
        if(unCasillero.estaOcupado())
            throw new CasilleroInvalidoException();
        this.movDisponibles =1;
        this.posicion = unCasillero;
        this.pisionico=false;
        unCasillero.ocupar();
		
	}



    public void avanzar(Casillero destino) {

        if(this.movDisponibles <=0)throw new BloqueadoException();
        this.posicion.calcularDistancia(destino,bonus.aplicarBonusVelocidad(this.velocidad));
        if (destino.estaOcupado())
            throw new CasilleroInvalidoException();

		this.posicion.desocupar();
        destino.ocupar();
        this.posicion = destino;
        estadoActual.aplicarEfecto(this,this.posicion.getSuperficie());
        posicion.getEquipamiento().addAlBonus(bonus);
    }

	
    public void atacar(AlgoFormer enemigo) {
        if(this.movDisponibles <=0)throw new BloqueadoException();
        if (this.equipo==enemigo.equipo)
            throw new FuegoAmigoException();
        posicion.calcularDistancia(enemigo.posicion,this.rangoAtaque);
        enemigo.recibirAtaque(bonus.aplicarBonusAtaque(ataque));
    }

    public void siguienteTurno(){
        this.bonus.siguienteTurno();
        if(0<this.movDisponibles) this.movDisponibles--;
    }
	
    public void cambiarEstadoAlternativo(){
        this.estadoActual=this.estadoAlternativo;
        this.estadoActual.modificarStatsFormer(this);
    }
	
    public void cambiarEstadoHumanoide(){
        this.estadoActual=this.estadoHumanoide;
        this.estadoActual.modificarStatsFormer(this);
    }

   
    public boolean estaMuerto() {
        return this.vida<=0;
    }


    public void recibirAtaque(int danio) {
        this.vida -=( bonus.aplicarBonusInmortal(danio));
    }

	public Equipo getEquipo() {
        return this.equipo;
    }
	
	public int getVida() {
        return vida;
    }

    public void asignarValoresStats(int ataque, int velocidad, int rangoAtaque) {

        this.ataque=ataque;
        this.velocidad=velocidad;
        this.rangoAtaque=rangoAtaque;

    }


    public void reducirVida(int porcentage){this.vida-= (float)(porcentage*this.vida)/100;}

    public void bloquearTurnos(int cantidad) {
        this.movDisponibles -=cantidad;
    }

    public void reducirVelocidad(int porcentage) {
        this.velocidad-=this.velocidad*porcentage/100;
    }

    public void activarEstadoPisionico() {
        this.pisionico=true;
    }

    public void reducirAtaqueDeEstadoAlterno(int porcentage) {
        estadoAlternativo.reducirDanio(porcentage);
        estadoActual.modificarStatsFormer(this);
    }

    public boolean estaPisionico() {
        return this.pisionico;
    }

    public Casillero getPosicion() {
        return this.posicion;
    }


    public int getMovDisponibles() {
        return this.movDisponibles;
    }

    public Bonus getBonus() {
        return this.bonus;
    }
}
