package toys.pokemon;

import java.util.HashMap;

public class ToyStore {
	
	
	// To restrict picking wrong item
	public enum TOY_TYPE{ 
		PIKACHU,SQUIRTLE,CHARMANDER
	}

	// To make any changes in discount 
	public int getDiscount(int count) {
		int discount = 0;
		switch (count) {
		case 2:
			discount = 10;
			break;
		case 3:
			discount = 20;
			break;
		}
		return discount;
	}
	
	// to give keys to each pokemon 
	private HashMap<TOY_TYPE, Double> toys = new HashMap<TOY_TYPE, Double>();
	
	public ToyStore() {
		toys.put(TOY_TYPE.PIKACHU, 6d); /*d=double*/
		toys.put(TOY_TYPE.SQUIRTLE, 5d); 
		toys.put(TOY_TYPE.CHARMANDER, 5d);
	}
	
	
	// Updating Price 
	public void updatePrice(TOY_TYPE toyType, double price) {
		if (toys.containsKey(toyType)) {
			toys.put(toyType, price);
		}
	}
	
	
	// Get Price 
	public double getPrice(TOY_TYPE toyType) {
		return toys.get(toyType);
	}

}
