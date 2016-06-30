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
            this.former.avanzar(this.casillero);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        
    }


    public void atack(AlgoFormer formerAAtacar){
        try {
           this.former.atacar(formerAAtacar);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

    }
}

