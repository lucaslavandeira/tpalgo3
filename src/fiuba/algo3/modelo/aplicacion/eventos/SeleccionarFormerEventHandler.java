package fiuba.algo3.modelo.aplicacion.eventos;

import fiuba.algo3.modelo.AlgoFormer;
import fiuba.algo3.modelo.Casillero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by Vietnamita on 18/06/2016.
 */


public class SeleccionarFormerEventHandler implements EventHandler<ActionEvent> {


    private AlgoFormer former;
    private ControladorDeMovimientos mov;

    public SeleccionarFormerEventHandler(AlgoFormer former, ControladorDeMovimientos mov)
    {
        this.former=former;
        this.mov=mov;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        mov.setFormer(this.former);
    }
}
