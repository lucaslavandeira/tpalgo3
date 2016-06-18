package fiuba.algo3.modelo.aplicacion.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Acerca de...");
        alert.setHeaderText("AlgoFormer 2016 Todos los derechos reservados, no se les ocurra copiar!!!");
        String mensaje = "75.07 Algoritmos y  programación III - GRUPO 7";
        alert.setContentText(mensaje);
        alert.show();
    }
}
