package ua.training.knight;

import ua.training.knight.interfaces.ComparableByPrice;
import ua.training.knight.interfaces.ComparableByWeight;
import ua.training.knight.interfaces.IEquipmentPiece;

public abstract class AbstractEquipmentItem 
					implements IEquipmentPiece, ComparableByPrice<AbstractEquipmentItem>, 
												ComparableByWeight<AbstractEquipmentItem> {
	private String name;
	private int weight;
	private int price;
	
	public AbstractEquipmentItem(String name, int weight, int price) {
		this.name = name;
		this.weight = weight;
		this.price = price;
	}
	
	public AbstractEquipmentItem() {
		name = "*Empty*";
	}

	@Override
	public int compareTo(AbstractEquipmentItem thatO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compareByWeight(AbstractEquipmentItem o) {
		int thisWeight = weight;
		int thatWeight = o.getWeight();
		
		if(thisWeight == thatWeight) return 0;
		else if(thisWeight > thatWeight) return 1;
		else if(thisWeight < thatWeight) return -1;
			
		throw new RuntimeException("This should never happen");
	}

	@Override
	public int compareByPrice(AbstractEquipmentItem o) {
		int thisPrice = price;
		int thatPrice = o.getPrice();
		
		if(thisPrice == thatPrice) return 0;
		else if(thisPrice > thatPrice) return 1;
		else if(thisPrice < thatPrice) return -1;
			
		throw new RuntimeException("This should never happen");
	}
	
	public int getWeight() {
		return weight;
	}
	
	public int getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return name + 
				" weight: " + weight +
				"  price: " + price;
	}
}
