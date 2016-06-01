package fiuba.algo3.modelo;

/**
 * Created by sickness on 30/05/16.
 */
public class Estado {

    int danioAtaque;
    int distanciaDeAtaque;
    int velocidad;


    public Estado(){
        this.danioAtaque = 1;
        this.distanciaDeAtaque = 1;
        this.velocidad = 1;
    }

    public Estado(int danio, int velocidad, int rango) {
        this.danioAtaque = danio;
        this.velocidad = velocidad;
        this.distanciaDeAtaque = rango;
    }
}
