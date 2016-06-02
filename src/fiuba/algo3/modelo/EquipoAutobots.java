package fiuba.algo3.modelo;

/**
 * Created by Diego on 01/06/2016.
 */
public class EquipoAutobots extends Equipo {

         AlgoFormerAutobot optimus;
         AlgoFormerAutobot bumblebee;
         AlgoFormerAutobot ratchet;


    public EquipoAutobots(Tablero tablero){
        super();
        this.optimus = new AlgoFormerAutobot(tablero.obtenerCasillero(1, 6),new Estado(50,2,2),
                new Estado(15,5,4),500);
        this.bumblebee = new AlgoFormerAutobot(tablero.obtenerCasillero(0, 5),new Estado(50,2,2),
                new Estado(15,5,4),500);

        this.ratchet = new AlgoFormerAutobot(tablero.obtenerCasillero(0, 7), new Estado(50,2,2),
                new Estado(15,5,4),500);

    }



}
