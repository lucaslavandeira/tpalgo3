package fiuba.algo3.modelo;

/**
 * Created by usuario on 13/06/2016.
 */
public class DobleCanion implements Arma {

    public DobleCanion(){

    }

    public void añadirAlBonus(Bonus bonus){
        bonus.agregarDobleCanion();

    }
}
