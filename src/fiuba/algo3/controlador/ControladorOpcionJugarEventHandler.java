package fiuba.algo3.controlador;
import fiuba.algo3.modelo.Juego;
import fiuba.algo3.modelo.Tablero;
import fiuba.algo3.vista.VistaJuego;
import fiuba.algo3.vista.VistaJuego;
import fiuba.algo3.vista.Vista;
import fiuba.algo3.vista.VistaMenuPrincipal;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
public class ControladorOpcionJugarEventHandler implements EventHandler<ActionEvent> {
    Tablero tablero = new Tablero(10);
	Juego nuevoJuego = new Juego(tablero);
	private  Stage stage;
	private VistaMenuPrincipal menu;

	public ControladorOpcionJugarEventHandler(Stage stageMenuPrincipal, VistaMenuPrincipal menu) {
		stage = stageMenuPrincipal;
		this.menu=menu;
	}



	@Override
	public void handle(ActionEvent event) {
		this.menu.setStopSonido();
        Scene escenarioPrincipal=new Scene(new VistaJuego (stage),1280,720, Color.SNOW );
        stage.setScene(escenarioPrincipal);
        stage.setFullScreen(true);
        stage.show();
	}
}
