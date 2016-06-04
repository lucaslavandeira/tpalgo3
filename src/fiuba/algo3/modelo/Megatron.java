package fiuba.algo3.modelo;

/**
 * Created by Diego on 03/06/2016.
 */
public class Megatron extends AlgoFormer {

    public Megatron(Casillero unCasillero){
        super(unCasillero);
        this.vida=550;
        this.setEstadoHumanoide();
        equipo = Equipo.DECEPTICONS;

    }

    public void setEstadoAlternativo(){
        this.danio=55;
        this.velocidad=8;
        this.rangoAtaque=2;
        this.estado = Estado.ALTERNATIVO;
        this.estaVolando = true;
    }

    public void setEstadoHumanoide(){
        this.danio=10;
        this.velocidad=1;
        this.rangoAtaque=3;
        this.estado = Estado.HUMANOIDE;
        this.estaVolando = false;
    }
}
