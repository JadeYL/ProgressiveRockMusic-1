package Inlup1_Del1;

public class Smycke extends Thing {
	
	int adelstenar;
	int isGold; //was boolean

	public Smycke(String n, int a, int an) {
		super(n);
		adelstenar = a;
		isGold = an;		
	}
	
	public int getValue(){
		int kost;
		int smyckeVal;
		if(isGold == 1)  // was boolean but now the switch is 1 instead. he checkbox will send 1.
			kost = 2000;
		else 
			kost = 700;		
		smyckeVal = ( adelstenar * 500 ) + kost;
		return smyckeVal;
	}
	

	
//	public void write() {
//		super.write();
//		System.out.println("Smycken kostar "+smyckeVal+" kr.");
//	}	
	
}
