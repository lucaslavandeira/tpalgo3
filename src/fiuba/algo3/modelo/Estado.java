package fiuba.algo3.modelo;

/**
 * Created by Mauro on 08/06/2016.
 */
public interface Estado {
	
	public void aplicarEfecto(AlgoFormer former,Efecto efecto);
	public void modificarStatsFormer(AlgoFormer former);
	public void modificarStatsEstado(int ataque,int velocidad,int rangoAtaque);
	public void reducirDanio(int porcentage);

}
