package fiuba.algo3.modelo;

/**
 * Created by Diego on 03/06/2016.
 */
public class Megatron extends AlgoFormer {

    public Megatron(Casillero unCasillero){
        super(unCasillero);
        this.nombre = "Megatron";
        this.vida=550;
        this.equipo=Equipo.DECEPTICONS;
        this.estadoAlternativo=new EstadoAlternativoAereo();
		this.estadoHumanoide=new EstadoHumanoideAereo();

        this.estadoAlternativo.modificarStatsEstado(55,8,2);
        this.estadoHumanoide.modificarStatsEstado(10,1,3);
        this.estadoActual=this.estadoHumanoide;
        this.estadoActual.modificarStatsFormer(this);
        this.estadoString = "Humanoide";
    }
    
    
	public String getNombre() {
		return nombre;
	}

}
