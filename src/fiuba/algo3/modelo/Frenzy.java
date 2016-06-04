package fiuba.algo3.modelo;



/**
 * Created by Diego on 03/06/2016.
 */
public class Frenzy extends AlgoFormer {

    public Frenzy(Casillero unCasillero){
        super(unCasillero);
        this.vida = 400;
        this.setEstadoHumanoide();
        equipo = Equipo.DECEPTICONS;

    }

    public void setEstadoAlternativo(){
        this.danio=25;
        this.velocidad=6;
        this.rangoAtaque=2;
        this.estado = Estado.ALTERNATIVO;
        this.estaVolando = false;
    }

    public void setEstadoHumanoide(){
        this.danio=10;
        this.velocidad=2;
        this.rangoAtaque=5;
        this.estado = Estado.HUMANOIDE;
        this.estaVolando = false;
    }
}
