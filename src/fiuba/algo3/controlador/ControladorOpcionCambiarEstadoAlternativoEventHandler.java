package fiuba.algo3.controlador;

import fiuba.algo3.modelo.AlgoFormer;
import fiuba.algo3.vista.VistaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorOpcionCambiarEstadoAlternativoEventHandler implements EventHandler<ActionEvent> {
    private AlgoFormer former;
    private VistaJuego vistaActualizada;
	public ControladorOpcionCambiarEstadoAlternativoEventHandler(AlgoFormer unFormer,VistaJuego vista) {
		this.former = unFormer;
		this.vistaActualizada = vista;
	}

	@Override
	public void handle(ActionEvent arg0) {
		this.former.cambiarEstadoAlternativo();
		this.vistaActualizada.actualizarVistaAlSeleccionFormer(this.former);
	}
}
