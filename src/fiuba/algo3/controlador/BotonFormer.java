package fiuba.algo3.controlador;

import fiuba.algo3.modelo.AlgoFormer;
import fiuba.algo3.modelo.Juego;
import fiuba.algo3.modelo.Optimus;
import fiuba.algo3.vista.VistaJuego;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Vietnamita on 18/06/2016.
 */
public class BotonFormer extends Button {
    private AlgoFormer former;


    public BotonFormer(AlgoFormer unFormer, ControladorDeMovimientos movimiento, Juego juego, VistaJuego vista){
        this.former=unFormer;
        SeleccionarFormerEventHandler seleccion=new SeleccionarFormerEventHandler(this.former,juego,movimiento,vista);
        this.setOnAction(seleccion);
    }

	public AlgoFormer getFormer(){
        return this.former;
    }
}

