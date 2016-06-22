package fiuba.algo3.modelo;

/**
 * Created by Vietnamita on 14/06/2016.
 */
public class BurbujaInmaculada implements Equipamiento{
private String burbujaInmaculada; 
    public BurbujaInmaculada(){
    	this.burbujaInmaculada = "Burbuja Inmaculada";
    }
    public void addAlBonus(Bonus bonus) {
            bonus.agregarInmortalidad();
    }
    public String getNombreDeBonus(){
    	return this.burbujaInmaculada;
    }
}
