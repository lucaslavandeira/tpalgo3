package fiuba.algo3.modelo;

/**
 * Created by Vietnamita on 11/06/2016.
 */
public class TormentaPsionica implements Efecto{
	
	public void aplicarEfectoAlternativoTerrestreEn(AlgoFormer former){
		throw new ImposibleAtravesarTormentaPsionicaException();
	}
	
	public void aplicarEfectohumanoideAereoEn(AlgoFormer former){
		if(!(former.estaPisionico())){
		former.reducirAtaqueDeEstadoAlterno(40);//porcentage  //se puede cambiar par ano usar if mandar msj directo al former
		former.activarEstadoPisionico();}
	}
	
	public void aplicarEfectoHumanoideTerrestreEn(AlgoFormer former){
		throw new ImposibleAtravesarTormentaPsionicaException();
	}
	
	public void aplicarEfectoAlternativoAereoEn(AlgoFormer former){
		if(!(former.estaPisionico())){
		former.reducirAtaqueDeEstadoAlterno(40);//porcentage
		former.activarEstadoPisionico();}
	}
}
