package ua.training.knightModel;

import ua.training.knightModel.equipment.*;

/**
 * Factory pattern implementation for equipment.
 * @author ramil
 *
 */
public class Smith {
	private String[] specsList;
	
	public AbstractEquipmentItem buildBySpecification(String spec) {
		String[] parsedSpecs = spec.split(" ");
		
		String name = parsedSpecs[0];
		int weight = Integer.parseInt(parsedSpecs[1]);
		int price = Integer.parseInt(parsedSpecs[2]);
		
		if(name.toUpperCase().equals(EquipmentTypes.SWORD.toString())) 
			return new Sword(name, weight, price);
		
		else if(name.toUpperCase().equals(EquipmentTypes.SHIELD.toString())) 
			return new Shield(name, weight, price);
		
		else if(name.toUpperCase().equals(EquipmentTypes.SPEAR.toString())) 
			return new Spear(name, weight, price);
		
		else if(name.toUpperCase().equals(EquipmentTypes.GAUNTLETS.toString())) 
			return new Gauntlets(name, weight, price);
		
		else if(name.toUpperCase().equals(EquipmentTypes.BRACERS.toString())) 
			return new Bracers(name, weight, price);
		
		else if(name.toUpperCase().equals(EquipmentTypes.HELMET.toString())) 
			return new Helmet(name, weight, price);
		
		else return new AbstractEquipmentItem(name, weight, price) {}; // If class of equipment is not defined
	}
	
}