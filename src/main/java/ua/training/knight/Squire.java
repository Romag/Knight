package ua.training.knight;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Manages equipment(weapons and armor) for a warrior(knight).
 * @author ramil
 *
 */
public class Squire {
	private static final String pathToEquipmentList = "/home/ramil/workspace/eclipseWorkspace/JET_task_1/src/main/resources/ua/training/equipment/equipmentList.txt";
	private List<AbstractEquipmentItem> equipmentUnderManagement;
	private Smith smith;
	
	public Squire() {
		smith = new Smith();
		equipmentUnderManagement = procureEquipment();
	}
	
	private List<AbstractEquipmentItem> procureEquipment() {
		//TODO add ability to choose which file to use to get list of equipment
		List<AbstractEquipmentItem> equipment = new ArrayList<>();
		try {
			for( String line : (Files.readAllLines(Paths.get(pathToEquipmentList))) ) {
				equipment.add(smith.buildBySpecification(line));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return equipment;
	}
	
	public String showEquipmentSortedByWeight() {
		sortEquipmentByWeight();
		return managedEquipment();
	}
	
	public String managedEquipment(){
		StringBuilder strb = new StringBuilder();
		for(AbstractEquipmentItem item : equipmentUnderManagement) {
			strb.append(item.getName() + " ");
		}
		return strb.toString();
	}
	
	public int calculateTotalCost() {
		//TODO cached version of cost calculation, to eliminate need to calculate it every time
		int sum=0;
		for(AbstractEquipmentItem item : equipmentUnderManagement) 
			sum += item.getPrice();
		
		return sum;
	}
	
	public void addItem(AbstractEquipmentItem iEP) {
		equipmentUnderManagement.add(iEP); 
	}

	private void sortEquipmentByWeight() {
		equipmentUnderManagement.sort(new ComparatorByWeight<AbstractEquipmentItem>());
	}
	
	private void sortEquipmentByPrice() {
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

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("Squire manages this equipment: \n");
		for(AbstractEquipmentItem aei : equipmentUnderManagement) {
			str.append("	["  + aei.toString() + "]\n");
		}
		return str.toString();
	}
	
	/*
	 * Range is inclusive on both ends.
	 */
	public String equipmentWithinPriceRange(int lowPrice, int highPrice) {
		StringBuilder strb = new StringBuilder();
		
		for(AbstractEquipmentItem item : equipmentUnderManagement)
			if(withingRange(lowPrice, highPrice, item.getPrice())) 
				strb.append(item.getName() + " ");
		
		
		return strb.toString();
	}
	
	/*
	 * Inclusive range
	 */
	private boolean withingRange(int low, int high, int value) {
		return low <= value 
					&& value <= high;
	}
}

