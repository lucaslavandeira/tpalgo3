package fiuba.algo3.ejemplo1;

import java.util.ArrayList;

/**
 * Created by sickness on 30/05/16.
 */
public class Tablero {
    Casillero[][] casilleros;

    public Tablero(int tamanio){
        casilleros = new Casillero[tamanio][tamanio];

        for (int i=0; i < tamanio; i++){
            for (int j=0; j < tamanio; j++){
                casilleros[i][j] = new Casillero(i, j);
            }
        }
    }
    public Casillero buscarCasillero(int xInicial, int yInicial, int direccionX, int direccionY){
        System.out.println(xInicial);
        System.out.println(yInicial);
        System.out.println(direccionX);
        System.out.println(direccionY);
        return (casilleros[xInicial + direccionX][yInicial + direccionY]);

    }

    //Este metodo solo se utiliza para realizar Tests
    public Casillero obtenerCasillero(int posicionX, int posicionY) {
        return (casilleros[posicionX][posicionY]);
    }
}
