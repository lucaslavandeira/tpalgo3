package fiuba.algo3.modelo.aplicacion;

import fiuba.algo3.modelo.*;
import fiuba.algo3.modelo.aplicacion.eventos.BotonCasillero;
import fiuba.algo3.modelo.aplicacion.eventos.BotonFormer;
import fiuba.algo3.modelo.aplicacion.eventos.ControladorDeMovimientos;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Vietnamita on 18/06/2016.
 */
public class EscenarioPrincipal extends BorderPane {

    private BarraDeMenu barra;
    private MediaPlayer mediaPlayer;
    private Tablero mapa;
    private Button mover;
    private Button atacar;
    private ControladorDeMovimientos mov;
    private Juego juego;
    private Optimus optimus;
    private Bumblebee bumblebee;
    private Ratchet ratchet;
    private Megatron megatron;
    private Frenzy frenzy;
    private Bonecrusher bonecrusher;

    public EscenarioPrincipal(Stage stage) {

        this.mapa=new Tablero(11);
        this.armarJuego();
        this.barra=new BarraDeMenu(stage);
        this.barra.setOpcionNuevoJuego(this);
        this.mov=new ControladorDeMovimientos();
        this.setTop(barra);
        this.panelLateralIzquierdo();
        this.panelCentral();
        this.panelInferior();
        final URL resource = getClass().getResource("/sonido/playing.mp3");
        final Media media = new Media(resource.toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    private void armarJuego() {
        this.juego=new Juego(this.mapa);
        optimus=new Optimus(mapa.obtenerCasillero(0,3));
        bumblebee=new Bumblebee(mapa.obtenerCasillero(0,5));
        ratchet=new Ratchet(mapa.obtenerCasillero(0,7));
        megatron=new Megatron(mapa.obtenerCasillero(10,3));
        frenzy=new Frenzy(mapa.obtenerCasillero(10,5));
        bonecrusher=new Bonecrusher(mapa.obtenerCasillero(10,7));
        this.juego.addAutobots(optimus,bumblebee,ratchet);
        this.juego.addDecepticons(megatron,frenzy,bonecrusher);

    }

    private void panelInferior() {
        BotonFormer botonOptimus=new BotonFormer(this.optimus,mov);
        Button botonBumblebee=new Button();
        Button botonRatchet=new Button();

        Button botonMegatron=new Button();
        Button botonFrenzy=new Button();
        Button botonBonecrucher=new Button();


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
                BotonCasillero boton=new BotonCasillero(this.mapa.obtenerCasillero(i,j));
                this.setVistaBotonCasillero(boton);
                fila.getChildren().add(boton);
            }
            panelCentral.getChildren().add(fila);
        }

        panelCentral.setAlignment(Pos.CENTER);
        this.setCenter(panelCentral);
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
        try {
            mover= FXMLLoader.load(getClass().getResource("sample.fxml"));
            atacar= FXMLLoader.load(getClass().getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        mover.setText("Mover");
        atacar.setText("Atacar");

        //OpcionMoverEventHandler opcionmover=new OpcionMoverEventHandler();



        VBox panelIzquierdo=new VBox();
        panelIzquierdo.setAlignment(Pos.CENTER);
        panelIzquierdo.getChildren().add(mover);
        panelIzquierdo.getChildren().add(atacar);
        this.setLeft(panelIzquierdo);
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
