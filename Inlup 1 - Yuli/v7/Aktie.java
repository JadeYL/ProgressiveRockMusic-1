

public class Aktie extends Item {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float kurs;
	int antal;
	
	public Aktie(String n, int an, float k){
		super(n);
		antal = an;
		kurs = k;
		
	}

	public void setKurs(float kurs){
		this.kurs = kurs;
	}
	
	public float getValue(){
		return (kurs * antal); 
	}
	
	public String toString(){
		return "Aktie: "+name+" värde:"+String.format("%.2f", getValue())+" antal:"+antal+" kurs:"+String.format("%.2f", kurs) + "\n";
	}

}
