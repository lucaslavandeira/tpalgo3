package fiuba.algo3.controlador;

import fiuba.algo3.modelo.Casillero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.net.URL;

/**
 * Created by Vietnamita on 18/06/2016.
 */
public class ControladorOpcionCasilleroEventHandler implements EventHandler<ActionEvent> {


    private Casillero posicion;
    private ControladorDeMovimientos mov;
//    private MediaPlayer sonidoMover;


    public ControladorOpcionCasilleroEventHandler(Casillero casillero, ControladorDeMovimientos mov){
       this.mov=mov;
       posicion = casillero;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        this.mov.setCasillero(posicion);
        /*Para mover no se si conviene que desapareca mover y atacar 
         * al hacer click en casillero
         * mejor que clickee en former y luego clickee en un casillero valido para mover
         * Se podria poner en un costado el former y el casillero que se esta seleccionando
         */
        //URL resource = getClass().getResource("/sonido/click.mp3");
//        Media sound = new Media(resource.toString());
//        sonidoMover = new MediaPlayer(sound);
//        sonidoMover.play();
        


    }
}
