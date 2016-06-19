package fiuba.algo3.controlador;

import fiuba.algo3.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class ControladorPasarTurno implements EventHandler<ActionEvent> {

	private Juego juegoAPasarTurno;
	private Label actualizarTurno;

	public ControladorPasarTurno(Juego juego, Label turno) {
		juegoAPasarTurno = juego;
		actualizarTurno = turno;
	}

	@Override
	public void handle(ActionEvent arg0) {
        juegoAPasarTurno.proximoTurno();
        actualizarTurno.setText("Turno: "+ juegoAPasarTurno.obtenerTurnoActual());
	}

}
