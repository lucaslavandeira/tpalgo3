package fiuba.algo3.controlador;

import fiuba.algo3.modelo.Casillero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by Vietnamita on 18/06/2016.
 */
public class ControladorOpcionCasilleroEventHandler implements EventHandler<ActionEvent> {


    private Casillero posicion;
    private ControladorDeMovimientos mov;
    private Button mover;
    private Button atacar;
    

    public ControladorOpcionCasilleroEventHandler(Casillero casillero, ControladorDeMovimientos mov,Button mover, Button atacar){
       this.mov=mov;
       posicion = casillero;
       this.mover = mover;
       this.atacar = atacar;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        this.mov.setCasillero(posicion);
        /*Para mover no se si conviene que desapareca mover y atacar 
         * al hacer click en casillero
         * mejor que clickee en former y luego clickee en un casillero valido para mover
         * Se podria poner en un costado el former y el casillero que se esta seleccionando
         */
        //this.mover.setVisible(false); 
        //this.atacar.setVisible(false);
        


    }
}