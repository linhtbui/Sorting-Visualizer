package edu.grinnell.sortingvisualizer.events;

import java.util.List;

public class CopyEvent <T extends Comparable<T>> implements SortEvent<T> {

	@Override
	public void apply(T[] arr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Integer> getAffectedIndices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmphasized() {
		// TODO Auto-generated method stub
		return false;
	}

}