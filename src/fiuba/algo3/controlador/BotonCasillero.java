package fiuba.algo3.controlador;

import fiuba.algo3.modelo.Casillero;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import java.io.IOException;

/**
 * Created by Vietnamita on 18/06/2016.
 */
public class BotonCasillero extends ToggleButton{

    private Casillero posicion;
    private ToggleButton local;

    public BotonCasillero (Casillero casillero, ControladorDeMovimientos movimiento){
        super();
        this.posicion=casillero;
        this.local=this;
        ControladorOpcionCasilleroEventHandler controladorCasillero=new ControladorOpcionCasilleroEventHandler(this.posicion,movimiento);
        this.setOnAction(controladorCasillero);
    }



    public Casillero getCasillero(){
        return this.posicion;
    }


}
