package fiuba.algo3.modelo;


/**
 * Created by sickness on 30/05/16.
 */
public abstract class AlgoFormer implements ObjetoDependienteDeTurno{
	
    protected Casillero posicion;
    protected String nombre;
	protected int vida;
    protected int ataque;
    protected int velocidad;
    protected int rangoAtaque;
	protected int movDisponibles;
    protected boolean bloqueado;
	protected boolean pisionico;
	protected String estadoString;
	protected Estado estadoActual;
    protected Estado estadoAlternativo;
    protected Estado estadoHumanoide;
	protected Equipo equipo;
    protected Bonus bonus;


    public AlgoFormer(Casillero unCasillero) {
        this.bonus=new Bonus();
        this.bloqueado=false;

        if(unCasillero.estaOcupado())
            throw new CasilleroInvalidoException();

        this.movDisponibles =100;
        this.posicion = unCasillero;
        this.pisionico=false;

        unCasillero.ocupar();
	}
    public AlgoFormer(){
        this.bonus=new Bonus();
        this.bloqueado=false;
        this.movDisponibles =0;
        this.pisionico=false;
    }


    public void avanzar(Casillero destino) {

        if(this.movDisponibles==0   || this.bloqueado==true){
            throw new BloqueadoException();
        }

        this.posicion.calcularDistancia(destino,bonus.aplicarBonusVelocidad(this.velocidad));

        if (destino.estaOcupado())
            throw new CasilleroInvalidoException();

		this.posicion.desocupar();
        destino.ocupar();
        this.posicion = destino;
        this.estadoActual.modificarStatsFormer(this);
        estadoActual.aplicarEfecto(this,this.posicion.getSuperficie());
        posicion.getEquipamiento().addAlBonus(bonus);

        this.movDisponibles--;
    }

	
    public void atacar(AlgoFormer enemigo) {
        if(this.movDisponibles==0   || this.bloqueado==true){
            throw new BloqueadoException();
        }

        if (this.equipo==enemigo.equipo)
            throw new FuegoAmigoException();

        posicion.calcularDistancia(enemigo.posicion,this.rangoAtaque);
        enemigo.recibirAtaque(bonus.aplicarBonusAtaque(ataque));

        this.movDisponibles--;
    }


    public void siguienteTurno(){
        this.bonus.siguienteTurno();

        if(this.movDisponibles<=0)this.movDisponibles++;
        else if (this.movDisponibles>0)this.movDisponibles=1;

        if(this.bloqueado==true)this.bloqueado=false;
        else this.bloqueado=true;
    }


    public void cambiarEstadoAlternativo(){
    	if(this.movDisponibles==0   || this.bloqueado==true){
            throw new BloqueadoException();
        }

        this.estadoActual=this.estadoAlternativo;
        this.estadoActual.modificarStatsFormer(this);
        this.estadoString = "Alternativo";

        this.movDisponibles--;
    }


    public void cambiarEstadoHumanoide(){
        if(this.movDisponibles==0){
            throw new BloqueadoException();
        }

        this.estadoActual=this.estadoHumanoide;
        this.estadoActual.modificarStatsFormer(this);
        this.estadoString = "Humanoide";

        this.movDisponibles--;
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
        return this.vida;
    }


	public int getVelocidad() {
        return this.velocidad;
    }


	public int getAtaque() {
        return this.ataque;
    }


    public void asignarValoresStats(int ataque, int velocidad, int rangoAtaque) {
        this.ataque=ataque;
        this.velocidad=velocidad;
        this.rangoAtaque=rangoAtaque;
    }


    public void reducirVida(int porcentage){
    	this.vida-= (float)(porcentage*this.vida)/100;
   	}


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


	public String getNombre() {
		return this.nombre;
	}


	public String getEstado() {
		return this.estadoString;
	}
	
	
    public void destruir() {
    	this.vida = 0;
		  this.posicion.desocupar();
		  this.movDisponibles = 0;
	 }

}
