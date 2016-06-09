package fiuba.algo3.modelo;

/**
 * Created by Diego on 03/06/2016.
 */
public class Bumblebee extends AlgoFormer{


    public Bumblebee(Casillero unCasillero){
        super(unCasillero);
        this.vida = 350;
        this.setEstadoHumanoide();
        this.equipo = Equipo.AUTOBOTS;

    }

    public void setEstadoAlternativo(){
        this.danio=20;
        this.velocidad=5;
        this.rangoAtaque=3;
        this.estaVolando = false;
        this.estado = this.estadoAlternativo;
    }

    public void setEstadoHumanoide(){
        this.danio=40;
        this.velocidad=2;
        this.rangoAtaque=1;
        this.estaVolando = false;
        this.estado = this.estadoHumanoide;
    }
}
