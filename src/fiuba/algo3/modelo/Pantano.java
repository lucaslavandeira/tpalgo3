package fiuba.algo3.modelo;

/**
 * Created by Vietnamita on 11/06/2016.
 */
public class Pantano implements Superficie {
	private SuperficiesEnum superficie ;
	public void aplicarEfectoAlternativoTerrestreEn(AlgoFormer former){
		former.reducirVelocidad(50);		//pasa porcentage
	}
	
	public void aplicarEfectohumanoideAereoEn(AlgoFormer former){
		
	}
	
	public void aplicarEfectoHumanoideTerrestreEn(AlgoFormer former){
		
	}
	
	public void aplicarEfectoAlternativoAereoEn(AlgoFormer former){
		
	}
	public SuperficiesEnum getSuperficie() {
		return superficie.PANTANO;
	}
}
