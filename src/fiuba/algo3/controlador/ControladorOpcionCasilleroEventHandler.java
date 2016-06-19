package fiuba.algo3.controlador;

import fiuba.algo3.modelo.Casillero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 * Created by Vietnamita on 18/06/2016.
 */
public class ControladorOpcionCasilleroEventHandler implements EventHandler<ActionEvent> {


    private Casillero posicion;
    private ControladorDeMovimientos mov;

    public ControladorOpcionCasilleroEventHandler(Casillero casillero, ControladorDeMovimientos mov){
       this.mov=mov;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        mov.setCasillero(posicion);


    }
}
