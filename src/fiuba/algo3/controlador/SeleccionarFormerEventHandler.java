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
import javafx.scene.text.Font;
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
    private VBox panel = new VBox();


    public SeleccionarFormerEventHandler(AlgoFormer former, ControladorDeMovimientos movimiento, Button mover, Button atacar, VBox panelIzquierdo)
    {
    	this.mover = mover;
    	this.atacar = atacar;
        this.former=former;
        this.movimientoActual=movimiento;
        this.panel = panelIzquierdo;
    }



	@Override
    public void handle(ActionEvent actionEvent) {
    	movimientoActual.setFormer(this.former);
    	this.mover.setVisible(true);
    	this.atacar.setVisible(true);
    	Label nombre = (Label) panel.getChildren().get(4);
    	nombre.setFont(new Font(20));
    	nombre.setVisible(true);
    	nombre.setText("Nombre: "+former.getNombre());
    	Label vida = (Label) panel.getChildren().get(5);
    	vida.setVisible(true);
    	int vidaEnInt = this.former.getVida();
    	String vidaEnString = String.valueOf(vidaEnInt);
    	vida.setText("vida: " + vidaEnString);
    	Label estado = (Label) panel.getChildren().get(6);
    	estado.setVisible(true);
    	Label velocidad = (Label) panel.getChildren().get(7);
    	velocidad.setVisible(true);
    	int velocidadEnInt = this.former.getVelocidad();
    	String velocidadEnString = String.valueOf(velocidadEnInt);
    	velocidad.setText("Velocidad: " + velocidadEnString);
    	Label ataque = (Label) panel.getChildren().get(8);
    	ataque.setVisible(true);
    	int ataqueEnInt = this.former.getAtaque();
    	String ataqueEnString = String.valueOf(ataqueEnInt);
    	ataque.setText("Ataque: " + ataqueEnString);
    	
    }



}
