package Inlup1_Del1;

public class Aktier extends Thing {
	private float kurs;
	int antal;

	public Aktier(String n, float k, int an) {
		super(n);
		kurs = k;
		antal = an;
	}
	
	public int getValue(){
		return (int) (kurs * antal);
	}

}
