package fiuba.algo3.modelo;

/**
 * Created by Diego on 01/06/2016.
 */
public class AlgoFormerDesepticon extends AlgoFormer {

    public AlgoFormerDesepticon(Casillero unCasillero, Estado estadoInicial, Estado estadoAlternativo, int vida) {
        super(unCasillero, estadoInicial, estadoAlternativo, vida);
    }

    public boolean esAutobot(){

        return false;
    }

    public boolean esDesepticon(){

        return true;
    }

}
