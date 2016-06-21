package fiuba.algo3.modelo;

/**
 * Created by Vietnamita on 11/06/2016.
 */
public class Nube implements Superficie {
	private SuperficiesEnum superficie ;
	public void aplicarEfectoAlternativoTerrestreEn(AlgoFormer former){
		//throw new UnidadTerrestreNoAtraviesaNubeException();
	}
	
	public void aplicarEfectohumanoideAereoEn(AlgoFormer former){
		//throw new UnidadAereaDebeEstarEnModoAlternoException();
	}
	
	public void aplicarEfectoHumanoideTerrestreEn(AlgoFormer former){
		//throw new UnidadTerrestreNoAtraviesaNubeException();
	}
	
	public void aplicarEfectoAlternativoAereoEn(AlgoFormer former){
		
	}

	public SuperficiesEnum getSuperficie() {
		return superficie.NUBE;
	}


	
}
