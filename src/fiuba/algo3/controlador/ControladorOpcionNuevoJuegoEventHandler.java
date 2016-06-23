package fiuba.algo3.controlador;

import fiuba.algo3.vista.VistaJuego;

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
public class ControladorOpcionNuevoJuegoEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private VistaJuego escenario;

    public ControladorOpcionNuevoJuegoEventHandler(Stage stage, VistaJuego escenario){
        this.escenario=escenario;
        this.stage=stage;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        this.escenario.setStopSonido();
        Scene escenarioPrincipal=new Scene(new VistaJuego (stage),1280,720, Color.SNOW );
        stage.setScene(escenarioPrincipal);
        stage.setFullScreen(true);
        stage.show();

    }
}