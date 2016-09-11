package toys.pokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import toys.pokemon.ToyStore.TOY_TYPE;

public class PokemonBuyer {

	private Map<TOY_TYPE, Integer> toys = new HashMap<TOY_TYPE, Integer>();
	private ToyStore store = new ToyStore();

	/* 
	 * @param toyType,
	 *            type of toy {@link ToyStore}
	 * @param quantity,
	 *            quantity
	 */
	public void buy(TOY_TYPE toyType, int quantity) {
		// Do not allow invalid quantity
		if (quantity <= 0) {
			System.out.println("\nQuantity can not be 0 zero or less : " + quantity);
			return;
		}

		if (toys.containsKey(toyType)) {
			// add quantity to existing count.
			int qty = toys.get(toyType);
			qty = qty + quantity;
			toys.put(toyType, qty);
		} else {
			toys.put(toyType, quantity);
		}
	}

	/**
	 * @return total prize of toys including discount.
	 */
	public double calculatePrize() {
		
		//clone toys so that multiple calculation will not fail.
		Map<TOY_TYPE, Integer> toysCloned = new HashMap<TOY_TYPE, Integer>();
		toysCloned.putAll(toys);

		/*
		 * Number of Different Pokemon | Purchased Discount Amount 
		 * 				1 						No discount
		 * 				2 						10% 
		 * 				3 						20%
		 */

		
		List<TOY_TYPE> sortedToyTypes = new ArrayList<TOY_TYPE>(toysCloned.keySet());

		int totalToyTypes = sortedToyTypes.size();

		double totalPrize = 0;

		// Sort the toys by quantity.
		for (int i=0; i<totalToyTypes; i++) {
			for (int j=i; j<totalToyTypes; j++) {
				if (toysCloned.get(sortedToyTypes.get(i)) > toysCloned.get(sortedToyTypes.get(j))) {
					TOY_TYPE temp = sortedToyTypes.get(i);
					sortedToyTypes.set(i, sortedToyTypes.get(j));
					sortedToyTypes.set(j, temp);
				}
			}
		}
		
		// Apply the discount.
		for (int i=0; i<totalToyTypes; i++) {
			// first one should be subtracted from all other item and apply discount.
			TOY_TYPE toy = sortedToyTypes.get(i);
			int qty = toysCloned.get(toy);
			
			int groupCount = totalToyTypes - i;
			int discount = store.getDiscount(groupCount);
			if (discount == 0) {
				// put prize on single kind.
				totalPrize = totalPrize + (store.getPrice(toy) * qty);
			} else {
				
				double groupPrize = 0;
				for (int j=i; j<totalToyTypes; j++) {
					
					// calculate the common prize.
					TOY_TYPE tempToy = sortedToyTypes.get(j);
					int totalCurrentToyQty = toysCloned.get(tempToy);
					groupPrize = groupPrize + (qty * store.getPrice(tempToy));
					
					// subtract the count from other quantity.
					toysCloned.put(tempToy, totalCurrentToyQty-qty);
				}
				
				// calculate the discount.
				groupPrize = groupPrize - ((groupPrize * discount)/100);
				
				totalPrize = totalPrize + groupPrize;
			}
		}
		return round(totalPrize);
	}

	// Rounding the value 
	private double round(double value) {
		return Math.round(value*100.0)/100.0;
	}
}
