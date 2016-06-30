package fiuba.algo3.modelo;

/**
 * Created by lucas on 21/06/16.
 */
public class Menasor extends AlgoFormer {

    public Menasor(Casillero unCasillero) {
        super(unCasillero);
        this.equipo = Equipo.DECEPTICONS;
        this.estadoAlternativo=new EstadoAlternativoTerrestre();
        this.estadoHumanoide= estadoAlternativo; // mismo estado

        this.estadoAlternativo.modificarStatsEstado(115,2,2);
        this.estadoActual=this.estadoHumanoide;
        this.estadoActual.modificarStatsFormer(this);
        this.estadoString = "";
        this.bloqueado = true;
        this.nombre = "Menasor";
    }
    public Menasor() {
    	super();
        this.vida = 0;
        this.equipo = Equipo.DECEPTICONS;
        this.estadoAlternativo=new EstadoAlternativoTerrestre();
        this.estadoHumanoide= estadoAlternativo; // mismo estado
        this.estadoAlternativo.modificarStatsEstado(115,2,2);
        this.estadoActual=this.estadoHumanoide;
        this.estadoActual.modificarStatsFormer(this);
        this.estadoString = "";
        this.nombre = "Menasor";
    }
	public void setVida(int VidaDelEquipo) {
		this.vida = VidaDelEquipo;
		
	}
}

