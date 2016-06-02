package fiuba.algo3.modelo;

/**
 * Created by Diego on 01/06/2016.
 */
public class Autobot extends AlgoFormer {

    public Autobot(Casillero unCasillero, Estado estadoInicial, Estado estadoAlternativo, int vida) {
        super(unCasillero, estadoInicial, estadoAlternativo, vida);
    }

    public boolean esAutobot(){

        return true;
    }

    public boolean esDecepticon(){

        return false;
    }

}
