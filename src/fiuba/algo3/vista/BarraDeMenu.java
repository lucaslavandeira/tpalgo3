package fiuba.algo3.vista;

import fiuba.algo3.controlador.ControladorOpcionAcercaDeEventHandler;
import fiuba.algo3.controlador.ControladorOpcionNuevoJuegoEventHandler;
import fiuba.algo3.controlador.ControladorOpcionPantallaCompletaEventHandler;
import fiuba.algo3.controlador.ControladorOpcionSalirEventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;


public class BarraDeMenu extends MenuBar {

    MenuItem opcionPantallaCompleta = new MenuItem("Pantalla completa");
    VistaJuego escenario;

    public BarraDeMenu(Stage stage) {
        Menu menuArchivo = new Menu("Archivo");
        Menu menuVer = new Menu("Ver");
        Menu menuAyuda = new Menu("Ayuda");

        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionAbrir = new MenuItem("Abrir");
        MenuItem opcionAcercaDe = new MenuItem("Acerca de...");
        MenuItem opcionNuevo= new MenuItem("Juego Nuevo");

        ControladorOpcionSalirEventHandler opcionSalirHandler = new ControladorOpcionSalirEventHandler();
        opcionSalir.setOnAction(opcionSalirHandler);

        ControladorOpcionAcercaDeEventHandler opcionAcercaDeHandler = new ControladorOpcionAcercaDeEventHandler();
        opcionAcercaDe.setOnAction(opcionAcercaDeHandler);

        ControladorOpcionPantallaCompletaEventHandler opcionPantallaCompletaHandler = new ControladorOpcionPantallaCompletaEventHandler(stage, opcionPantallaCompleta);
        opcionPantallaCompleta.setOnAction(opcionPantallaCompletaHandler);

        ControladorOpcionNuevoJuegoEventHandler opcionNuevoJuegoEventHandler =new ControladorOpcionNuevoJuegoEventHandler(stage,escenario);
        opcionNuevo.setOnAction(opcionNuevoJuegoEventHandler);


        opcionPantallaCompleta.setDisable(true);

        menuArchivo.getItems().addAll(opcionNuevo, new SeparatorMenuItem(), opcionSalir);
        menuAyuda.getItems().addAll(opcionAcercaDe);
        menuVer.getItems().addAll(opcionPantallaCompleta);

        this.getMenus().addAll(menuArchivo, menuVer, menuAyuda);
    }

    public void aplicacionMaximizada() {
        opcionPantallaCompleta.setDisable(false);

    }

    public void setOpcionNuevoJuego(VistaJuego escenarioPrincipal){
        this.escenario=escenarioPrincipal;
    }
}
