package fiuba.algo3.modelo;

/**
 * Created by Diego on 03/06/2016.
 */
public class Bonecrusher extends AlgoFormer {	
	
    public Bonecrusher(Casillero unCasillero){
        super(unCasillero);
        this.nombre = "Bonecrusher";
        this.vida=200;
		this.equipo=Equipo.DECEPTICONS;
        this.estadoAlternativo=new EstadoAlternativoTerrestre();
		this.estadoHumanoide=new EstadoHumanoideTerrestre();

        this.estadoAlternativo.modificarStatsEstado(30,8,3);
        this.estadoHumanoide.modificarStatsEstado(30,1,3);
        this.estadoActual=this.estadoHumanoide;
        this.estadoActual.modificarStatsFormer(this);
        this.estadoString = "Humanoide";
    }
    
    
	public String getNombre() {
		return nombre;
	}

}
