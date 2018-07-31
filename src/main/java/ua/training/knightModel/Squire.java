package ua.training.knightModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.text.Highlighter.HighlightPainter;

import ua.training.knightModel.equipment.AbstractEquipmentItem;

/**
 * Manages equipment(weapons and armor) for a warrior(knight).
 * @author ramil
 *
 */
public class Squire {
	private static final String pathToEquipmentList = "ua/training/equipmentList.txt";
	private List<AbstractEquipmentItem> equipmentUnderManagement;
	private Smith smith;
	
	
	public Squire() {
		smith = new Smith();
		equipmentUnderManagement = procureEquipment();
	}
	
	private List<AbstractEquipmentItem> procureEquipment() {
		System.out.println();
		
		

		List<AbstractEquipmentItem> equipment = new ArrayList<>();
		try {
			Path path = Paths.get(Thread.currentThread().getContextClassLoader().getResource(pathToEquipmentList).toURI());
			for( String line : (Files.readAllLines(path)) ) {
				equipment.add(smith.buildBySpecification(line));
			}
			
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		
		
		return equipment;
	}
	
	public String showEquipmentSortedByWeight() {
		sortEquipmentByWeight();
		return managedEquipmentHTML();
	}
	
	public String managedEquipment(){
		return managedEquipentTemplate("");
	}
	
	public String managedEquipmentHTML() {
		return managedEquipentTemplate("<br />");
	}
	
	private String managedEquipentTemplate(String HTMLNewLine) {
		StringBuilder strb = new StringBuilder();
		for(AbstractEquipmentItem item : equipmentUnderManagement) {
			strb.append(HTMLNewLine + item.getName() + " " 
						+ item.getWeight() + Units.KILOGRAM.toString() + " " 
						+ item.getPrice() + Units.FLORIN.toString());
		}
		return strb.toString();
	}
	
	public String calculateTotalCost() {
		//TODO cached version of cost calculation, to eliminate need to calculate it every time
		int sum=0;
		for(AbstractEquipmentItem item : equipmentUnderManagement) 
			sum += item.getPrice();
		
		return "<br />Total cost of equipment: " + sum + Units.FLORIN.toString();
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
				strb.append(item.getName() + " "
						+ item.getPrice() + Units.FLORIN.toString());
		
		
		return strb.toString();
	}
	
	public String equipmentWithinPriceRangeHTML(int lowPrice, int highPrice) {
		StringBuilder strb = new StringBuilder();
		
		strb.append("<br />Equipment within ["+lowPrice+"-"+highPrice+"] range: ");
		for(AbstractEquipmentItem item : equipmentUnderManagement)
			if(withingRange(lowPrice, highPrice, item.getPrice())) 
				strb.append("<br />" + item.getName() + " "
						+ item.getPrice() + Units.FLORIN.toString());
		
		
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

