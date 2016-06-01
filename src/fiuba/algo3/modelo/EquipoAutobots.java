package fiuba.algo3.modelo;

/**
 * Created by Diego on 01/06/2016.
 */
public class EquipoAutobots extends Equipo {

         AlgoFormer optimus;
         AlgoFormer bumblebee;
         AlgoFormer ratchet;


    public EquipoAutobots(Tablero tablero){
        super();
        this.optimus = new AlgoFormer(tablero.obtenerCasillero(1, 6),new Estado(50,2,2),
                new Estado(15,5,4),500);
        this.bumblebee = new AlgoFormer(tablero.obtenerCasillero(0, 5),new Estado(50,2,2),
                new Estado(15,5,4),500);

        this.ratchet = new AlgoFormer(tablero.obtenerCasillero(0, 7), new Estado(50,2,2),
                new Estado(15,5,4),500);

    }

}
