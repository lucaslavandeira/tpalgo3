package fiuba.algo3.modelo;
/**
 * Created by Mauro on 08/06/2016.
 */
public class EstadoAlternativoVuela extends EstadoAlternativo{
	public void aplicarEfecto(Casillero posicion) {
		posicion.efectoAereo(this);
	}

}
