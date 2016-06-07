package fiuba.algo3.modelo;


/**
 * Created by sickness on 30/05/16.
 */
public class Tablero {
    private Casillero[][] casilleros;
    private int tamanio;

    public Tablero(int tamanio){
        this.casilleros = new Casillero[tamanio][tamanio];

        for (int i=0; i < tamanio; i++){
            for (int j=0; j < tamanio; j++) {
                this.casilleros[i][j] = new Casillero(i, j);
            }
        }

        this.tamanio = tamanio;
    }

    public Casillero obtenerCasillero(int posicionX, int posicionY) {
        if(posicionX < 0 || posicionY < 0 || posicionX >= this.tamanio || posicionY >= this.tamanio) {
            throw new CasilleroInvalidoException();
        }

        return (this.casilleros[posicionX][posicionY]);
    }
}
