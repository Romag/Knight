package ua.training.main;

import ua.training.knightModel.equipment.EquipmentTypes;

public class Main {

	public static void main(String[] args) {
		String name = "bracers";
		name = name.toUpperCase();
		
		System.out.println(EquipmentTypes.BRACERS.toString());
		System.out.println(name);
		System.out.println(name.equals(EquipmentTypes.BRACERS.toString()));
		
	}
	

}
