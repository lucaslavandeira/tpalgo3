package fiuba.algo3.modelo;


/**
 * Created by sickness on 30/05/16.
 */
public class Tablero {
    Casillero[][] casilleros;
    int tamanio;

    public Tablero(int tamanio){
        casilleros = new Casillero[tamanio][tamanio];

        for (int i=0; i < tamanio; i++){
            for (int j=0; j < tamanio; j++) {
                casilleros[i][j] = new Casillero(i, j);
            }
        }

        this.tamanio = tamanio;
    }

    public Casillero obtenerCasillero(int posicionX, int posicionY) {
        return (casilleros[posicionX][posicionY]);
    }
}
