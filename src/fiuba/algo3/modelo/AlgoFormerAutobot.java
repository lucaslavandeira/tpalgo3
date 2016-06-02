package fiuba.algo3.modelo;

/**
 * Created by Diego on 01/06/2016.
 */
public class AlgoFormerAutobot extends AlgoFormer {

    public AlgoFormerAutobot(Casillero unCasillero, Estado estadoInicial, Estado estadoAlternativo, int vida) {
        super(unCasillero, estadoInicial, estadoAlternativo, vida);
    }

    public boolean esAutobot(){

        return true;
    }

    public boolean esDesepticon(){

        return false;
    }

}
