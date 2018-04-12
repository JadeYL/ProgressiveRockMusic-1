package Inlup1_Del1;

import java.io.Serializable;
import java.util.ArrayList;

public class Owner implements Serializable {
	private String namn;
	ArrayList<Thing> list = new ArrayList<Thing>();	
	
	public Owner (String namn){
		this.namn = namn;
	}
	public void newItem(Thing thing){
		list.add(thing);
	}
	
	public String getName(){
		return namn;
	}
	
	public ArrayList<Thing> getItem(){
		return list;
	}
	
	public int totalValue(){
		int totalvalue = 0;
		for (Thing t : list){
			totalvalue += t.getValue();
		}
		return totalvalue;
	}

}
