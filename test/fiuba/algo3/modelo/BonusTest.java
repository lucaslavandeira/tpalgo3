package fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Created by Diego on 02/06/2016.
 */
public class BonusTest {

    Tablero tablero;
    Casillero casillero;
    @Before
    public void setUp() {
        tablero = new Tablero(11);
    }


    @Test
    public void test00CrearCorrectamenteUnBonus(){
        Bonus bonus=new Bonus(tablero.obtenerCasillero(1,1));
        Casillero casillero=tablero.obtenerCasillero(1,1);
        Assert.assertTrue(casillero.enteContenido.esBonus()== true);

    }

    @Test
    public void test01CrearBonusDeDobleCanion(){
        Bonus bonus= new DobleCanion(tablero.obtenerCasillero(1,1));
        Casillero casillero=tablero.obtenerCasillero(1,1);

        Bonus elbonus=(Bonus)casillero.enteContenido;
        Assert.assertTrue(elbonus.ataqueAdicional()==2);

    }
}
