package Inlup1.TestCode;

public class Apparat extends Item {
	int inkopspris;
	int slitage;
	
	public Apparat(String n, int f, int slit){
		super(n);
		inkopspris = f;
		slitage = slit;
	}
	
	public int getValue(){
		float x = 0;
		int j;
		if (slitage == 0 || slitage <= 10){
			slitage/=10;
			x = inkopspris * slitage * (float)1.25;
		} else {
			System.err.println("Slitage pris för hög");  //insert throwable
		}
		return (int) x;
	}
	
	public String toString(){
		return "Apparat: "+name+" värde:"+inkopspris+" pris:"+getValue()+" slitage: "+slitage+"\n";
	}
}
