package fiuba.algo3.modelo;

/**
 * Created by Vietnamita on 11/06/2016.
 */
public class NebulosaAndromeda implements Superficie {
	private SuperficiesEnum superficie ;
	public void aplicarEfectoAlternativoTerrestreEn(AlgoFormer former){
		
	}
	
	public void aplicarEfectohumanoideAereoEn(AlgoFormer former){
		former.bloquearTurnos(3); //se pasan el numero de turnos bloqueado
	}
	
	public void aplicarEfectoHumanoideTerrestreEn(AlgoFormer former){
	    
	}
	
	public void aplicarEfectoAlternativoAereoEn(AlgoFormer former){
		former.bloquearTurnos(3);
	}
	public SuperficiesEnum getSuperficie() {
		return superficie.NEBULOSAANDROMEDA;
	}
}
