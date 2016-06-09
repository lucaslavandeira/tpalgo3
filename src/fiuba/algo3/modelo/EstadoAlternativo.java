package fiuba.algo3.modelo;
/**
 * Created by Mauro on 08/06/2016.
 */
public class EstadoAlternativo extends Estado {
	public void aplicarEfectoDelCasillero(Casillero posicion) {
		posicion.efectoTerrestre(this);
	}
}
