import java.io.Serializable;
import java.util.ArrayList;

public class Agare implements Serializable {
	private String namn;
	ArrayList<Item> list = new ArrayList<Item>();
	
	public Agare (String namn){
		this.namn = namn;
	}
	
	public void newItem(Item item){
		list.add(item);
	}
	
	public String getName(){
		return namn;
	}
	
	public ArrayList<Item> getItem(){
		return list;
	}
	
	public float totalValue(){
		float totalvalue = 0;
		for (Item t : list){
			totalvalue += t.getValue();
		}
		return totalvalue;
	}

}
