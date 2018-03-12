package edu.grinnell.sortingvisualizer.events;

import java.util.List;

public interface SortEvent <T extends Comparable<T>> {
	
	public void apply(T[] arr);
	
	public List<Integer> getAffectedIndices();
	
	public boolean isEmphasized();
	
}
