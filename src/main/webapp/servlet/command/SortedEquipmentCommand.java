package servlet.command;

import ua.training.knight.Knight;

public class SortedEquipmentCommand implements Command {
	Knight k;
	
	public SortedEquipmentCommand(Knight k) {
		this.k = k;
	}


	@Override
	public String execute() {
		return k.showSortedByWeightEquipment();
	}

}
