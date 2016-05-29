package fiuba.algo3.vista;

import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Vista {

	private JFrame ventana;
	private JPanel panelBotones;
	private JPanel panelLabelsImagenes;
	private JPanel panelLabelsTexto;
	private JLabel[] labels;
	private JButton[] botones;
		
	
	public Vista ( int cantLabels, int cantBotones, String titulo, int anchoVentana, int altoVentana){
		panelBotones = new JPanel ();
		panelLabelsImagenes = new JPanel();
		labels = new JLabel [cantLabels];
		botones = new JButton [cantBotones];
		ventana = new JFrame (titulo);
		crearVentana(anchoVentana, altoVentana);
	}
	
	public void crearVentana (int anchoVentana, int altoVentana){
		ventana.setBounds (0, 0, anchoVentana, altoVentana);
	}
	
	public void crearBotonConControlador (int i, String titulo, ActionListener listener){
		botones[i] = new JButton (titulo);
		botones[i].addActionListener(listener);
	}
	
	public void crearBotonSinControlador (int i, String titulo){
		botones[i]= new JButton (titulo);
	}
	
	public void darControladorABoton (int i, ActionListener listener){
		botones[i].addActionListener(listener);
	}
	
	public void crearLabelSinTitulo(int i){
		labels[i] = new JLabel();
	}
	
	public void crearLabelConTitulo (int i, String titulo){
		labels[i]= new JLabel (titulo);
	}
	
	public JFrame getVentana(){
		return this.ventana;
	}
	
	public JPanel getPanelBotones(){
		return this.panelBotones;
	}
	
	public void crearPanelLabelsTexto(){
		this.panelLabelsTexto = new JPanel();
	}
	
	public JPanel getPanelLabelsTexto(){
		return this.panelLabelsTexto;
	}
	
	public JPanel getPanelLabels(){
		return this.panelLabelsImagenes;
	}
	
	public JButton getBoton(int i){
		return this.botones[i];
	}
	
	public JLabel getLabel(int i){
		return this.labels[i];
	}
	
	public void mostrarVentana(){
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setVisible(true);
	}
	

	public void mostrarError(String error, String causa) {
		JOptionPane.showMessageDialog(null, error, causa, JOptionPane.ERROR_MESSAGE);
		
	}
	
}
