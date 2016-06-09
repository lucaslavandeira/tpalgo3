package fiuba.algo3.modelo;


/**
 * Created by Diego on 03/06/2016.
 */
public class Ratchet extends AlgoFormer{

    public Ratchet(Casillero unCasillero){
        super(unCasillero);
        this.vida=150;
        this.setEstadoHumanoide();
        this.equipo = Equipo.AUTOBOTS;

    }

    public void setEstadoAlternativo(){
        this.danio=35;
        this.velocidad=8;
        this.rangoAtaque=2;
        this.estado = this.estadoAlternativoVuela;
        this.estaVolando = true;
    }

    public void setEstadoHumanoide(){
        this.danio=5;
        this.velocidad=1;
        this.rangoAtaque=5;
        this.estado = this.estadoHumanoide;
        this.estaVolando = false;
    }
}

