package fiuba.algo3.modelo;

/**
 * Created by usuario on 12/06/2016.
 */
public class Bonus implements  ObjetoDependienteDeTurno{

    private int duracionInmortal=0;
    private int duracionDobleCanion=0;
    private int duracionTriplicaVelocidad=0;

    public void siguienteTurno(){
        if(0<this.duracionInmortal)
            this.duracionInmortal--;

        if(0<this.duracionInmortal)
            this.duracionDobleCanion--;

        if(0<this.duracionInmortal)
            this.duracionTriplicaVelocidad--;
    }


    public Bonus (){

    }

    public int aplicarBonusAtaque(int ataque){
        if (duracionDobleCanion > 0)ataque=ataque*2;
        return ataque;
    }

    public int aplicarBonusVelocidad(int velocidad){
        if(duracionTriplicaVelocidad > 0)velocidad=velocidad*3;
        return velocidad;

    }

    public int aplicarBonusInmortal(int danio){
        if(duracionInmortal > 0)danio=0;
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



}
