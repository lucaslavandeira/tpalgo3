package fiuba.algo3.modelo;

/**
 * Created by lucas on 21/06/16.
 */
public class Superion extends AlgoFormer {

    public Superion(Casillero unCasillero) {
        super(unCasillero);
        this.equipo = Equipo.AUTOBOTS;
        this.estadoAlternativo=new EstadoAlternativoTerrestre();
        this.estadoHumanoide= estadoAlternativo; // mismo estado
        this.estadoAlternativo.modificarStatsEstado(100,3,2);
        this.estadoActual=this.estadoHumanoide;
        this.estadoActual.modificarStatsFormer(this);
        this.estadoString = "";
        this.bloqueado = true;
        this.nombre = "Superion";
    }
    public Superion() {
        super();
        this.vida = 0;
        this.equipo = Equipo.AUTOBOTS;
        this.estadoAlternativo=new EstadoAlternativoTerrestre();
        this.estadoHumanoide= estadoAlternativo; // mismo estado
        this.estadoAlternativo.modificarStatsEstado(100,3,2);
        this.estadoActual=this.estadoHumanoide;
        this.estadoActual.modificarStatsFormer(this);
        this.estadoString = "";
        this.nombre = "Superion";
    }
	public void setVida(int VidaDelEquipo) {
		this.vida = VidaDelEquipo;
		
	}
}
