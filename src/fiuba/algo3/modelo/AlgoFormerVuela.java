package fiuba.algo3.modelo;
/**
 * Created by Mauro on 08/06/2016.
 */
public abstract class AlgoFormerVuela extends AlgoFormer {

	public AlgoFormerVuela(Casillero unCasillero) {
		super(unCasillero);
		// TODO Auto-generated constructor stub
	}
    public void avanzar(Casillero destino) {

        if (this.velocidad < this.posicion.calcularDistancia(destino)){
            throw new SobrepasaSuVelocidadException();
        }

        if (destino.estaOcupado())
            throw new CasilleroInvalidoException();

        this.posicion.desocupar();
        destino.ocupar();
        this.posicion = destino;
        estado.aplicarEfecto(this.posicion);
    }

}
