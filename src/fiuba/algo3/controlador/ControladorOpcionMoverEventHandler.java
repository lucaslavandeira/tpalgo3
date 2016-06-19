package fiuba.algo3.controlador;

import fiuba.algo3.modelo.Casillero;

import fiuba.algo3.vista.VistaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by Vietnamita on 18/06/2016.
 */
public class ControladorOpcionMoverEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Casillero posicion;
    private ControladorDeMovimientos mov;

    public ControladorOpcionMoverEventHandler(Stage stage, ControladorDeMovimientos mov){
        this.stage=stage;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        mov.run();
        stage.show();

    }
}