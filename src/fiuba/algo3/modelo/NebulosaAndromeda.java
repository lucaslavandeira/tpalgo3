package fiuba.algo3.modelo;

/**
 * Created by Vietnamita on 11/06/2016.
 */
public class NebulosaAndromeda implements Efecto{
	
	public void aplicarEfectoAlternativoTerrestreEn(AlgoFormer former){
		throw new ImposibleAtravesarNebulosaAndromedaException();
	}
	
	public void aplicarEfectohumanoideAereoEn(AlgoFormer former){
		former.bloquearTurnos(3); //se pasan el numero de turnos bloqueado
	}
	
	public void aplicarEfectoHumanoideTerrestreEn(AlgoFormer former){
		throw new ImposibleAtravesarNebulosaAndromedaException();
	}
	
	public void aplicarEfectoAlternativoAereoEn(AlgoFormer former){
		former.bloquearTurnos(3);
	}
}
