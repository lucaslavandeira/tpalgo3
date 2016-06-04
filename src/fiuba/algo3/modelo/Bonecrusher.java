package fiuba.algo3.modelo;

/**
 * Created by Diego on 03/06/2016.
 */
public class Bonecrusher extends AlgoFormer {

    public Bonecrusher(Casillero unCasillero){
        super(unCasillero);
        this.vida=200;
        this.setEstadoHumanoide();
        equipo = Equipo.DECEPTICONS;
    }

    public void setEstadoAlternativo(){
        this.danio=30;
        this.velocidad=8;
        this.rangoAtaque=3;
        this.estado = Estado.ALTERNATIVO;
        this.estaVolando = false;
    }

    public void setEstadoHumanoide(){
        this.danio=30;
        this.velocidad=1;
        this.rangoAtaque=3;
        this.estado = Estado.HUMANOIDE;
        this.estaVolando = false;
    }



}
