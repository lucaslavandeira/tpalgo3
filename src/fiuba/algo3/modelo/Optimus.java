package fiuba.algo3.modelo;


/**
 * Created by Diego on 03/06/2016.
 */
public class Optimus extends AlgoFormer {

    public Optimus(Casillero unCasillero){
        super(unCasillero);
        this.vida=500;
        this.setEstadoHumanoide();
        this.equipo = Equipo.AUTOBOTS;

    }

    public void setEstadoAlternativo(){
        this.danio=15;
        this.velocidad=5;
        this.rangoAtaque=4;
        this.estado = Estado.ALTERNATIVO;
        this.estaVolando = false;
    }

    public void setEstadoHumanoide(){
        this.danio=50;
        this.velocidad=2;
        this.rangoAtaque=2;
        this.estado = Estado.HUMANOIDE;
        this.estaVolando = false;
    }
}
