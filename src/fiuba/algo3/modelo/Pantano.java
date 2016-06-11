package fiuba.algo3.modelo;

/**
 * Created by Vietnamita on 11/06/2016.
 */
public class Pantano implements Efecto{
	
	public void aplicarEfectoAlternativoTerrestreEn(AlgoFormer former){
		former.reducirVelocidad(50);		//pasa porcentage
	}
	
	public void aplicarEfectohumanoideAereoEn(AlgoFormer former){
		throw new ImposibleAtravesarPantanoException();
	}
	
	public void aplicarEfectoHumanoideTerrestreEn(AlgoFormer former){
		throw new ImposibleAtravesarPantanoException();
	}
	
	public void aplicarEfectoAlternativoAereoEn(AlgoFormer former){
		
	}
}
