package fiuba.algo3.ejemplo1;

/**
 * Created by sickness on 30/05/16.
 */
public class Casillero {
    Tablero elTablero;
    boolean tieneChispa = false;
    int posicionX;
    int posixionY;

    public Casillero(int posicionX, int posicionY, Tablero unTablero) {
        this.posicionX = posicionX;
        this.posixionY = posicionY;
        this.elTablero = unTablero;
    }

    public Casillero buscarCasillero(int direccionX, int direccionY){

        return this.elTablero.buscarCasillero(this.posicionX, this.posixionY, direccionX, direccionY);

    }

}
