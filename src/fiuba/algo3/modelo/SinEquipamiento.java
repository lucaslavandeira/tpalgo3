package fiuba.algo3.modelo;

/**
 * Created by usuario on 13/06/2016.
 */
public class SinEquipamiento implements Equipamiento {
    private String sinEquipamiento;
    
    
	public SinEquipamiento(){
		this.sinEquipamiento = " ";
    }
    
    public void addAlBonus(Bonus bonus) {

    }
    
    
    public String getNombreDeBonus(){
    	return this.sinEquipamiento;
    }
    
    
}
