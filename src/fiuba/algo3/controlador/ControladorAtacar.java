package fiuba.algo3.controlador;

import java.util.ArrayList;
import fiuba.algo3.modelo.AlgoFormer;
import fiuba.algo3.modelo.Casillero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorAtacar implements EventHandler<ActionEvent> {
       private AlgoFormer formerAAtacar;
       private boolean encontrado;
       private ControladorDeMovimientos movimientoActual;
	   private ArrayList formers;
	public ControladorAtacar(ControladorDeMovimientos movimiento, ArrayList listaDeFormers) {
		encontrado = false;  
        this.formers = listaDeFormers;
		movimientoActual = movimiento;
	}

	private void buscarFormerAAtacar(Casillero casillero, ArrayList listaDeFormers) {
		for (int i =0; i<listaDeFormers.size() || encontrado == false;i++) {
           AlgoFormer formerAnterior = (AlgoFormer) listaDeFormers.get(i) ;
           if ((formerAnterior.getPosicion().getX() == casillero.getX()) && (formerAnterior.getPosicion().getY() == casillero.getY())){
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
	}

}
