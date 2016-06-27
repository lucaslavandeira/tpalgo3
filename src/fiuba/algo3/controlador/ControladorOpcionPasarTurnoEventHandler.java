package fiuba.algo3.controlador;

import fiuba.algo3.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;

import java.net.URL;

public class ControladorOpcionPasarTurnoEventHandler implements EventHandler<ActionEvent> {

	private Juego juegoAPasarTurno;
	private Label actualizarTurno;
	private MediaPlayer sonidoMover;

	public ControladorOpcionPasarTurnoEventHandler(Juego juego, Label turno) {
		juegoAPasarTurno = juego;
		actualizarTurno = turno;
	}

	@Override
	public void handle(ActionEvent arg0) {
        juegoAPasarTurno.proximoTurno();
		URL resource = getClass().getResource("/sonido/click.mp3");
//		Media sound = new Media(resource.toString());
//		sonidoMover = new MediaPlayer(sound);
//		sonidoMover.play();
        actualizarTurno.setText("Turno: "+ juegoAPasarTurno.obtenerTurnoActual());
	}

}
