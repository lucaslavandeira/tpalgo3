package fiuba.algo3.modelo;


/**
 * Created by Diego on 03/06/2016.
 */
public class Optimus extends AlgoFormer {
 private String nombre = "Optimus";
    public Optimus(Casillero unCasillero){
        super(unCasillero);
        this.vida=500;
        this.equipo = Equipo.AUTOBOTS;
		this.estadoAlternativo=new EstadoAlternativoTerrestre();
		this.estadoHumanoide=new EstadoHumanoideTerrestre();

        this.estadoAlternativo.modificarStatsEstado(15,5,4);
        this.estadoHumanoide.modificarStatsEstado(50,2,2);
        this.estadoActual=this.estadoHumanoide;
        this.estadoActual.modificarStatsFormer(this);

    }
	public String getNombre() {
		
		return nombre;
	}

}
