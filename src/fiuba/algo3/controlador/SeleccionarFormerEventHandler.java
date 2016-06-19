package fiuba.algo3.controlador;

import java.io.IOException;


import fiuba.algo3.controlador.ControladorAtacar;
import fiuba.algo3.controlador.ControladorDeMovimientos;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;


import fiuba.algo3.modelo.AlgoFormer;

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
    private Stage actualizarVista;
    StackPane panel = new StackPane();


    public SeleccionarFormerEventHandler(AlgoFormer former, ControladorDeMovimientos movimiento, Button mover, Button atacar)
    {
    	this.mover = mover;
    	this.atacar = atacar;
        this.former=former;
        this.movimientoActual=movimiento;
        
    }


    public SeleccionarFormerEventHandler(AlgoFormer former, ControladorDeMovimientos movimiento, VBox panelIzquierdo) {
		// TODO Auto-generated constructor stub
	}


	@Override
    public void handle(ActionEvent actionEvent) {
    	movimientoActual.setFormer(this.former);
    	this.mover.setVisible(true);
    	this.atacar.setVisible(true);
    	
    }



}
