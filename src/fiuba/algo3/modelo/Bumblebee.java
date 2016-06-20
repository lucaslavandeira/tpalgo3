package fiuba.algo3.modelo;

/**
 * Created by Diego on 03/06/2016.
 */
public class Bumblebee extends AlgoFormer{
	 private String nombre = "Bumblebee";

    public Bumblebee(Casillero unCasillero){
        super(unCasillero);
        this.vida = 350;
        this.equipo = Equipo.AUTOBOTS;
		this.estadoAlternativo=new EstadoAlternativoTerrestre();
		this.estadoHumanoide=new EstadoHumanoideTerrestre();

        this.estadoAlternativo.modificarStatsEstado(20,5,3);
        this.estadoHumanoide.modificarStatsEstado(40,2,1);
        this.estadoActual=this.estadoHumanoide;
        this.estadoActual.modificarStatsFormer(this);
        this.estadoString = "Humanoide";
    }
	public String getNombre() {
		return nombre;
	}

}
