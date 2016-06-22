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
                this.casilleros[i][j].asignarEquipamiento(this.asignarBonus());
            }
        }

        this.tamanio = tamanio;
    }


    private Equipamiento asignarBonus() {
		Random random= new Random();
		int superficieAleatoria = (int)(random.nextDouble() * 40 + 1);

		switch (superficieAleatoria){
		    case 1:  return new SinEquipamiento();
		    case 2:  return new SinEquipamiento();
		    case 3:  return new SinEquipamiento();
		    case 4:  return new SinEquipamiento();
		    case 5:  return new SinEquipamiento();
		    case 6:  return new SinEquipamiento();
		    case 7:  return new SinEquipamiento();
		    case 8:  return new SinEquipamiento();
		    case 9:  return new Flash();
		    case 10:  return new BurbujaInmaculada();
		    case 11:  return new DobleCanion();
		    default: return new SinEquipamiento();
		}
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
