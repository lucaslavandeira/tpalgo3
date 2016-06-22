package fiuba.algo3.modelo;

/**
 * Created by lucas on 21/06/16.
 */
public class Menasor extends AlgoFormer {

    public Menasor(Casillero unCasillero) {
        super(unCasillero);
        this.vida = 1000;
        this.equipo = Equipo.DECEPTICONS;
        this.estadoAlternativo=new EstadoAlternativoTerrestre();
        this.estadoHumanoide= estadoAlternativo; // mismo estado

        this.estadoAlternativo.modificarStatsEstado(115,2,2);
        this.estadoActual=this.estadoHumanoide;
        this.estadoActual.modificarStatsFormer(this);
        this.estadoString = "Humanoide";
    }
}

