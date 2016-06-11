package fiuba.algo3.modelo;

/**
 * Created by Vietnamita on 11/06/2016.
 */
public interface Efecto {
	
	public void aplicarEfectoAlternativoTerrestreEn(AlgoFormer former);
	public void aplicarEfectohumanoideAereoEn(AlgoFormer former);
	public void aplicarEfectoHumanoideTerrestreEn(AlgoFormer former);
	public void aplicarEfectoAlternativoAereoEn(AlgoFormer former);
}
