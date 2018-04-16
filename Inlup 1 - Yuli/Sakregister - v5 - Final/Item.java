package LowestCopy;

import java.io.Serializable;
import java.math.BigDecimal;

public class Item extends ObjectRenamedForNow implements Serializable {
	protected String name;
	protected int value;
	
	public Item(String n){
		name = n; //or this
	}
	
	public void write(){ //override removed. thing is unstable on other platforms.
		
	}
	
	public float getValue(){  //change to SetFloat eventually please.
		String numberAsString = String.format("%.2f",new BigDecimal(value));
		//float value = Float.parseFloat(numberAsString);
		return value;
	}
	
	public String getName() {
		return name;
	}
	
	public Item getItem(){
		return null;  //referred in child classes later
	}
	
}
