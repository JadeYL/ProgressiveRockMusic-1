package Inlup1_Del1;

public class Apparat extends Thing {
	int inköpspris;
	int slitage;
	
	public Apparat(String n, int inpris, int slit) {
		super(n);
		inköpspris = inpris;
		slitage = slit;
	}
	
	public int getValue(){
		float x = 0; //initialised?
		int j;
		if (slitage == 0 || slitage <=10){  //could be if loop.
			slitage/=10;
			x = inköpspris * slitage * (float)1.25;
		} else {
			System.out.println("error slitage is too high"); //insert throwable.
		}
		return (int) x; //possible change the public 'int' to float?
	}
	
	

}
