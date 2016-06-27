package fiuba.algo3.vista;
import fiuba.algo3.modelo.*;


import fiuba.algo3.controlador.BotonCasillero;
import fiuba.algo3.controlador.BotonFormer;
import fiuba.algo3.controlador.ControladorOpcionAtacarEventHandler;
import fiuba.algo3.controlador.ControladorDeMovimientos;
import fiuba.algo3.controlador.ControladorOpcionAceptarEventHandler;
import fiuba.algo3.controlador.ControladorOpcionMoverEventHandler;
import fiuba.algo3.controlador.ControladorOpcionPasarTurnoEventHandler;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;



/**
 * Created by Vietnamita on 18/06/2016.
 */
public class VistaJuego extends BorderPane {

    private BarraDeMenu barra;
    private MediaPlayer mediaPlayer;
    private Tablero mapa;
    private Button mover;
    private Button atacar;
    private Button pasarTurno;
    private ControladorDeMovimientos movimiento;
    private Juego juego;
    private Optimus optimus;
    private Bumblebee bumblebee;
    private Ratchet ratchet;
    private Megatron megatron;
    private Frenzy frenzy;
    private Bonecrusher bonecrusher;
    private BotonFormer botonOptimus;
    private BotonFormer botonBumblebee;
    private BotonFormer botonRatchet;
    private BotonFormer botonMegatron;
    private BotonFormer botonFrenzy;
    private BotonFormer botonBonecrusher;
    private Stage vista;
	private Label Vida;
	private Label ataque;
	private Label vida;
	private Label estado;
	private Label velocidad;
	private Label turno;
	private VBox panelIzquierdo;
	private Label nombre;
	private ArrayList<AlgoFormer> listaDeFormers;
	private Button cambiarEstadoHumanoide;
	private Button cambiarEstadoAlternativo;
	private Label bonus;
    //private MediaPlayer sonidoGanador;

    public VistaJuego(Stage stage) {

        this.mapa=new Tablero(11);
        this.mapa.asignarEfectosAleatorios();
        this.armarJuego();
        this.barra=new BarraDeMenu(stage,this);
        barra.setStyle("-fx-base:black");
        this.barra.setOpcionNuevoJuego(this);
        this.movimiento=new ControladorDeMovimientos();
        this.setTop(barra);
        this.panelLateralIzquierdo();
        this.panelCentral();
        this.panelLateralDerecho();
        //final URL resource = getClass().getResource("/sonido/actionSound.m4a");
        //final Media media = new Media(resource.toString());
//        mediaPlayer = new MediaPlayer(media);
//        mediaPlayer.play();
        this.setStyle("-fx-base:black");
        this.vista = stage;
    }

    private void armarJuego() {
        this.juego=new Juego(this.mapa);
        optimus=new Optimus(mapa.obtenerCasillero(0,3));
        bumblebee=new Bumblebee(mapa.obtenerCasillero(0,5));
        ratchet=new Ratchet(mapa.obtenerCasillero(0,7));
        megatron=new Megatron(mapa.obtenerCasillero(10,3));
        frenzy=new Frenzy(mapa.obtenerCasillero(10,5));
        bonecrusher=new Bonecrusher(mapa.obtenerCasillero(10,7));
        this.juego.addAutobots(optimus,bumblebee,ratchet);
        this.juego.addDecepticons(megatron,frenzy,bonecrusher);
        this.juego.comenzarJuego();
        listaDeFormers = new ArrayList();
        listaDeFormers.add(optimus);
        listaDeFormers.add(bumblebee);
        listaDeFormers.add(ratchet);
        listaDeFormers.add(megatron);
        listaDeFormers.add(frenzy);
        listaDeFormers.add(bonecrusher);
       
    }

    private void panelLateralDerecho() {
    	botonOptimus=new BotonFormer(this.optimus,movimiento,juego,this);
    	botonBumblebee=new BotonFormer(this.bumblebee,movimiento,juego,this);
    	botonRatchet=new BotonFormer(this.ratchet,movimiento,juego,this);

    	botonMegatron=new BotonFormer(this.megatron,movimiento,juego,this);
    	botonFrenzy=new BotonFormer(this.frenzy,movimiento,juego,this);
    	botonBonecrusher=new BotonFormer(this.bonecrusher,movimiento,juego,this);


        this.addEfecto(botonOptimus);
        this.addEfecto(botonBumblebee);
        this.addEfecto(botonRatchet);
        this.addEfecto(botonMegatron);
        this.addEfecto(botonFrenzy);
        this.addEfecto(botonBonecrusher);


        this.setImagenIcono(botonOptimus,"/imagenes/caraOptimus.jpg");
        this.setImagenIcono(botonBumblebee,"/imagenes/caraBumble.jpg");
        this.setImagenIcono(botonRatchet,"/imagenes/caraRatchet.jpg");
        this.setImagenIcono(botonMegatron,"/imagenes/caraMegatron.jpg");
        this.setImagenIcono(botonFrenzy,"/imagenes/caraFrenzy.jpg");
        this.setImagenIcono(botonBonecrusher,"/imagenes/caraboneCrusher.jpg");
        VBox panelLateralDerecho=new VBox();
        VBox subpanelSuperior=new VBox();
        VBox subpanelInferior=new VBox();

        subpanelSuperior.getChildren().addAll(botonOptimus,botonBumblebee,botonRatchet);
        subpanelSuperior.setAlignment(Pos.CENTER_LEFT);
        subpanelInferior.setStyle("-fx-base:black");

        subpanelInferior.getChildren().addAll(botonMegatron,botonFrenzy,botonBonecrusher);
        subpanelInferior.setAlignment(Pos.CENTER_RIGHT);
        subpanelSuperior.setStyle("-fx-base:black");

        panelLateralDerecho.getChildren().addAll(subpanelSuperior,subpanelInferior);
        panelLateralDerecho.setAlignment(Pos.CENTER);
        panelLateralDerecho.setSpacing(100);
        panelLateralDerecho.getStyleClass().add("-fx-base:black");
        this.setRight(panelLateralDerecho);

    }

    private void addEfecto(Button boton) {

        DropShadow shadow = new DropShadow();

        boton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        boton.setEffect(shadow);
                    }
                });

        boton.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        boton.setEffect(null);
                    }
                });

    }

    private void panelCentral() {
        VBox panelCentral=new VBox();
        for(int i=0;i<this.mapa.tamanio();i++){
            HBox fila=new HBox();
            for(int j=0;j<this.mapa.tamanio();j++)
            {
            	SuperficiesEnum superficieEnum = ((Superficie) this.mapa.obtenerCasillero(i,j).getSuperficie()).getSuperficie();
                BotonCasillero boton=new BotonCasillero(this.mapa.obtenerCasillero(i,j),this.movimiento);
                this.setVistaBotonCasillero(boton,superficieEnum);
                this.addEfecto(boton);
                fila.getChildren().add(boton);
            }
            panelCentral.getChildren().add(fila);
        }

        panelCentral.setAlignment(Pos.CENTER);
        this.setCenter(panelCentral);
    }
    public void actualizarVista(){
       for(int i=0;i<listaDeFormers.size();i++) {
           if (listaDeFormers.get(i) == null || listaDeFormers.get(i).estaMuerto()){

               //final URL resource = getClass().getResource("/sonido/muerte.mp3");
               //final Media media = new Media(resource.toString());
//               MediaPlayer sound=new MediaPlayer(media);
//               sound.play();


               listaDeFormers.get(i).getPosicion().desocupar();
               this.desabilitarBotonFormer(listaDeFormers.get(i));
               listaDeFormers.remove(i);
           }
       }

       try { 
    	   this.juego.hayGanador();
    	} catch(RuntimeException JugadorGanoException) { 
    	    this.mostrarMensajeAlGanador();
    	}
        this.ocultarEstadisticas();
    	this.panelCentral();
    }
    private void ocultarEstadisticas() {
    	this.cambiarEstadoHumanoide.setVisible(false);
    	this.cambiarEstadoAlternativo.setVisible(false);
    	this.mover.setVisible(false);
    	this.atacar.setVisible(false);
    	this.nombre.setVisible(false);
    	this.vida.setVisible(false);
    	this.estado.setVisible(false);
    	this.velocidad.setVisible(false);
    	this.ataque.setVisible(false);
    	bonus.setVisible(false);
		
	}

	private void mostrarMensajeAlGanador() {
		Stage ventanaGanador = new Stage();

//        this.mediaPlayer.stop();
		ventanaGanador.setTitle("Ganaron los "+ juego.getGanador()+"!!");
		ventanaGanador.getIcons().add(new Image(getClass().getResourceAsStream("/iconos/optimus.png")));

        VBox modeloVentanaGanador = new VBox();
        modeloVentanaGanador.setStyle("-fx-base:black");
		Label texto = new Label ();
		Button aceptar = new Button();
        this.addEfecto(aceptar);
        this.setStyle("-fx-base:black");
		aceptar.setText("Aceptar");

        texto.setText("El equipo ganador: " + juego.getGanador());
		texto.setAlignment(Pos.TOP_CENTER);

        aceptar.setAlignment(Pos.CENTER);

        modeloVentanaGanador.getChildren().add(texto);
		modeloVentanaGanador.getChildren().add(aceptar);
		modeloVentanaGanador.setAlignment(Pos.CENTER);

        Scene ventanaDisenio=new Scene(modeloVentanaGanador,240,120,Color.SNOW );
        ventanaGanador.setScene(ventanaDisenio);
        ventanaGanador.initStyle(StageStyle.UNDECORATED);
        ventanaGanador.setFullScreen(false);
        ventanaGanador.show();
        //URL resource = getClass().getResource("/sonido/drums.mp3");
        //Media sound = new Media(resource.toString());
//        sonidoGanador = new MediaPlayer(sound);
//        sonidoGanador.play();
        aceptar.setOnAction(new ControladorOpcionAceptarEventHandler(this.vista));

	}



	private void desabilitarBotonFormer(AlgoFormer formerMuerto) {
    	switch (formerMuerto.getNombre()){
    	case "Optimus": botonOptimus.setDisable(true);
    	break;
    	case "Bumblebee": botonBumblebee.setDisable(true);
    	break;
    	case "Ratchet": botonRatchet.setDisable(true);
    	break;
    	case "Megatron": botonMegatron.setDisable(true);
    	break;
    	case "Bonecrusher": botonBonecrusher.setDisable(true);
    	break;
    	case "Frenzy": botonFrenzy.setDisable(true);
    	break;
    	}
		
	}

	private void setVistaBotonCasillero(BotonCasillero botonCasillero, SuperficiesEnum superficie){
        botonCasillero.setPrefSize(50,50);
        this.asignarColorAlCasillero(botonCasillero , superficie);
        this.asignarEstrellaAlBonus(botonCasillero);
        if(botonCasillero.getCasillero().estaOcupado()){
            ImageView imagenSalir=new ImageView();

            imagenSalir.setImage(new javafx.scene.image.Image(getClass().getResource(this.obtenerDisenio(botonCasillero)).toExternalForm()));
            imagenSalir.setFitHeight(50);
            imagenSalir.setFitWidth(50);

            Button nuevo=new Button();
            botonCasillero.setGraphic(imagenSalir);
            //botonCasillero.setPrefSize(50, 50);
            botonCasillero.setContentDisplay(ContentDisplay.CENTER);
            botonCasillero.setAlignment(Pos.BOTTOM_CENTER);
        }

        if(botonCasillero.getCasillero().tieneChispaSuprema()) {
            ImageView imagenSalir=new ImageView();
            imagenSalir.setImage(new javafx.scene.image.Image(getClass().getResource("/iconos/Internet.png").toExternalForm()));
            imagenSalir.setFitHeight(50);
            imagenSalir.setFitWidth(50);

            Button nuevo=new Button();
            botonCasillero.setGraphic(imagenSalir);
            //botonCasillero.setPrefSize(50, 50);
            botonCasillero.setContentDisplay(ContentDisplay.CENTER);
            botonCasillero.setAlignment(Pos.BOTTOM_CENTER);
        }

        botonCasillero.setPrefSize(80,80);
    }

    private String obtenerDisenio(BotonCasillero botonCasillero) {

        if(optimus.getPosicion()==botonCasillero.getCasillero()){
            return("/imagenes/caraOptimus.jpg");
        }
        if(bumblebee.getPosicion()==botonCasillero.getCasillero()){
            return("/imagenes/caraBumble.jpg");
        }
        if(ratchet.getPosicion()==botonCasillero.getCasillero()){
            return("/imagenes/caraRatchet.jpg");
        }
        if(megatron.getPosicion()==botonCasillero.getCasillero()){
            return("/imagenes/caraMegatron.jpg");
        }
        if(frenzy.getPosicion()==botonCasillero.getCasillero()){
            return("/imagenes/caraFrenzy.jpg");
        }
        if(bonecrusher.getPosicion()==botonCasillero.getCasillero()){
            return("/imagenes/caraboneCrusher.jpg");
        }

        return("");
    }

    private void asignarEstrellaAlBonus(BotonCasillero botonCasillero) {
	       String nombreDeBonus =botonCasillero.getCasillero().getNombreEquipamiento();
	       if (nombreDeBonus != " "){
	           ImageView imagenSalir=new ImageView();

               if(nombreDeBonus=="Burbuja Inmaculada")
	           imagenSalir.setImage(new javafx.scene.image.Image(getClass().getResource("/iconos/activex-cache.png").toExternalForm()));
               if(nombreDeBonus=="Doble Canion")
                   imagenSalir.setImage(new javafx.scene.image.Image(getClass().getResource("/iconos/run.png").toExternalForm()));
               if(nombreDeBonus=="Flash")
                   imagenSalir.setImage(new javafx.scene.image.Image(getClass().getResource("/iconos/removable-driver3.png").toExternalForm()));

               imagenSalir.setFitHeight(34);
	           imagenSalir.setFitWidth(34);
	    	   botonCasillero.setGraphic(imagenSalir);
	       }
		
	}

	private void asignarColorAlCasillero(BotonCasillero botonCasillero, SuperficiesEnum superficie) {
    	
    	switch (superficie){
    	case ROCA: botonCasillero.setStyle("-fx-base: brown;");
    	break;
    	case PANTANO: botonCasillero.setStyle("-fx-base: green;");
    	break;
    	case ESPINAS: botonCasillero.setStyle("-fx-base: limegreen;");
    	break;
    	case NUBE: botonCasillero.setStyle("-fx-base: cyan;");
    	break;
    	case NEBULOSAANDROMEDA: botonCasillero.setStyle("-fx-base: violet;");
    	break;
    	case TORMENTAPSIONICA: botonCasillero.setStyle("-fx-base: darkviolet;");
    	break;
    	}
	}

	private void panelLateralIzquierdo(){
    	cambiarEstadoHumanoide=new Button();
    	cambiarEstadoAlternativo=new Button();
        mover=new Button();
        atacar=new Button();
        pasarTurno=new Button();


        nombre=new Label();
        vida=new Label();
        ataque=new Label();
        estado=new Label();
        velocidad = new Label();
        turno = new Label();
        bonus = new Label();

       String stilo="-fx-font-family:Transformers;-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill:#333333; -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 )";
        String stilo2="-fx-font-family:Transformers;-fx-font-size: 15px; -fx-font-weight: bold; -fx-text-fill: white; -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 )";
        String stilo3="-fx-font-family:Transformers;-fx-font-size: 15px; -fx-font-weight: bold; -fx-text-fill: #dc143c ; -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 )";
        nombre.setStyle(stilo);
        vida.setStyle(stilo2);
        ataque.setStyle(stilo2);
        velocidad.setStyle(stilo2);
        estado.setStyle(stilo2);
        bonus.setStyle(stilo3);
        turno.setStyle(stilo);




        //Dividir paneles para ordenar


        panelIzquierdo = new VBox();
        try {
            mover= FXMLLoader.load(getClass().getResource("sample.fxml"));
            atacar= FXMLLoader.load(getClass().getResource("sample.fxml"));
            pasarTurno=FXMLLoader.load(getClass().getResource("sample.fxml"));
            cambiarEstadoHumanoide=FXMLLoader.load(getClass().getResource("sample.fxml"));
            cambiarEstadoAlternativo=FXMLLoader.load(getClass().getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        mover.setText("Mover");mover.setMaxWidth(500);
        atacar.setText("Atacar");atacar.setMaxWidth(500);
        pasarTurno.setText("Pasar Turno");pasarTurno.setMaxWidth(500);
        cambiarEstadoHumanoide.setText("Cambiar Estado Humanoide"); cambiarEstadoAlternativo.setMaxWidth(500);
        cambiarEstadoAlternativo.setText("Cambiar Estado Alternativo");cambiarEstadoHumanoide.setMaxWidth(500);
        vida.setText("Vida:....");
        ataque.setText("Ataque:....");
        estado.setText("Estado: Humanoide");
        velocidad.setText("Velocidad:....");
        turno.setFont(new Font(20));
        turno.setText("Turno:");
        bonus.setText("Bonus: ");
        panelIzquierdo.getChildren().add(turno);
        panelIzquierdo.getChildren().add(pasarTurno);
        panelIzquierdo.getChildren().add(atacar);
        panelIzquierdo.getChildren().add(mover);
        panelIzquierdo.getChildren().add(cambiarEstadoHumanoide);
        panelIzquierdo.getChildren().add(cambiarEstadoAlternativo);
        panelIzquierdo.getChildren().add(nombre);
        panelIzquierdo.getChildren().add(vida);
        panelIzquierdo.getChildren().add(ataque);
        panelIzquierdo.getChildren().add(velocidad);
        panelIzquierdo.getChildren().add(estado);
        panelIzquierdo.getChildren().add(bonus);
        panelIzquierdo.setAlignment(Pos.CENTER);
        this.setLeft(panelIzquierdo);
       
        this.pasarTurno.setOnAction(new ControladorOpcionPasarTurnoEventHandler(this.juego,this.turno));
        this.atacar.setOnAction(new ControladorOpcionAtacarEventHandler(movimiento,listaDeFormers,this) );
        this.mover.setOnAction(new ControladorOpcionMoverEventHandler(movimiento,this));
        atacar.setVisible(false);
        pasarTurno.setVisible(true);
        mover.setVisible(false);
        vida.setVisible(false);
        estado.setVisible(false);
        velocidad.setVisible(false);
        ataque.setVisible(false);
        bonus.setVisible(false);
    	this.cambiarEstadoHumanoide.setVisible(false);
    	this.cambiarEstadoAlternativo.setVisible(false);
        turno.setText("Turno: "+juego.obtenerTurnoActual());
        
    }
    public void actualizarVistaAlSeleccionFormer(AlgoFormer former){
    	estado.setText("Estado: "+former.getEstado());
    	this.cambiarEstadoHumanoide.setVisible(true);
    	this.cambiarEstadoAlternativo.setVisible(true);
    	this.mover.setVisible(true);
    	this.atacar.setVisible(true);
    	this.nombre.setFont(new Font(20));
    	this.nombre.setVisible(true);
    	this.nombre.setText(former.getNombre());
    	this.vida.setVisible(true);
    	int vidaEnInt = former.getVida();
    	String vidaEnString = String.valueOf(vidaEnInt);
    	this.vida.setText("vida: " + vidaEnString);
    	this.estado.setVisible(true);
    	this.velocidad.setVisible(true);
    	int velocidadEnInt = former.getVelocidad();
    	String velocidadEnString = String.valueOf(velocidadEnInt);
    	this.velocidad.setText("Velocidad: " + velocidadEnString);
    	this.ataque.setVisible(true);
    	int ataqueEnInt = former.getAtaque();
    	String ataqueEnString = String.valueOf(ataqueEnInt);
    	this.ataque.setText("Ataque: " + ataqueEnString);
    	bonus.setVisible(true);
    	bonus.setText("Bonus:"+this.bonusDisponibles(former));
    	
    }
    private String bonusDisponibles(AlgoFormer former) {


    if (former.getBonus().tengoBonusInmortal()){
        return " Burbuja Inmaculada; ";
    }
	if (former.getBonus().tengoDobleCanion()){
        return " Doble Canion; ";
 	}
    if (former.getBonus().tengoTriplicaVelocidad()){
        return " Flash; ";
	}  
		return " ";
	}

	private void setImagenIcono(Button boton,String recurso){
        ImageView imagen=new ImageView();
        imagen.setImage(new javafx.scene.image.Image(getClass().getResource(recurso).toExternalForm()));
        imagen.setFitHeight(80);
        imagen.setFitWidth(80);
        boton.setGraphic(imagen);
        boton.setContentDisplay(ContentDisplay.CENTER);
    }
	public Button obtenerBotonCambiarEstadoHumanoide() {
		return this.cambiarEstadoHumanoide;
	}
	public Button obtenerBotonCambiarEstadoAlternativo() {
		return this.cambiarEstadoAlternativo;
	}


    public void setStopSonido() {
        //this.mediaPlayer.stop();
    }
}