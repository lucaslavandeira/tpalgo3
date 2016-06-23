package fiuba.algo3.modelo;

/**
 * Created by usuario on 13/06/2016.
 */
public class DobleCanion implements Equipamiento {
    private String dobleCanion;
    
    
    public DobleCanion(){
         dobleCanion = "Doble Canion";
    }

    
    public void addAlBonus(Bonus bonus){
        bonus.agregarDobleCanion();
    }
    
    
    public String getNombreDeBonus(){
    	return dobleCanion;
    }
    
    
}
