package fiuba.algo3.modelo;

/**
 * Created by Vietnamita on 11/06/2016.
 */
public class Espinas implements Superficie {
	private SuperficiesEnum superficie;
	public void aplicarEfectoAlternativoTerrestreEn(AlgoFormer former){
		former.reducirVida(5); //porcentaje
	}
	
	public void aplicarEfectohumanoideAereoEn(AlgoFormer former){
		former.reducirVida(5);
	}
	
	public void aplicarEfectoHumanoideTerrestreEn(AlgoFormer former){
		former.reducirVida(5);
	}
	
	public void aplicarEfectoAlternativoAereoEn(AlgoFormer former){
		former.reducirVida(5);
	}
	public SuperficiesEnum getSuperficie() {
		return superficie.ESPINAS;
	}
}
