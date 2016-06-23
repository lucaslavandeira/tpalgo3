package fiuba.algo3.controlador;

import fiuba.algo3.vista.VistaMenuPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControladorOpcionAceptarEventHandler implements EventHandler<ActionEvent> {
    private Stage vistaNueva;
	public ControladorOpcionAceptarEventHandler(Stage vista) {
		this.vistaNueva = vista;
	}

	@Override
	public void handle(ActionEvent arg0) {
		this.vistaNueva = new Stage();
		this.vistaNueva.setTitle("TRANSFORMERS");
		this.vistaNueva.getIcons().add(new Image(getClass().getResourceAsStream("/iconos/optimus.png")));
        Scene bienvenida=new Scene(new VistaMenuPrincipal(this.vistaNueva),750,480,Color.SNOW );
        this.vistaNueva.setScene(bienvenida);
        this.vistaNueva.initStyle(StageStyle.UNDECORATED);
        this.vistaNueva.setFullScreen(true);
        this.vistaNueva.show();

	}

}
