package fiuba.algo3.modelo;

/**
 * Created by Diego on 01/06/2016.
 */
public class EquipoDecepticons extends Equipo {

    AlgoFormer megatron;
    AlgoFormer bonecrusher;
    AlgoFormer frenzy;


    public EquipoDecepticons(Tablero tablero){
        super();
        this.megatron = new AlgoFormer(tablero.obtenerCasillero(9, 6),new Estado(50,2,2),
                new Estado(15,5,4),500);
        this.bonecrusher = new AlgoFormer(tablero.obtenerCasillero(10, 5),new Estado(50,2,2),
                new Estado(15,5,4),500);

        this.frenzy = new AlgoFormer(tablero.obtenerCasillero(10, 7), new Estado(50,2,2),
                new Estado(15,5,4),500);

    }
}
