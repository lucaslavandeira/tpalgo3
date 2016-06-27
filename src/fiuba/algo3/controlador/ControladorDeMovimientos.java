package fiuba.algo3.controlador;

import fiuba.algo3.modelo.AlgoFormer;
import fiuba.algo3.modelo.Casillero;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;


/**
 * Created by Vietnamita on 18/06/2016.
 */
public class ControladorDeMovimientos {
    private AlgoFormer former;
    private Casillero casillero;
//    private MediaPlayer sonidoAtack;
//    private MediaPlayer sonidoMover;
//    private MediaPlayer sonidoEquipo;

    public ControladorDeMovimientos(){
    }

    public void setFormer(AlgoFormer former){
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
            if(this.casillero.tieneEquipamiento()){
               this.producirSonidoEquipamiento();
            }


            this.former.avanzar(this.casillero);
             URL resource = getClass().getResource("/sonido/movimiento.mp3");
             Media sound = new Media(resource.toString());
//            sonidoMover = new MediaPlayer(sound);
//            sonidoMover.play();
//



        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        
    }

    private void producirSonidoEquipamiento() {
        URL resource2 = getClass().getResource("/sonido/equipamiento.mp3");
        Media sound2 = new Media(resource2.toString());
//        sonidoEquipo = new MediaPlayer(sound2);
//        sonidoEquipo.play();
    }

    public void atack(AlgoFormer formerAAtacar){
        try {
           this.former.atacar(formerAAtacar);

            final URL resource = getClass().getResource("/sonido/explode.mp3");
            final Media media = new Media(resource.toString());
//            sonidoAtack = new MediaPlayer(media);
//            sonidoAtack.play();




        } catch (RuntimeException e) {
            e.printStackTrace();
        }

    }
}

