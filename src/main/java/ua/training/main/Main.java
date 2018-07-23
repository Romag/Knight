package ua.training.main;

import ua.training.knight.AbstractArmorItem;
import ua.training.knight.AbstractEquipmentItem;
import ua.training.knight.Squire;

public class Main {

	public static void main(String[] args) {
		new Squire();
		
		new AbstractEquipmentItem("Shield", 4, 250) {
		};
	}

}
