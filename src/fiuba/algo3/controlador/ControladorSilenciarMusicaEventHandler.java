package fiuba.algo3.controlador;

import fiuba.algo3.vista.VistaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by Vietnamita on 23/06/2016.
 */
public class ControladorSilenciarMusicaEventHandler implements EventHandler<ActionEvent> {
    private VistaJuego escenario;

    public ControladorSilenciarMusicaEventHandler(VistaJuego escenario){
        this.escenario=escenario;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        escenario.setStopSonido();

    }
}
