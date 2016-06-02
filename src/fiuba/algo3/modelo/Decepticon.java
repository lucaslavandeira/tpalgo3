package fiuba.algo3.modelo;

/**
 * Created by Diego on 01/06/2016.
 */
public class Decepticon extends AlgoFormer {

    public Decepticon(Casillero unCasillero, Estado estadoInicial, Estado estadoAlternativo, int vida) {
        super(unCasillero, estadoInicial, estadoAlternativo, vida);
    }

    public boolean esAutobot(){

        return false;
    }

    public boolean esDecepticon(){

        return true;
    }

}
