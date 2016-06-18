package fiuba.algo3.modelo.aplicacion.eventos;

import fiuba.algo3.modelo.aplicacion.EscenarioPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;

//import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Vietnamita on 18/06/2016.
 */
public class OpcionNuevoJuegoEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private EscenarioPrincipal escenario;

    public OpcionNuevoJuegoEventHandler(Stage stage, EscenarioPrincipal escenario){
        this.escenario=escenario;
        this.stage=stage;
    }


    @Override
    public void handle(ActionEvent actionEvent) {



    }
}