package fiuba.algo3.vista;

import com.sun.javafx.scene.control.skin.ButtonSkin;

import fiuba.algo3.controlador.ControladorOpcionJugarEventHandler;
import fiuba.algo3.controlador.ControladorOpcionMoverEventHandler;
import fiuba.algo3.controlador.ControladorOpcionSalirEventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;


/**
 * Created by Diego on 14/06/2016.
 */
public class VistaMenuPrincipal extends HBox {

   private  MediaPlayer mediaPlayer;
   private  Stage stage;

    public VistaMenuPrincipal(Stage stage) {

        super();
        this.stage=stage;
        this.setStyle("-fx-color:black");
        this.setFondo();
        this.setBotonJugar();
        this.setBotonSalir();
        this.setAlignment(Pos.BOTTOM_CENTER);
        this.setSonido();
        this.setSpacing(1200);

    }


    private void  setFondo() {

        BackgroundSize backgroundSize = new BackgroundSize(1360, 768, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(this.setImagenFondo(), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
        this.setBackground(new Background(backgroundImage));

    }


    private Image setImagenFondo() {
        return new Image(getClass().getResourceAsStream("/imagenes/transformers-30.jpg"));
    }


    private void setBotonSalir(){

        Button botonSalir = new Button();

        try {
            botonSalir= FXMLLoader.load(getClass().getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageView imagenSalir=new ImageView();
        imagenSalir.setImage(new Image(getClass().getResource("/iconos/salir.png").toExternalForm()));
        imagenSalir.setFitHeight(50);
        imagenSalir.setFitWidth(50);


        botonSalir.setGraphic(imagenSalir);
        botonSalir.setLayoutY(500);
        botonSalir.setPrefSize(50, 50);
        botonSalir.setContentDisplay(ContentDisplay.CENTER);
        botonSalir.setAlignment(Pos.BOTTOM_LEFT);

        //accion
        botonSalir.setOnAction(new ControladorOpcionSalirEventHandler());


        this.getChildren().add(botonSalir);
    }

    private void setBotonJugar(){

        Button botonJugar = new Button();
        //sytle con css
        try {
            botonJugar= FXMLLoader.load(getClass().getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        ImageView imagenSalir=new ImageView();
        imagenSalir.setImage(new Image(getClass().getResource("/iconos/Internet.png").toExternalForm()));
        imagenSalir.setFitHeight(50);
        imagenSalir.setFitWidth(50);

        botonJugar.setGraphic(imagenSalir);
        botonJugar.setPrefSize(50, 50);
        botonJugar.setContentDisplay(ContentDisplay.CENTER);
        botonJugar.setAlignment(Pos.BOTTOM_CENTER);

        botonJugar.setOnAction(new ControladorOpcionJugarEventHandler(stage,this));


        this.getChildren().add(botonJugar);
    }



    private void setSonido(){
        final URL resource = getClass().getResource("/sonido/intro.mp3");
        final Media media = new Media(resource.toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();}


public void setStopSonido(){
    this.mediaPlayer.stop();
}

}