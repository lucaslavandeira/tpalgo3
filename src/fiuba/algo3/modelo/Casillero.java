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
        this.estaOcupado = true;
    }


    public boolean estaOcupado() {
        return this.estaOcupado;
    }


    public void desocupar() {
        this.estaOcupado = false;
    }

    public int calcularDistancia(Casillero otroCasillero) {

        int distanciaX = Math.abs(this.posicionX - otroCasillero.posicionX);
        int distanciaY = Math.abs(this.posicionY - otroCasillero.posicionY);

        if (distanciaX > distanciaY){
            return distanciaX;
        }else{
            return distanciaY;
        }

    }
}
