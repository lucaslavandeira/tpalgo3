package fiuba.algo3.modelo;

/**
 * Created by Vietnamita on 11/06/2016.
 */
public class TormentaPsionica implements Superficie {
	private SuperficiesEnum superficie ;
	public void aplicarEfectoAlternativoTerrestreEn(AlgoFormer former){
		
	}
	
	public void aplicarEfectohumanoideAereoEn(AlgoFormer former){
		if(!(former.estaPisionico())){
		former.reducirAtaqueDeEstadoAlterno(40);//porcentaje  //se puede cambiar par ano usar if mandar msj directo al former
		former.activarEstadoPisionico();}
	}
	
	public void aplicarEfectoHumanoideTerrestreEn(AlgoFormer former){
		
	}
	
	public void aplicarEfectoAlternativoAereoEn(AlgoFormer former){
		if(!(former.estaPisionico())){
		former.reducirAtaqueDeEstadoAlterno(40);//porcentaje
		former.activarEstadoPisionico();}
	}
	public SuperficiesEnum getSuperficie() {
		return superficie.TORMENTAPSIONICA;
	}
}
