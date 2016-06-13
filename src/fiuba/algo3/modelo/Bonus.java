package fiuba.algo3.modelo;

/**
 * Created by usuario on 12/06/2016.
 */
public class Bonus {

    private int duracionInmortal=0;
    private int duracionDobleCanion=0;
    private int duracionTriplicaVelocidad=0;

    public Bonus (){

    }

    public int aplicarBonusAtaque(int ataque){
        if (0<duracionDobleCanion)ataque=ataque*2;
        return ataque;
    }

    public int aplicarBonusVelocidad(int velocidad){
        if(0<duracionTriplicaVelocidad)velocidad=velocidad*3;
        return velocidad;

    }

    public int aplicarBonusInmortal(int danio){
        if(0<duracionInmortal)danio=0;
        return danio;
    }

    public void agregarDobleCanion(){
        this.duracionDobleCanion++;
    }

    public void agregarInmortalidad(){
        this.duracionInmortal++;
    }

    public void agregarVelocidad(){
        this.duracionTriplicaVelocidad++;
    }

    public void quitarDuracionDeUnTurno(){
        if(0<this.duracionInmortal)
        this.duracionInmortal--;

        if(0<this.duracionInmortal)
        this.duracionDobleCanion--;

        if(0<this.duracionInmortal)
        this.duracionTriplicaVelocidad--;
    }

}
