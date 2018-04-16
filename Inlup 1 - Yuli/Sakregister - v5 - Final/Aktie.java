package LowestCopy;

public class Aktie extends Item {
	private float kurs;
	int antal;
	
	public Aktie(String n, int an, float k){
		super(n);
		antal = an;
		kurs = k;
		
	}
	
	//Kursen ska kunna �ndras
	public void setKurs(float kurs){
		this.kurs = kurs;
	}
	
	public float getValue(){
		return (kurs * antal); 
	}
	
	public String toString(){
		return "Aktie: "+name+" v�rde:"+String.format("%.2f", getValue())+" antal:"+antal+" kurs:"+String.format("%.2f", kurs) + "\n";
	}

}
