package fiuba.algo3.modelo;

/**
 * Created by Diego on 02/06/2016.
 */
public class DobleCanion extends Bonus {


    public DobleCanion(Casillero unCasillero) {
        super(unCasillero);
    }

    public void setBonus(){
        this.ataqueespecial=2;
        this.escudoInmortal=false;
        this.modificadorVelocidad=0;
        this.durabilidad=3;
    }




}
