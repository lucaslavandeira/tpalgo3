package fiuba.algo3.modelo;

/**
 * Created by sickness on 30/05/16.
 */
public class Estado {
    int velocidad;
    int vida;
    int distanciaDeAtaque;

    public Estado(){
        this.velocidad = 1;
        this.vida = 1;
        this.distanciaDeAtaque = 1;
    }

    public Estado(int velocidad, int vida, int dist_ataque) {
        this.velocidad = velocidad;
        this.vida = vida;
        this.distanciaDeAtaque = dist_ataque;
    }
}
