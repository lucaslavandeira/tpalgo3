package fiuba.algo3.modelo;

/**
 * Created by sickness on 30/05/16.
 */
public class Casillero {
    private AlgoFormer ocupante;
    private int posicionX;
    private int posicionY;
    private boolean tieneChispaSuprema;

    public Casillero(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.tieneChispaSuprema = false;
    }

	public void colocarChispaSuprema(){
		tieneChispaSuprema = true;
	}
	public boolean tieneChispaSuprema(){
		return this.tieneChispaSuprema;
	}
    public void colocarRobot(AlgoFormer algoFormer) {
        ocupante = algoFormer;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public boolean estaOcupado() {
        return (ocupante != null);
    }


}
