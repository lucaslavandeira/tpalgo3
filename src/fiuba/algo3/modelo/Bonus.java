package fiuba.algo3.modelo;

/**
 * Created by Diego on 02/06/2016.
 */
public class Bonus implements UnidadJuego{

    int ataqueespecial;
    boolean escudoInmortal;
    int modificadorVelocidad;
    int durabilidad;


    public Bonus(Casillero unCasillero){
        super();
        this.setBonus();
        unCasillero.colocarEnte(this);
    }

    public void setBonus(){
        this.ataqueespecial=0;
        this.escudoInmortal=false;
        this.modificadorVelocidad=0;
        this.durabilidad=0;

    }

    public boolean esAlgoFormer() {
        return false;
    }
    public boolean esChispaSuprema() {
        return false;
    }
    public boolean esBonus(){return true;}
    public boolean esAutobot(){return false;}
    public boolean esDesepticon(){return false;}

    public int ataqueAdicional(){
        return this.ataqueespecial;
    }

}
