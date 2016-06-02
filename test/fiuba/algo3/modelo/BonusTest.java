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
        new Bonus(tablero.obtenerCasillero(1,1));
        Casillero casillero=tablero.obtenerCasillero(1,1);
        Assert.assertTrue(casillero.enteContenido.esBonus()== true);

    }

    @Test
    public void test01CrearBonusDeDobleCanion(){
        new DobleCanion(tablero.obtenerCasillero(1,1));
        Casillero casillero=tablero.obtenerCasillero(1,1);

        Bonus elbonus =(Bonus)casillero.enteContenido;
        Assert.assertTrue(elbonus.ataqueAdicional()==2);

    }

    @Test
    public void test02BonusNoEsChispaSuprema(){
        new Bonus(tablero.obtenerCasillero(1,1));
        Casillero casillero=tablero.obtenerCasillero(1,1);

        Bonus elbonus =(Bonus)casillero.enteContenido;
        Assert.assertTrue(elbonus.esChispaSuprema()==false);
    }

    @Test
    public void test03BonusNoEsAutobot(){
        new Bonus(tablero.obtenerCasillero(1,1));
        Casillero casillero=tablero.obtenerCasillero(1,1);

        Bonus elbonus =(Bonus)casillero.enteContenido;
        Assert.assertTrue(elbonus.esAutobot()==false);
    }

    @Test
    public void test04BonusNoEsDesepticon(){
        new Bonus(tablero.obtenerCasillero(1,1));
        Casillero casillero=tablero.obtenerCasillero(1,1);

        Bonus elbonus =(Bonus)casillero.enteContenido;
        Assert.assertTrue(elbonus.esDecepticon()==false);
    }

    @Test
    public void test05TransformerPuedeMoverseAUnCasilleroConBonus(){
        EquipoAutobots autobots =new EquipoAutobots(tablero);
        new DobleCanion(casillero= tablero.obtenerCasillero(1,7));
        //optimus inicia en la posicion (1,6)
        //en la posicion 1,7 esta el bonus

        autobots.optimus.avanzar(0,1);
        Bonus elbonus= (Bonus)autobots.optimus.posicion.enteContenido;
        Assert.assertTrue(elbonus.esBonus() == true);

    }
}
