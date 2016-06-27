package fiuba.algo3.controlador;

import fiuba.algo3.modelo.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;


/**
 * Created by Vietnamita on 18/06/2016.
 */
public class ControladorDeMovimientos {
    private AlgoFormer former;
    private Casillero casillero;
    private Juego juego;
    //    private MediaPlayer sonidoAtack;
//    private MediaPlayer sonidoMover;
//    private MediaPlayer sonidoEquipo;

    public ControladorDeMovimientos(){
    }

    public void setFormer(AlgoFormer former, Juego juego){
        this.juego = juego;
        
        this.former=former;
    }
    public AlgoFormer getFormer(){
        return this.former;
    }

    public void setCasillero(Casillero casillero){
        this.casillero=casillero;
    }
    public Casillero getCasillero(){
    	return this.casillero;
    }

    public void run(){
        try {
            if (this.casillero.tieneEquipamiento()) {
                //this.producirSonidoEquipamiento();
            }


            this.former.avanzar(this.casillero);
            if (this.former.getEquipo() == Equipo.AUTOBOTS) {
                try {
                    juego.formarSuperion();
                    System.out.println("SUPERION FORMADO");
                } catch (SobrepasaRangosException e) {}

            } else {
                try {
                    juego.formarMenasor();
                    System.out.println("MENASOR FORMADO");
                } catch (SobrepasaRangosException e) {}
            }

             //URL resource = getClass().getResource("/sonido/movimiento.mp3");
             //Media sound = new Media(resource.toString());
//            sonidoMover = new MediaPlayer(sound);
//            sonidoMover.play();
//



        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        
    }

    /*private void producirSonidoEquipamiento() {
        URL resource2 = getClass().getResource("/sonido/equipamiento.mp3");
        Media sound2 = new Media(resource2.toString());
        sonidoEquipo = new MediaPlayer(sound2);
            sonidoEquipo.play();
    }*/

    public void atack(AlgoFormer formerAAtacar){
        try {
           this.former.atacar(formerAAtacar);

            //final URL resource = getClass().getResource("/sonido/explode.mp3");
            //final Media media = new Media(resource.toString());
//            sonidoAtack = new MediaPlayer(media);
//            sonidoAtack.play();




        } catch (RuntimeException e) {
            e.printStackTrace();
        }

    }
}

