package Inlup1.TestCode;

public class Aktie extends Item {
	private float kurs;
	int antal;
	
	public Aktie(String n, int an, float k){
		super(n);
		antal = an;
		kurs = k;
		
	}
	
	public int getValue(){
		return (int)(kurs * antal); //forcecast  FLAG for removal later.
	}
	
	public String toString(){
		return "Aktie: "+name+" värde:"+getValue()+" antal:"+antal+" kurs:"+kurs + "\n";
	}

}
