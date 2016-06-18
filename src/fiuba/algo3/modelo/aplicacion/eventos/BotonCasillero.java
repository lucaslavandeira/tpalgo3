package fiuba.algo3.modelo.aplicacion.eventos;

import fiuba.algo3.modelo.Casillero;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import java.io.IOException;

/**
 * Created by Vietnamita on 18/06/2016.
 */
public class BotonCasillero extends Button{

    private Casillero posicion;
    private Button local;

    public BotonCasillero (Casillero casillero){
        super();
        this.posicion=casillero;

        this.local=this;
    }



    public Casillero getCasillero(){
        return this.posicion;
    }


}
