package fiuba.algo3.modelo;

public class ChispaSuprema implements UnidadJuego{
	public ChispaSuprema(Casillero unCasillero){
		unCasillero.colocarEnte(this);
	}
    public boolean esAlgoFormer() {
        return false;
    }

    public boolean esChispaSuprema() {
        return true;
    }

}
