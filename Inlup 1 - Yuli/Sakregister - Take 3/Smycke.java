package Inlup1.TestCode;

public class Smycke extends Item {
	int adelstenar;
	boolean isGold; //mark for was Boolean
	
	public Smycke(String n, int a, boolean an){
		super(n);
		adelstenar = a;
		isGold = an;
	}
	
	public int getValue(){
		int kost;
		int smyckePris;
		if(isGold == false){
			kost = 2000;
		} else {
			kost = 700;
		}
		smyckePris = ( adelstenar * 500 ) + kost;  //name flag
		return smyckePris;				
	}
	
	public String toString(){ //this is actual
		return "Smycke: " + getName() + " värde:" + getValue()
				+ " stenar:"+adelstenar+ " silver\n";  //if sats here isGold ? " guld\n" : " silver\n";
	} 
	
	
}
