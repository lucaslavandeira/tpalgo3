package fiuba.algo3.modelo;

/**
 * Created by sickness on 30/05/16.
 */
public class Casillero {
    private boolean estaOcupado;
	private boolean tieneChispaSuprema;
    private int posicionX;
    private int posicionY;
    private Superficie superficie;
    private Equipamiento equipamiento;
	

    public Casillero(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.tieneChispaSuprema = false;
    }

	public void colocarChispaSuprema(){
		this.tieneChispaSuprema = true;
	}

    public void asignarEquipamiento(Equipamiento equipamiento){this.equipamiento = equipamiento;}


    public void ocupar()
    {
        this.estaOcupado = true;
        if(this.tieneChispaSuprema)throw new JugadorGanoException();
    }


    public boolean estaOcupado() {
        return this.estaOcupado;
    }


    public void desocupar() {
        this.estaOcupado = false;
    }
	
	public Superficie getSuperficie(){
		return this.superficie;
	}

    public Equipamiento getEquipamiento(){
        return this.equipamiento;
    }


    public void calcularDistancia(Casillero otroCasillero,int limite) {



        int distanciaX = Math.abs(this.posicionX - otroCasillero.posicionX);
        int distanciaY = Math.abs(this.posicionY - otroCasillero.posicionY);

        if(distanciaX>limite  ||  distanciaY>limite)
            throw new SobrepasaRangosException();

    }


    public void asignarSuperficie(Superficie superficie) {
        this.superficie = superficie;
    }
}
