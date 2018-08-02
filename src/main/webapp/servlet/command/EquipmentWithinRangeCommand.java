package servlet.command;

import ua.training.knight.Knight;

public class EquipmentWithinRangeCommand implements Command {
	private Knight k;
	private int low;
	private int high;
	
	
	public EquipmentWithinRangeCommand(Knight k, int low, int high) {
		this.k = k;
		this.low = low;
		this.high = high; 
	}
	
	@Override
	public String execute() {
		return k.showEquipmentWithingPriceRange(low, high);
	}

}
