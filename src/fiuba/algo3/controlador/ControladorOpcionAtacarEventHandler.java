package fiuba.algo3.controlador;

import java.util.ArrayList;
import fiuba.algo3.modelo.AlgoFormer;
import fiuba.algo3.modelo.Casillero;
import fiuba.algo3.vista.VistaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorOpcionAtacarEventHandler implements EventHandler<ActionEvent> {
       private AlgoFormer formerAAtacar;
       private boolean encontrado;
       private ControladorDeMovimientos movimientoActual;
	   private ArrayList formers;
	private VistaJuego vista;
	public ControladorOpcionAtacarEventHandler(ControladorDeMovimientos movimiento, ArrayList listaDeFormers, VistaJuego vista) {
		encontrado = false;  
        this.formers = listaDeFormers;
		movimientoActual = movimiento;
		this.vista=vista;
	}

	private void buscarFormerAAtacar(Casillero casillero, ArrayList listaDeFormers) {
		for (int i =0; i<listaDeFormers.size() || !encontrado;i++) {
           AlgoFormer formerAnterior = (AlgoFormer) listaDeFormers.get(i) ;
           if (formerAnterior.getPosicion() == casillero){
        	   formerAAtacar = formerAnterior;
        	   encontrado = true;
           }
		}	
	}

	@Override
	public void handle(ActionEvent event) {
		buscarFormerAAtacar(movimientoActual.getCasillero(),this.formers);
		if (encontrado){
		movimientoActual.atack(this.formerAAtacar);
		}
		vista.actualizarVistaAlMoverFormer();
	}

}
