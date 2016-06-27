package fiuba.algo3.modelo;



/**
 * Created by Diego on 03/06/2016.
 */
public class Frenzy extends AlgoFormer {

    public Frenzy(Casillero unCasillero){
        super(unCasillero);
        this.nombre = "Frenzy";
        this.vida = 400;
        this.equipo=Equipo.DECEPTICONS;
        this.estadoAlternativo=new EstadoAlternativoTerrestre();
		this.estadoHumanoide=new EstadoHumanoideTerrestre();

        this.estadoAlternativo.modificarStatsEstado(25,6,2);
        this.estadoHumanoide.modificarStatsEstado(10,2,5);
        this.estadoActual=this.estadoHumanoide;
        this.estadoActual.modificarStatsFormer(this);
        this.estadoString = "Humanoide";
    }
    
    
	public String getNombre() {	
		return nombre;
	}

}
