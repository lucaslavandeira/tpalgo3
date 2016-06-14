package fiuba.algo3.modelo;

/**
 * Created by Vietnamita on 14/06/2016.
 */
public class Flash implements Equipamiento{


    public void addAlBonus(Bonus bonus) {
        bonus.agregarVelocidad();
    }
}
