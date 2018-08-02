package ua.training.knight;

public class Knight {
	private Squire squire;
	
	public Knight() {
		squire = new Squire();
	}
	
	public String equipmentCost() {
		return squire.calculateTotalCost();
	}
	
	public String showSortedByWeightEquipment() {
		return squire.showEquipmentSortedByWeight();
	}
	
	public String showEquipmentWithingPriceRange(int low, int high) {
		return squire.equipmentWithinPriceRangeHTML(low, high);
	}
	

	
}
