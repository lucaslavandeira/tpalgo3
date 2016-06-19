package fiuba.algo3.controlador;

import fiuba.algo3.modelo.AlgoFormer;

import javafx.scene.control.Button;

/**
 * Created by Vietnamita on 18/06/2016.
 */
public class ControladorFormer extends Button {
    private AlgoFormer former;


    public ControladorFormer(AlgoFormer former ,ControladorDeMovimientos mov){
        this.former=former;

        SeleccionarFormerEventHandler seleccion=new SeleccionarFormerEventHandler(this.former,mov);
        this.setOnAction(seleccion);
    }

    public AlgoFormer getFormer(){
        return this.former;
    }
}
