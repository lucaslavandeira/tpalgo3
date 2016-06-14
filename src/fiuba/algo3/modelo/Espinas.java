package fiuba.algo3.modelo;

/**
 * Created by Vietnamita on 11/06/2016.
 */
public class Espinas implements Superficie {
	
	public void aplicarEfectoAlternativoTerrestreEn(AlgoFormer former){
		former.reducirVida(5); //porcentage
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
}
