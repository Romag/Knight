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
	private static final String pathToEquipmentList = "src/main/resources/ua/training/equipment/equipmentList";
	private List<AbstractEquipmentItem> equipmentUnderManagement;
	private Smith smith;
	
	public Squire() {
		smith = new Smith();
		equipmentUnderManagement = procureEquipment();
	}
	
	private List<AbstractEquipmentItem> procureEquipment() {
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

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("Squire manages this equipment: \n");
		for(AbstractEquipmentItem aei : equipmentUnderManagement) {
			str.append("	"  + aei.toString() + "\n");
		}
		return str.toString();
	}
	
	
}

