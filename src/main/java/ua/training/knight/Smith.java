package ua.training.knight;


/**
 * Builder pattern implementation for equipment.
 * @author ramil
 *
 */
public class Smith {
	private String[] specsList;
	
	//TODO remove hardcoded version
	public AbstractEquipmentItem buildBySpecification(String spec) {
		String[] parsedSpecs = spec.split(" ");
		
		String name = parsedSpecs[0];
		int weight = Integer.parseInt(parsedSpecs[1]);
		int price = Integer.parseInt(parsedSpecs[2]);
		
		return new AbstractEquipmentItem(name, weight, price) {

			@Override
			public String toString() {
				return super.toString();
			}};
	}
	
}
