package fiuba.algo3.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
*/

import fiuba.algo3.controlador.ControladorBotonSalir;



public class VistaMenuPrincipal extends Vista{
	//private static final long serialVersionUID = 1L;

	public VistaMenuPrincipal(){
		super (2, 2, "Nuevo Juego", 500, 500);
		crearLabelConTitulo(0, "AlgoFormers");
		crearBotonSinControlador(0, "Jugar");
		crearBotonConControlador(1, "Salir", new ControladorBotonSalir());
		getPanelBotones().setLayout(new FlowLayout());
		for (int i=0 ; i<2; i++){
			getPanelBotones().add(getBoton(i));
		}
		
		getLabel(0).setFont(new Font("Tahoma", 1, 25));
		getLabel(0).setForeground(new java.awt.Color(0, 0, 0));
		getLabel(0).setBackground(Color.WHITE);
		
		getPanelLabels().add(getLabel(0));
		getVentana().getContentPane().setLayout(new BorderLayout());
		getVentana().add(getPanelLabels(), BorderLayout.CENTER);
		getVentana().add(getPanelBotones(), BorderLayout.SOUTH);
		mostrarVentana();

	}

	public static void main (String[] args){
		new VistaMenuPrincipal();
	}

}