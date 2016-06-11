package fiuba.algo3.modelo;


/**
 * Created by Diego on 03/06/2016.
 */
public class Ratchet extends AlgoFormer{

    public Ratchet(Casillero unCasillero){
        super(unCasillero);
        this.vida=150;
        this.equipo = Equipo.AUTOBOTS;
		this.estadoAlternativo=new EstadoAlternativoAereo();
		this.estadoHumanoide=new EstadoHumanoideAereo();

        this.estadoAlternativo.modificarStatsEstado(35,8,2);
        this.estadoHumanoide.modificarStatsEstado(5,1,5);
        this.estadoActual=this.estadoHumanoide;
        this.estadoActual.modificarStatsFormer(this);

    }


}

