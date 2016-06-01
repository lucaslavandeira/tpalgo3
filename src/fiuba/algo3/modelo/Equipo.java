package fiuba.algo3.modelo;

/**
 * Created by Diego on 01/06/2016.
 */
public class Equipo {

    public boolean contenedorChispa=false;
    public boolean ganador=false;


    public void asignarChispa(){
        this.contenedorChispa=true;
    }

    public void asignarGanador(){
        this.contenedorChispa=true;
    }

    public boolean  esGanador(){
        return this.ganador;
    }

    public boolean  tieneChispa(){
        return this.contenedorChispa;
    }

}
