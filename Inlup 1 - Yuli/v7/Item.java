
import java.io.Serializable;
import java.math.BigDecimal;

public class Item extends ObjectRenamedForNow implements Serializable {
	protected String name;
	protected int value;
	
	public Item(String n){
		name = n;
	}
	
	public void write(){ //removed override. may be unstable on other programs.	
	}
	
	public float getValue(){
		String numberAsString = String.format("%.2f",new BigDecimal(value));
		return value;
	}
	
	public String getName() {
		return name;
	}
	
	public Item getItem(){
		return null;  //referred in the child classes later
	}
	
}
