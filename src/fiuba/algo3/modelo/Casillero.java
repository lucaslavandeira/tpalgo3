package fiuba.algo3.modelo;

/**
 * Created by sickness on 30/05/16.
 */
public class Casillero {
    private boolean estaOcupado;
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
		return tieneChispaSuprema;
	}

    public void ocupar() {
        estaOcupado = true;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public boolean estaOcupado() {
        return estaOcupado;
    }


    public void desocupar() {
        estaOcupado = false;
    }
}
