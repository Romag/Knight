package ua.training.knight.interfaces;

import ua.training.knight.AbstractEquipmentItem;

public interface ComparableByPrice<T extends AbstractEquipmentItem> extends Comparable<T> {
	int compareByPrice(T o);

}
