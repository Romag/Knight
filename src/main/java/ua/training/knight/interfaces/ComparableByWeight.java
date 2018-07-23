package ua.training.knight.interfaces;


public interface ComparableByWeight<T> extends Comparable<T> {
	int compareByWeight(T o);
	
}
