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

        if(0<this.duracionDobleCanion)
            this.duracionDobleCanion--;

        if(0<this.duracionTriplicaVelocidad)
            this.duracionTriplicaVelocidad--;
    }


    public Bonus (){

    }
    public boolean tengoBonusInmortal(){
    	return (this.duracionInmortal>0); 
    }
    public boolean tengoDobleCanion(){
    	return (this.duracionDobleCanion>0); 
    }
    public boolean tengoTriplicaVelocidad(){
    	return (this.duracionTriplicaVelocidad>0); 
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
    	//Al pasar turno descuenta por lo tanto tengo agregarlo 3 veces para que por lo menos lo use 1 turno
        this.duracionDobleCanion+=3;
    }

    public void agregarInmortalidad(){
        this.duracionInmortal+=3;
    }

    public void agregarVelocidad(){
        this.duracionTriplicaVelocidad+=3;
    }



}
