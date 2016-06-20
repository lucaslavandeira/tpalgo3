package fiuba.algo3.vista;
import fiuba.algo3.modelo.*;

import fiuba.algo3.controlador.BotonCasillero;
import fiuba.algo3.controlador.BotonFormer;
import fiuba.algo3.controlador.ControladorOpcionAtacarEventHandler;
import fiuba.algo3.controlador.ControladorDeMovimientos;
import fiuba.algo3.controlador.ControladorOpcionMoverEventHandler;
import fiuba.algo3.controlador.ControladorOpcionSalirEventHandler;
import fiuba.algo3.controlador.ControladorOpcionPasarTurnoEventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;



/**
 * Created by Vietnamita on 18/06/2016.
 */
public class VistaJuego extends BorderPane {

    private BarraDeMenu barra;
    private MediaPlayer mediaPlayer;
    private Tablero mapa;
    private Button mover;
    private Button atacar;
    private Button pasarTurno;
    private ControladorDeMovimientos movimiento;
    private Juego juego;
    private Optimus optimus;
    private Bumblebee bumblebee;
    private Ratchet ratchet;
    private Megatron megatron;
    private Frenzy frenzy;
    private Bonecrusher bonecrusher;
    private Stage vista;
	private Label Vida;
	private Label ataque;
	private Label vida;
	private Label estado;
	private Label velocidad;
	private Label turno;
	private VBox panelIzquierdo;
	private Label nombre;
	private ArrayList listaDeFormers;
    public VistaJuego(Stage stage) {

        this.mapa=new Tablero(11);
        this.armarJuego();
        this.barra=new BarraDeMenu(stage);
        this.barra.setOpcionNuevoJuego(this);
        this.movimiento=new ControladorDeMovimientos();
        this.setTop(barra);
        this.panelLateralIzquierdo();
        this.panelCentral();
        this.panelInferior();
       final URL resource = getClass().getResource("/sonido/playing.mp3");
        final Media media = new Media(resource.toString());
      mediaPlayer = new MediaPlayer(media);
      mediaPlayer.play();
      this.vista = stage;
    }

    private void armarJuego() {
        this.juego=new Juego(this.mapa);
        optimus=new Optimus(mapa.obtenerCasillero(9,3));
        bumblebee=new Bumblebee(mapa.obtenerCasillero(0,5));
        ratchet=new Ratchet(mapa.obtenerCasillero(0,7));
        megatron=new Megatron(mapa.obtenerCasillero(10,3));
        frenzy=new Frenzy(mapa.obtenerCasillero(10,5));
        bonecrusher=new Bonecrusher(mapa.obtenerCasillero(10,7));
        this.juego.addAutobots(optimus,bumblebee,ratchet);
        this.juego.addDecepticons(megatron,frenzy,bonecrusher);
        this.juego.comenzarJuego();
        listaDeFormers = new ArrayList();
        listaDeFormers.add(optimus);
        listaDeFormers.add(bumblebee);
        listaDeFormers.add(ratchet);
        listaDeFormers.add(megatron);
        listaDeFormers.add(frenzy);
        listaDeFormers.add(bonecrusher);
       
    }

    private void panelInferior() {
    	BotonFormer botonOptimus=new BotonFormer(this.optimus,movimiento,this);
    	BotonFormer botonBumblebee=new BotonFormer(this.bumblebee,movimiento,this);
    	BotonFormer botonRatchet=new BotonFormer(this.ratchet,movimiento,this);

    	BotonFormer botonMegatron=new BotonFormer(this.megatron,movimiento,this);
    	BotonFormer botonFrenzy=new BotonFormer(this.frenzy,movimiento,this);
    	BotonFormer botonBonecrucher=new BotonFormer(this.bonecrusher,movimiento,this);


        this.setImagenIcono(botonOptimus,"/imagenes/caraOptimus.jpg");
        this.setImagenIcono(botonBumblebee,"/imagenes/caraBumble.jpg");
        this.setImagenIcono(botonRatchet,"/imagenes/caraRatchet.jpg");
        this.setImagenIcono(botonMegatron,"/imagenes/caraMegatron.jpg");
        this.setImagenIcono(botonFrenzy,"/imagenes/caraFrenzy.jpg");
        this.setImagenIcono(botonBonecrucher,"/imagenes/caraboneCrusher.jpg");
        HBox panelInferior=new HBox();
        HBox subpanelIzq=new HBox();
        HBox subpanelDer=new HBox();

        subpanelIzq.getChildren().addAll(botonOptimus,botonBumblebee,botonRatchet);
        subpanelIzq.setAlignment(Pos.CENTER_LEFT);

        subpanelDer.getChildren().addAll(botonMegatron,botonFrenzy,botonBonecrucher);
        subpanelDer.setAlignment(Pos.CENTER_RIGHT);

        panelInferior.getChildren().addAll(subpanelIzq,subpanelDer);
        panelInferior.setAlignment(Pos.CENTER);
        panelInferior.setSpacing(100);
        this.setBottom(panelInferior);

    }

    private void panelCentral() {
        //BotonCasillero botonCasillero=new BotonCasillero(this.mapa.obtenerCasillero(0,0));
        //Casillero casi=this.mapa.obtenerCasillero(0,4);
        //Optimus optimus=new Optimus(casi);
        //this.setVistaBotonCasillero(botonCasillero);

        VBox panelCentral=new VBox();

        for(int i=0;i<11;i++){
            HBox fila=new HBox();
            for(int j=0;j<11;j++)
            {
                BotonCasillero boton=new BotonCasillero(this.mapa.obtenerCasillero(i,j),this.movimiento);
                this.setVistaBotonCasillero(boton);
                fila.getChildren().add(boton);
            }
            panelCentral.getChildren().add(fila);
        }

        panelCentral.setAlignment(Pos.CENTER);
        this.setCenter(panelCentral);
    }
    public void actualizarVistaAlMoverFormer(){
    	this.panelCentral();
    }
    private void setVistaBotonCasillero(BotonCasillero botonCasillero){
        botonCasillero.setPrefSize(50,50);
        if(botonCasillero.getCasillero().estaOcupado()){
            ImageView imagenSalir=new ImageView();
            imagenSalir.setImage(new javafx.scene.image.Image(getClass().getResource("/iconos/autobots.png").toExternalForm()));
            imagenSalir.setFitHeight(34);
            imagenSalir.setFitWidth(34);

            Button nuevo=new Button();
            botonCasillero.setGraphic(imagenSalir);
            botonCasillero.setPrefSize(50, 50);
            botonCasillero.setContentDisplay(ContentDisplay.CENTER);
            botonCasillero.setAlignment(Pos.BOTTOM_CENTER);
        }

        if(botonCasillero.getCasillero().tieneChispaSuprema()) {
            ImageView imagenSalir=new ImageView();
            imagenSalir.setImage(new javafx.scene.image.Image(getClass().getResource("/iconos/Internet.png").toExternalForm()));
            imagenSalir.setFitHeight(34);
            imagenSalir.setFitWidth(34);

            Button nuevo=new Button();
            botonCasillero.setGraphic(imagenSalir);
            botonCasillero.setPrefSize(50, 50);
            botonCasillero.setContentDisplay(ContentDisplay.CENTER);
            botonCasillero.setAlignment(Pos.BOTTOM_CENTER);
        }

    }

    private void panelLateralIzquierdo(){
        mover=new Button();
        atacar=new Button();
        pasarTurno=new Button();
        nombre=new Label();
        vida=new Label();
        ataque=new Label();
        estado=new Label();
        velocidad = new Label();
        turno = new Label();
        panelIzquierdo = new VBox();
        try {
            mover= FXMLLoader.load(getClass().getResource("sample.fxml"));
            atacar= FXMLLoader.load(getClass().getResource("sample.fxml"));
            pasarTurno=FXMLLoader.load(getClass().getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        mover.setText("Mover");
        atacar.setText("Atacar");
        pasarTurno.setText("Pasar Turno");
        vida.setText("Vida:....");
        ataque.setText("Ataque:....");
        estado.setText("Estado: Humanoide");
        velocidad.setText("Velocidad:....");
        turno.setFont(new Font(25));
        turno.setText("Turno:");
        
        
        panelIzquierdo.getChildren().add(mover);
        panelIzquierdo.getChildren().add(atacar);
        panelIzquierdo.getChildren().add(pasarTurno);
        panelIzquierdo.getChildren().add(turno);
        panelIzquierdo.getChildren().add(nombre);
        panelIzquierdo.getChildren().add(vida);
        panelIzquierdo.getChildren().add(estado);
        panelIzquierdo.getChildren().add(velocidad);
        panelIzquierdo.getChildren().add(ataque);
        panelIzquierdo.setAlignment(Pos.CENTER);
        this.setLeft(panelIzquierdo);
        this.pasarTurno.setOnAction(new ControladorOpcionPasarTurnoEventHandler(this.juego,this.turno));
        this.atacar.setOnAction(new ControladorOpcionAtacarEventHandler(movimiento,listaDeFormers) );
        this.mover.setOnAction(new ControladorOpcionMoverEventHandler(movimiento,this));
        atacar.setVisible(false);
        pasarTurno.setVisible(true);
        mover.setVisible(false);
        vida.setVisible(false);
        estado.setVisible(false);
        velocidad.setVisible(false);
        ataque.setVisible(false);
        turno.setText("Turno: "+juego.obtenerTurnoActual());
        
    }
    public void actualizarVistaAlSeleccionFormer(AlgoFormer former){
    	this.mover.setVisible(true);
    	this.atacar.setVisible(true);
    	this.nombre.setFont(new Font(20));
    	this.nombre.setVisible(true);
    	this.nombre.setText("Nombre: "+former.getNombre());
    	this.vida.setVisible(true);
    	int vidaEnInt = former.getVida();
    	String vidaEnString = String.valueOf(vidaEnInt);
    	this.vida.setText("vida: " + vidaEnString);
    	this.estado.setVisible(true);
    	this.velocidad.setVisible(true);
    	int velocidadEnInt = former.getVelocidad();
    	String velocidadEnString = String.valueOf(velocidadEnInt);
    	this.velocidad.setText("Velocidad: " + velocidadEnString);
    	this.ataque.setVisible(true);
    	int ataqueEnInt = former.getAtaque();
    	String ataqueEnString = String.valueOf(ataqueEnInt);
    	this.ataque.setText("Ataque: " + ataqueEnString);
    }
    private void setImagenIcono(Button boton,String recurso){
        ImageView imagen=new ImageView();
        imagen.setImage(new javafx.scene.image.Image(getClass().getResource(recurso).toExternalForm()));
        imagen.setFitHeight(80);
        imagen.setFitWidth(80);
        boton.setGraphic(imagen);
        boton.setContentDisplay(ContentDisplay.CENTER);
    }
}