
import java.io.Serializable;
import java.math.BigDecimal;

public class Item  extends ObjectRenamedForNow implements Serializable {
	protected String name;
	protected int value;
	
	public Item(String n){
		name = n;
	}
	@Override
	public void write(){
	}
	
	public float getValue(){
		String numberAsString = String.format("%.2f",new BigDecimal(value));
		return value;
	}
	
	public String getName() {
		return name;
	}
	
	public Item getItem(){
		return null;  //referred in child classes later
	}
	
}
