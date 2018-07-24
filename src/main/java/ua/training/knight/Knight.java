package ua.training.knight;

import java.util.List;

public class Knight {
	private Squire squire;
	
	public Knight() {
		squire = new Squire();
	}
	
	public int equipmentCost() {
		return squire.calculateTotalCost();
	}
	
	public String showSortedByWeightEquipment() {
		return  squire.showEquipmentSortedByWeight();
	}
	
	public String showEquipmentWithingPriceRange(int low, int high) {
		return squire.equipmentWithinPriceRange(low, high);
	}
	
	public void swingSword() {
		//TODO 
		//System.out.println("Knight is swinging sword.");}
	}
	
}
