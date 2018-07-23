package ua.training.knight;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Manages equipment(weapons and armor) for a warrior(knight).
 * @author ramil
 *
 */
public class Squire {
	private static final String pathToEquipmentList = "JET_task_1/src/main/resources/ua/training/equipment/equipmentList";
	private List<AbstractEquipmentItem> equipmentUnderManagement;
	
	public Squire() {
		equipmentUnderManagement = procureEquipment();
	}
	
	private static List<AbstractEquipmentItem> procureEquipment() {
		List<AbstractEquipmentItem> equipmentList = new ArrayList<>();
		try{
			FileInputStream fIS = new FileInputStream(new File(pathToEquipmentList));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return equipmentList;
	}
	
	public String managedEquipment(){/*TODO*/ return null;}
	
	public void addItem(AbstractEquipmentItem iEP) {
		equipmentUnderManagement.add(iEP); 
	}
	
	public void sortequipmentByWeight() {
		equipmentUnderManagement.sort(new ComparatorByWeight<AbstractEquipmentItem>());
	}
	
	public void sortEquipmentByPrice() {
		equipmentUnderManagement.sort(new ComparatorByPrice<AbstractEquipmentItem>());
	}
	
	private class ComparatorByWeight<T extends AbstractEquipmentItem> implements Comparator<T> {

		@Override
		public int compare(T o1, T o2) {
			return comapreByWeight(o1, o2);
		}

		private int comapreByWeight(T o1, T o2) {
			return o1.compareByWeight(o2);
		}
	}
	
	private class ComparatorByPrice<T extends AbstractEquipmentItem> implements Comparator<T> {

		@Override
		public int compare(T o1, T o2) {
			return compareByPrice(o1, o2);
		}
		
		private int compareByPrice(T o1, T o2) {
			return o1.compareByPrice(o2);
		}
		
	}
}

