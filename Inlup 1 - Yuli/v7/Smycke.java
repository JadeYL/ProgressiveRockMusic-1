

public class Smycke extends Item {
	int adelstenar;
	boolean isGold; //mark for was Boolean
	
	public Smycke(String n, int a, boolean an){
		super(n);
		adelstenar = a;
		isGold = an;
	}
	
	public float getValue(){
		int kost;
		int smyckePris;
		if(isGold == false){
			kost = 2000;
		} else {
			kost = 700;
		}
		smyckePris = ( adelstenar * 500 ) + kost;
		return smyckePris;				
	}
	
	public String checkifGold(){
		if(isGold == false){
			return " Silver";
		} else {
			return " Guld";
		}
	}
	
	
	public String toString(){
		return "Smycke: " + getName() + " värde:" + String.format("%.2f", getValue())
				+ " stenar:"+adelstenar+ checkifGold() + " \n";
	} 
	
	
}
