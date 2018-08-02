package servlet.command;

import ua.training.knight.Knight;

public class TotalCostCommand implements Command {
	Knight k;
	
	public TotalCostCommand(Knight k) {
		this.k = k;
	}

	@Override
	public String execute() {
		return k.equipmentCost();
	}

}
