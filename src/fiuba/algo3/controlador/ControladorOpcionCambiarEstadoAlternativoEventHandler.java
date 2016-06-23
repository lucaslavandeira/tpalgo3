package fiuba.algo3.controlador;

import fiuba.algo3.modelo.AlgoFormer;
import fiuba.algo3.vista.VistaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;

public class ControladorOpcionCambiarEstadoAlternativoEventHandler implements EventHandler<ActionEvent> {
    private AlgoFormer former;
    private VistaJuego vistaActualizada;
	private MediaPlayer player;

	public ControladorOpcionCambiarEstadoAlternativoEventHandler(AlgoFormer unFormer,VistaJuego vista) {
		this.former = unFormer;
		this.vistaActualizada = vista;
	}

	@Override
	public void handle(ActionEvent arg0) {
		this.former.cambiarEstadoAlternativo();
		final URL resource = getClass().getResource("/sonido/electronica.mp3");
		final Media media = new Media(resource.toString());
		player = new MediaPlayer(media);
		player.play();
		this.vistaActualizada.actualizarVistaAlSeleccionFormer(this.former);
	}
}
