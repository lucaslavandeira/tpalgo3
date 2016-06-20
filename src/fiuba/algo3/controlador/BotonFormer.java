package fiuba.algo3.controlador;

import fiuba.algo3.modelo.AlgoFormer;
import fiuba.algo3.modelo.Optimus;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Vietnamita on 18/06/2016.
 */
public class BotonFormer extends Button {
    private AlgoFormer former;


    public BotonFormer(AlgoFormer former ,ControladorDeMovimientos movimiento, Button mover, Button atacar, VBox panelIzquierdo){
        this.former=former;
        SeleccionarFormerEventHandler seleccion=new SeleccionarFormerEventHandler(this.former,movimiento,mover,atacar,panelIzquierdo);
        this.setOnAction(seleccion);
    }

	public AlgoFormer getFormer(){
        return this.former;
    }
}
