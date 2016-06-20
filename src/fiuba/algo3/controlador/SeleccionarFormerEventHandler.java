package fiuba.algo3.controlador;

import java.io.IOException;


import fiuba.algo3.controlador.ControladorOpcionAtacarEventHandler;
import fiuba.algo3.controlador.ControladorDeMovimientos;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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

    private Button mover;
    private Button atacar;
    private AlgoFormer former;
    private ControladorDeMovimientos movimientoActual;
    private Stage vista;
    private VBox panel = new VBox();
    private VistaJuego vistaAnterior;

    public SeleccionarFormerEventHandler(AlgoFormer former, ControladorDeMovimientos movimiento,VistaJuego vista)
    {
        this.former=former;
        this.movimientoActual=movimiento;
        vistaAnterior = vista;
    }



	@Override
    public void handle(ActionEvent actionEvent) {
    	movimientoActual.setFormer(this.former);
        vistaAnterior.obtenerBotonCambiarEstadoHumanoide().setOnAction(new ControladorOpcionCambiarEstadoHumanoideEventHandler(this.former,vistaAnterior));
        vistaAnterior.obtenerBotonCambiarEstadoAlternativo().setOnAction(new ControladorOpcionCambiarEstadoAlternativoEventHandler(this.former,vistaAnterior));
        vistaAnterior.actualizarVistaAlSeleccionFormer(this.former);

    }



}
