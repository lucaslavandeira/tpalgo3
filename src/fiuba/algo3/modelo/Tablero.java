package fiuba.algo3.modelo;

import java.util.Random;

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
                this.casilleros[i][j].asignarSuperficie(this.superficieAleatoria());
                this.casilleros[i][j].asignarEquipamiento(new SinEquipamiento());
            }
        }

        this.tamanio = tamanio;
    }


    private Superficie superficieAleatoria() {
		Random random= new Random();
		int superficieAleatoria = (int)(random.nextDouble() * 6 + 1);

		switch (superficieAleatoria){
		    case 1:  return new Roca();
		    case 2:  return new Pantano();
		    case 3:  return new Espinas();
		    case 4:  return new Nube();
		    case 5:  return new NebulosaAndromeda();
		    default: return new TormentaPsionica();
		}
	}

	public Casillero obtenerCasillero(int posicionX, int posicionY) {
        if(posicionX < 0 || posicionY < 0 || posicionX >= this.tamanio || posicionY >= this.tamanio) {
            throw new CasilleroInvalidoException();
        }

        return (this.casilleros[posicionX][posicionY]);
    }


    public Casillero obtenerCentroDeTablero(){
    	return this.casilleros[this.tamanio/2][this.tamanio/2];
    }
}
