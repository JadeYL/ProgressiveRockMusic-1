package Inlup1.TestCode;

import java.io.Serializable;

public class Item extends Object implements Serializable {
	protected String name;
	protected int value;
	
	public Item(String n){
		name = n; //or this
	}
	
	public void write(){ //override removed. thing is unstable on other platforms.
		
	}
	
	public int getValue(){
		return value;
	}
	
	public String getName() {
		return name;
	}
	
	public Item getItem(){
		return null;  //referred in child classes later
	}
	
}
