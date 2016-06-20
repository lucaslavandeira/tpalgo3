package fiuba.algo3.vista;

import fiuba.algo3.modelo.*;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Vista extends Application {

    public static final void main(String[] args) {
        launch(args);
    }

//hola
    @Override
    public void start(final Stage stage) throws Exception{
        stage.setTitle("TRANSFORMERS");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/iconos/optimus.png")));
        Scene bienvenida=new Scene(new VistaMenuPrincipal(stage),750,480,Color.SNOW );
        stage.setScene(bienvenida);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setFullScreen(true);
        stage.show();
    }


}
