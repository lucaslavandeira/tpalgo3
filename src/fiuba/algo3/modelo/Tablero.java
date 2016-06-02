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
                casilleros[i][j] = new Casillero(i, j, this);
            }
        }

        this.tamanio = tamanio;
    }
    public Casillero buscarCasillero(int xInicial, int yInicial, int direccionX, int direccionY){
        if  (xInicial + direccionX >= tamanio || yInicial + direccionY >= tamanio
                                    || xInicial+direccionX < 0 ||  yInicial+direccionY <0)
            throw new PosicionFueraDelMapaException();

        return casilleros[xInicial + direccionX][yInicial + direccionY];
    }

    //Este metodo solo se utiliza para realizar Tests
    public Casillero obtenerCasillero(int posicionX, int posicionY) {
        return (casilleros[posicionX][posicionY]);
    }
}
