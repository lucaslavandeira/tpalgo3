package fiuba.algo3.modelo;
/**
 * Created by Mauro on 08/06/2016.
 */
public class EstadoHumanoideTerrestre implements Estado {
	
	private int ataque;
	private int velocidad;
	private int rangoAtaque;
	
	public EstadoHumanoideTerrestre(){
		
	}
	
	public void aplicarEfecto(AlgoFormer former,Superficie superficie){
		superficie.aplicarEfectoHumanoideTerrestreEn(former);
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
