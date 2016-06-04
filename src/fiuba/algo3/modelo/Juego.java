package fiuba.algo3.modelo;

/**
 * Created by lucas on 04/06/16.
 */
public class Juego {

    Tablero tablero;
    public Juego(int tamanioTablero) {
        tablero = new Tablero(tamanioTablero);
    }

    public Tablero getTablero() {
        return tablero;
    }
}
