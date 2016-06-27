package fiuba.algo3.controlador;
import fiuba.algo3.modelo.Juego;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.vista.VistaJuego;
import fiuba.algo3.vista.VistaMenuPrincipal;
import javafx.event.ActionEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import java.net.URL;

public class ControladorOpcionJugarEventHandler implements EventHandler<ActionEvent> {
    Tablero tablero = new Tablero(10);
	Juego nuevoJuego = new Juego(tablero);
	private  Stage stage;
	private VistaMenuPrincipal menu;
	private MediaPlayer sonidoClick;

	public ControladorOpcionJugarEventHandler(Stage stageMenuPrincipal, VistaMenuPrincipal menu) {
		stage = stageMenuPrincipal;
		this.menu=menu;
	}



	@Override
	public void handle(ActionEvent event) {
		this.menu.setStopSonido();
		URL resource = getClass().getResource("/sonido/chispa.mp3");
		Media sound = new Media(resource.toString());
//		sonidoClick = new MediaPlayer(sound);
//		sonidoClick.play();
        Scene escenarioPrincipal=new Scene(new VistaJuego (stage),1280,720, Color.SNOW );
        stage.setScene(escenarioPrincipal);
        stage.setFullScreen(true);
        stage.show();
	}
}
