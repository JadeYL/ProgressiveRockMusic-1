package LowestCopy;

public class Apparat extends Item {
	float inkopspris;
	int slitage;
	
	public Apparat(String n, float f, int slit){
		super(n);
		inkopspris = f;
		slitage = slit;
	}
	
	public float getValue(){
		System.out.println("Slitage getvalue works.");
		float x = 0;
		
		
		switch (slitage){  //DEBUG
		case 10:
			return x;
		case 9:
			x = inkopspris * slitage * (float)0.9;    
			return x;
		case 8:
			x = inkopspris * slitage * (float)0.8;
			return x;
		case 7:
			x = inkopspris * slitage * (float)0.7;
			return x;
		case 6:
			x = inkopspris * slitage * (float)0.6;
			return x;
		case 5:
			x = inkopspris * slitage * (float)0.5;
			return x;
		case 4:
			x = inkopspris * slitage * (float)0.4;
			return x;
		case 3:
			x = inkopspris * slitage * (float)0.3;
			return x;
		case 2:
			x = inkopspris * slitage * (float)0.2;
			return x;
		case 1:
			x = inkopspris * slitage * (float)0.1;
			return x;
		default: 
			System.out.println("Slitage is not between 1 to 10");
			
		}
		
//		if (slitage == 0 || slitage <= 10){
//			slitage/=10;
//			x = inkopspris * slitage * (float)1.25;
//		} else {
//			System.err.println("Slitage pris för hög");  //insert throwable
//		}
		return x;
	}
	
	public String toString(){    //getValue()*1.25 = moms
		return "Apparat: "+name+" värde:"+String.format("%.2f", getValue()*1.25)+" pris:"+String.format("%.2f", inkopspris)+" slitage: "+slitage+"\n";
	}
}
