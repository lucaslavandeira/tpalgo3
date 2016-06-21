package fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ControladorOpcionInstructivoEventHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Instructivo");
        alert.setHeaderText("Instructivo");
        String mensaje = "Convencion para la superficie segun el color de los casilleros\n"
        		+ "Color Griz: Superficie Roca no afecta en ningun estado\n"
        		+ "Color Verde Oscuro: Superficie pantano quita un %50 en su velocidad en estado terrestre\n"
        		+ "Color Verde claro: Superficie espinas 5% de danio en cualquier estado\n"
        		+ "Color Celeste: Superficie Nube no afecta en ningun estado\n"
        		+ "Color Violeta oscuro: Superficie Tormenta Psionica reduce %40 el ataque en estado aereo\n"
        		+ "Color Violeta claro: Superficie Nebulosa de Andromeda bloquea 3 turnos en estado aereo\n"
        		+ "\n"
        		+ "Convencion para el BONUS:";
        alert.setContentText(mensaje);
        alert.show();
	}
 

}
