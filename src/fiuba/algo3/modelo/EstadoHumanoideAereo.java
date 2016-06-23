package fiuba.algo3.modelo;

/**
 * Created by Vietnamita on 11/06/2016.
 */
public class EstadoHumanoideAereo implements Estado{
	
	private int ataque;
	private int velocidad;
	private int rangoAtaque;
	
	public EstadoHumanoideAereo(){
		
	}
	
	public void aplicarEfecto(AlgoFormer former,Superficie superficie){
		superficie.aplicarEfectohumanoideAereoEn(former);
	}
	
	public void modificarStatsFormer(AlgoFormer former){
		former.asignarValoresStats(this.ataque,this.velocidad,this.rangoAtaque);
	}
	
	public void modificarStatsEstado(int ataque,int velocidad,int rangoAtaque){
		this.ataque=ataque;
		this.velocidad=velocidad;
		this.rangoAtaque=rangoAtaque;
	}

	public void reducirDanio(int porcentage){
		this.ataque-=this.ataque*porcentage/100;
	}
	
	
}
