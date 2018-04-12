package Inlup1_Del1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	Scanner sc = new Scanner(System.in);
	static ArrayList<Owner> PArray = new ArrayList<Owner>();
	
	Owner getOwner(String namn){
		for (Owner o : PArray){
			if(o.getName().equalsIgnoreCase(namn))   // tab - find error for getName();
				return o;
		}
		return null;					
	}
	
	//insert Exceptions
	int insertIntegers(String str){
		while (true){
			try{
				int f=Integer.parseInt(sc.nextLine());
				return f;
			}
			catch (NumberFormatException num){
				System.out.println("Int required");
				continue; 
			}
		}
	}
	
	//
	
	String readString(String str){
		String text = sc.nextLine();return text;
	}
	
	void createPerson(){
		String namn = readString("Insert name of new person.");
		Owner o = getOwner(namn);
		if (o!=null)
			System.out.println("Person already exists.");
		else{
			Owner nw = new Owner(namn);
			PArray.add(nw);
			System.out.println(nw.getName().equalsIgnoreCase(namn) + " created.");		
		}
	}
	
	void makeObject(int s, String namn, int k, int an, Owner owner){
		
		switch(s){
			case 1:{
				Aktier ak = new Aktier(namn, k, an); // perhaps x + y? since the variables may be volatile. very volatile otherwise.
				owner.newItem(ak); //mark for create.
				System.out.println("Created " + ak);
				break;
				
			}
			case 2 : {
				Apparat ap = new Apparat(namn, k, an);
				owner.newItem(ap);
				System.out.println("Created " + ap );
				break;
			}
			case 3 : {
				Smycke sm = new Smycke(namn, k, an);
				owner.newItem(sm);
				System.out.println("Created " + sm );
				break;
			}
		}		
	}	
	
	void findOwner(){
		String namn = readString("Insert name of person.");
		Owner o = getOwner(namn);
		if (o!= null){
			System.out.println(o.getName() + " has the following items ");
			for (Thing r : o.getItem()){
				System.out.println(r + " : " + r.getItem() + " with value " + r.getValue());
			}
		}
	}
}


