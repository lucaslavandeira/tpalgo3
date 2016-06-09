package fiuba.algo3.modelo;
/**
 * Created by Mauro on 08/06/2016.
 */
public class EstadoHumanoide extends Estado {
	public void aplicarEfecto(Casillero posicion) {
		posicion.efectoTerrestre(this);
	}
}
