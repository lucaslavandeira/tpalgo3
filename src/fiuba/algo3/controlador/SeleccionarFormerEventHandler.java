package fiuba.algo3.controlador;

import java.io.IOException;


import fiuba.algo3.controlador.ControladorOpcionAtacarEventHandler;
import fiuba.algo3.controlador.ControladorDeMovimientos;
import fiuba.algo3.modelo.Juego;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;


import fiuba.algo3.modelo.AlgoFormer;
import fiuba.algo3.vista.VistaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


/**
 * Created by Vietnamita on 18/06/2016.
 */


public class SeleccionarFormerEventHandler implements EventHandler<ActionEvent>{

    private final Juego juego;
    private Button mover;
    private Button atacar;
    private AlgoFormer former;
    private ControladorDeMovimientos movimientoActual;
    private Stage vista;
    private VBox panel = new VBox();
    private VistaJuego vistaAnterior;
    //private MediaPlayer sonidoMover;

    public SeleccionarFormerEventHandler(AlgoFormer former, Juego juego, ControladorDeMovimientos movimiento, VistaJuego vista)
    {
        this.juego = juego;
        this.former=former;
        this.movimientoActual=movimiento;
        vistaAnterior = vista;
    }



	@Override
    public void handle(ActionEvent actionEvent) {
    	movimientoActual.setFormer(this.former, juego);
        //URL resource = getClass().getResource("/sonido/click.mp3");
//        Media sound = new Media(resource.toString());
//        sonidoMover = new MediaPlayer(sound);
//        sonidoMover.play();
        vistaAnterior.obtenerBotonCambiarEstadoHumanoide().setOnAction(new ControladorOpcionCambiarEstadoHumanoideEventHandler(this.former,vistaAnterior));
        vistaAnterior.obtenerBotonCambiarEstadoAlternativo().setOnAction(new ControladorOpcionCambiarEstadoAlternativoEventHandler(this.former,vistaAnterior));
        vistaAnterior.actualizarVistaAlSeleccionFormer(this.former);

    }



}
